<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administer Words</title>
</head>
<body>
<h1>Word List Administration</h1>
    
   
    <ul>
        <c:forEach var="t" items="${it.words}" varStatus="loop">
            <li><a href="${t.value}">${t.value}</a>&nbsp;&nbsp;Value: ${t.points}</li>
        </c:forEach>
    </ul>
   
   	<br></br>
    <hr></hr>
	<p>Enter a new word and the points associated with it. Then click Save</p>

	<form action="../hibernate/administer/save" method="POST">
		<label for="value">Value</label>
		<input name="value" />
		<label for="Points">Points</label>
		<input name="Points" />
		<input type="submit" value="Save" />
	</form>
	<hr></hr>
</body>
</html>