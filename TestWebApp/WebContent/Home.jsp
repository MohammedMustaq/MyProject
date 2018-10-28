<%@page import="com.dev.model.beans.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%-- <%
		Person p=(Person)request.getAttribute("person"); 
	%>
	<%=p %> --%>
	
	
	<jsp:useBean id="person" class="com.dev.model.beans.Person" scope="session">
	
		<jsp:setProperty property="id" name="person" value="100"/>
		<jsp:setProperty property="name" name="person" value="UNK"/>
		<jsp:setProperty property="address" name="person" value="UNK"/>
		<jsp:setProperty property="email" name="person" value="UNK"/>
		
	</jsp:useBean>
	
	Name:
	<jsp:getProperty property="name" name="person"/>
	<br>
	Name:${person.name}
	<br>
	Name:<%  person=(Person)session .getAttribute("person");%> <%=person.getName()%>
	<br>	
	<%=person %>
	<%@include file="page.html" %>

</body>
</html>