<%@ include file="/init.jsp"%>


<portlet:actionURL name="startGame" var="startGame"></portlet:actionURL>
<portlet:actionURL name="startGame" var="game"></portlet:actionURL>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>

<h1>Neues Spiel</h1>
<form method="POST" action="${startGame}"> <h3>Kreuzen Sie die gewünschten Kategorien an:</h3> 
<fieldset> 
<c:if test="${sessionScope.cList == null}">keine Kategorien freigeschaltet</c:if>
<c:forEach items="${sessionScope.cList}" var="c">
	<input type="checkbox" name="<portlet:namespace />categories" value="${c.getCategoryName()}"> <c:out value="${c.getCategoryName()}" />
<br/>
</c:forEach>
</fieldset>
<input type="submit" value="Los gehts">
</form>
<p><a href=<%=mainMenu%>> Zurück </a></p>

