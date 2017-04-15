package game.infonaer.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.liferay.portal.kernel.model.User;

import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.DifficultyLocalServiceUtil;
import de.ki.sbam.service.QuestionLocalService;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.impl.QuestionLocalServiceImpl;

public class InfonaerGame {
	private Random randomGenerator;
	private User player;
	private List<Category> categories;
	private int currentDifficulty = 0;
	private List<Difficulty> difficulties;
	private Question currentQuestion; 
	private int score = 0;
	private int guaranteedScore = 0;
	private boolean fifyFiftyUsed = false;
	private boolean audienceUsed = false;
	private boolean gameOver = false;
	private boolean won = false;
	private HashSet<HashMap<Integer,HashSet<String>>> questions;
	
	public InfonaerGame(User user, List<Category> categories, List<Difficulty> difficulties){
		player = user;
		this.categories = categories;
		this.difficulties = difficulties;
		this.questions = new HashSet<HashMap<Integer,HashSet<String>>>();
	}
	
	public void  newGame(){
		randomGenerator = new Random();
	}
	
	public void step(){
		pickQuestion();
		String answer = "";
		evaluateAnswer(answer);
	}

	

	public void pickQuestion() {
		int size = categories.size();
		if (size == 0){
			throw new IllegalStateException("Keine Kategorie!");
		}
		int chosenCategoryIndex = randomGenerator.nextInt(size);
		Category category = categories.get(chosenCategoryIndex);
		Difficulty difficulty = difficulties.get(currentDifficulty);
		List<Question> questionPool = QuestionLocalServiceUtil.findByCategoryAndDifficulty(category.getCategoryId(), difficulty.getDifficultyId());
		int chosenQuestionIndex = randomGenerator.nextInt(questionPool.size());
		currentQuestion = questionPool.get(chosenQuestionIndex);
	}
	
	public boolean evaluateAnswer(String answer) {
		//TODO log answer for stats
		if (!gameOver && currentQuestion.getRightAnswer().equals(answer)){
			
			if (currentDifficulty < difficulties.size()){
				Difficulty difficulty = difficulties.get(currentDifficulty);
				addScore(difficulty);
				if (difficulty.isGuaranteed()){
					guaranteedScore = difficulty.getScore();
				}
				currentDifficulty++;
			} else {
				win();
			}
			return true;
		} else {
			lose();
			return false;
		}
		
	}


	private void win(){
		won = true;
		gameOver();
	}
	

	public int retire(){
		gameOver();
		return score;
	}
	
	private void lose() {
		score = guaranteedScore;
		gameOver();
	}
	
	private void gameOver() {
		gameOver = true;
		saveHighscore();		
	}

	private void saveHighscore() {
		// TODO Auto-generated method stub
		
	}

	private void addScore(Difficulty difficulty) {
		score = difficulty.getScore();
		
	}
}
