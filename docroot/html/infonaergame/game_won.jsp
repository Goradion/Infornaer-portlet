<%@ include file="/init.jsp"%>



<portlet:actionURL name="endGame" var="endGame"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>

<h1>Herzlichen Gl�ckwunsch! Sie sind Inforn�r!</h1>
<p>Die 1.000.000 Informollar erhalten sie vom zust�ndigen Informator.</p>

<p><a href=<%=highscores %>>Highscores</a> ansehen</p> 

<p><a href=<%=endGame%>>Zur�ck zum Hauptmen�</a></p>