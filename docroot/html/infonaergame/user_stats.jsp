<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbam.service.UserStatisticsLocalServiceUtil"%>
<%@page import="de.ki.sbam.model.UserStatistics"%>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath"
		value="<%=Constants.USER_STATS_JSP%>" />
</liferay-portlet:renderURL>

<h1>Nutzerstatistiken</h1>

<liferay-ui:search-container var="searchContainer" delta="5" emptyResultsMessage="Keine Statistiken wurden gefunden."
	compactEmptyResultsMessage="Keine Statistiken gefunden."
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
		<liferay-ui:search-container-column-text name="Name">
			<%=UserLocalServiceUtil.getUser(userStat.getUserId()).getFullName() %>
		</liferay-ui:search-container-column-text>
		 
		<liferay-ui:search-container-column-text property="gamesPlayed"
			name="Spiele gespielt" /> 
		<liferay-ui:search-container-column-text property="gamesWon"
			name="Spiele gewonnen" />
		<liferay-ui:search-container-column-text property="rightAnswers"
			name="Fragen Richtig" />
		<liferay-ui:search-container-column-text property="wrongAnswers"
			name="Fragen Falsch" />
			
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>

<p>
	<a href=<%=editMode%>> Zurück </a>
</p>