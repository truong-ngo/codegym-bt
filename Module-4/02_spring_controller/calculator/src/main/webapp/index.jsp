<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calculator" method="post">
    <input type="text" name="operand_one">
    <input type="text" name="operand_two">
    <input type="submit" name="operator" value="add">
    <input type="submit" name="operator" value="sub">
    <input type="submit" name="operator" value="mul">
    <input type="submit" name="operator" value="div">
</form>
<p>Result: ${result}</p>
</body>
</html>