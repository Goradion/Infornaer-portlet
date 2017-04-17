<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbam.service.UserStatisticsLocalServiceUtil"%>
<%@page import="de.ki.sbam.model.UserStatistics"%>

<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath"
		value="<%=Constants.HIGHSCORES_JSP%>" />
</liferay-portlet:renderURL>

<h1>Highscores</h1>

<liferay-ui:search-container var="searchContainer" delta="5"
	compactEmptyResultsMessage="No user stats yet."
	deltaConfigurable="true" iteratorURL="<%=iteratorURL%>">
<liferay-ui:search-container-results> 
<%
results = UserStatisticsLocalServiceUtil.getUserStatisticses(searchContainer.getStart(), searchContainer.getEnd());
total = UserStatisticsLocalServiceUtil.getUserStatisticsesCount();
searchContainer.setTotal(total);
searchContainer.setResults(results);
%>

</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="de.ki.sbam.model.UserStatistics"
		modelVar="userStat" keyProperty="userId">
		<liferay-ui:search-container-column-text name="Name" />
		 <%=UserLocalServiceUtil.getUser(userStat.getUserId()).getFullName() %>
		<liferay-ui:search-container-column-text property="gamePlayed"
			name="Gespielt" /> 
		<liferay-ui:search-container-column-text property="gameWon"
			name="Gewonnen" />
		<liferay-ui:search-container-column-text property="answersRight"
			name="Fragen Richtig" />
		<liferay-ui:search-container-column-text property="answersWrong"
			name="Fragen Falsch" />
			
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>

<p>
	<a href=<%=mainMenu%>> Back </a>
</p>