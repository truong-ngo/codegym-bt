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
    <title>User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/user/user-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/bootstrap/dist/js/bootstrap.js"></script>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="logo-and-search">
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/user?username=${username}&action=view">
                        <img class="logo-img" src="${pageContext.request.contextPath}/resource/user-icon.png" alt="logo">
                    </a>
                </div>
                <form class="search" action="${pageContext.request.contextPath}/user?username=${username}&action=search" method="post">
                    <div class="search-box input-group input-group-sm">
                        <label class="search-icon" for="search-input">
                            <button class="search-btn"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg></button>
                        </label>
                        <input id="search-input" type="text" name="search" class="form-control" placeholder="Search">
                        <select class="form-select" name="search-item" aria-label="Default select example">
                            <option value="name">By name</option>
                            <option value="country">By country</option>
                        </select>
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
            <div class="create-sort">
                <button class="create-btn btn btn-primary my-3" data-bs-toggle="modal" data-bs-target="#create-modal">
                    Create new user
                </button>
                <form class="sort" action="${pageContext.request.contextPath}/user?username=${username}&action=sort" method="post">
                    <div class="sort-box input-group input-group-sm my-3 ms-2">
                        <button class="sort-btn btn btn-primary">Sort</button>
                        <div class="form-container">
                            <select class="sort-select form-select" name="sort-item" aria-label="Default select example">
                                <option value="name">By name</option>
                                <option value="country">By country</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Country</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <th scope="row"><c:out value="${user.getId()}"/></th>
                        <td><c:out value="${user.getName()}"/></td>
                        <td><c:out value="${user.getEmail()}"/></td>
                        <td><c:out value="${user.getCountry()}"/></td>
                        <td><button type="button" onclick="openEditModal('${user.getId()}', '${user.getName()}', '${user.getEmail()}', '${user.getCountry()}')"
                                    class="edit-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit-modal">Edit
                        </button></td>
                        <td><button type="button" onclick="openDeleteModal(${user.getId()})"
                                    class="delete-btn btn btn-primary" data-bs-toggle="modal" data-bs-target="#delete-modal">
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
                        <a class="yes-btn text-white" href="${pageContext.request.contextPath}/login">Yes</a>
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
                    <h1 class="modal-title fs-5" id="create-header">Create new user</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/user?username=${username}&action=create" method="post">
                        <label for="c-name" class="form-label mt-2">Enter name:</label>
                        <input id="c-name" type="text" name="name" class="form-control" placeholder="Name" required>
                        <label for="c-email" class="form-label mt-2">Enter email:</label>
                        <input id="c-email" type="text" name="email" class="form-control" placeholder="Email" required>
                        <label for="c-country" class="form-label mt-2">Enter country:</label>
                        <input id="c-country" type="text" name="country" class="form-control" placeholder="Country" required>
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
                    <h1 class="modal-title fs-5" id="edit-header">Edit user #<span id="e-id-container"></span></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/user?username=${username}&action=edit" method="post">
                        <input id="e-id" type="text" name="id" class="form-control">
                        <label for="e-name" class="form-label mt-2">Edit name:</label>
                        <input id="e-name" type="text" name="name" class="form-control" placeholder="Name">
                        <label for="e-email" class="form-label mt-2">Edit email:</label>
                        <input id="e-email" type="text" name="email" class="form-control" placeholder="Email">
                        <label for="e-country" class="form-label mt-2">Edit country:</label>
                        <input id="e-country" type="text" name="country" class="form-control" placeholder="Country">
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
                    <h1 class="modal-title fs-5" id="delete-header">Delete user #<span id="d-id-container"></span></h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body d-b-modal">
                    <div>Do you want to delete user #<span id="d-id-body"></span>?</div>
                    <form action="${pageContext.request.contextPath}/user?username=${username}&action=delete" method="post">
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
<script src="${pageContext.request.contextPath}/user/user.js"></script>
</html>
