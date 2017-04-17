<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="gotoNewQuestion" var="newQuestion"></portlet:actionURL>
<%-- 
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
      <td><c:out value="${q.getDifficultyId_fk()}" /></td>
      <td><c:out value="${q.getCategoryId_fk()}" /></td>
    </tr>
  </c:forEach>
</table> 
--%>
<%--For displaying Previous link except for the 1st page --%>
<%-- 
	<c:if test="${currentPage != 1}">
		<portlet:actionURL name="questionPagination" var="previousPage">
			<portlet:param name="page" value="${currentPage - 1}"/>
		</portlet:actionURL>
		<a href="<%=previousPage%>">&lt;</a>
	</c:if>
--%>
	<%--For displaying Page numbers. 
	The when condition does not display a link for the current page--%>
	<%--
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
	--%>

	<%--For displaying Next link --%>
	<%--
	<c:if test="${currentPage lt noOfPages}">
		<portlet:actionURL name="questionPagination" var="nextPage">
			<portlet:param name="page" value="${currentPage + 1}"/>
		</portlet:actionURL>
		<a href="<%=nextPage%>">&gt;</a>
	</c:if>
 --%>
<!-- SearchContainer START -->
<%
	List<Question> questions = QuestionLocalServiceUtil.getQuestions(0,
			QuestionLocalServiceUtil.getQuestionsCount());
%>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.QUESTION_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Fragen</h1>

<liferay-ui:search-container  var="searchContainer" delta="5" emptyResultsMessage="Keine Fragen wurden gefunden."
	compactEmptyResultsMessage="Keine Fragen gefunden." deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = QuestionLocalServiceUtil.getQuestions(searchContainer.getStart(),
							searchContainer.getEnd());
					total = QuestionLocalServiceUtil.getQuestionsCount();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>
<%--
	<portlet:actionURL name="gotoEditQuestion" var="edit">
		<portlet:param name="questionId" value="${c.getCategoryId()}" />
	</portlet:actionURL>
	<portlet:actionURL name="deleteCategory" var="delete">
		<portlet:param name="categoryId" value="${c.getCategoryId()}" />
	</portlet:actionURL>
 --%>	
	<liferay-ui:search-container-row className="de.ki.sbam.model.Question"
		modelVar="question" keyProperty="questionId">
<%-- 		<liferay-ui:search-container-column-text>
			<a href=<%=edit%>>Ändern</a> <a href=<%=delete%>>Löschen</a>
		</liferay-ui:search-container-column-text>
--%>
		<liferay-ui:search-container-column-text property="questionContent"
			name="Frageninhalt" />
		<liferay-ui:search-container-column-text name="Antwort A" property="answerA"/>
		<liferay-ui:search-container-column-text name="Antwort B" property="answerB"/>
		<liferay-ui:search-container-column-text name="Antwort C" property="answerC"/>
		<liferay-ui:search-container-column-text name="Antwort D" property="answerD"/>
		<liferay-ui:search-container-column-text name="Richtige Antwort" property="rightAnswer"/>
		<liferay-ui:search-container-column-text name="Kategorie">
			<%=CategoryLocalServiceUtil.fetchCategory(question.getCategoryId_fk()).getCategoryName() %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Schwierigkeit" property="difficultyId_fk"/>
		<liferay-ui:search-container-column-jsp path="<%=Constants.ADMIN_ACTION_QUESTION %>"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->


<p>
	<a href=<%=newQuestion%>>Neue Frage</a>
</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>