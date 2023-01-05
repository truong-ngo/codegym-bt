let token = localStorage.getItem("token");
let mess = localStorage.getItem("mess");
let usernameText = localStorage.getItem("username");

function toggleSearch() {
    let input = document.querySelector(".search-input");
    if (input.classList.contains("hide")) {
        input.classList.remove("hide");
        input.classList.add("show");
    } else if (input.classList.contains("show")) {
        input.classList.remove("show");
        input.classList.add("hide");
    }
}

window.onload = function() {
    if (usernameText != null && usernameText != undefined) {
        $(".login").hide();
        $(".user-area").show();
        $(".user").text(usernameText)
    } else {
        $(".login").show();
        $(".user-area").hide();
    }
}

function login() {
    let username = $("#l-username").val();
    let password = $("#l-password").val();
    let user = {
        "username": username,
        "password": password
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/users/login",
        type: "POST",
        data: JSON.stringify(user),
        success: function(data) {
            let token = data.accessToken;
            localStorage.setItem("token", token);
            localStorage.setItem("mess", "Login successfully");
            localStorage.setItem("username", data.username);
            let roles = data.roles;
            if (roles[0].authority == "ROLE_USER") {
                window.location.href = "http://127.0.0.1:5500/html/product/index.html"
            } else if (roles[0].authority == "ROLE_ADMIN") {
                window.location.href = "http://127.0.0.1:5500/html/admin/admin.html"
            }
        },
        error: function(data) {
            alert("Login unsuccessful, wrong username or password");
        }
    })
    event.preventDefault();
}

function register() {
    let username = $("#r-username").val();
    let password = $("#r-password").val();
    let user = {
        "username": username,
        "password": password
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/users/register",
        type: "POST",
        data: JSON.stringify(user),
        success: function(data) {
            alert("Register successfully");
        },
        error: function(data) {
            alert("Register unsuccessful, username existed");
        }
    })
    event.preventDefault();
}