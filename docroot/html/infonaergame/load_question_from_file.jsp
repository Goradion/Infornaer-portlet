<%@ include file="/init.jsp"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="uploadQuestions" var="fileAdded"></portlet:actionURL>
<portlet:actionURL name="gotoNewQuestion" var="newQuestion"></portlet:actionURL>
<h1>Fragen aus Datei laden</h1>
<p>Hinweis zum Format: <br/>
	frage|antwortA|antwortB|antwortC|antwortD|richtigeAntort(A|B|C|D)|Kategorie|Schwierigkeit
</p>
<%if(portletSession.getAttribute("questions")==null) {%>
	<aui:form action="<%=fileAdded %>" method="POST" >
		<aui:input name="uploadedFile" id="uploadFile" type="file" required="true">
			<aui:validator name="acceptFiles" >'txt'</aui:validator>
		</aui:input>		
		<input type="submit" name="Laden"/>
	</aui:form>
<%}else { 
	LinkedList<String[]> questions = (LinkedList<String[]>)portletSession.getAttribute("questions"); 
	%>
	<p style="color:#FF0000">There are unsubmitted Questions! Submit first.</p>
	
	<table>
	  <tr>
	  	<th>Frage</th>
	  	<th>Antwort A</th>
	  	<th>Antwort B</th>
	  	<th>Antwort C</th>
	  	<th>Antwort D</th>
	  	<th>Lösung</th>
	  	<th>Kategorie</th>
	  	<th>Schwierigkeit</th>
	  </tr>
		<%for(String[] q: questions) {%>
	    <tr>
	    	<td><%=q[0] %></td>
	    	<td><%=q[1] %></td>
	    	<td><%=q[2] %></td>
	    	<td><%=q[3] %></td>
	    	<td><%=q[4] %></td>
	    	<td><%=q[5] %></td>
	    	<td><%=q[6] %></td>
	    	<td><%=q[7] %></td>
	    </tr>
		<%} %>
	</table>
<p><a href=<%=fileAdded %>>Submit Questions</a></p>
<%} %>

<p><a href=<%=newQuestion%>> Back </a></p>
