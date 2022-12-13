<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>

There are ${customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>
                <c:out value="${c.getId()}"/>
            </td>
            <td>
                <a href="info?id=${c.getId()}">${c.getName()}</a>
            </td>
            <td>
                <c:out value="${c.getEmail()}"/>
            </td>
            <td>
                <c:out value="${c.getAddress()}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>