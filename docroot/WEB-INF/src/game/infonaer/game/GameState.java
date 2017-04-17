package game.infonaer.game;

import java.util.List;

import com.liferay.portal.kernel.model.User;

import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Question;

public class GameState {
	
	private User player;
	private List<Category> categories;
	
	private List<Difficulty> difficulties;
	
	private int currentDifficulty = 0;
	private Question currentQuestion; 
	private int guaranteedScore = 0;
	private long score = 0;
	private boolean fifyFiftyUsed = false;
	private boolean audienceUsed = false;
	private boolean gameOver = false;
	private boolean won = false;
	
	public GameState(User player, List<Category> categories, List<Difficulty> difficulties) {
		super();
		this.player = player;
		this.categories = categories;
		this.difficulties = difficulties;
	}
	
	public User getPlayer() {
		return player;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public List<Difficulty> getDifficulties() {
		return difficulties;
	}
	public int getCurrentDifficulty() {
		return currentDifficulty;
	}
	public void increaseCurrentDifficulty(){
			currentDifficulty++;
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public int getGuaranteedScore() {
		return guaranteedScore;
	}
	public void setGuaranteedScore(int guaranteedScore) {
		this.guaranteedScore = guaranteedScore;
	}
	public boolean isGameOver() {
		return gameOver;
	}

	private void endGame() {
		gameOver = true;
	}
	
	public boolean isWon() {
		return won;
	}
	
	public long win(){
		won = true;
		endGame();
		return score;
	}

	public long retire() {
		endGame();
		return score;
	}
	
	public long lose() {
		dropScore();
		endGame();
		return score;
	}
	
	private void dropScore(){
		score = guaranteedScore;
	}
	
	public long getScore() {
		return score;
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
	public boolean isFifyFiftyUsed() {
		return fifyFiftyUsed;
	}
	
	public void useFifyFifty() {
		this.fifyFiftyUsed = true;
	}
	
	public boolean isAudienceUsed() {
		return audienceUsed;
	}
	
	public void useAudience() {
		this.audienceUsed = true;
	}
	
	
	
}
