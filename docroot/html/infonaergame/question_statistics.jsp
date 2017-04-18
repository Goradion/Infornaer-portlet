<%@ include file="/init.jsp"%>

<portlet:actionURL name="gotoQuestionOverview" var="questionOverview"></portlet:actionURL>

<!-- SearchContainer START -->
<%
	List<QuestionStatistics> questionsStatisticses = QuestionStatisticsLocalServiceUtil.getQuestionStatisticses(0,
			QuestionStatisticsLocalServiceUtil.getQuestionStatisticsesCount());
%>
<a href=<%=questionOverview%>>Zurück</a>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.QUESTION_STATS_JSP%>" />
</liferay-portlet:renderURL>

<h1>Fragen Statistiken</h1>

<liferay-ui:search-container  var="searchContainer" delta="5" emptyResultsMessage="Keine Statistiken wurden gefunden."
	compactEmptyResultsMessage="Keine Statistiken gefunden." deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = QuestionStatisticsLocalServiceUtil.getQuestionStatisticses(searchContainer.getStart(),
							searchContainer.getEnd());
					total = QuestionStatisticsLocalServiceUtil.getQuestionStatisticsesCount();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="de.ki.sbam.model.QuestionStatistics"
		modelVar="question" keyProperty="questionId">
		<liferay-ui:search-container-column-text property="questionId"
			name="Id" />
		<liferay-ui:search-container-column-text name="Frage" value="<%=QuestionLocalServiceUtil.fetchQuestion(question.getQuestionId()).getQuestionContent() %>"/>
		<liferay-ui:search-container-column-text name="A geantwortet" property="answered_a"/>
		<liferay-ui:search-container-column-text name="B geantwortet" property="answered_b"/>
		<liferay-ui:search-container-column-text name="C geantwortet" property="answered_c"/>
		<liferay-ui:search-container-column-text name="D geantwortet" property="answered_d"/>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->