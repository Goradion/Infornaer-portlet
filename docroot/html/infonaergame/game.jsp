<%@ include file="/init.jsp"%>



<portlet:actionURL name="leaveCurrentGame" var ="leave"></portlet:actionURL>
 
<%
	//Question question = null;  !!!!!!!!!!!Question!!!!!!!!!!!!!!!!!!
	//if(actionRequest.getAttribute("question")!=null){				\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	//	question = (Question)actionRequest.getAttribute("question"); actionRequest ist hier null, frag mich nicht warum!
	//}																////////////////////////////////////////////////////
%>


<a href=<%=leave%>>Aussteigen</a>
<%//if(question==null) {%>
<aui:container cssClass="jumbotron">
	<aui:row>
		<div>
			<aui:col span="1"></aui:col>
			<!-- spacer -->
			<aui:col span="10">
				<p class="bg-info">${question.getQuestionContent()}</p>
			</aui:col>
			<aui:col span="1"></aui:col>
			<!-- spacer -->
		</div>
	</aui:row>
	<aui:row>
		<aui:col span="3">
			<form action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="a"/>
						</portlet:actionURL> method="post">
				<button type="submit" class="btn btn-primary">A: ${question.getAnswerA()}</button>
			</form>
		</aui:col>
		<aui:col span="3">
			<form action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="b"/>
						</portlet:actionURL> method="post">
				<button type="submit" class="btn btn-success">B: ${question.getAnswerB()}</button>
			</form>
		</aui:col>
		<aui:col span="3">
			<form action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="c"/>
						</portlet:actionURL> method="post">
				<button type="submit" class="btn btn-info">C: ${question.getAnswerC()}</button>
			</form>
		</aui:col>
		<aui:col span="3">
			<form action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="d"/>
						</portlet:actionURL> method="post">
				<button type="submit" class="btn btn-danger">D: ${question.getAnswerD()}</button>
			</form>
		</aui:col> 
	</aui:row>
</aui:container>
<!-- debug zurück zum Haupmenue -->
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<p>
	<a href=<%=mainMenu%>>Back</a>
</p>

<%//} else { %>
<!-- 
	<aui:container>
		<h1>Hier ist was falsch gelaufen!</h1>
		<h2><a href=<portlet:actionURL name="gotoMainMenu"></portlet:actionURL>>Zurück zum Hauptmenü</a></h2>
	</aui:container>
	-->
<%//}%> 