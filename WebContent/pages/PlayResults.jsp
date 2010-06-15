<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="rbt" uri="urn:com:sun:jersey:api:view" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guess Scramble Word</title>
</head>
<body>
<h1>${it.message}</h1>
    
   <table border="1" width="30%">
   <th>Number Correct</th>
   <th>Number Wrong</th>
	   <tr>
		   <td><b>${it.numCorrect}</b></td>
		   <td><b>${it.numWrong}</b></td>
	   </tr>
   <tr>
	   <td align="left" colspan="2">
	   <a href="/jersey/hibernate/play/again">Play Scramble Again</a>
	   </td>
   </tr>
   <tr>
	   <td align="left" colspan="2">
	   <a href="/jersey/hibernate/list">Update Word Dictionary</a>
	   </td>
   </tr>
        
   </table>
   
   	
</body>