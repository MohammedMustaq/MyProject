<%@page import="com.mpt.model.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
</style>

</head>
<body>
<h1></h1>
 <jsp:useBean id="student" class="com.mpt.model.beans.Student" scope="request"/>
<table border=1px border-color="blue" align="center" cellspacing="0px" cellpadding="10px" bgcolor="aqua">
<tr>
<th>Sid</th>
<th>Name</th>
<th>Password</th>
</tr>
<tr>
<td>${student.sid }</td>
<td>${student.name }</td>
<td>${student.password }</td>
</tr>
</table>

</body>
</html>