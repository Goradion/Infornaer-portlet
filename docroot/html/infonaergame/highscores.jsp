<%@ include file="/init.jsp"%>


<portlet:actionURL name="gotoMainMenu" var="mainMenu">
	
</portlet:actionURL>

<h1>Highscores</h1>
<div>
Hier sollen die Highscores aller Spieler einsehbar sein.<br>
	Wenn der Spieler eingeloggt ist, bekommt er sein eigenes Ergebnis,<br>
	falls er schon mal gespielt hat und sein Name in den Highscores vorhanden ist.<br>
	Sein Name soll etwa so in der Liste erscheinen:<br>
	<ul>
		<li> 1. Spieler Spieler
		<li> 2. Spieler Spieler
		<li> 3. UNSER SPIELER
		<li> ...
		<li> 10. Der Zehnte Spieler
	</ul>
	<br>
	oder so, falls er nicht unter den 10 besten ist:<br>
	<ul>
		<li> ...
		<li> ...
		<li> Ein Spieler Mittendrin
		<li> Noch ein Spieler
		<li> UNSER SPIELER
		<li> Ein Spieler nach unserem Spieler
		<li> noch einer
		<li> ...
		<li> ...
	</ul> 
	<br>
	Falls er nicht eingeloggt ist, werden nur die ersten (z.B.) 10 Spieler aufgelistet.<br>
</div>
<p>
	<a href=<%=mainMenu%>> Back </a>
</p>