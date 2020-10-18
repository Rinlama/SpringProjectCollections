
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<title>Yahoo from JSP</title>



</head>

<body>
${errorMessage}
<form action="/login" method="post">
	Enter name
   <input type="test" name="user"> <br>
    <input type="password" name="password"><br>
   <input type="submit" value="login"/>

</form>
</body>

</html>