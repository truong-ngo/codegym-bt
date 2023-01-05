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

// List customer
window.onload = function() {
    listCustomer();
}

function listCustomer() {
    $.ajax({
        url: "http://localhost:8080/",
        type: "GET",
        dataType: "json",
        success: function(data) {
            let html = "";
            for (const c of data) {
                html += renderCustomer(c);
            }
            $(".customers-list").html(html);
        }
    })
}

function renderCustomer(customer) {
    return `<tr>` + 
           `<td>${customer.id}</td>` + 
           `<td><a onclick="viewCustomer(${customer.id})" href="view.html">${customer.firstName}</a></td>` + 
           `<td>${customer.lastName}</td>` + 
           `<td><a onclick="deleteCustomer(${customer.id})" class="modal-toggle delete-form">Delete</a></td>` + 
           `<td><a onclick="openEditForm(${customer.id})" class="modal-toggle edit-form">Edit</a></td>`;
}

// Add customer

function clearForm() {
    $(".modal-header").empty();
    $(".modal-submit").empty();
    $(".modal-submit").attr("onclick", "");
    $("#first_name").val("");
    $("#last_name").val("");
}

$(function() {
    $(".create-toggle").click(openAddForm);
})

function openAddForm() {
    $(".modal-header").html("Add customer");
    $(".modal-submit").text("Add");
    $(".modal-submit").attr("onclick", "addCustomer()");
    openModal();
}

function addCustomer() {
    let firstName = $("#first_name").val();
    let lastName = $("#last_name").val();
    let newCustomer = {
        firstName: firstName,
        lastName: lastName
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newCustomer),
        url: "http://localhost:8080/",
        success: listCustomer
    })

    event.preventDefault();
    closeModal();
    clearForm();
}

// Edit customer

let customerId;
function openEditForm(id) {
    customerId = id;
    $.ajax({
        url: "http://localhost:8080/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $('#first_name').val(data.firstName);
            $('#last_name').val(data.lastName);
        }
    })
    $(".modal-header").html("Edit customer <span>#" + id + "<span>");
    $(".modal-submit").text("Edit");
    $(".modal-submit").attr("onclick", "editCustomer()");
    openModal();
    event.preventDefault();
}

function editCustomer() {
    let firstName = $("#first_name").val();
    let lastName = $("#last_name").val();
    let editCustomer = {
        id: customerId,
        firstName: firstName,
        lastName: lastName
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(editCustomer),
        url: "http://localhost:8080/",
        success: listCustomer
    });
    event.preventDefault();
    closeModal();
}

// Delete customer

function deleteCustomer(id) {
    if (confirm("Do you want to delete customer #" + id)) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "DELETE",
            url: "http://localhost:8080/" + id,
            success: listCustomer
        })
        event.preventDefault();
    }
}

function viewCustomer(id) {
    localStorage.setItem("id", id);
}