<%@ include file="/init.jsp"%>
<%@page import="game.infonaer.game.GameState"%>
<%@page import="game.infonaer.game.AudienceJokerResult"%>
<portlet:actionURL name="evalAnswer" var="answerA">
	<portlet:param name="answer" value="a" />
</portlet:actionURL>
<portlet:actionURL name="evalAnswer" var="answerB">
	<portlet:param name="answer" value="b" />
</portlet:actionURL>
<portlet:actionURL name="evalAnswer" var="answerC">
	<portlet:param name="answer" value="c" />
</portlet:actionURL>
<portlet:actionURL name="evalAnswer" var="answerD">
	<portlet:param name="answer" value="d" />
</portlet:actionURL>

<portlet:actionURL name="leaveCurrentGame" var="leave"></portlet:actionURL>
<portlet:actionURL name="fiftyFiftyJoker" var="fiftyFiftyJoker"></portlet:actionURL>
<portlet:actionURL name="audienceJoker" var="audienceJoker"></portlet:actionURL>

<%
	GameState gameState = (GameState) portletSession.getAttribute("gameState");
	if (gameState != null) {
		AudienceJokerResult audienceJokerResult = (AudienceJokerResult) portletSession.getAttribute("audienceJokerResult");
		String audienceGuessA = "";
		String audienceGuessB = "";
		String audienceGuessC = "";
		String audienceGuessD = "";
		if (audienceJokerResult != null){
			audienceGuessA = Double.toString(audienceJokerResult.getPercentA());
			audienceGuessB = Double.toString(audienceJokerResult.getPercentB());
			audienceGuessC = Double.toString(audienceJokerResult.getPercentC());
			audienceGuessD = Double.toString(audienceJokerResult.getPercentD());
		}
		Question question = gameState.getCurrentQuestion();

		if (question != null) {
%>
<aui:container cssClass="jumbotron">
	<aui:button-row>
		<aui:col span="1"></aui:col>
		<aui:col span="1">
			<aui:form>
				<aui:button type="submit" href='<%=leave%>' value="Aussteigen"></aui:button>
			</aui:form>
		</aui:col>
		<aui:col span="7"></aui:col>
		<%
			if (!gameState.isFifyFiftyUsed()) {
		%>
		<aui:col span="1">
			<aui:form>
				<aui:button type="submit" href='<%=fiftyFiftyJoker%>' value="50:50"></aui:button>
			</aui:form>
		</aui:col>
		<%
			}
							if (!gameState.isAudienceUsed()) {
		%>

		<aui:col span="1">
			<aui:form>
				<aui:button type="submit" href='<%=audienceJoker%>'
					value="Publikum"></aui:button>
			</aui:form>
		</aui:col>
		<aui:col span="1"></aui:col>
		<%
			}
		%>
	</aui:button-row>
	<aui:row>

		<aui:col span="1"></aui:col>
		<aui:col span="10">
			<p><%=question.getQuestionContent()%></p>
		</aui:col>
		<aui:col span="1"></aui:col>
	</aui:row>
	<aui:button-row>
		<aui:col span="1"></aui:col>
		<aui:col span="5">
			<form
				action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="a"/>
						</portlet:actionURL>
				method="post">
				<button type="submit" class="btn btn-primary">
					A:
					<%=question.getAnswerA()%> <%=audienceGuessA%></button>
			</form>
		</aui:col>
		<aui:col span="5">
			<form
				action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="b"/>
						</portlet:actionURL>
				method="post">
				<button type="submit" class="btn btn-primary">
					B:
					<%=question.getAnswerB()%> <%=audienceGuessB%></button>
			</form>
		</aui:col>
		<aui:col span="1"></aui:col>
	</aui:button-row>
	<aui:button-row>
		<aui:col span="1"></aui:col>
		<aui:col span="5">
			<form
				action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="c"/>
						</portlet:actionURL>
				method="post">
				<button type="submit" class="btn btn-primary">
					C:
					<%=question.getAnswerC()%> <%=audienceGuessC %></button>
			</form>
		</aui:col>
		<aui:col span="5">
			<form
				action=<portlet:actionURL name="evalAnswer">
							<portlet:param name="answer" value="d"/>
						</portlet:actionURL>
				method="post">
				<button type="submit" class="btn btn-primary">
					D:
					<%=question.getAnswerD()%> <%=audienceGuessD%></button>
			</form>
		</aui:col>
		<aui:col span="1"></aui:col>
	</aui:button-row>
</aui:container>
<!-- debug zurück zum Haupmenue -->
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<p>
	<a href=<%=mainMenu%>>Back</a> </br>
	<%=gameState.toString()%>
</p>

<%
	}
	} else {
%>
<!-- 
	<aui:container>
		<h1>Hier ist was falsch gelaufen!</h1>
		<h2><a href=<portlet:actionURL name="gotoMainMenu"></portlet:actionURL>>Zurück zum Hauptmenü</a></h2>
	</aui:container>
	-->
<%
	}
%>
