<%@ include file="/init.jsp"%>



<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="gotoNewQuestion" var="newQuestion"></portlet:actionURL>
<portlet:actionURL name="gotoLoadQuestionFromFile" var="loadFromFile"></portlet:actionURL>
<portlet:actionURL name="goToQuestionOverview" var="questionOverview"></portlet:actionURL>

<h1>Editor Modus</h1>
<p>Hier soll es m�glich sein f�r berechtigte Spieler/Administratoren
	Fragen zu bearbeiten. Eventuell sollen nicht berechtigte Spieler, die
	M�glichkeit haben eigene Fragen einzureichen, die von Administratoren
	gepr�ft und zugelassen werden k�nnen.</p>
<p>Das Editieren von Fragen kann auf zwei Arten passieren:</p>

<ol>
	<li>Vorhandene Fragen aus einer Datei laden.</li>
	<li>Fragen manuell erstellen.</li>
</ol>

<p>
	<a href=<%=mainMenu%>>Back</a>
</p>
<p><a href=<%=loadFromFile%>> Load Question From File </a></p>
<p>
	<a href=<%=newQuestion%>>Edit manually</a>
</p>
<p>
	<a href=<%=questionOverview%>>Fragen �berblick</a>
</p>