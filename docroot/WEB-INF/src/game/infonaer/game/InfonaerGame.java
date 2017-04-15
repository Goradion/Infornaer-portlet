package game.infonaer.game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.QuestionLocalService;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import de.ki.sbam.service.impl.QuestionLocalServiceImpl;

public class InfonaerGame {
	private Random randomGenerator;
	private List<Category> categories;
	private int currentDifficulty = 0;
	private List<Difficulty> difficulties;
	private Question currentQuestion; 
	private int score = 0;
	private boolean fifyFiftyUsed = false;
	private boolean audienceUsed = false;
	private boolean gameOver = false;
	private HashSet<HashMap<Integer,HashSet<String>>> questions;
	
	public InfonaerGame(List<Category> categories, List<Difficulty> difficulties){
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
		if (currentQuestion.getRightAnswer().equals(answer)){
			addScore(currentQuestion.getDifficultyId_fk());
			if (currentDifficulty < difficulties.size()){
				currentDifficulty++;
			} else {
				// win
			}
			return true;
			
		} else {
			return false;
		}
		
	}

	public int win(){
		
		return score;
	}
	public int retire(){
		gameOver = true;
		return score;
	}
	private int lose() {
		// TODO drop to lifeline
		return score;
	}

	private void saveHighscore() {
		// TODO Auto-generated method stub
		
	}

	private void addScore(long difficultyId) {
		// TODO Auto-generated method stub
		
	}
}
