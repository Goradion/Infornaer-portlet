package game.infonaer.portlet;

import static game.infonaer.constants.Constants.CATEGORY_OVERVIEW_JSP;
import static game.infonaer.constants.Constants.EDIT_CATEGORY_JSP;
import static game.infonaer.constants.Constants.EDIT_CONTENT_JSP;
import static game.infonaer.constants.Constants.EDIT_QUESTION_JSP;
import static game.infonaer.constants.Constants.GAME_ERROR_JSP;
import static game.infonaer.constants.Constants.GAME_JSP;
import static game.infonaer.constants.Constants.GAME_OVER_JSP;
import static game.infonaer.constants.Constants.GAME_WON_JSP;
import static game.infonaer.constants.Constants.HIGHSCORES_JSP;
import static game.infonaer.constants.Constants.LOAD_QUESTION_FROM_FILE_JSP;
import static game.infonaer.constants.Constants.NEW_CATEGORY_JSP;
import static game.infonaer.constants.Constants.NEW_GAME_JSP;
import static game.infonaer.constants.Constants.NEW_QUESTION_JSP;
import static game.infonaer.constants.Constants.QUESTION_OVERVIEW_JSP;
import static game.infonaer.constants.Constants.VIEW_JSP;
import static game.infonaer.constants.Constants.QUESTION_STATS_JSP;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

/**
 * Portlet implementation class InfonaerGame
 */
public class InfonaerGamePortlet extends MVCPortlet {

	/**
	 * initializes the InfonaerGamePortlet
	 * adds the established Difficulties to the Database
	 * see "Who wants to be a millionaire"
	 */
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

	/**
	 * navigates to the new game page or resumes the game in the session
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void gotoNewGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		if (gameState == null) {
			actionRequest.getPortletSession().setAttribute("currentPage", NEW_GAME_JSP, PortletSession.PORTLET_SCOPE);
			insertUnlockedCategories(actionRequest, actionResponse);
		} else {
			navigateByGameState(actionRequest, actionResponse);
		}
	}

	/**
	 * navigates to the appropiate Page depending on the gameState in the portletSession
	 * @param actionRequest
	 * @param actionResponse
	 */
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

