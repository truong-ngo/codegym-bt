<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="${pageContext.request.contextPath}/dictionary" method="post">
    <input type="text" name="word" placeholder="Enter your word:">
    <button>Search</button>
    <p>
        <c:out value="${result == null ? '' : result}"/>
    </p>
</form>
</body>
</html>