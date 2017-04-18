package game.infonaer.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.liferay.portal.kernel.model.User;

import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Highscore;
import de.ki.sbam.model.Question;
import de.ki.sbam.model.QuestionStatistics;
import de.ki.sbam.service.HighscoreLocalServiceUtil;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.QuestionStatisticsLocalServiceUtil;
import de.ki.sbam.service.UserStatisticsLocalServiceUtil;

public class InfonaerGameUtil {
	private static Random randomGenerator = new Random();

	
	
	/**
	 * creates a new gameState
	 * adds a played game for the player
	 * @param user
	 * @param selectedCategories
	 * @param difficulties
	 * @return
	 */
	public static GameState startNewGame(User user, List<Category> selectedCategories, List<Difficulty> difficulties){
		UserStatisticsLocalServiceUtil.addPlayedGame(user.getUserId());
		return new GameState(user, selectedCategories, difficulties);
	}
	/**
	 * picks a new Question for the gameState if possible
	 * 
	 * @param gameState
	 */
	public static void pickQuestion(GameState gameState) {
		if (gameState.isGameOver() || gameState.isWon() || gameState.hasError()) {
			return;
		}
		List<Category> categories = gameState.getCategories();
		List<Difficulty> difficulties = gameState.getDifficulties();
		int currentDifficulty = gameState.getCurrentDifficulty();
		if (categories.isEmpty() || difficulties.isEmpty() || currentDifficulty >= difficulties.size()) {
			gameState.crash();
			return;
		}
		int chosenCategoryIndex = randomGenerator.nextInt(categories.size());
		Category category = categories.get(chosenCategoryIndex);
		Difficulty difficulty = difficulties.get(currentDifficulty);
		List<Question> questionPool = QuestionLocalServiceUtil.findByCategoryAndDifficulty(category.getCategoryId(),
				difficulty.getScore());
		if (!questionPool.isEmpty()) {
			int chosenQuestionIndex = randomGenerator.nextInt(questionPool.size());
			gameState.setCurrentQuestion(questionPool.get(chosenQuestionIndex));
		} else {
			gameState.crash();
		}

	}

	/**
	 * evaluates the given answer for the given gameState and changes the state
	 * accordingly
	 * 
	 * @param gameState
	 * @param answer
	 * @return if the answer was correct or not
	 */
	public static boolean evaluateAnswer(GameState gameState, String answer) {
		Question currentQuestion = gameState.getCurrentQuestion();
		QuestionStatisticsLocalServiceUtil.addAnswer(currentQuestion.getQuestionId(), answer);
		List<Difficulty> difficulties = gameState.getDifficulties();
		if (!gameState.isGameOver() && currentQuestion.getRightAnswer().equals(answer)) {

			if (gameState.getCurrentDifficulty() < difficulties.size()) {
				Difficulty difficulty = difficulties.get(gameState.getCurrentDifficulty());
				gameState.setScore(difficulty.getScore());
				if (difficulty.isGuaranteed()) {
					gameState.setGuaranteedScore(difficulty.getScore());
				}
				boolean gameContinues = gameState.advanceGame();
				if (!gameContinues){
					win(gameState);
				}
			} 
			UserStatisticsLocalServiceUtil.addRightAnswer(gameState.getPlayer().getUserId());
			return true;
		} else {
			UserStatisticsLocalServiceUtil.addWrongAnswer(gameState.getPlayer().getUserId());
			lose(gameState);
			return false;
		}

	}

	/**
	 * used the 50:50 joker on the given gameState. removes two wrong answers
	 * from the currentQuestion of the gameState
	 * 
	 * @param gameState
	 */
	public static void useFiftyFifty(GameState gameState) {
		if (!gameState.isFifyFiftyUsed()) {
			Question currentQuestion = gameState.getCurrentQuestion();
			List<String> answers = new ArrayList<>();
			answers.add("A");
			answers.add("B");
			answers.add("C");
			answers.add("D");

			answers.remove(currentQuestion.getRightAnswer());
			int nextInt = randomGenerator.nextInt(answers.size());
			answers.remove(nextInt);

			for (String s : answers) {
				switch (s) {
				case "A":
					currentQuestion.setAnswerA(null);
					break;
				case "B":
					currentQuestion.setAnswerB(null);
					break;
				case "C":
					currentQuestion.setAnswerC(null);
					break;
				case "D":
					currentQuestion.setAnswerD(null);
					break;
				default:
					break;
				}
			}

			gameState.useFifyFifty();
		}
	}

	/**
	 * uses the audience joker on the given gameState determines percentages
	 * from previous answers to the current Question
	 * 
	 * @param gameState
	 * @return how often the answers were chosen previously relative to one
	 *         another
	 */
	public static AudienceJokerResult useAudience(GameState gameState) {
		if (!gameState.isAudienceUsed()) {
			Question currentQuestion = gameState.getCurrentQuestion();
			QuestionStatistics questionStats = QuestionStatisticsLocalServiceUtil
					.fetchQuestionStatistics(currentQuestion.getQuestionId());

			long answeredA = 0;
			long answeredB = 0;
			long answeredC = 0;
			long answeredD = 0;

			// Nachricht kann durch 50:50 entfernt worden sein
			if (currentQuestion.getAnswerA() != null) {
				answeredA = questionStats.getAnswered_a();
			}
			if (currentQuestion.getAnswerB() != null) {
				answeredB = questionStats.getAnswered_b();
			}
			if (currentQuestion.getAnswerC() != null) {
				answeredC = questionStats.getAnswered_c();
			}
			if (currentQuestion.getAnswerD() != null) {
				answeredD = questionStats.getAnswered_d();
			}
			long totalAnswers = answeredA + answeredB + answeredC + answeredD;

			double percentA = 0.0;
			double percentB = 0.0;
			double percentC = 0.0;
			double percentD = 0.0;

			if (totalAnswers != 0) {
				percentA = answeredA * 100.0 / totalAnswers;
				percentB = answeredB * 100.0 / totalAnswers;
				percentC = answeredC * 100.0 / totalAnswers;
				percentD = answeredD * 100.0 / totalAnswers;
			}
			gameState.useAudience();
			return new AudienceJokerResult(percentA, percentB, percentC, percentD);
		} else {
			return null;
		}

	}

	/**
	 * wins the game for the given gameState
	 * 
	 * @param gameState
	 */
	private static void win(GameState gameState) {
		UserStatisticsLocalServiceUtil.addWonGame(gameState.getPlayer().getUserId());
		gameState.win();
		saveHighscore(gameState);
	}

	/**
	 * retires from the game for the given gameSate
	 * 
	 * @param gameState
	 */
	public static void retire(GameState gameState) {
		gameState.retire();
		saveHighscore(gameState);
	}

	/**
	 * loses the game for the given gameState
	 * 
	 * @param gameState
	 */
	private static void lose(GameState gameState) {
		gameState.lose();
		saveHighscore(gameState);
	}

	/**
	 * saves the score of the player for the given gameState
	 * 
	 * @param gameState
	 */
	private static void saveHighscore(GameState gameState) {
		long userId = gameState.getPlayer().getUserId();
		Highscore highscore = HighscoreLocalServiceUtil.fetchHighscore(userId);
		if (highscore == null) {
			highscore = HighscoreLocalServiceUtil.createHighscore(userId);
		}
		long score = highscore.getScore();
		highscore.setScore(score + gameState.getScore());
		HighscoreLocalServiceUtil.updateHighscore(highscore);
	}

}
