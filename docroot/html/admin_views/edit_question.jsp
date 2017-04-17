<%@ include file="/init.jsp"%>




<portlet:actionURL name="addQuestion" var="addQuestionURL" />

<portlet:actionURL name="goToQuestionOverview" var="questionOverview"></portlet:actionURL>
<h1>Frage ändern</h1>
<form method="POST" action="${addQuestionURL}">
	<input type="text" name="<portlet:namespace />questionId" 
		value="${sessionScope.questionId}" maxlength="75" readonly	hidden="true" /> <br /> 
	Frage: <br />
	<textarea name="<portlet:namespace />question" rows="5">${sessionScope.question}</textarea>	<br /> 
	Antwort A: <br /> 
	<input type="text"	name="<portlet:namespace />answerA" value="${sessionScope.answerA}"
		maxlength="75" required /> <br /> 
	Antwort B: <br /> 
	<input	type="text" name="<portlet:namespace />answerB"	value="${sessionScope.answerB}" maxlength="75" required /> <br />
	Antwort C: <br /> 
	<input type="text" name="<portlet:namespace />answerC" value="${sessionScope.answerC}"	maxlength="75" required /> <br /> 
	Antwort D: <br /> 
	<input type="text" name="<portlet:namespace />answerD"	value="${sessionScope.answerD}" maxlength="75" required /> <br />
	Richtige Antwort: <br /> 
	<select	name="<portlet:namespace />rightAnswer">
		<option value="A"
			${sessionScope.rightAnswer.equals("A") ? 'selected' : ''}>A</option>
		<option value="B"
			${sessionScope.rightAnswer.equals("B") ? 'selected' : ''}>B</option>
		<option value="C"
			${sessionScope.rightAnswer.equals("C") ? 'selected' : ''}>C</option>
		<option value="D"
			${sessionScope.rightAnswer.equals("D") ? 'selected' : ''}>D</option>
	
	</select> <br/>
	Schwierigkeit: <br /> 
	<select	name="<portlet:namespace />difficulty">
		<c:forEach items="${sessionScope.dList}" var="d">
			<option value="${d.getScore()}"
				${difficulty == d.getScore() ? 'selected' : ''}>${d.getScore()}</option>
		</c:forEach>
	</select> <br /> 
	Kategorie: <br /> 
	<select	name="<portlet:namespace />category">
		<c:forEach items="${sessionScope.cList}" var="c">
			<option value="${c.getCategoryId()}"
				${category == c.getCategoryId() ? 'selected' : ''}>${c.getCategoryName()}</option>
		</c:forEach>
	</select> <input type="submit" value="Ändern"> <br>
</form>
<p>
	<a href=<%=questionOverview%>>Zurück</a>
</p>