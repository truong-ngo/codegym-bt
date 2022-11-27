<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: X1 Carbon
  Date: 23/11/2022
  Time: 11:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .mess-modal {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-image: linear-gradient(90deg, #0dcaf0, hotpink);
        }
        .mess-container {
            width: 300px;
            height: 200px;
            position: relative;
            top: 50%;
            left: 50%;
            transform: translateY(-50%) translateX(-50%);
            background-color: white;
            box-shadow: 2px 2px 15px #8b95a3;
            padding: 12px;
            border-radius: 8px;
            text-align: center;
        }
        .icon-container {
            margin: 12px auto 0 auto;
            width: 50px;
            height: 50px;
        }
        .icon {
            width: 50px;
            height: 50px;
        }
        .mess {
            color: green;
            margin-bottom: 12px;
        }
        .login-time, .user-note {
            color: black;
        }
    </style>
</head>
<body>
    <%
    String username = request.getParameter("username");
    LocalDate time = (LocalDate) request.getAttribute("loginTime");
    %>
    <div class="mess-modal">
        <div class="mess-container">
            <div class="icon-container">
                <img class="icon" src="success.png" alt="success">
            </div>
            <h3 class="mess">Login successfully</h3>
            <p class="user-note">Hi <%= username%></p>
            <p class="login-time">Login time: <%= time%></p>
        </div>
    </div>
</body>
</html>
