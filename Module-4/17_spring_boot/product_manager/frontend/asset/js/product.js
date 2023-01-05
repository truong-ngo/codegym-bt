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

// List product
window.onload = function() {
    listProduct();
}

let listBrand;

function listProduct() {
    $.ajax({
        url: "http://localhost:8080/products",
        type: "GET",
        dataType: "json",
        success: function(data) {
            let html = "";
            for (const c of data[0]) {
                html += renderProduct(c);
            }
            $(".products-list").html(html);
            $("#brand").html(renderBrand(data[1]));
            listBrand = data[1]
        }
    })
}

function renderProduct(product) {
    return `<tr>` + 
           `<td>${product.id}</td>` + 
           `<td><a onclick="viewproduct(${product.id})" href="view.html">${product.name}</a></td>` + 
           `<td>${product.price}</td>` + 
           `<td>${product.description}</td>` + 
           `<td>${product.brand.name}</td>` + 
           `<td><a onclick="deleteProduct(${product.id})" class="modal-toggle delete-form">Delete</a></td>` + 
           `<td><a onclick="openEditForm(${product.id})" class="modal-toggle edit-form">Edit</a></td>`;
}

function renderBrand(brands) {
    let content = "";
    for (const b of brands) {
        content += `<option class="brand" id="brand-${b.id}" value="${b.id}">${b.name}</option>`
    }
    return content;
}

// Add product

function clearForm() {
    $(".modal-header").empty();
    $(".modal-submit").empty();
    $(".modal-submit").attr("onclick", "");
    $("#name").val("");
    $("#price").val("");
    $("#description").val("");
    $(".brand").attr("selected", false)
}

$(function() {
    $(".create-toggle").click(openAddForm);
})

function openAddForm() {
    clearForm();
    $(".modal-header").html("Add product");
    $(".modal-submit").text("Add");
    $(".modal-submit").attr("onclick", "addProduct()");
    openModal();
}

function addProduct() {
    let name = $("#name").val();
    let price = $("#price").val();
    let description = $("#description").val();
    let brand = {
        id: $("#brand").val(),
    }
    let newProduct = {
        name: name,
        price: price,
        description: description,
        brand: brand
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newProduct),
        url: "http://localhost:8080/products",
        success: listProduct
    })

    event.preventDefault();
    closeModal();
    clearForm();
}

// Edit product

let productId;
function openEditForm(id) {
    productId = id;
    $.ajax({
        url: "http://localhost:8080/products/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $("#name").val(data.name);
            $("#price").val(data.price);
            $("#description").val(data.description);
            let brand = "#brand-" + data.brand.id;
            $(".brand").attr("selected", false);
            $(brand).attr("selected", true);
        }
    })
    $(".modal-header").html("Edit product <span>#" + id + "<span>");
    $(".modal-submit").text("Edit");
    $(".modal-submit").attr("onclick", "editProduct()");
    openModal();
    event.preventDefault();
}

function editProduct() {
    let name = $("#name").val();
    let price = $("#price").val();
    let description = $("#description").val();
    let brand = {
        id: $("#brand").val(),
    }
    let editProduct = {
        id: productId,
        name: name,
        price: price,
        description: description,
        brand: brand
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(editProduct),
        url: "http://localhost:8080/products",
        success: listProduct
    });
    event.preventDefault();
    closeModal();
}

// Delete product

function deleteProduct(id) {
    if (confirm("Do you want to delete product #" + id)) {
        $.ajax({
            // headers: {
            //     'Accept': 'application/json',
            //     'Content-Type': 'application/json'
            // },
            type: "DELETE",
            url: "http://localhost:8080/products/" + id,
            success: listProduct
        })
        event.preventDefault();
    }
}

function viewCustomer(id) {
    localStorage.setItem("id", id);
}