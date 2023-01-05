let token = localStorage.getItem("token");
let mess = localStorage.getItem("mess");
let usernameText = localStorage.getItem("username");
let categories = localStorage.getItem("categories");

function logout() {
    if (confirm("Do you want to logout")) {
        localStorage.clear();
        window.location.href = "http://127.0.0.1:5500/html/product/index.html";
    }
}

window.onload = function() {
    if (mess != null && mess != undefined) {
        alert(mess)
        localStorage.removeItem("mess");
    }
    $(".p-table-body").html(renderDashBoard());
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token,
        },
        url: "http://localhost:8080/admin/items",
        type: "GET",
        dataType: "json",
        success: function(data) {
            localStorage.setItem("products", JSON.stringify(data[0]));
            localStorage.setItem("categories", JSON.stringify(data[1]));
            localStorage.setItem("users", JSON.stringify(data[2]));
            $("#category").html(renderCategoriesForm(data[1]));
        },
        error: function(rs) {
            console.log(rs.status);
        }
    })
}

$(function() {
    $(".modal-close").click(closeModal);
})

function renderDashBoard() {
    return  `<div class="row g-0">
                <div class="col col-lg-4 p-4">
                    <div class="item-container">
                        <div onclick="list('product')" class="row item border d-flex align-items-center p-2">
                            <div class="col col-lg-4 item-img">
                                <img class="img-icon" src="/assets/img/logo/product.svg" alt="">
                            </div>
                            <div class="col col-lg-8 item-img d-flex align-items-center justify-content-end">
                                <div class="me-5 right-text">
                                    <p class="item-header my-2">Product</p>
                                    <p class="item-desc my-2">50 record</p>
                                </div>
                            </div>
                        </div>        
                    </div>
                </div>
                <div class="col col-lg-4 p-4">
                    <div class="item-container">
                        <div onclick="list('category')" class="row item border d-flex align-items-center p-2">
                            <div class="col col-lg-4 item-img">
                                <img class="img-icon" src="/assets/img/logo/category.svg" alt="">
                            </div>
                            <div class="col col-lg-8 item-img d-flex align-items-center justify-content-end">
                                <div class="me-5 right-text">
                                    <p class="item-header my-2">Category</p>
                                    <p class="item-desc my-2">50 record</p>
                                </div>
                            </div>
                        </div>        
                    </div>
                </div>
                <div class="col col-lg-4 p-4">
                    <div class="item-container">
                        <div onclick="list('user')" class="row item border d-flex align-items-center p-2">
                            <div class="col col-lg-4 item-img">
                                <img class="img-icon" src="/assets/img/logo/user.svg" alt="">
                            </div>
                            <div class="col col-lg-8 item-img d-flex align-items-center justify-content-end">
                                <div class="me-5 right-text">
                                    <p class="item-header my-2">User</p>
                                    <p class="item-desc my-2">50 record</p>
                                </div>
                            </div>
                        </div>        
                    </div>
                </div>
            </div>`
}

function renderProductFrame() {
    return  `<div class="content-header d-flex align-items-center justify-content-between">` +
                `<div class="h4 ms-4">Product</div>` +
                `<div class="me-2 d-flex align-items-center py-1">` +
                    `<button onclick="openAddForm()" class="btn btn-outline-dark no-border-radius me-2 create-toggle">Add new product</button>` +
                    `<span class="me-2">Sort by: </span>` +
                    `<div class="me-2">` +
                        `<select class="form-select no-border-radius" aria-label="Default select example">` +
                            `<option selected>Select</option>` +
                            `<option value="name">Name</option>` +
                            `<option value="price">Price</option>` +
                        `</select>` +
                    `</div>` +
                `</div>` +
            `</div>` +
            `<div class="content-body ms-4 me-3">` +
                `<table class="table table-striped">` +
                    `<thead>` +
                        `<th>Id</th>` +
                        `<th>Name</th>` +
                        `<th>Price</th>` +
                        `<th>Category</th>` +
                        `<th>Image</th>` +
                        `<th>Action</th>` +
                    `</thead>` +
                    `<tbody class="p-table-body">` +

                    `</tbody>` +
                `</table>` +
            `</div>`;
}

