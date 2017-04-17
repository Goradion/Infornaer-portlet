<%@ include file="/init.jsp"%>




<portlet:actionURL name="upsertCategory" var="upsertCategory"></portlet:actionURL>
<portlet:actionURL name="goToCategoryOverview" var="categoryOverview"></portlet:actionURL>
<h1>Neue Kategorie</h1>
<form method="POST" action="${upsertCategory}" >
Name:
<input type="text" name="<portlet:namespace />categoryName" value="${categoryName}" maxlength="75" /> <br />
<input type="submit" value="Abschicken"> <br>
</form>
<p><a href=<%=categoryOverview%>>Zurück</a></p>