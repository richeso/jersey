<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="rbt" uri="urn:com:sun:jersey:api:view" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CD</title>
    </head>
    <body>

    <h1>Contact List</h1>
    
   
    <ul>
        <c:forEach var="t" items="${it.contacts}" varStatus="loop">
            <li><a href="${t.id}">${t.name}</a>
        </c:forEach>
    </ul>
    <p>
        The initial content of session variable testfromjersey is: <c:out value="${sessionScope.testfromjersey}" /> <br/>
    	 	
    </p>
    <%
    String var = (String) request.getSession().getAttribute("testfromjersey");
    var = var + " .. and modified in contacts.jsp";
    %>
    <c:set var="testfromjersey" value="<%=var %>" scope="session" />
    <p>
        The modified local variable   testfromjersey is: <%=var %> <br/>   	
     	The modified session variable testfromjersey is: <c:out value="${sessionScope.testfromjersey}" /> <br/>   	
    </p>
    </body>
</html>
