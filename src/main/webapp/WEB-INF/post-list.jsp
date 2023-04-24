<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 12/04/2023
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <title>List of poste</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<header>
    <h1> My List of posts</h1>

    <div>Welcom ${sessionScope.username}</div>
    <form action="${pageContext.request.contextPath}/login" method="get">
        <button type="submit">Déconexion</button>
    </form>
</header>

<c:forEach var ="post" items ="${posts}">
    <div class="bd-example">
        <div class="card">
            <div class="card-header">
                <p>${post.title}</p>
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                    <p>${post.content}</p>
                    <footer class="blockquote-footer">${post.authore}></footer>
                </blockquote>
            </div>
        </div>
        <div class="card-footer text-muted">
            Publié le  ${post.getCreatedAt()}
        </div>
    </div>
</c:forEach>

</body>
</html>
