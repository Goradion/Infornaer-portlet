<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="goToCategoryOverview" var="categoryOverview"></portlet:actionURL>
<portlet:actionURL name="goToQuestionOverview" var="questionOverview"></portlet:actionURL>

<h1>Editor Modus</h1>
<p>Hier soll es möglich sein für berechtigte Spieler/Administratoren
	Fragen zu bearbeiten. Eventuell sollen nicht berechtigte Spieler, die
	Möglichkeit haben eigene Fragen einzureichen, die von Administratoren
	geprüft und zugelassen werden können.</p>
<p>Das Editieren von Fragen kann auf zwei Arten passieren:</p>

<ol>
	<li>Vorhandene Fragen aus einer Datei laden.</li>
	<li>Fragen manuell erstellen.</li>
</ol>

<p>
	<a href=<%=mainMenu%>>Back</a>
</p>

<p>
	<a href=<%=categoryOverview%>>Kategorien</a>
</p>
<p>
	<a href=<%=questionOverview%>>Fragen</a>
</p>
