<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/font/fontawesome-free-6.1.2-web/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/login/login.css">
    <script src="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/js/bootstrap.js"></script>

</head>
<body>
    <div class="login-layout">
        <div class="border bg-black login-container">
            <form class="login-content" action="/login">
                <div class="img-container">
                    <img class="user-img" src="${pageContext.request.contextPath}/resource/img/user.png" alt="user">
                </div>
                <h4 class="header text-white">LOG IN</h4>
                <div class="input-group input-group-sm my-2">
                    <span class="input-group-text" id="username">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z"></path>
                        </svg>
                    </span>
                    <input type="text" name="username" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="username">
                </div>
                <div class="input-group input-group-sm my-2">
                    <span class="input-group-text" id="password">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                            <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"></path>
                        </svg>
                    </span>
                    <input type="text" name="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="password">
                </div>
                <div class="form-check">
                    <input class="check form-check-input me-1" type="checkbox" value="" id="remember">
                    <label class="remember form-check-label text-white" for="remember">Remember me</label>
                </div>
                <button class="submit btn btn-light mt-3">Login</button>
                <a class="forgot-pass" href="#!">Forgot password?</a>
                <p class="wrong-mess">
                    <c:out value="${mess == null ? '' : mess}"/>
                </p>
            </form>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/js/bootstrap.js"></script>
</html>