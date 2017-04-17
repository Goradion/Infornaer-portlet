<%@ include file="/init.jsp"%>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoHighscores" var="highscores"></portlet:actionURL>
<portlet:actionURL name="gotoNewGame" var="newGame"></portlet:actionURL>


<%
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId = "EDIT_CONTENT";
%>


<h1>Wer Wird Infornär</h1>
<ol>
	<li><a href=<%=newGame %>>Spielen</a></li>
	<li><a href=<%=highscores %>>Highscores</a></li>
</ol>

<hr>
<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, actionId) %>">
<p> <a href=<%=editMode%>> To editor-mode </a> </p>

</c:if>


