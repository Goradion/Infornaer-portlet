<%@ include file="/init.jsp"%>


<portlet:actionURL name="startSimonGame" var="startSGame"></portlet:actionURL>
<portlet:actionURL name="startGame" var="game"></portlet:actionURL>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>

<h1>New Game View</h1>
<form method="POST" action="${startSGame}"> <h3>Kreuzen Sie die gewünschten Kategorien an:</h3> 
<fieldset> 
<c:forEach items="${sessionScope.cList}" var="c">
<input type="checkbox" name="<portlet:namespace />categories" value="${c.getCategoryName()}"> <c:out value="${c.getCategoryName()}" />
<br/>
</c:forEach>
</fieldset>
<input type="submit" value="Los gehts">
</form>
<p><a href=<%=game%>> start the game </a></p>
<p><a href=<%=mainMenu%>> To Game Over </a></p>

