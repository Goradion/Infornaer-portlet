<%@ include file="/init.jsp"%>



<portlet:actionURL name="endGame" var="endGame"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>

<h1>Herzlichen Glückwunsch! Sie sind Infornär!</h1>
<p>Die 1.000.000 Informollar erhalten sie vom zuständigen Informator.</p>

<p><a href=<%=highscores %>>Highscores</a> ansehen</p> 

<p><a href=<%=endGame%>>Zurück zum Hauptmenü</a></p>