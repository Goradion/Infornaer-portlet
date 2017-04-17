<%@ include file="/init.jsp"%>


<portlet:actionURL name="endGame" var="endGame"></portlet:actionURL>
<h1>Game ERROR!</h1>
<p>Etwas schreckliches ist geschehen.</p>
<p>Was auch immer Sie getan haben, berichten Sie dem Zuständigen
	davon, wenn dies nicht noch einmal passieren soll.
<p>
	<a href=<%=endGame%>>Zurück zum Hauptmenü</a>
</p>