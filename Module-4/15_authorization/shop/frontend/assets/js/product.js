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

// Render all product
window.onload = function() {
    if (mess != null && mess != undefined) {
        alert(mess)
        localStorage.removeItem("mess");
    }
    if (usernameText != null && usernameText != undefined) {
        $(".login").hide();
        $(".user-area").show();
        $(".user").text(usernameText)
    } else {
        $(".login").show();
        $(".user-area").hide();
    }
    listProduct();
}

function listProduct() {
    $.ajax({
        url: "http://localhost:8080/products/item",
        type: "GET",
        dataType: "json",
        success: function(data) {
            let productHtml = "";
            for (const p of data[0]) {
                productHtml += renderProduct(p);
            }
            $(".products-list").html(productHtml);
            $("#category").html(renderCategories(data[1]));
            $(".category-item").html(renderCategoriesSidebar(data[1]));
        }
    })
}

function renderProduct(product) {
    return  `<div class="col col-lg-4 mb-3">` +
                `<div class="product-item">` + 
                    `<a onclick="viewProduct(${product.id})" class="text-decoration-none">` +
                        `<div class="image border p-3">` +
                            `<img src="/assets/img/product/${product.image}" class="img" alt="">` +
                        `</div>` +
                        `<div class="desc border p-3 no-border-bottom">` + 
                            `<p class="p-name text-center mb-1">${product.name}</p>` +
                            `<p class="p-price text-center mt-1 mb-0">${product.price}$</p>` +
                        `</div>` +
                    `</a>` +
                    `<div class="action border px-3 pb-3 text-center">` +
                        `<a onclick="openEditForm(${product.id})" class="btn btn-sm btn-outline-dark no-border-radius me-1" href="#!">Edit</a>` +
                        `<a class="btn btn-sm btn-outline-dark no-border-radius" href="#!">Delete</a>` +
                    `</div>` +     
                `</div>` +
            `</div>`
}

function renderCategories(categories) {
    let content = "";
    for (const c of categories) {
        content += `<option class="category no-border-radius" id="category-${c.id}" value="${c.id}">${c.name}</option>`;
    }
    return content;
}

function renderCategoriesSidebar(categories) {
    let content = "";
    for (const c of categories) {
        content += `<li><a onclick="filterByCategory(${c.id})" href="#!">${c.name}</a></li>`;
    }
    return content;
}

// Add product
function addProduct() {
    let form = $(".add-menu")[0];
    let formData = new FormData(form);
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token,
        },
        url: "http://localhost:8080/products/save",
        type: "POST",
        data: formData,
        enctype: 'multipart/form-data',
        contentType: false,
        processData: false,
        cache: false,
        success: listProduct
    })
    event.preventDefault();
}

// Filter

function filterByCategory(categoryId) {
    $.ajax({
        url: "http://localhost:8080/products/filter/category/" + categoryId,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let productHtml = "";
            for (const p of data) {
                productHtml += renderProduct(p);
            }
            $(".products-list").html(productHtml);
        }
    })
}

function filterByPrice(start, end) {
    let url = `http://localhost:8080/products/filter/price?start=${start}&end=${end}`;
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let productHtml = "";
            for (const p of data) {
                productHtml += renderProduct(p);
            }
            $(".products-list").html(productHtml);
        }
    })
}

function searchProduct() {
    if (event.keyCode == 13) {
        let value = $(".search-input").val();
        $.ajax({
            url: "http://localhost:8080/products/search?q=" + value,
            type: "GET",
            dataType: "json",
            success: function(data) {
                let productHtml = "";
                for (const p of data) {
                    productHtml += renderProduct(p);
                }
                $(".products-list").html(productHtml);
            }
        })
        preventSubmitSearch();
    }
}

function preventSubmitSearch() {
    let form = $(".search-bar")[0];
    form.addEventListener('submit', function (event){
        event.preventDefault();
    })
}

function sortProduct() {
    let value = $("#sort").val();
    $.ajax({
        url: "http://localhost:8080/products/sort?q=" + value,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let productHtml = "";
            for (const p of data) {
                productHtml += renderProduct(p);
            }
            $(".products-list").html(productHtml);
        },
        // error: function() {
        //     if (value != "-----") {
        //         window.location.href = "http://127.0.0.1:5500/html/404.html";
        //     }
        // }
    })
}

function viewProduct(id) {
    $.ajax({
        url: "http://localhost:8080/products/item/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let jsonData = JSON.stringify(data)
            localStorage.setItem("product", jsonData);
            window.location.href = "http://127.0.0.1:5500/html/product/view.html"
        },
        error: function() {
            window.location.href = "http://127.0.0.1:5500/html/404.html";
        }
    })
}

function logout() {
    if (confirm("Do you want to logout")) {
        localStorage.clear();
        window.location.href = "http://127.0.0.1:5500/html/product/index.html";
    }
}
    