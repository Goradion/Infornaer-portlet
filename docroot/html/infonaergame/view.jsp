<%@ include file="/init.jsp"%>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>
<portlet:actionURL name="gotoNewGame" var="newGame"></portlet:actionURL>

<h1>Wer Wird Infon�r</h1>
<ol>
	<li><a href=<%=newGame %>>Neues Spiel</a> starten kann </li>
	<li><a href=<%=highscores %>>Highscores</a> ansehen kann </li>
</ol>

<hr>

<p> <a href=<%=editMode%>> To editor-mode </a> </p>


