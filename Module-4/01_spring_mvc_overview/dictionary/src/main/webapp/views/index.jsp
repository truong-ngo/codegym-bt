<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dictionary</title>
</head>
<body>
<h1>Converter</h1>
<form action="${pageContext.request.contextPath}/translate" method="post">
    <label for="vni">Enter VNI word: </label>
    <input id="vni" type="text" name="vni">
    <button type="reset">Reset</button>
    <button type="submit">Submit</button>
</form>
<span>Result: </span>
<c:if test="${mess != null}">
    <span><c:out value="${mess}"/></span>
</c:if>
</body>
</html>