<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
    <style>
        * {
            box-sizing: border-box;
            padding: 0;
            margin: 0;
        }
        .container {
            padding: 12px;
        }
        p {
            margin: 8px 0;
        }
        .btn {
            padding: 8px 0;
            background-color: dodgerblue;
            border: none;
            border-radius: 4px;
            margin-bottom: 12px;
        }
        .btn a {
            text-decoration: none;
            color: white;
            padding: 8px 16px;
        }
        table {
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid black;
        }
        th {
            padding: 4px 12px;
        }
        td {
            padding: 4px;
        }
        .image-container {
            height: 50px;
            position: relative;
            border-right: 1px solid black;
            border-bottom: 1px solid black;
        }
        .image {
            position: absolute;
            top: 9%;
            left: 19%;
            width: 40px;
            height: 40px;
        }
    </style>
</head>
<body>
<div class="container">
    <p>Click to open customer list</p>
    <button class="btn">
        <a href="${pageContext.request.contextPath}/customers">Click me</a>
    </button>
    <table>
        <c:if test="${customers != null}">
            <tr>
                <th>Name</th>
                <th>Date of Birth</th>
                <th>Address</th>
                <th>Image</th>
            </tr>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.getName()}"/></td>
                    <td><c:out value="${customer.getDateOfBirth()}"/></td>
                    <td><c:out value="${customer.getAddress()}"/></td>
                    <td class="image-container"><img class="image" src="<c:out value="${customer.getURL()}"/>" alt=""></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>