	/**
	 * starts the game with the categories chosen on the new game page if possible
	 * creates a gameState and puts it in the portlet session
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void startGame(ActionRequest actionRequest, ActionResponse actionResponse) {
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

	/**
	 * ends the game. clears the session of attributes used by the game
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void endGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("gameState");
		portletSession.removeAttribute("audienceJokerResult");
		gotoMainMenu(actionRequest, actionResponse);
	}

	public void gotoHighscores(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", HIGHSCORES_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoMainMenu(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", VIEW_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoEditMode(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CONTENT_JSP, PortletSession.PORTLET_SCOPE);

	}
	public void gotoQuestionStatistics(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().setAttribute("currentPage", QUESTION_STATS_JSP , PortletSession.PORTLET_SCOPE);
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

	/**
	 * inserts the possible categories a question can be part of into the portlet session
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void insertCategories(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Category> categories = CategoryLocalServiceUtil.findAll();
		actionRequest.getPortletSession().setAttribute("cList", categories, PortletSession.APPLICATION_SCOPE);
	}
	/**
	 * inserts unlocked categories for use in the game into the portlet session
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void insertUnlockedCategories(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Category> categories = CategoryLocalServiceUtil.findUnlocked();
		actionRequest.getPortletSession().setAttribute("cList", categories, PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * inserts the possible difficulties a question can have into the portlet session
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void insertDifficulties(ActionRequest actionRequest, ActionResponse actionResponse) {
		List<Difficulty> difficulties = DifficultyLocalServiceUtil.findAll();
		actionRequest.getPortletSession().setAttribute("dList", difficulties, PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to edit a question
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void gotoEditQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_QUESTION_JSP, PortletSession.PORTLET_SCOPE);
		insertCategories(actionRequest, actionResponse);
		insertDifficulties(actionRequest, actionResponse);
		fillQuestionForm(actionRequest, actionResponse);
	}

	/**
	 * inserts the attributes of a chosen question to edit into the portlet session
	 * @param actionRequest
	 * @param actionResponse
	 */
	private void fillQuestionForm(ActionRequest actionRequest, ActionResponse actionResponse) {
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

	/**
	 * imports questions from an uploaded file
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws URISyntaxException
	 */
	public void uploadQuestions(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, URISyntaxException {
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

	/**
	 * updates a question with the parameters given in the actionRequest, if a questionId is given
	 * creates a new question with the parameters given in the actionRequest, i no questionId is given
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void upsertQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
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
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(td.getUserId());
			if (questionId == null) {
				QuestionLocalServiceUtil.addQuestion(questionContent, answerA, answerB, answerC, answerD, rightAnswer,
						categoryId, difficultyId, user);
			} else {
				long id = Long.parseLong(questionId);

				Question question = QuestionLocalServiceUtil.getQuestion(id);
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

	/**
	 * deletes the question with questionId given in the actionRequest
	 * and returns to the overview
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteQuestion(ActionRequest actionRequest, ActionResponse actionResponse) {
		String questionId = actionRequest.getParameter("questionId");
			try {
				QuestionLocalServiceUtil.deleteQuestion(Long.parseLong(questionId));
			} catch (NumberFormatException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		goToQuestionOverview(actionRequest, actionResponse);
	}

	/**
	 * inserts test questions into the database to test the game
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = td.getUserId();
		User user = null;
		Category category = CategoryLocalServiceUtil.addCategory("Test");
		try {
			user = UserLocalServiceUtil.getUser(userId);
			List<Difficulty> difficulties = DifficultyLocalServiceUtil.findAll();
			for (Difficulty difficulty : difficulties) {
				for (int i = 1; i < 5; i++) {
					QuestionLocalServiceUtil.addQuestion("TestfrageA " + i, "Richtig", "Falsch", "Falsch", "Falsch",
							"A", category.getCategoryId(), difficulty.getPrimaryKey(), user);
					QuestionLocalServiceUtil.addQuestion("TestfrageB " + i, "Falsch", "Richtig", "Falsch", "Falsch",
							"B", category.getCategoryId(), difficulty.getPrimaryKey(), user);
					QuestionLocalServiceUtil.addQuestion("TestfrageC " + i, "Falsch", "Falsch", "Richtig", "Falsch",
							"C", category.getCategoryId(), difficulty.getPrimaryKey(), user);
					QuestionLocalServiceUtil.addQuestion("TestfrageD " + i, "Falsch", "Falsch", "Falsch", "Richtig",
							"D", category.getCategoryId(), difficulty.getPrimaryKey(), user);
				}
			}
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * navigates to the question overview and clears the portlet session of saved attributes of a question
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void goToQuestionOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", QUESTION_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("questionId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("question", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("answerA", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("answerB", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("answerC", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("answerD", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("rightAnswer", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("difficulty", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("category", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("dList", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("cList", PortletSession.APPLICATION_SCOPE);
	}


	/**
	 * updates a category with the parameters given in the actionRequest, if a categoryId is given
	 * creates a new category with the parameters given in the actionRequest, i no questionId is given
	 * and the categoryName does not already exists (see CategoryLocalServiceImpl)
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void upsertCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		String categoryIdString = actionRequest.getParameter("categoryId");
		String categoryName = actionRequest.getParameter("categoryName");
		String unlocked = actionRequest.getParameter("unlocked");
		boolean isUnlocked = (unlocked != null);
		try {
			if (categoryIdString == null) {
				CategoryLocalServiceUtil.addCategory(categoryName);
			} else {
				long categoryId = Long.parseLong(categoryIdString);
				Category category = CategoryLocalServiceUtil.getCategory(categoryId);
				category.setCategoryName(categoryName);
				if (isUnlocked && unlockPossible(categoryId)) {
					category.setUnlocked(true);
				} else {
					category.setUnlocked(false);
				}
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

	/**
	 * determines if a category can be unlocked
	 * @param categoryId
	 * @return
	 */
	private boolean unlockPossible(long categoryId) {
		for (Difficulty difficulty : DifficultyLocalServiceUtil.findAll()) {
			List<Question> findByCategoryAndDifficulty = QuestionLocalServiceUtil
					.findByCategoryAndDifficulty(categoryId, difficulty.getPrimaryKey());
			if (findByCategoryAndDifficulty.isEmpty()) { // TODO Anzahl erhöhen
															// für variable
															// Fragen
				return false;
			}
		}
		return true;
	}

	/**
	 * deletes a category if it exists for the categoryId given in the actionRequest
	 * @param actionRequest
	 * @param actionResponse
	 */
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
		// categoryPagination(actionRequest, actionResponse);
	}

	/**
	 * navigates to a category overview
	 * clears the portlet session of attributes of a category
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void goToCategoryOverview(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", CATEGORY_OVERVIEW_JSP,
				PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("categoryId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("categoryName", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("unlocked", PortletSession.APPLICATION_SCOPE);
	}

	
	/**
	 * navigates to a form to create a new category
	 * clears the portlet session of attributes of a category
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void gotoNewCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
		PortletSession portletSession = actionRequest.getPortletSession();
		portletSession.removeAttribute("categoryId", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("categoryName", PortletSession.APPLICATION_SCOPE);
		portletSession.removeAttribute("unlocked", PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * navigates to a form to edit an existing category
	 * fills the portlet session with attributes of the category
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void gotoEditCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_CATEGORY_JSP, PortletSession.PORTLET_SCOPE);
		fillCategoryEditForm(actionRequest, actionResponse);
	}

	/**
	 * fills the portlet session with attributes of the category to use in a page
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void fillCategoryEditForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		String categoryId = actionRequest.getParameter("categoryId");
		try {
			Category category = CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryId));
			PortletSession portletSession = actionRequest.getPortletSession();
			portletSession.setAttribute("categoryId", category.getCategoryId(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("categoryName", category.getCategoryName(), PortletSession.APPLICATION_SCOPE);
			portletSession.setAttribute("unlocked", category.isUnlocked(), PortletSession.APPLICATION_SCOPE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * evaluates the answer given in the actionRequest
	 * uses InfonaerGameUtil to advance the game 
	 * @param actionRequest
	 * @param actionResponse
	 */
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

	/**
	 * ends the current game by choice
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void leaveCurrentGame(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		if (gameState != null) {
			InfonaerGameUtil.retire(gameState);
		}
		navigateByGameState(actionRequest, actionResponse);
	}

	/**
	 * uses the 50:50 joker in the current game if there is any
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void fiftyFiftyJoker(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		
		InfonaerGameUtil.useFiftyFifty(gameState);
	}

	/**
	 * uses the audience joker in the current game if there is any
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void audienceJoker(ActionRequest actionRequest, ActionResponse actionResponse) {
		GameState gameState = (GameState) actionRequest.getPortletSession().getAttribute("gameState");
		AudienceJokerResult useAudience = InfonaerGameUtil.useAudience(gameState);
		actionRequest.getPortletSession().setAttribute("audienceJokerResult", useAudience);
	}

}
