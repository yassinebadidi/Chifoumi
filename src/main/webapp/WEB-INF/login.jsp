<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 17/04/2023
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <button type="submit">Login</button>
</form>

<form action="${pageContext.request.contextPath}/register" method="get">
    <button type="submit">S'enregistrer</button>
</form>

<c:if test="${isError == true}">
    <p> Mauvais identifiant ou mot de passe </p>
</c:if>

</body>
</html>
