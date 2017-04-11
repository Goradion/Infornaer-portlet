<%@ include file="/init.jsp"%>




<portlet:actionURL name="addQuestion" var="addQuestionURL" />

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<h1>Neue Frage</h1>
<form method="POST" action="${addQuestionURL}" >
	Frage: <br/>
	<textarea name="<portlet:namespace />question" rows="5" > </textarea> <br/>
	Antwort A: <br />
	<input type="text" name="<portlet:namespace />answerA" value="" maxlength="75" required/> <br />
	Antwort B: <br />
	<input type="text" name="<portlet:namespace />answerB" value="" maxlength="75" required/> <br />
	Antwort C: <br />
	<input type="text" name="<portlet:namespace />answerC" value="" maxlength="75" required/> <br />
	Antwort D: <br />
	<input type="text" name="<portlet:namespace />answerD" value="" maxlength="75" required/> <br />
	Richtige Antwort: <br />
	<select name="<portlet:namespace />rightAnswer" >
	    <option value="A">A</option>
	    <option value="B">B</option>
	    <option value="C">C</option>
	    <option value="D">D</option>
	</select>
	Schwierigkeit: <br />
	<select name="<portlet:namespace />difficulty" >
	    <option value="1">Leicht</option>
	    <option value="2">Mittel</option>
	    <option value="3">Schwer</option>
	</select>
	<br/>
	Kategorie: <br />
	<input type="text" name="<portlet:namespace />category" value="" maxlength="75" required/> <br />
	<input type="submit" value="Abschicken"> <br>
</form>	
<p><a href=<%=editMode%>>Back</a></p>