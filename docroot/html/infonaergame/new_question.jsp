<%@ include file="/init.jsp"%>



<portlet:actionURL name="gotoLoadQuestionFromFile" var="loadFromFile"></portlet:actionURL>
<portlet:actionURL name="upsertQuestion" var="addQuestionURL"></portlet:actionURL>
<portlet:actionURL name="gotoQuestionOverview" var="questionOverview"></portlet:actionURL>

<portlet:actionURL name="gotoEditMode" var="editMode"></portlet:actionURL>
<h1>Neue Frage</h1>
<form method="POST" action="${addQuestionURL}" >
	Frage: <br/>
	<textarea name="<portlet:namespace />question" rows="5" ></textarea> <br/>
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
	<br />
	Schwierigkeit: <br />
	<select name= "<portlet:namespace />difficulty" >
		<c:forEach items="${sessionScope.dList}" var="d">
			<option value="${d.getScore()}">${d.getScore()}</option>
		</c:forEach>
	</select>
	<br/>
	Kategorie: <br />
	<select name= "<portlet:namespace />category" >
		<c:forEach items="${sessionScope.cList}" var="c">
			<option value="${c.getCategoryId()}">${c.getCategoryName()}</option>
		</c:forEach>
	</select>
	<input type="submit" value="Abschicken"> <br/>
	<a href=<%=loadFromFile%>>Frage(n) auf einer Datei laden</a> <br>
</form>	
<p><a href=<%=questionOverview%>>Back</a></p>