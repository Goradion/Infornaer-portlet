<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="gotoCategoryOverview" var="categoryOverview"></portlet:actionURL>
<portlet:actionURL name="gotoQuestionOverview" var="questionOverview"></portlet:actionURL>
<portlet:actionURL name="gotoUserStats" var="userStats"></portlet:actionURL>

<portlet:actionURL name="test" var="testURL"></portlet:actionURL>

<h1>Editor Modus</h1>

<p>
	<a href=<%=categoryOverview%>>Kategorien</a>
</p>
<p>
	<a href=<%=questionOverview%>>Fragen</a>
</p>
<p>
	<a href=<%=userStats%>>Nutzerstatistiken</a>
</p>
<p>
	<a href=<%=mainMenu%>>Back</a>
</p>

<h2>Testbereich zu Demozwecken</h2>
<div style="color:#FF0000">fügt ca. 240 Fragen in die Kategorie Test:</div>
<p><a href=<%=testURL%>>Testfragen einfügen</a></p>
