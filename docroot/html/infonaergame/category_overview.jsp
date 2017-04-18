<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoNewCategory" var="newCategory"></portlet:actionURL>


<!-- SearchContainer START -->
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
	compactEmptyResultsMessage="Keine Kategorien gefunden." deltaConfigurable="true"
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

	<liferay-ui:search-container-row className="de.ki.sbam.model.Category"
		modelVar="category" keyProperty="categoryId">
		<liferay-ui:search-container-column-text property="categoryName"
			name="Name" />
		<liferay-ui:search-container-column-text name="Freigeschaltet">
			<%=(category.isUnlocked())? "Ja":"Nein" %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Anzahl Fragen">
			<%=QuestionLocalServiceUtil.findByCategory(category.getCategoryId()).size() %>
		</liferay-ui:search-container-column-text>
	<liferay-ui:search-container-column-jsp path="<%=Constants.ADMIN_ACTION_CATEGORY %>"/>  
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->

<p>
	<a href=<%=newCategory%>>Neue Kategorie</a>
</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>