function renderProduct(product) {
    // let category = product.category;
    // let nameStr = category.name;
    // console.log(nameStr)
    return  `<tr id="product-${product.id}">` +
                `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.id}</p></div></td>` +
                `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.name}</p></div></td>` +
                `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.price}$</p></div></td>` +
                `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.category.name}</p></div></td>` +
                `<td><div class="p-box p-image d-flex align-item-center"><img class="p-img" src="/assets/img/product/${product.image}" alt="image"></div></td>` +
                `<td>` +
                    `<div class="p-box d-flex align-item-center">` + 
                        `<p class="p-text">` +
                            `<a onclick=openEditForm(${product.id}) class="p-edit me-3">Edit</a>` +
                            `<a class="p-delete">Delete</a>` +
                        `</p>` +
                    `</div>` +
                `</td>` +
            `</tr>`
}

function renderProductEdit(product) {
    return  `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.id}</p></div></td>` +
            `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.name}</p></div></td>` +
            `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.price}$</p></div></td>` +
            `<td><div class="p-box d-flex align-item-center"><p class="p-text">${product.category}</p></div></td>` +
            `<td><div class="p-box p-image d-flex align-item-center"><img class="p-img" src="/assets/img/product/${product.image}" alt="image"></div></td>` +
            `<td>` +
                `<div class="p-box d-flex align-item-center">` + 
                    `<p class="p-text">` +
                        `<a onclick=openEditForm(${product.id}) class="p-edit me-3">Edit</a>` +
                        `<a class="p-delete">Delete</a>` +
                    `</p>` +
                `</div>` +
            `</td>`
}

function renderProductTable(products) {
    let frame = renderProductFrame()
    $(".dashboard-content").html(frame);
    let html = "";
    for (const p of products) {
        html += renderProduct(p);
    }
    $(".p-table-body").html(html);
}

function list(item) {
    switch(item) {
        case 'product':
            let products = localStorage.getItem("products");
            renderProductTable(products)
            break;
    }
}

// Open & close modal
function openModal() {
    $(".modal").show();
}

function closeModal() {
    $(".modal").hide();
}

// Binding modal button
$(function() {
    $(".modal-close").click(closeModal);
})

function clearForm() {
    $(".modal-header").empty();
    $(".modal-submit").empty();
    $(".modal-submit").attr("onclick", "");
    $("#name").val("");
    $("#price").val("");
    $("#category").attr("selected", false)
}

function openAddForm() {
    clearForm();
    $(".modal-header").html("Add product");
    $(".modal-submit").text("Add");
    $(".modal-submit").attr("onclick", "addProduct()");
    $(".id").attr("disable", true);
    openModal();
}

function renderCategoriesForm(categories) {
    let content = "";
    for (const c of categories) {
        content += `<option class="category" id="category-${c.id}" value="${c.id}">${c.name}</option>`
    }
    return content;
}

let productId;
function openEditForm(id) {
    productId = id; 
    $.ajax({
        url: "http://localhost:8080/products/item/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $("#name").val(data.name);
            $("#price").val(data.price);
            let category = "#category-" + data.category.id;
            $(".category").attr("selected", false);
            $(category).attr("selected", true);
        }
    })
    $(".modal-header").html("Edit product <span>#" + id + "<span>");
    $(".modal-submit").text("Edit");
    $(".modal-submit").attr("onclick", "editProduct()");
    $(".id").attr("disable", false);
    $(".id").val(id)
    openModal();
    event.preventDefault();
}

function addProduct() {
    let form = $(".modal-form")[0];
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
        success: function(data) {
            list('product');
        },
        error: function(rs) {
            console.log(rs.status);
        }
    })
    preventSubmitForm();
    closeModal();
}

// function preventSubmitForm() {
//     let form = $(".modal-form")[0];
//     form.addEventListener('submit', function (event){
//         event.preventDefault();
//     })
// }

function editProduct() {
    let form = $(".modal-form")[0];
    let formData = new FormData(form);
    $.ajax({
        headers: {
            "Authorization": "Bearer " + token,
        },
        url: "http://localhost:8080/products/save/" + productId,
        type: "POST",
        data: formData,
        enctype: 'multipart/form-data',
        contentType: false,
        processData: false,
        cache: false,
        success: function(data) {
            let pHtml = renderProductEdit(data)
            $("#product-" + productId).html(pHtml);
        }
    })
    preventSubmitForm();
    closeModal();
}



