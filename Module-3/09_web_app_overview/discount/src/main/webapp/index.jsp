<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        .container {
            padding: 10px 20px;
            display: inline-block;
            background-color: #d5d2d2;
        }

        .form {
            text-align: right;
        }

        .header {
            margin: 12px 0;
        }

        .input {
            margin: 4px 0;
            padding: 8px 8px 8px 4px;
            display: block;
            width: 100%;
        }

        .submit {
            padding: 8px 16px;
            color: white;
            background-color: black;
            border: 1px solid black;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form" action="/discount" method="get">
        <h2 class="header">Product Discount Calculator</h2>
        <input type="text" name="desc" class="input" placeholder="Description">
        <input type="text" name="price" class="input" placeholder="Price">
        <input type="text" name="discount" class="input" placeholder="Discount Percent">
        <input type="submit" class="submit" value="Send">
    </form>
    <a href="login.jsp">Login</a>
</div>
</body>
</html>