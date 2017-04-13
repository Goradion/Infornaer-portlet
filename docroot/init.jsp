<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="de.ki.sbam.service.QuestionLocalServiceUtil"%>
<%@ page import="de.ki.sbam.model.Question"%>
<%@ page import="de.ki.sbam.service.persistence.QuestionUtil"%>
<%@ page import="game.infonaer.portlet.QuestionFromFileBuilder" %>
<%@ page import="java.util.*" %>

<portlet:defineObjects/>
<theme:defineObjects/>