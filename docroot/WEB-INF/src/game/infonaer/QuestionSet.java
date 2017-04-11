package game.infonaer;

import static game.infonaer.constants.Constants.EASY;

import java.util.HashSet;
import java.util.Random;

import de.ki.sbam.model.Question;
import de.ki.sbam.service.QuestionLocalServiceUtil;



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
