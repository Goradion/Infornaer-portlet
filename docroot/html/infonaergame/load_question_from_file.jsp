<%@ include file="/init.jsp"%>


<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="uploadQuestions" var="fileAdded"></portlet:actionURL>
<h1>Load Question From File View</h1>

<aui:form action="<%=fileAdded %>" method="POST" >
	<aui:input name="uploadedFile" id="uploadFile" type="file">
		<aui:validator name="acceptFiles" >'txt'</aui:validator>
	</aui:input>
	<input type="submit" name="Laden"/>
</aui:form> 
<p><a href=<%=editMode%>> Done </a></p>
<p><a href=<%=editMode%>> Back </a></p>