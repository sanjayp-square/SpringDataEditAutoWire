<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<h1>Update Details</h1>


<form action="updateAction.html"  method="post">
<td>Username</td><br>
<input type="text" name="usn" value="${data.name}"/><br>
<td>Mobile</td><br>
<input type="text" name="pwd" value="${data.mobile}"/><br><br>

<input type="hidden" name="id" value="${data.id}"/><br><br>
<input type="submit" value="Submit"> 

</form>


</body>
</html>