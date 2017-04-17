package game.infonaer.portlet;

import static game.infonaer.constants.Constants.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import de.ki.sbam.exception.NoSuchCategoryException;
import de.ki.sbam.exception.NoSuchHighscoreException;
import de.ki.sbam.model.Category;
import de.ki.sbam.model.Difficulty;
import de.ki.sbam.model.Highscore;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.CategoryLocalServiceUtil;
import de.ki.sbam.service.DifficultyLocalServiceUtil;
import de.ki.sbam.service.HighscoreLocalServiceUtil;
import de.ki.sbam.service.QuestionLocalServiceUtil;
import game.infonaer.game.AudienceJokerResult;
import game.infonaer.game.GameState;
import game.infonaer.game.InfonaerGameUtil;
import game.infonaer.constants.Constants;

/**
 * Portlet implementation class InfonaerGame
 */
public class InfonaerGamePortlet extends MVCPortlet {

	@Override
	public void init() throws PortletException {
		super.init();
		int scores[] = { 50, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 500000, 1000000 };
		boolean guarantees[] = { false, false, false, false, true, false, false, false, false, true, false, false,
				false, false, false };

		for (int i = 0; i < 15; i++) {
			DifficultyLocalServiceUtil.addDifficultry(scores[i], guarantees[i]);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doEdit(renderRequest, renderResponse);

	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletContext portletContext = this.getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext
				.getRequestDispatcher("/html/infonaergame/view.jsp");
		Object o = renderRequest.getPortletSession().getAttribute("currentPage", PortletSession.PORTLET_SCOPE);
		String curPage = VIEW_JSP;
		if (o != null) {
			curPage = o.toString();
			portletRequestDispatcher = portletContext.getRequestDispatcher(curPage);
		}
		portletRequestDispatcher.include(renderRequest, renderResponse);

	}

	@ProcessAction(name = "clearEntities")
	public void clearEntities(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// QuestionLocalServiceUtil.deleteAllQuestions();
		// CategoryLocalServiceUtil.deleteAllCategories();
		// DifficultyLocalServiceUtil.deleteAllDifficulties();
	}

	public void gotoNewGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		if (gameState == null) {
			actionRequest.getPortletSession().setAttribute("currentPage", NEW_GAME_JSP, PortletSession.PORTLET_SCOPE);
			insertUnlockedCategories(actionRequest, actionResponse);
		} else {
			navigateByGameState(actionRequest, actionResponse);
		}
	}

	private void navigateByGameState(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		if (gameState == null) {
			gotoNewGame(actionRequest, actionResponse);
		} else {
			if (gameState.isGameOver()) {
				if (gameState.hasError()) {
					gotoGameError(actionRequest, actionResponse);
				} else if (gameState.isWon()) {
					gotoGameWon(actionRequest, actionResponse);
				} else {
					gotoGameOver(actionRequest, actionResponse);
				}
			} else {
				gotoGameQuestion(actionRequest, actionResponse);
			}
		}

	}

