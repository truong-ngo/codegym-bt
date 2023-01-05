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
    let jsonProduct = localStorage.getItem("product");
    let product = JSON.parse(jsonProduct);
    renderProduct(product);
    if (usernameText != null && usernameText != undefined) {
        $(".login").hide();
        $(".user-area").show();
        $(".user").text(usernameText)
    } else {
        $(".login").show();
        $(".user-area").hide();
    }
}

function renderProduct(product) {
    $(".img-desc").attr("src", "/assets/img/product/" + product.image);
    $(".name-desc").text(product.name);
    $(".price-desc").text("Price: " + product.price + "$");
    $(".add-cart").attr("onclick", `addToCart(${product.id})`)
}

function addToCart(id) {
    
}

function logout() {
    if (confirm("Do you want to logout")) {
        localStorage.clear();
        window.location.href = "http://127.0.0.1:5500/html/product/index.html";
    }
}