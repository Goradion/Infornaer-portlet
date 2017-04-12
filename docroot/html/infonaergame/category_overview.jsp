
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="test" var="test"></portlet:actionURL>



<p><a href=<%=test%>> Test </a></p>
<table>
  <tr>
  	<th>Id</th>
  	<th>Name</th>
  </tr>
  <c:forEach items="${cList}" var="c">
  	<portlet:actionURL name="gotoEditCategory" var="edit">
		<portlet:param name="questionId" value="${c.getQuestionId()}"/>
	</portlet:actionURL>
	<portlet:actionURL name="deleteCategory" var="delete">
		<portlet:param name="categoryId" value="${c.getQuestionId()}"/>
	</portlet:actionURL>
    <tr>
      <td><a href = <%=edit%> >�ndern</a> <a href = <%=delete%> >L�schen</a></td>
      <td><c:out value="${c.getCategoryName()}" /></td>
      
    </tr>
  </c:forEach>
</table>
<%--For displaying Previous link except for the 1st page --%>
	<c:if test="${currentPage != 1}">
		<portlet:actionURL name="categoryPagination" var="previousPage">
			<portlet:param name="page" value="${currentPage - 1}"/>
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
					<portlet:param name="page" value="${i}"/>
				</portlet:actionURL>
				<a href="<%=pageURL%>">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<portlet:actionURL name="categoryPagination" var="nextPage">
			<portlet:param name="page" value="${currentPage + 1}"/>
		</portlet:actionURL>
		<a href="<%=nextPage%>">&gt;</a>
	</c:if>
	

</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>