$(function() {
    $(".create-toggle").click(openCreateModal)
})

function openCreateModal() {
    $(".modal#create-modal").show();
}

$(function() {
    $(".modal-close").click(closeModal)
})

function closeModal() {
    $(".modal").hide();
}

window.onload = function () {
    successHandler()
}

function successHandler() {
    $.ajax({
        url: "http://localhost:8080/",
        type: "GET",
        dataType: "json",
        success: function(data) {
            let html = "";
            for (let i = 0; i < data.length; i++) {
                html += getSmartphone(data[i]);
            }
            $(".sm-list").html(html);
        }
    })
}

function getSmartphone(smartphone) {
    return `<tr><td>${smartphone.id}</td><td>${smartphone.producer}</td><td>${smartphone.model}</td><td>${smartphone.price}$</td>` +
           `<td><a onclick="openDeleteModal(${smartphone.id})" class="delete-toggle" href="${smartphone.id}">Delete</a></td>` +
           `<td><a onclick="openEditModal(${smartphone.id})" class="edit-toggle" href="${smartphone.id}">Edit</a></td></tr>`;
}

$(function() {
    $(".create-submit").click(addNewSmartPhone);
})

function clearAddForm() {
    $('#producer').val("");
    $('#model').val("");
    $('#price').val("");
}

function addNewSmartPhone() {
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
 
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        url: "http://localhost:8080/",
        success: successHandler

    });
    event.preventDefault();
    closeModal();
    clearAddForm();
}

$(function() {
    $(".edit-toggle").click(openEditModal)
})

function openEditModal(id) {
    let urlStr = "http://localhost:8080/" + id
    $.ajax({
        url: urlStr,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $('#e-producer').val(data.producer);
            $('#e-model').val(data.model);
            $('#e-price').val(data.price);
            $('.e-id').text(data.id);
        }
    })
    event.preventDefault();
    $("#edit-modal").show();
}

$(function() {
    $(".edit-submit").click(editSmartPhone)
})

function editSmartPhone() {
    let producer = $('#e-producer').val();
    let model = $('#e-model').val();
    let price = $('#e-price').val();
    let id = $('.e-id').text();
    let editSmartphone = {
        id: id,
        producer: producer,
        model: model,
        price: price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(editSmartphone),
        url: "http://localhost:8080/",
        success: successHandler
    });
    event.preventDefault();
    closeModal();
}

$(function() {
    $(".delete-submit").click(deleteSmartPhone)
})

function openDeleteModal(id) {
    let urlStr = "http://localhost:8080/" + id
    $.ajax({
        url: urlStr,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $('.d-id').text(data.id);
            $('.d-id-c').text(data.id);
        }
    })
    event.preventDefault();
    $("#delete-modal").show();
}

function deleteSmartPhone() {
    let id = $('.d-id').text();
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "DELETE",
        url: "http://localhost:8080/" + id,
        success: successHandler
    });
    event.preventDefault();
    closeModal();
}

