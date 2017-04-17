<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbam.service.HighscoreLocalServiceUtil"%>
<%
	List<Highscore> highscores = HighscoreLocalServiceUtil.getHighscores(0,
			HighscoreLocalServiceUtil.getHighscoresCount());
%>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="currentPage"
		value="<%=Constants.HIGHSCORES_JSP%>" />
</liferay-portlet:renderURL>

<h1>Highscores</h1>

<liferay-ui:search-container var="searchContainer" delta="2"
	compactEmptyResultsMessage="No highscores yet."
	deltaConfigurable="false" iteratorURL="<%=iteratorURL%>">
<liferay-ui:search-container-results
		results="<%= HighscoreLocalServiceUtil.getHighscores(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>
	<liferay-ui:search-container-row className="de.ki.sbam.model.Highscore"
		modelVar="highscore" keyProperty="userId">
		<liferay-ui:search-container-column-text property="userName"
			name="Name" />
		<liferay-ui:search-container-column-text property="score"
			name="Highscore" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator  />
</liferay-ui:search-container>

<p>
	<a href=<%=mainMenu%>> Back </a>
</p>