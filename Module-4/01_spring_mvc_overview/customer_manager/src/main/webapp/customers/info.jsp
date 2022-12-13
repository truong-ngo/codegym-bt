<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="${pageContext.request.contextPath}/update" method="post">
<fieldset>
    <legend>Customer Information</legend>
    <input type="hidden" name="id" value="${customer.id}">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <c:out value="${customer.id}"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" value="${customer.name}">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" value="${customer.email}">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address" value="${customer.address}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
</fieldset>
</form>
<a href="${pageContext.request.contextPath}/customers">Back to list</a>.