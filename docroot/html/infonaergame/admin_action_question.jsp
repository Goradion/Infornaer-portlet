<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Question question = (Question)row.getObject();
	long questionId = question.getPrimaryKey();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="gotoEditQuestion" var="editQuestion">
		<portlet:param name="questionId" value='<%=""+questionId%>'/>
	</portlet:actionURL>
	<liferay-ui:icon image="edit" message="Edit" url='<%=editQuestion %>'/>
	
	<portlet:actionURL name="deleteQuestion" var="deleteQuestion">
		<portlet:param name="questionId" value='<%=""+questionId %>'/>
	</portlet:actionURL>
	<liferay-ui:icon-delete url='<%=deleteQuestion %>'/>
	
	
</liferay-ui:icon-menu>