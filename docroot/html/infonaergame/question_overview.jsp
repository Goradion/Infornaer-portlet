
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoNewQuestion" var="newQuestion"></portlet:actionURL>

<table>
  <tr>
  	<th>Id</th>
  	<th>Frage</th>
  	<th>Antwort A</th>
  	<th>Antwort B</th>
  	<th>Antwort C</th>
  	<th>Antwort D</th>
  	<th>Lösung</th>
  	<th>Schwierigkeit</th>
  	<th>Kategorie</th>
  </tr>
  <c:forEach items="${qList}" var="q">
  	<portlet:actionURL name="gotoEditQuestion" var="edit">
		<portlet:param name="questionId" value="${q.getQuestionId()}"/>
	</portlet:actionURL>
	<portlet:actionURL name="deleteQuestion" var="delete">
		<portlet:param name="questionId" value="${q.getQuestionId()}"/>
	</portlet:actionURL>
    <tr>
      <td><a href = <%=edit%> >Ändern</a> <a href = <%=delete%> >Löschen</a></td>
      <td><c:out value="${q.getQuestionContent()}" /></td>
      <td><c:out value="${q.getAnswerA()}" /></td>
      <td><c:out value="${q.getAnswerB()}" /></td>
      <td><c:out value="${q.getAnswerC()}" /></td>
      <td><c:out value="${q.getAnswerD()}" /></td>
      <td><c:out value="${q.getRightAnswer()}" /></td>
      <td><c:out value="${q.getDifficulty()}" /></td>
      <td><c:out value="${q.getCategory()}" /></td>
    </tr>
  </c:forEach>
</table>
<%--For displaying Previous link except for the 1st page --%>
	<c:if test="${currentPage != 1}">
		<portlet:actionURL name="questionPagination" var="previousPage">
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
				<portlet:actionURL name="questionPagination" var="pageURL">
					<portlet:param name="page" value="${i}"/>
				</portlet:actionURL>
				<a href="<%=pageURL%>">${i}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<%--For displaying Next link --%>
	<c:if test="${currentPage lt noOfPages}">
		<portlet:actionURL name="questionPagination" var="nextPage">
			<portlet:param name="page" value="${currentPage + 1}"/>
		</portlet:actionURL>
		<a href="<%=nextPage%>">&gt;</a>
	</c:if>
	
<p>
	<a href=<%=newQuestion%>>Neue Nachricht</a>
</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>