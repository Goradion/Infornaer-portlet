<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ page import="game.infonaer.constants.Constants"%>
<%@ page import="de.ki.sbam.service.QuestionLocalServiceUtil"%>
<%@ page import="de.ki.sbam.model.Question"%>
<%@ page import="de.ki.sbam.model.Highscore"%>
<%@ page import="de.ki.sbam.service.persistence.QuestionUtil"%>
<%@ page import="game.infonaer.portlet.QuestionFromFileBuilder" %>
<%@ page import="java.util.*" %>

<portlet:defineObjects/>
<theme:defineObjects/>