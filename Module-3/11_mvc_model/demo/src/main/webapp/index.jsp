<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css">
</head>
<body>
    <div class="modal-layout">
        <div class="modal-container">
            <form class="login-form text-center" action="${pageContext.request.contextPath}/login" method="post">
                <div class="image-container">
                    <img class="image" src="${pageContext.request.contextPath}/resource/user.png" alt="user">
                </div>
                <h2 class="h2 mb-4">Login</h2>
                <input type="text" class="form-control mb-2" name="username" placeholder="Username">
                <input type="password" class="form-control" name="password">
                <div class="checkbox-field my-2 text-center">
                    <input type="checkbox" class="checkbox" placeholder="Password">
                    <span class="checkbox-content">Remember me</span>
                </div>
                <button class="submit mt-2 py-2 mb-3">Login</button>
                <p class="alert">
                    <c:out value="${mess == null ? '' : mess}"/>
                </p>
            </form>
        </div>
    </div>
</body>
</html>