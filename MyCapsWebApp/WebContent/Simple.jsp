<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>  
<head>  
<title>Core Tag Example</title>  
</head>  
<body>  
<c:set var="income" scope="session" value="${4000*4}"/>  
<c:if test="${income > 8000}">  
   <p>My income is: <c:out value="${income}"/><p>  
</c:if>  

<c:forEach var="j" begin="1" end="3">  
   Item <c:out value="${j}"/><p>  
</c:forEach>  

<c:set var="Income" scope="session" value="${4000*4}"/>  
<c:out value="${Income}"/> 

<br>
<c:forTokens items="Rahul-Nakul-Rajesh" delims="-" var="name">  
   <c:out value="${name}"/><p>  
</c:forTokens>  

 
</body>  
</html>