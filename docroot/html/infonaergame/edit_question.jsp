<%@ include file="/init.jsp"%>




<portlet:actionURL name="addQuestion" var="addQuestionURL" />

<portlet:actionURL name="goToQuestionOverview" var="questionOverview"></portlet:actionURL>
<h1>Frage ändern</h1>
<form method="POST" action="${addQuestionURL}" >
	Id: <br/>
	<input type="text" name="<portlet:namespace />questionId" value="${questionId}" maxlength="75" readonly/> <br />
	Frage: <br/>
	<textarea name="<portlet:namespace />question" rows="5" >${question}</textarea> <br/>
	Antwort A: <br />
	<input type="text" name="<portlet:namespace />answerA" value="${answerA}" maxlength="75" required/> <br />
	Antwort B: <br />
	<input type="text" name="<portlet:namespace />answerB" value="${answerB}" maxlength="75" required/> <br />
	Antwort C: <br />
	<input type="text" name="<portlet:namespace />answerC" value="${answerC}" maxlength="75" required/> <br />
	Antwort D: <br />
	<input type="text" name="<portlet:namespace />answerD" value="${answerD}" maxlength="75" required/> <br />
	Richtige Antwort: <br />
	<select name="<portlet:namespace />rightAnswer" >
	    <option value="A" ${rightAnswer.equals("A") ? 'selected' : ''}>A</option>
	    <option value="B" ${rightAnswer.equals("B") ? 'selected' : ''}>B</option>
	    <option value="C" ${rightAnswer.equals("C") ? 'selected' : ''}>C</option>
	    <option value="D" ${rightAnswer.equals("D") ? 'selected' : ''}>D</option>
	</select>
	Schwierigkeit: <br />
	<select name="<portlet:namespace />difficulty" >
	    <option value="1" ${difficulty == 1 ? 'selected' : ''}>Leicht</option>
	    <option value="2" ${difficulty == 2 ? 'selected' : ''}>Mittel</option>
	    <option value="3" ${difficulty == 3 ? 'selected' : ''}>Schwer</option>
	</select>
	<br/>
	Kategorie: <br />
	<input type="text" name="<portlet:namespace />category" value="${category}" maxlength="75" required/> <br />
	<input type="submit" value="Ändern"> <br>
</form>	
<p><a href=<%=questionOverview%>>Zurück</a></p>