function openEditModal(id, name, email, address) {
    document.getElementById("e-id-container").innerHTML = id;
    document.getElementById("e-id").value = id;
    document.getElementById("e-name").value = name;
    document.getElementById("e-email").value = email;
    document.getElementById("e-address").value = address;
}

function openDeleteModal(id) {
    document.getElementById("d-id-container").innerHTML = id;
    document.getElementById("d-id-body").innerHTML = id;
    document.getElementById("d-id").value = id;
}