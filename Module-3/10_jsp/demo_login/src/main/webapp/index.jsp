<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="bootstrap-5.2.2/dist/css/bootstrap.css">
    <style>
        * {
            box-sizing: border-box;
        }
        .login-modal {
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            background-image: linear-gradient(90deg, #0dcaf0, hotpink);
        }
        /*.login-container::before {*/
        /*    content: "";*/
        /*    display: block;*/
        /*    width: 300px;*/
        /*    height: 400px;*/
        /*    background-color: #6c757d;*/
        /*    border-radius: 8px;*/
        /*    position: relative;*/
        /*    top: -24px;*/
        /*    left: -12px;*/
        /*    opacity: 50%;*/
        /*    transform: rotate(-5deg);*/
        /*}*/
        .pseudo {
            display: block;
            width: 300px;
            height: 400px;
            background-color: #6c757d;
            position: relative;
            top: 50%;
            left: 50%;
            transform: translateY(-50%) translateX(-50%) rotate(-5deg);
            opacity: 50%;
            box-shadow: 2px 2px 15px #8b95a3;
        }
        .login-container {
            position: absolute;
            width: 300px;
            height: 400px;
            top: 50%;
            left: 50%;
            transform: translateY(-50%) translateX(-50%);
            padding: 24px 12px;
            background-color: black;
            color: white;
            z-index: 4;
            box-shadow: 2px 2px 15px #8b95a3;
        }
        .login-form {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translateY(-50%) translateX(-50%);
        }
        .login-image {
            width: 100px;
            height: 100px;
            margin: 0 auto;
        }
        .image {
            width: 100px;
            height: 100px;
        }
        .header {
            margin: 0 0 24px 0;
            text-align: center;
        }
        .input {
            border-radius: 12px;
            padding: 8px 16px;
            font-size: 14px;
            border: none;
        }
        .checkbox {
            position: relative;
            top: 3px;
        }
        .checkbox-content {
            font-size: 12px;
        }
        .submit {
            border: none;
            width: 100%;
            border-radius: 12px;
            background-image: linear-gradient(90deg, #0dcaf0, hotpink);
            color: white;
        }
        .submit:hover {
            opacity: 80%;
        }
        #alert {
            color: red;
            font-size: 12px;
            text-align: center;
            height: 18px;
            margin-bottom: 12px;
        }
    </style>
</head>
<body>
    <div class="login-modal">
        <div class="pseudo"></div>
        <div class="login-container">
            <form action="user-login" class="login-form" method="post">
                <div class="login-image">
                    <img class="image" src="login.png" alt="login-image">
                </div>
                <h2 class="header">Login</h2>
                <input id="username" type="text" name="username" class="username input mt-2 px-1" placeholder="Username" autocomplete="off">
                <input type="password" name="password" class="input mt-2 px-1" placeholder="Password" autocomplete="off">
                <div class="checkbox-field my-2 text-center">
                    <input type="checkbox" class="checkbox">
                    <span class="checkbox-content">Remember me</span>
                </div>
                <button class="submit mt-2 py-2 mb-3">Login</button>
                <p id="alert">
                    <c:out value="${error == null ? '' : error}"/>
                </p>
            </form>
        </div>
    </div>
</body>
</html>