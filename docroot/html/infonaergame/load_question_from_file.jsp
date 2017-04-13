<%@ include file="/init.jsp"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="uploadQuestions" var="fileAdded"></portlet:actionURL>
<h1>Load Question From File View</h1>
<aui:fieldset>
	<aui:form action="<%=fileAdded %>" method="POST" >
		<aui:input name="uploadedFile" id="uploadFile" type="file">
			<aui:validator name="acceptFiles" >'txt'</aui:validator>
		</aui:input>
		<input type="submit" name="Laden"/>
	</aui:form>
<% if((QuestionFromFileBuilder)session.getAttribute("qffb")!=null){	
	QuestionFromFileBuilder qffb = (QuestionFromFileBuilder)session.getAttribute("qffb");
	LinkedList<String[]> q = qffb.getLoadedQuestions();
%>
	<table>
  <tr>
  	<th>Frage</th>
  	<th>Antwort A</th>
  	<th>Antwort B</th>
  	<th>Antwort C</th>
  	<th>Antwort D</th>
  	<th>Lösung</th>
  	<th>Schwierigkeit</th>
  	<th>Kategorie</th>
  </tr>
  <c:forEach items="${q}" var="q">
    <tr>
      <td><c:out value="${q[0]}" /></td>
      <td><c:out value="${q[1]}" /></td>
      <td><c:out value="${q[2]}" /></td>
      <td><c:out value="${q[3]}" /></td>
      <td><c:out value="${q[4]}" /></td>
      <td><c:out value="${q[5]}" /></td>
      <td><c:out value="${q[6]}" /></td>
      <td><c:out value="${q[7]}" /></td>
    </tr>
  </c:forEach>
</table>
<p><a>href=<%=fileAdded %>>Submit Questions</a></p>
<%}%>

</aui:fieldset>

<p><a href=<%=editMode%>> Done </a></p>
<p><a href=<%=editMode%>> Back </a></p>