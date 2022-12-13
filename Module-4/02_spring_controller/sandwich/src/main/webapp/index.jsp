<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    <input type="checkbox" name="lettuce" value="lettuce">Lettuce
    <input type="checkbox" name="tomato" value="tomato">Tomato
    <input type="checkbox" name="mustard" value="mustard">Mustard
    <input type="checkbox" name="sprouts" value="sprouts">Spouts
    <button>Save</button>
</form>
<p>${lettuce}</p>
<p>${tomato}</p>
<p>${mustard}</p>
<p>${sprouts}</p>
</body>
</html>