	private void gotoGameError(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_ERROR_JSP, PortletSession.PORTLET_SCOPE);
		
	}

	private void gotoGameWon(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_WON_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoGameOver(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_OVER_JSP, PortletSession.PORTLET_SCOPE);
	}

	private void gotoGameQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void startSimonGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		String[] categoryNames = actionRequest.getParameterValues("categories");
		if (categoryNames == null) {
			gotoMainMenu(actionRequest, actionResponse);
			return;
		}
		List<Category> selectedCategories = new ArrayList<>();

		for (String categoryName : categoryNames) {
			try {
				selectedCategories.add(CategoryLocalServiceUtil.getCategoryByName(categoryName));
			} catch (NoSuchCategoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		List<Difficulty> difficulties = DifficultyLocalServiceUtil.findAll();
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = td.getUser();
		GameState gameState = new GameState(user, selectedCategories, difficulties);
		InfonaerGameUtil.pickQuestion(gameState);
		actionRequest.getPortletSession().setAttribute("gameState", gameState, PortletSession.PORTLET_SCOPE);
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void endGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("gameState");
		portletSession.removeAttribute("audienceJokerResult");
		gotoMainMenu(actionRequest, actionResponse);
	}

	public void gotoHighscores(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", HIGHSCORES_JSP, PortletSession.PORTLET_SCOPE);

		// HashMap<String,Long> highscores = new HashMap<String,Long>();
		// for(Highscore h:
		// HighscoreLocalServiceUtil.getHighscores(QueryUtil.ALL_POS,
		// QueryUtil.ALL_POS)){
		// highscores.put(h.getUserName(), h.getScore());
		// }
		// actionRequest.setAttribute("highscores", highscores);
		// testHighscores();
	}

	public void highscoresPagination(ActionRequest actionRequest, ActionResponse actionResponse) {
		int page = 1;
		int recordsPerPage = 5;
		if (actionRequest.getParameter("page") != null) {
			page = Integer.parseInt(actionRequest.getParameter("page"));
		}
		int highscoresCount = HighscoreLocalServiceUtil.getHighscoresCount();
		int noOfPages = (int) Math.ceil(highscoresCount * 1.0 / recordsPerPage);
		int start = (page - 1) * recordsPerPage;
		int end = start + recordsPerPage;
		if (end > highscoresCount) {
			end = highscoresCount;
		}
		List<Highscore> highscores = HighscoreLocalServiceUtil.getHighscores(start, end);
		actionRequest.setAttribute("highscoresList", highscores);
		actionRequest.setAttribute("noOfPages", noOfPages);
		actionRequest.setAttribute("currentPage", page);
	}

	public void gotoMainMenu(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", VIEW_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoEditMode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_JSP, PortletSession.PORTLET_SCOPE);

	}

	public void gotoLoadQuestionFromFile(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", LOAD_QUESTION_FROM_FILE_JSP,
				PortletSession.PORTLET_SCOPE);
	}

	public void gotoNewQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_QUESTION_JSP, PortletSession.PORTLET_SCOPE);
		insertCategories(actionRequest, actionResponse);
		insertDifficulties(actionRequest, actionResponse);
	}

	private void insertCategories(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Category> categories = CategoryLocalServiceUtil.findAll();
		actionRequest.getPortletSession().setAttribute("cList", categories, PortletSession.APPLICATION_SCOPE);
	}

	private void insertUnlockedCategories(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Category> categories = CategoryLocalServiceUtil.findUnlocked();
		actionRequest.getPortletSession().setAttribute("cList", categories, PortletSession.APPLICATION_SCOPE);
	}

	private void insertDifficulties(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Difficulty> difficulties = DifficultyLocalServiceUtil.findAll();
		actionRequest.setAttribute("dList", difficulties);
	}

	public void gotoEditQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_QUESTION_JSP, PortletSession.PORTLET_SCOPE);
		insertCategories(actionRequest, actionResponse);
		insertDifficulties(actionRequest, actionResponse);
		fillEditForm(actionRequest, actionResponse);
	}

	private void fillEditForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		String questionId = actionRequest.getParameter("questionId");
		long id = Long.parseLong(questionId);
		try {
			Question question = QuestionLocalServiceUtil.getQuestion(id);
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("questionId", question.getQuestionId(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("question", question.getQuestionContent(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("answerA", question.getAnswerA(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("answerB", question.getAnswerB(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("answerC", question.getAnswerC(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("answerD", question.getAnswerD(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("rightAnswer", question.getRightAnswer(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("difficulty", question.getDifficultyId_fk(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("category", question.getCategoryId_fk(), PortletSession.APPLICATION_SCOPE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadQuestions(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, URISyntaxException {
		System.out.println("Uploading questions requested...");
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		if (actionRequest.getPortletSession().getAttribute("questions") == null) {
			File file = uploadPortletRequest.getFile("uploadedFile");
			QuestionFromFileBuilder qffb = new QuestionFromFileBuilder(file);
			qffb.buildQuestions();
			LinkedList<String[]> tokenizedQuestions = new LinkedList<String[]>(qffb.questionsTokenized);
			if (!tokenizedQuestions.isEmpty()) {
				// pass to view
				actionRequest.getPortletSession().setAttribute("questions", tokenizedQuestions);
				return;
			}
		} else {
			// create questions
			LinkedList<String[]> tokenizedQuestions = (LinkedList<String[]>) actionRequest.getPortletSession()
					.getAttribute("questions");
			for (String[] q : tokenizedQuestions) {
				try {
					// löse catName zu catId auf
					long catId = CategoryLocalServiceUtil.getCategoryByName(q[6]).getCategoryId();
					QuestionLocalServiceUtil.addQuestion(q[0], q[1], q[2], q[3], q[4], q[5].toUpperCase(), catId,
							Integer.parseInt(q[7]), td.getUser());
				} catch (NoSuchUserException | NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchCategoryException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			actionRequest.getPortletSession().removeAttribute("questions");
		}
	}

	public void addQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String questionId = actionRequest.getParameter("questionId");
		String questionContent = actionRequest.getParameter("question");
		String answerA = actionRequest.getParameter("answerA");
		String answerB = actionRequest.getParameter("answerB");
		String answerC = actionRequest.getParameter("answerC");
		String answerD = actionRequest.getParameter("answerD");
		String rightAnswer = actionRequest.getParameter("rightAnswer");
		long difficultyId = Long.parseLong(actionRequest.getParameter("difficulty"));
		String categoryString = actionRequest.getParameter("category");
		long categoryId = Long.parseLong(categoryString);
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(td.getUserId());
			if (questionId == null) {
				QuestionLocalServiceUtil.addQuestion(questionContent, answerA, answerB, answerC, answerD, rightAnswer,
						categoryId, difficultyId, user);
			} else {
				long id = Long.parseLong(questionId);

				Question question = QuestionLocalServiceUtil.getQuestion(id);
				Category category = CategoryLocalServiceUtil.getCategory(categoryId);
				question.setQuestionContent(questionContent);
				question.setAnswerA(answerA);
				question.setAnswerB(answerB);
				question.setAnswerC(answerC);
				question.setAnswerD(answerD);
				question.setRightAnswer(rightAnswer);
				question.setDifficultyId_fk(difficultyId);
				question.setCategoryId_fk(categoryId);
				question.setModifiedDate(new Date());
				QuestionLocalServiceUtil.updateQuestion(question);
			}
			goToQuestionOverview(actionRequest, actionResponse);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberFormatException e2) {

		}

	}

	public void deleteQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
		String questionId = actionRequest.getParameter("questionId");
		try {
			QuestionLocalServiceUtil.deleteQuestion(Long.parseLong(questionId));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goToQuestionOverview(actionRequest, actionResponse);
	}

	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
		// actionRequest.getPortletSession().setAttribute("currentPage",
		// EDIT_QUESTION_JSP, PortletSession.PORTLET_SCOPE);
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		System.out.println(gameState.getCurrentDifficulty());
	}

	public void getHighscore(ActionRequest actionRequest, ActionResponse actionResponse) {

	}

	public void addHighscore(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		// HighscoreLocalServiceUtil.createHighscore(td.getUserId());
	}

	public void goToQuestionOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", QUESTION_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);

		questionPagination(actionRequest, actionResponse);
	}

	public void questionPagination(ActionRequest actionRequest, ActionResponse actionResponse) {
		int page = 1;
		int recordsPerPage = 5;
		if (actionRequest.getParameter("page") != null) {
			page = Integer.parseInt(actionRequest.getParameter("page"));
		}
		int questionsCount = QuestionLocalServiceUtil.getQuestionsCount();
		int noOfPages = (int) Math.ceil(questionsCount * 1.0 / recordsPerPage);
		int start = (page - 1) * recordsPerPage;
		int end = start + recordsPerPage;
		if (end > questionsCount) {
			end = questionsCount;
		}
		List<Question> questions = QuestionLocalServiceUtil.getQuestions(start, end);
		actionRequest.setAttribute("qList", questions);
		actionRequest.setAttribute("noOfPages", noOfPages);
		actionRequest.setAttribute("currentPage", page);
	}

	public void upsertCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		String categoryId = actionRequest.getParameter("categoryId");
		String categoryName = actionRequest.getParameter("categoryName");
		String unlocked = actionRequest.getParameter("unlocked");
		boolean isUnlocked = (unlocked != null);
		try {
			if (categoryId == null) {
				CategoryLocalServiceUtil.addCategory(categoryName);
			} else {
				Category category = CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryId));
				category.setCategoryName(categoryName);
				category.setUnlocked(isUnlocked);
				CategoryLocalServiceUtil.updateCategory(category);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goToCategoryOverview(actionRequest, actionResponse);
	}

	public void deleteCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		String categoryId = actionRequest.getParameter("categoryId");
		try {
			CategoryLocalServiceUtil.deleteCategory(Long.parseLong(categoryId));
		} catch (NoSuchCategoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		categoryPagination(actionRequest, actionResponse);
	}

	public void goToCategoryOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", CATEGORY_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);

		categoryPagination(actionRequest, actionResponse);
	}

	public void categoryPagination(ActionRequest actionRequest, ActionResponse actionResponse) {
		int page = 1;
		int recordsPerPage = 5;
		if (actionRequest.getParameter("page") != null) {
			page = Integer.parseInt(actionRequest.getParameter("page"));
		}
		int categoryCount = CategoryLocalServiceUtil.getCategoriesCount();
		int noOfPages = (int) Math.ceil(categoryCount * 1.0 / recordsPerPage);
		int start = (page - 1) * recordsPerPage;
		int end = start + recordsPerPage;
		if (end > categoryCount) {
			end = categoryCount;
		}
		List<Category> categories = CategoryLocalServiceUtil.getCategories(start, end);
		actionRequest.setAttribute("cList", categories);
		actionRequest.setAttribute("noOfPages", noOfPages);
		actionRequest.setAttribute("currentPage", page);
	}

	public void gotoNewCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoEditCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
		fillCategoryInput(actionRequest, actionResponse);
	}

	public void fillCategoryInput(ActionRequest actionRequest, ActionResponse actionResponse) {
		String categoryId = actionRequest.getParameter("categoryId");
		try {
			Category category = CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryId));
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("categoryId", category.getCategoryId(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("categoryName", category.getCategoryName(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("unlocked", category.getCategoryName(), PortletSession.APPLICATION_SCOPE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void evalAnswer(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().removeAttribute("audienceJokerResult");
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		if (gameState == null) {
			gotoMainMenu(actionRequest, actionResponse);
		} else {
			String answer = actionRequest.getParameter("answer");
			boolean evaluateAnswer = InfonaerGameUtil.evaluateAnswer(gameState, answer.toUpperCase());
			if (evaluateAnswer && !gameState.isGameOver()) {
				InfonaerGameUtil.pickQuestion(gameState);
			}
			navigateByGameState(actionRequest, actionResponse);
		}
	}

	public void startGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_JSP, PortletSession.PORTLET_SCOPE);
		Question question = QuestionLocalServiceUtil.findByDifficulty(1).get(0);
		actionRequest.setAttribute("question", question);
	}

	public void leaveCurrentGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_GAME_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void fiftyFiftyJoker(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		InfonaerGameUtil.useFiftyFifty(gameState);
	}

	public void audienceJoker(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		AudienceJokerResult useAudience = InfonaerGameUtil.useAudience(gameState);
		actionRequest.getPortletSession().setAttribute("audienceJokerResult", useAudience);
		System.out.println("publicJoker"); // TODO remove
		System.out.println(useAudience);
	}

	private void testHighscores() {
		List<User> users = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (User u : users) {
			System.out.println(u.getUserId() + " " + u.getFullName());
		}
		for (int i = 0; i < 50; i++) {
			HighscoreLocalServiceUtil.addHighscore(new Random().nextLong(), users.get(i % users.size()));
		}
		for (Highscore h : HighscoreLocalServiceUtil.getHighscores(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
			System.out.println(h.getScore() + " " + h.getUserName());
		}
	}
}
