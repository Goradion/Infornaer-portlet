<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="goToCategoryOverview" var="categoryOverview"></portlet:actionURL>
<portlet:actionURL name="goToQuestionOverview" var="questionOverview"></portlet:actionURL>
<portlet:actionURL name="test" var="testURL"></portlet:actionURL>

<h1>Editor Modus</h1>

<p>
	<a href=<%=categoryOverview%>>Kategorien</a>
</p>
<p>
	<a href=<%=questionOverview%>>Fragen</a>
</p>
<p>
	<a href=<%=mainMenu%>>Back</a>
</p>
<p>
	<a href=<%=testURL%>>Test</a>
</p>