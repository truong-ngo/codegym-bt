<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Demo</title>
</head>
<body>
<h2>c:out example</h2>
<c:out value="${30*60}"/>
<h2>c:set example</h2>
<c:set var="salary" scope="session" value="${1000}"/>
<c:out value="${salary}"/>
<h2>c:remove example</h2>
<c:set scope="request" var="greeting" value="Hello every body" />
Greeting: <c:out value="${greeting}"/>
<br/><br/>
<c:remove scope="request" var="greeting" />
After remove:
<br/>
Greeting: <c:out value="${greeting}"/>

<h2>c:catch example</h2>
<c:catch var = "ex">
    <%
        int[] arr = new int[5];
        arr[5] = 0;
    %>
</c:catch>
<c:if test = "${ex != null}">
    Exception : ${ex}
    <br />
    Message: ${ex.message}
</c:if>

<h2>c:if example</h2>
<c:if test = "${salary > 500}">
    <p>My salary is: <c:out value = "${salary}"/><p>
</c:if>

<h2>c:choose, c:when, c:otherwise</h2>
<p>Your salary is : <c:out value = "${salary}"/></p>
<c:choose>
    <c:when test = "${salary <= 0}">
        Salary is very low to survive.
    </c:when>
    <c:when test = "${salary > 500}">
        Salary is very good.
    </c:when>
    <c:otherwise>
        No comment sir...
    </c:otherwise>
</c:choose>
</body>
</html>