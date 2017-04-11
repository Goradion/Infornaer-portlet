<%@ include file="/init.jsp"%>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>
<portlet:actionURL name="gotoNewGame" var="newGame"></portlet:actionURL>

<h1>Das Hauptmenü</h1>
<p> Hier wird das Hauptmenü angezeigt, aus dem man:</p>
	<ol>
		<li> Ein <a href=<%=newGame %>>neues Spiel</a> starten kann </li>
		<li> Die <a href=<%=highscores %>>Highscores</a> ansehen kann </li>
	</ol>

<hr>

<p> <a href=<%=editMode%>> To editor-mode </a> </p>


