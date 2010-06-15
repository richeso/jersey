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
<h1>Guess the Selected Word</h1>
    
   <table border="1" width="30%">
   <th>Selected Scrambled Word</th>
	   <tr>
		   <td><b>${it.scrambledWord}</b></td>
	   </tr>
        
   </table>
   	<br></br>
    <hr></hr>
	<p>Enter Your Guess for the Unscrambled Word and then click Submit Guess</p>

	<form action="guess" method="POST">
		<label for="guess">Submit Guess</label>
		<input name="guess" />
		<input type="submit" value="guess" />
	</form>
	<hr></hr>
</body>