<%@ include file="/init.jsp"%>
<%@page import="game.infonaer.game.GameState"%>


<portlet:actionURL name="endGame" var="endGame"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>
<h1>Game Over!</h1>
<p>Viel Glück beim nächsten Mal.</p>
<%
GameState gameState = (GameState) portletSession.getAttribute("gameState");
if (gameState != null){
%>
<p>Sie gehen mit <%=gameState.getScore()%> Informollar nach Hause.</p>

<% } %>
<p><a href=<%=highscores %>>Highscores</a> ansehen</p> 
<p><a href=<%=endGame%>>Zurück zum Hauptmenü</a></p>