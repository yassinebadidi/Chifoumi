<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 18/04/2023
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action = "${pageContext.request.contextPath}/register" method="post">
    <input type="text" name="newusername">
    <input type="text" name="newpassword">
    <button type="submit">S'enregistrer</button>
</form>

<c:if test="${Existe == true}">
    <p> username existe déja, réssayez ! sinon connectez-vous : </p>
    <form action = "${pageContext.request.contextPath}/login" method= "get">
        <button type="submit">Se connecter</button>
    </form>
</c:if>

<c:if test="${isCreated == true}">
    <p> Vous avez été ajouter avec succès, vous pouvez vous connecter </p>
    <form action = "${pageContext.request.contextPath}/login" method= "get">
        <button type="submit">Se connecter</button>
    </form>
</c:if>

<c:if test="${isCreated == false}">
    <p> Un problème de notre part réssayez plutard </p>
</c:if>
</body>
</html>
