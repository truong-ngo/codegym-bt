<%--
  Created by IntelliJ IDEA.
  User: X1 Carbon
  Date: 27/11/2022
  Time: 12:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/product/product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/bootstrap/dist/js/bootstrap.js"></script>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="logo-and-search">
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/product?username=${username}&action=view">
                        <img class="logo-img" src="${pageContext.request.contextPath}/resource/product.png" alt="logo">
                    </a>
                </div>
                <form class="search" action="${pageContext.request.contextPath}/product?username=${username}&action=search" method="post">
                    <div class="search-box input-group input-group-sm">
                        <label class="search-icon" for="search-input">
                            <button class="search-btn"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg></button>
                        </label>
                        <input id="search-input" type="text" name="search" class="form-control" placeholder="Search">
                    </div>
                </form>
            </div>
            <button type="button" class="log-out btn btn-light my-2" data-bs-toggle="modal" data-bs-target="#log-out-modal">
                <c:out value="${username}"/>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                    <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                </svg>
            </button>
        </div>

        <div class="body">
            <button type="button" class="btn btn-primary mt-4 mb-2" data-bs-toggle="modal" data-bs-target="#create-modal">
                Create new product
            </button>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Description</th>
                        <th scope="col">Supplier</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th scope="row"><c:out value="${product.getId()}"/></th>
                        <td><c:out value="${product.getName()}"/></td>
                        <td><c:out value="${product.getPrice()}"/></td>
                        <td><c:out value="${product.getDescription()}"/></td>
                        <td><c:out value="${product.getSupplier()}"/></td>
                        <td><button type="button" onclick="openEditModal('${product.getId()}', '${product.getName()}', '${product.getPrice()}', '${product.getDescription()}', '${product.getSupplier()}')"
                                    class="edit btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit-modal">Edit
                        </button></td>
                        <td><button type="button" onclick="openDeleteModal(${product.getId()})"
                                    class="delete btn btn-primary" data-bs-toggle="modal" data-bs-target="#delete-modal">
                            Delete
                        </button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Log out modal -->
    <div class="modal fade" id="log-out-modal" tabindex="-1" aria-labelledby="log-out-header" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="log-out-header">Log out</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Do you want to log out?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary px-3 py-1" data-bs-dismiss="modal">No</button>
                    <button type="button" class="btn btn-primary p-0">
                        <a class="yes-btn text-white" href="${pageContext.request.contextPath}/index.jsp">Yes</a>
                    </button>
                </div>
            </div>
        </div>
    </div>

    <%--Create modal--%>
    <div class="modal fade" id="create-modal" tabindex="-1" aria-labelledby="create-header" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="create-header">Create new product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/product?username=${username}&action=create" method="post">
                        <label for="c-name" class="form-label mt-2">Enter name:</label>
                        <input id="c-name" type="text" name="name" class="form-control" placeholder="Name">
                        <label for="c-price" class="form-label mt-2">Enter price:</label>
                        <input id="c-price" type="text" name="price" class="form-control" placeholder="Price">
                        <label for="c-description" class="form-label mt-2">Enter description:</label>
                        <input id="c-description" type="text" name="description" class="form-control" placeholder="Description">
                        <label for="c-supplier" class="form-label mt-2">Enter supplier:</label>
                        <input id="c-supplier" type="text" name="supplier" class="form-control" placeholder="Supplier">
                        <div class="submit mt-3">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--Edit modal--%>
    <div class="modal fade" id="edit-modal" tabindex="-1" aria-labelledby="edit-header" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="edit-header">Edit product #<span id="e-id-container"></span></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/product?username=${username}&action=edit" method="post">
                        <input id="e-id" type="text" name="id" class="form-control">
                        <label for="e-name" class="form-label mt-2">Edit name:</label>
                        <input id="e-name" type="text" name="name" class="form-control" placeholder="Name">
                        <label for="e-price" class="form-label mt-2">Edit price:</label>
                        <input id="e-price" type="text" name="price" class="form-control" placeholder="Price">
                        <label for="e-description" class="form-label mt-2">Edit description:</label>
                        <input id="e-description" type="text" name="description" class="form-control" placeholder="Description">
                        <label for="e-supplier" class="form-label mt-2">Edit supplier:</label>
                        <input id="e-supplier" type="text" name="supplier" class="form-control" placeholder="Supplier">
                        <div class="submit mt-3">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Save change</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <%--Delete modal--%>
    <div class="modal fade" id="delete-modal" tabindex="-1" aria-labelledby="delete-header" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="delete-header">Delete product #<span id="d-id-container"></span></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body d-b-modal">
                    <div>Do you want to delete product #<span id="d-id-body"></span>?</div>
                    <form action="${pageContext.request.contextPath}/product?username=${username}&action=delete" method="post">
                        <input id="d-id" type="text" name="id" class="form-control">
                        <div class="submit mt-3">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn btn-primary">Delete</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/product/product.js"></script>
</html>
