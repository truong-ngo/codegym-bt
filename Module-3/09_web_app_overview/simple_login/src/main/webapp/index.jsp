<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<style type="text/css">
    .login {
        height:180px; width:253px;
        margin:0;
        padding: 10px 10px 40px 10px;
        border:1px #CCC solid;
    }
    h2 {
        text-align: center;
    }
    .login input {
        padding:5px; margin:5px
    }
</style>
<body>
<form method="get" action="/login">
    <div class="login">
        <h2>Login</h2>
        <input type="text" name="username" size="30"  placeholder="username"/>
        <input type="password" name="password" size="30" placeholder="password"/>
        <input type="submit" value="Sign in"/>
    </div>
</form>
</body>
</html>