<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoNewQuestion" var="newQuestion"></portlet:actionURL>
<portlet:actionURL name="gotoQuestionStatistics" var="questionStats"></portlet:actionURL>

<!-- SearchContainer START -->
<%
	List<Question> questions = QuestionLocalServiceUtil.getQuestions(0,
			QuestionLocalServiceUtil.getQuestionsCount());
%>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.QUESTION_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Fragen</h1>
<p align="right"><a href='<%=questionStats%>'>Fragen Statistiken</a></p>
<liferay-ui:search-container  var="searchContainer" delta="5" emptyResultsMessage="Keine Fragen wurden gefunden."
	compactEmptyResultsMessage="Keine Fragen gefunden." deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = QuestionLocalServiceUtil.getQuestions(searchContainer.getStart(),
							searchContainer.getEnd());
					total = QuestionLocalServiceUtil.getQuestionsCount();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.ki.sbam.model.Question"
		modelVar="question" keyProperty="questionId">

		<liferay-ui:search-container-column-text property="questionContent"
			name="Frageninhalt" />
		<liferay-ui:search-container-column-text name="Antwort A" property="answerA"/>
		<liferay-ui:search-container-column-text name="Antwort B" property="answerB"/>
		<liferay-ui:search-container-column-text name="Antwort C" property="answerC"/>
		<liferay-ui:search-container-column-text name="Antwort D" property="answerD"/>
		<liferay-ui:search-container-column-text name="Richtige Antwort" property="rightAnswer"/>
		<liferay-ui:search-container-column-text name="Kategorie">
			<%=CategoryLocalServiceUtil.fetchCategory(question.getCategoryId_fk()).getCategoryName() %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Schwierigkeit" property="difficultyId_fk"/>
		<liferay-ui:search-container-column-jsp path="<%=Constants.ADMIN_ACTION_QUESTION %>"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->


<p>
	<a href=<%=newQuestion%>>Neue Frage</a>
</p>
<p>
	<a href=<%=editMode%>>Zurück</a>
</p>