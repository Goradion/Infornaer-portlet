<%@ include file="/init.jsp"%>


<portlet:actionURL name="gotoGameOver" var="gameOver"></portlet:actionURL>
<portlet:actionURL name="startSimonGame" var="startSGame"></portlet:actionURL>

<h1>New Game View</h1>
<form method="POST" action="${startSGame}"> <h3>Kreuzen Sie die gewŁnschten Kategorien an:</h3> 
<fieldset> 
<c:forEach items="${cList}" var="c">
<input type="checkbox" name="<portlet:namespace />${c.getCategoryName()}" value="${c.getCategoryName()}"> <c:out value="${c.getCategoryName()}" />
<br/>
</c:forEach>
</fieldset>
<input type="submit" value="Los gehts">
</form>

<p><a href=<%=gameOver%>> To Game Over </a></p>