<%--
  Created by IntelliJ IDEA.
  User: X1 Carbon
  Date: 29/11/2022
  Time: 10:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${product.getName()}"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/dist/css/bootstrap.css">
    <style>
        .img-container .img {
            width: 100%;
            height: 100%;
            object-fit: contain;
        }
        .cart, .cart-link, .link {
            display: flex;
            align-items: center;
            flex-direction: row;
        }
        .cart-link {
            margin-left: 8px;
        }
    </style>
</head>
    <body>
        <div class="container">
            <div class="header">
                <div class="logo-and-search">
                    <div class="logo">
                        <img style="margin-left: -50px" class="logo-img" src="${pageContext.request.contextPath}/resource/product.png" alt="logo">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col col-lg-4 col-md-12 py-3">
                    <div class="card" style="width: 100%; height: 100%; border-radius: 0">
                        <div class="card-body">
                            <h5 class="card-text mb-3 mt-2">Product name: <span><c:out value="${product.getName()}"/></span></h5>
                            <p class="card-text">Price:
                                <span style="color: red"><c:out value="${product.getPrice()}"/>$</span>
                            </p>
                            <p class="card-text">Description: <span><c:out value="${product.getDescription()}"/></span></p>
                            <p class="card-text">Brand: <span><c:out value="${product.getBrand().getName()}"/></span></p>
                            <h6 class="card-text">Specification: </h6>
                            <p style="text-align: justify" class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus aspernatur atque cum deleniti distinctio ducimus earum facere, fugiat hic magnam minima neque odio perferendis placeat quod sunt ullam vel velit.</p>
                            <div class="link">
                                <a href="${pageContext.request.contextPath}/product?username=${username}" class="btn btn-primary">Back</a>
                                <a href="#!" class="btn btn-primary cart-link">
                                    <span class="cart">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart" viewBox="0 0 16 16">
                                            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                        </svg>
                                    </span>
                                    <span style="margin-left: 8px" class="cart-text">Add to cart</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col col-lg-8 col-md-12 py-3">
                    <div class="img-container">
                        <img class="img" src="${pageContext.request.contextPath}/resource/Product-Photos.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>