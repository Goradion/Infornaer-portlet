<%@ include file="/init.jsp"%>



<portlet:actionURL name="upsertCategory" var="upsertCategory"></portlet:actionURL>
<portlet:actionURL name="goToCategoryOverview" var="categoryOverview"></portlet:actionURL>
<h1>Kategorie ändern</h1>
<form method="POST" action="${upsertCategory}" >
<input type="text" name="<portlet:namespace />categoryId" value="${sessionScope.categoryId}" maxlength="75" disabled="true" hidden="true"/> <br />
Name:
<input type="text" name="<portlet:namespace />categoryName" value="${sessionScope.categoryName}" maxlength="75" /> <br />
<input type="checkbox" name="<portlet:namespace />unlocked" value="${sessionScope.unlocked}" ${sessionScope.unlocked ? 'checked' : ''}  />
freischalten <div style="color:#FF0000">(muss für jede Schwierigkeit Fragen haben)</div><br>

<input type="submit" value="Abschicken"> <br>
</form>

<p><a href=<%=categoryOverview%>>Zurück</a></p>