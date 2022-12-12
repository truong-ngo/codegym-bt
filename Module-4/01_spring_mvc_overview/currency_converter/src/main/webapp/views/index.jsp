<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h1>Converter</h1>
<form action="${pageContext.request.contextPath}/convert" method="post">
    <label for="usd">Enter USD amount: </label>
    <input id="usd" type="text" name="usd_amount">
    <button type="reset">Reset</button>
    <button type="submit">Submit</button>
</form>
<c:if test="${mess != null}">
    <p><c:out value="${mess}"/></p>
</c:if>
</body>
</html>