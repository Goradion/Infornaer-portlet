package game.infonaer.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import org.junit.experimental.categories.Categories;

import com.liferay.portal.kernel.model.User;

import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.DifficultyLocalServiceUtil;
import de.ki.sbam.service.QuestionLocalService;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.impl.QuestionLocalServiceImpl;
import edu.emory.mathcs.backport.java.util.Arrays;

public class InfonaerGameUtil {
	private static Random randomGenerator = new Random();

	public static void pickQuestion(GameState gameState) {
		List<Category> categories = gameState.getCategories();
		List<Difficulty> difficulties = gameState.getDifficulties();
		int size = categories.size();
		if (size == 0) {
			throw new IllegalStateException("Keine Kategorie!");
		}
		int chosenCategoryIndex = randomGenerator.nextInt(size);
		Category category = categories.get(chosenCategoryIndex);
		Difficulty difficulty = difficulties.get(gameState.getCurrentDifficulty());
		List<Question> questionPool = QuestionLocalServiceUtil.findByCategoryAndDifficulty(category.getCategoryId(),
				difficulty.getScore());
		int chosenQuestionIndex = randomGenerator.nextInt(questionPool.size());
		gameState.setCurrentQuestion(questionPool.get(chosenQuestionIndex));
	}

	public static boolean evaluateAnswer(GameState gameState, String answer) {
		// TODO log answer for stats
		List<Difficulty> difficulties = gameState.getDifficulties();
		if (!gameState.isGameOver() && gameState.getCurrentQuestion().getRightAnswer().equals(answer)) {

			if (gameState.getCurrentDifficulty() < difficulties.size()) {
				Difficulty difficulty = difficulties.get(gameState.getCurrentDifficulty());
				gameState.setScore(difficulty.getScore());
				if (difficulty.isGuaranteed()) {
					gameState.setGuaranteedScore(difficulty.getScore());
				}
				gameState.increaseCurrentDifficulty();
			} else {
				win(gameState);

			}
			return true;
		} else {
			lose(gameState);
			return false;
		}

	}

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

	private static void win(GameState gameState) {
		gameState.win();
		saveHighscore(gameState);
	}

	public static void retire(GameState gameState) {
		gameState.retire();
		saveHighscore(gameState);
	}

	private static void lose(GameState gameState) {
		gameState.lose();
		saveHighscore(gameState);
	}

	private static void saveHighscore(GameState gameState) {
		// TODO Auto-generated method stub

	}

}
