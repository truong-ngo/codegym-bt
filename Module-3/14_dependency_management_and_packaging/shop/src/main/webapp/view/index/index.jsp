<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/font/fontawesome-free-6.1.2-web/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/index/index.css">
    <script src="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/js/bootstrap.js"></script>
</head>
<body>
    <header class="header mb-2">
        <div class="container">
            <div class="logo-and-search">
                <div class="logo-box">
                    <img class="logo-img" src="${pageContext.request.contextPath}/resource/img/logo.png" alt="">
                </div>
                <form class="input-group mb-3 search-box" action="" method="post">
                    <label class="input-group-text" for="name-search">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                        </svg>
                    </label>
                    <input id="name-search" type="text" class="form-control" placeholder="Search">
                </form>
            </div>
            <div class="user">
                <div class="user-container">
                    <div class="login">
                        <a href="${pageContext.request.contextPath}/login" class="btn btn-light">Login</a>
                    </div>
                    <div class="signup ms-2">
                        <a href="" class="btn btn-warning">Sign-up</a>
                    </div>
                    <div class="avatar-box ms-2">
                        <div class="avatar">

                        </div>
                        <div class="dropdown">
                            <button style="color: white" onclick="toggleMenu()" class="user-btn btn p-1" type="button">
                                ▼
                            </button>
                            <ul id="user-control" class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container-fluid slider">
        <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="..." class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="..." class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="..." class="d-block w-100" alt="...">
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div style="height: 400px" class="border col col-lg-3"></div>
            <div style="height: 400px" class="border col col-lg-9"></div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/resource/lib/bootstrap/dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/view/index/index.js"></script>
</html>