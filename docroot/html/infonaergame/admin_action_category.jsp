<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Category category = (Category)row.getObject();
	long categoryId = category.getPrimaryKey();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="gotoEditCategory" var="editCategory">
		<portlet:param name="categoryId" value='<%=""+category.getCategoryId() %>'/>
	</portlet:actionURL>
	<liferay-ui:icon image="edit" message="Edit" url='<%=editCategory %>'/>
	
	<portlet:actionURL name="deleteCategory" var="deleteCategory">
		<portlet:param name="categoryId" value='<%=""+category.getCategoryId() %>'/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url='<%=deleteCategory %>'/>
	
	
</liferay-ui:icon-menu>