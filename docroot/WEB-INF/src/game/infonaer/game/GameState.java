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
	
	/**
	 * 
	 * @return the user who plays the game
	 */
	public User getPlayer() {
		return player;
	}
	
	/**
	 * 
	 * @return the categories where questions can come from
	 */
	public List<Category> getCategories() {
		return categories;
	}
	/**
	 * 
	 * @return all difficulty stages
	 */
	public List<Difficulty> getDifficulties() {
		return difficulties;
	}
	
	/**
	 * 
	 * @return the current Difficulty stage
	 */
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
	
	/**
	 * 
	 * @return the question of the current stage
	 */
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	/**
	 * sets the current question to a new one
	 * @param currentQuestion
	 */
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	
	/**
	 * if the player loses he gets this score
	 * @return the guaranteed score
	 */
	public long getGuaranteedScore() {
		return guaranteedScore;
	}
	
	/**
	 * sets the guaranteed score
	 * @param guaranteedScore
	 */
	public void setGuaranteedScore(long guaranteedScore) {
		this.guaranteedScore = guaranteedScore;
	}
	
	/**
	 * 
	 * @return if the game is over
	 */
	public boolean isGameOver() {
		return gameOver;
	}
	
	/**
	 * 
	 * @return if the game has an error
	 */
	public boolean hasError(){
		return error;
	}

	/**
	 * ends the Game
	 */
	private void endGame() {
		gameOver = true;
	}
	
	/**
	 * 
	 * @return if the game is won
	 */
	public boolean isWon() {
		return won;
	}
	
	/**
	 * wins the game
	 * @return the score
	 */
	public long win(){
		won = true;
		endGame();
		return score;
	}

	/**
	 * ends the game with the current score
	 * @return the score
	 */
	public long retire() {
		endGame();
		return score;
	}
	
	/**
	 * ends the game and drops to the last guaranteed score
	 * @return the score
	 */
	public long lose() {
		dropScore();
		endGame();
		return score;
	}
	
	/**
	 * crashed the game to indicate an error
	 */
	public void crash(){
		error = true;
		endGame();
	}
	
	/**
	 * drops the score to the guaranteed score
	 */
	private void dropScore(){
		score = guaranteedScore;
	}
	
	/**
	 * 
	 * @return the score
	 */
	public long getScore() {
		return score;
	}
	
	/**
	 * sets the score
	 * @param score
	 */
	public void setScore(long score) {
		this.score = score;
	}
	
	/**
	 * 
	 * @return if the 50:50 joker was used
	 */
	public boolean isFifyFiftyUsed() {
		return fifyFiftyUsed;
	}
	
	/**
	 * indicate that the 50:50 joker was used.
	 * does not impact the question in any way.
	 * this has to be done externally.
	 */
	public void useFifyFifty() {
		this.fifyFiftyUsed = true;
	}
	
	/**
	 * 
	 * @return if the audience joker was used
	 */
	public boolean isAudienceUsed() {
		return audienceUsed;
	}
	
	/**
	 * indicate that the audience joker was used.
	 * does not impact the question in any way.
	 * this has to be done externally.
	 */
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
