<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Summary</title>
</head>
<body>
<h1 align="center">Table Summary</h1>
<table>
<tr>
<th>ID<th>
<th>Name<th>
<th>Mobile<th>
<th>Edit<th>
<th>Delete<th>
</tr>


<c:forEach items="${detail}" var="i">     

  <tr>
   <td align="center"><c:out value="${i.id}" /></td>
   <td><c:out value="${i.name}" /></td>
   <td><c:out value="${i.mobile}" /></td>
 <td><a href="edit.html?id=<c:out value="${i.id}" />">Edit</a></td> 

<td><a href="delete.html?id=<c:out value="${i.id}" />">Delete</a><td>

  </tr>

</c:forEach>

  </table>

</body>
</html>