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
	private HashSet<HashMap<Integer,HashSet<String>>> questions;
	
	public InfonaerGame(){
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
		int nextInt = randomGenerator.nextInt(size);
		Category category = categories.get(nextInt);
//		QuestionLocalServiceUtil.findByCategoryAndDifficulty(categoryId_fk, difficulty);
	}
	
	public void evaluateAnswer(String answer) {
		//TODO log answer for stats
		if (currentQuestion.getRightAnswer().equals(answer)){
			addScore(currentQuestion.getDifficultyId_fk());
			pickQuestion();
		} else {
			saveHighscore();
			gameOver();
		}
		
	}

	private void gameOver() {
		// TODO Auto-generated method stub
		
	}

	private void saveHighscore() {
		// TODO Auto-generated method stub
		
	}

	private void addScore(long difficultyId) {
		// TODO Auto-generated method stub
		
	}
}
