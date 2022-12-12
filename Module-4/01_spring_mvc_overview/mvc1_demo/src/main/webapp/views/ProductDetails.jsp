<%--
  Created by IntelliJ IDEA.
  User: X1 Carbon
  Date: 12/12/2022
  Time: 9:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
</head>
<body>
    <div id="global">
        <h4>The product has been saved.</h4>
        <p>
        <h5>Details:</h5>
        Product Name: ${product.getName()}<br/>
        Description: ${product.getDescription()}<br/>
        Price: $${product.getPrice()}
        </p>
    </div>
</body>
</html>
