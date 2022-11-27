<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <style>
         * {
             box-sizing: border-box;
         }
        .container {
            display: inline-block;
        }
        .label, .input {
            display: block;
            margin: 8px 0;
        }
        .input {
            width: 100%;
            padding: 4px;
        }
        .button {
            margin: 8px 0;
            padding: 4px 0;
            width: 100%;
            cursor: pointer;
            background-color: black;
            color: white;
        }
        p {
            color: blue;
        }
    </style>
</head>
<body>
<div class="container">
    <form class="form" action="${pageContext.request.contextPath}/converter" method="post">
        <h2>Currency converter</h2>
        <label class="label" for="rate">Rate:</label>
        <input class="input" id="rate" type="text" name="rate" value="23000">
        <label class="label" for="usd">USD:</label>
        <input class="input" id="usd" type="text" name="usd" placeholder="Usd" checked>
        <button class="button">Converter</button>
        <p>
            <c:out value="${vnd == null ? '' : 'VND:'}"/>
            <c:out value="${vnd == null ? '' : vnd}"/>
        </p>
    </form>
</div>
</body>
</html>