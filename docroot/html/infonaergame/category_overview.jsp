
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbam.service.QuestionLocalServiceUtil"%>
<%@page import="de.ki.sbam.service.CategoryLocalServiceUtil"%>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoNewCategory" var="newCategory"></portlet:actionURL>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Freigeschaltet</th>
		<th>Anzahl Fragen</th>
	</tr>
	<c:forEach items="${cList}" var="c">
		<portlet:actionURL name="gotoEditCategory" var="edit">
			<portlet:param name="categoryId" value="${c.getCategoryId()}" />
		</portlet:actionURL>
		<portlet:actionURL name="deleteCategory" var="delete">
			<portlet:param name="categoryId" value="${c.getCategoryId()}" />
		</portlet:actionURL>
		<tr>
			<td><a href=<%=edit%>>Ändern</a> <a href=<%=delete%>>Löschen</a></td>
			<td><c:out value="${c.getCategoryName()}" /></td>
			<td><c:out value="${c.isUnlocked() ? 'Ja' : 'Nein'}" /></td>
			<td><c:out
					value="${QuestionLocalServiceUtil.findByCategory(c.getCategoryId())}" /></td>

		</tr>
	</c:forEach>
</table>
<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
	<portlet:actionURL name="categoryPagination" var="previousPage">
		<portlet:param name="page" value="${currentPage - 1}" />
	</portlet:actionURL>
	<a href="<%=previousPage%>">&lt;</a>
</c:if>

<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
<c:forEach begin="1" end="${noOfPages}" var="i">
	<c:choose>
		<c:when test="${currentPage eq i}">
			<td>${i}</td>
		</c:when>
		<c:otherwise>
			<portlet:actionURL name="categoryPagination" var="pageURL">
				<portlet:param name="page" value="${i}" />
			</portlet:actionURL>
			<a href="<%=pageURL%>">${i}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<portlet:actionURL name="categoryPagination" var="nextPage">
		<portlet:param name="page" value="${currentPage + 1}" />
	</portlet:actionURL>
	<a href="<%=nextPage%>">&gt;</a>
</c:if>

<!-- TEST mit SearchContainer START -->
<%
	List<Category> categories = CategoryLocalServiceUtil.getCategories(0,
			CategoryLocalServiceUtil.getCategoriesCount());
%>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.CATEGORY_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Kategorien</h1>

<liferay-ui:search-container var="searchContainer" delta="5"
	compactEmptyResultsMessage="No categories." deltaConfigurable="false"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = CategoryLocalServiceUtil.getCategories(searchContainer.getStart(),
							searchContainer.getEnd());
					total = CategoryLocalServiceUtil.getCategoriesCount();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<portlet:actionURL name="gotoEditCategory" var="edit">
		<portlet:param name="categoryId" value="${c.getCategoryId()}" />
	</portlet:actionURL>
	<portlet:actionURL name="deleteCategory" var="delete">
		<portlet:param name="categoryId" value="${c.getCategoryId()}" />
	</portlet:actionURL>
	
	<liferay-ui:search-container-row className="de.ki.sbam.model.Category"
		modelVar="category" keyProperty="categoryId">
		<liferay-ui:search-container-column-text>
			<a href=<%=edit%>>Ändern</a> <a href=<%=delete%>>Löschen</a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="categoryName"
			name="Name" />
		<liferay-ui:search-container-column-text name="Freigeschaltet">
			<%=(category.isUnlocked())? "Ja":"Nein" %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Anzahl Fragen">
			<%=QuestionLocalServiceUtil.findByCategory(category.getCategoryId()).size() %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- TEST mit SearchContainer END -->

<p>
	<a href=<%=newCategory%>>Neue Kategorie</a>
</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>