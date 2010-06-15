<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="rbt" uri="urn:com:sun:jersey:api:view" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administer Words</title>
</head>
<body>
<h1>Word List Administration</h1>
    
   <table border="1" width="30%">
   <th>Action</th>
   <th>Value</th>
   <th>Points</th>
   <c:forEach var="t" items="${it.words}" varStatus="loop">
	   <tr>
	   	   <td align="left"><a href="/jersey/hibernate/delete/${t.id}/">Remove</a></td>
		   <td><b>${t.value}</b></td>
		   <td>${t.points}</td>
	   </tr>
   </c:forEach> 
        
   </table>
   	<br></br>
    <hr></hr>
	<p>Enter a new word and the points associated with it. Then click Save</p>

	<form action="/jersey/hibernate/save" method="POST">
		<label for="value">Value</label>
		<input name="value" />
		<label for="points">Points</label>
		<input name="points" />
		<input type="submit" value="Save" />
	</form>
	<hr></hr>
	<table>
       <tbody>
       <tr><td align="left"><a href="/jersey/hibernate/play/init">Play Scramble &nbsp;</a></td><td> &nbsp; Play Scramble</td></tr>
      	</tbody>
	</table>	
</body>
</html>