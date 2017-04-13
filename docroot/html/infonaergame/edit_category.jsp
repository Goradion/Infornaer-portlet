<%@ include file="/init.jsp"%>




<portlet:actionURL name="upsertCategory" var="upsertCategory"></portlet:actionURL>
<portlet:actionURL name="goToCategoryOverview" var="categoryOverview"></portlet:actionURL>
<h1>Kategorie ändern</h1>
<form method="POST" action="${upsertCategory}" >
<input type="text" name="<portlet:namespace />categoryId" value="${categoryId}" maxlength="75" readonly hidden = "true"/> <br />
Name:
<input type="text" name="<portlet:namespace />categoryName" value="${categoryName}" maxlength="75" /> <br />
<input type="submit" value="Abschicken"> <br>
</form>
<p><a href=<%=categoryOverview%>>Zurück</a></p>