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
	private long guaranteedScore = 0;
	private long score = 0;
	private boolean fifyFiftyUsed = false;
	private boolean audienceUsed = false;
	private boolean gameOver = false;
	private boolean won = false;
	private boolean error = false;
	
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
	/**
	 * increases difficulty and wins the game if end is reached
	 */
	public void advanceGame(){	
		currentDifficulty++;
		if (currentDifficulty >= difficulties.size()){
			win();
		}
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public long getGuaranteedScore() {
		return guaranteedScore;
	}
	public void setGuaranteedScore(long guaranteedScore) {
		this.guaranteedScore = guaranteedScore;
	}
	public boolean isGameOver() {
		return gameOver;
	}
	
	public boolean hasError(){
		return error;
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
	
	public void crash(){
		error = true;
		endGame();
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

	@Override
	public String toString() {
		return "GameState [player=" + player.getUserId() + ", categories=" + categories + ", difficulties=" + difficulties
				+ ", currentDifficulty=" + currentDifficulty + ", currentQuestion=" + currentQuestion
				+ ", guaranteedScore=" + guaranteedScore + ", score=" + score + ", fifyFiftyUsed=" + fifyFiftyUsed
				+ ", audienceUsed=" + audienceUsed + ", gameOver=" + gameOver + ", won=" + won + "]";
	}
	
	
	
}
