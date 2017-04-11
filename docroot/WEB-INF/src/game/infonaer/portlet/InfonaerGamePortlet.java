package game.infonaer.portlet;

import static game.infonaer.constants.Constants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

import de.ki.sbam.model.Highscore;
import de.ki.sbam.model.Question;
import de.ki.sbam.service.HighscoreLocalServiceUtil;
import de.ki.sbam.service.QuestionLocalServiceUtil;

/**
 * Portlet implementation class InfonaerGame
 */
public class InfonaerGamePortlet extends MVCPortlet {

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
//			if (curPage.equals(VIEW_JSP)) {
//				portletRequestDispatcher = portletContext.getRequestDispatcher(VIEW_JSP);
//			} else {
//				switch (curPage) {
//				case VIEW_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(VIEW_JSP);
//					break;
//				case EDIT_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(EDIT_JSP);
//					break;
//				case EDIT_MANUALLY_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(EDIT_MANUALLY_JSP);
//					break;
//				case HELP_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(HELP_JSP);
//					break;
//				case NEW_GAME_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(NEW_GAME_JSP);
//					break;
//				case HIGHSCORES_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(HIGHSCORES_JSP);
//					break;
//				case GAME_OVER_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(GAME_OVER_JSP);
//					break;
//				case LOAD_QUESTION_FROM_FILE_JSP:
//					portletRequestDispatcher = portletContext.getRequestDispatcher(LOAD_QUESTION_FROM_FILE_JSP);
//					break;
//				default:
//					break;
//				}
//
//			}
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

	public void gotoNewGame(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		actionRequest.getPortletSession().setAttribute("currentPage", NEW_GAME_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoHighscores(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", HIGHSCORES_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoMainMenu(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", VIEW_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoNewQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", NEW_QUESTION_JSP, PortletSession.PORTLET_SCOPE);
	}

	public void gotoGameOver(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", GAME_OVER_JSP, PortletSession.PORTLET_SCOPE);
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
	
	public void gotoEditQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_QUESTION_JSP,
				PortletSession.PORTLET_SCOPE);
		fillEditForm(actionRequest, actionResponse);
	}

	private void fillEditForm(ActionRequest actionRequest, ActionResponse actionResponse) {
		String questionId = actionRequest.getParameter("questionId");
		long id = Long.parseLong(questionId);
		try {
			Question question = QuestionLocalServiceUtil.getQuestion(id);
			actionRequest.setAttribute("questionId", question.getQuestionId());
			System.out.println(question.getQuestionContent());
			actionRequest.setAttribute("question", question.getQuestionContent());
			actionRequest.setAttribute("answerA", question.getAnswerA());
			actionRequest.setAttribute("answerB", question.getAnswerB());
			actionRequest.setAttribute("answerC", question.getAnswerC());
			actionRequest.setAttribute("answerD", question.getAnswerD());
			actionRequest.setAttribute("rightAnswer", question.getRightAnswer());
			actionRequest.setAttribute("difficulty", question.getDifficulty());
			actionRequest.setAttribute("category", question.getCategory());
			question.setAnswerA("neue Antwort A");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadQuestions(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, URISyntaxException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("uploadedFile");
		String fileName = uploadPortletRequest.getFileName("uploadedFile");

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
		int difficulty = Integer.parseInt(actionRequest.getParameter("difficulty"));
		String category = actionRequest.getParameter("category");
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(td.getUserId());
			if (questionId == null){
			QuestionLocalServiceUtil.addQuestion(questionContent, answerA, answerB, answerC, answerD, rightAnswer,
					category, difficulty, user);
			} else {
				long id = Long.parseLong(questionId);
				Question question = QuestionLocalServiceUtil.getQuestion(id);
				question.setQuestionContent(questionContent);
				question.setAnswerA(answerA);
				question.setAnswerB(answerB);
				question.setAnswerC(answerC);
				question.setAnswerD(answerD);
				question.setRightAnswer(rightAnswer);
				question.setDifficulty(difficulty);
				question.setCategory(category);
				question.setModifiedDate(new Date());
				QuestionLocalServiceUtil.updateQuestion(question);
				goToQuestionOverview(actionRequest, actionResponse);
			}
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}

	public void test(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.getPortletSession().setAttribute("currentPage", EDIT_QUESTION_JSP,
				PortletSession.PORTLET_SCOPE);
		System.out.println("testing edit");
		long id = 41273;
		try {
			Question question = QuestionLocalServiceUtil.getQuestion(id);
			actionRequest.setAttribute("questionId", question.getQuestionId());
			actionRequest.setAttribute("questionContent", question.getQuestionContent());
			actionRequest.setAttribute("answerA", question.getAnswerA());
			actionRequest.setAttribute("answerB", question.getAnswerB());
			actionRequest.setAttribute("answerC", question.getAnswerC());
			actionRequest.setAttribute("answerD", question.getAnswerD());
			actionRequest.setAttribute("rightAnswer", question.getRightAnswer());
			actionRequest.setAttribute("difficulty", question.getDifficulty());
			actionRequest.setAttribute("category", question.getCategory());
			question.setAnswerA("neue Antwort A");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getHighscore(ActionRequest actionRequest, ActionResponse actionResponse){
		
	}
	
	public void addHighscore(ActionRequest actionRequest, ActionResponse actionResponse){
		ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		HighscoreLocalServiceUtil.createHighscore(td.getUserId());
	}

	public void goToQuestionOverview(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().setAttribute("currentPage", QUESTION_OVERVIEW_JSP, PortletSession.PORTLET_SCOPE);
		
		questionPagination(actionRequest, actionResponse);
	}

	public void questionPagination(ActionRequest actionRequest, ActionResponse actionResponse) {
		int page = 1;
		int recordsPerPage = 5;
		if (actionRequest.getParameter("page") != null){
			page = Integer.parseInt(actionRequest.getParameter("page"));
		}
		int questionsCount = QuestionLocalServiceUtil.getQuestionsCount();
		int noOfPages = (int) Math.ceil(questionsCount * 1.0 / recordsPerPage);
		int start = (page-1)*recordsPerPage;
		int end = start + recordsPerPage;
		if (end >= questionsCount){
			end = questionsCount - 1;
		}
		List<Question> questions = QuestionLocalServiceUtil.getQuestions(start, end);
		actionRequest.setAttribute("qList", questions);
		actionRequest.setAttribute("noOfPages", noOfPages);
		actionRequest.setAttribute("currentPage", page);
	}
}
