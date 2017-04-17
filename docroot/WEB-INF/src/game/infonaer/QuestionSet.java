package game.infonaer;


import java.util.HashSet;

import de.ki.sbam.model.Question;



public class QuestionSet {
	// private HashMap<Integer, HashSet<Question>> questions;
	private HashSet<Question> questions;

	public QuestionSet() {
		for (int i = 0; i < 5; i++) {
			Question question = null;
			do {
//				int rand = new Random().nextInt(QuestionLocalServiceUtil.findByDifficulty(EASY).size());
//				question = QuestionLocalServiceUtil.findByDifficulty(EASY).get(rand);
			} while (!questions.add(question));
		}
	}
}
