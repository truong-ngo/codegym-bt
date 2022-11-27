<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vietnamese Dictionary</title>
</head>
<style>
    * {
        font-family: Arial;
    }
    .word {
        padding: 8px 16px 8px 6px;
    }
    .submit {
        background-color: #c2c0c0;
        border: none;
        border-radius: 3px;
        padding: 10px 16px;
    }
</style>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/translate">
    <input class="word" type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input class="submit" type = "submit" id = "submit" value = "Search"/>
</form>
</body>
</html>