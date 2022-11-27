<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple calculator</title>
    <style>
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }
        .container {
            padding: 16px 8px;
            width: 300px;
        }
        h1 {
            text-align: center;
            margin-bottom: 12px;
        }
        .operand, .operator {
            width: 100%;
            padding: 8px 8px 8px 4px;
            margin: 4px 0;
        }
        .btn {
            padding: 12px 16px;
            width: 100%;
            margin: 4px 0;
            background-color: dodgerblue;
            border: none;
            border-radius: 4px;
        }
        h3 {
            margin-top: 4px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Simple Calculator</h1>
    <form action="${pageContext.request.contextPath}/calculator" method="post">
        <input class="operand" name="first-operand" type="text">
        <select class="operator" name="operator" id="">
            <option value="add">Addition</option>
            <option value="sub">Subtraction</option>
            <option value="mul">Multiplication</option>
            <option value="div">Division</option>
        </select>
        <input class="operand" name="second-operand" type="text">
        <button class="btn">Calculate</button>
        <h3>Result:
            <c:choose>
                <c:when test="${result == null}">
                    <c:out value=""/>
                </c:when>
                <c:when test="${result == Float.NaN}">
                    <c:out value="${mess}"/>
                </c:when>
                <c:otherwise>
                    <c:out value="${result}"/>
                </c:otherwise>
            </c:choose>
        </h3>
    </form>
</div>

</body>
</html>