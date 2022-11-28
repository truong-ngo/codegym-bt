function openEditModal(id, name, email, country) {
    document.getElementById("e-id-container").innerHTML = id;
    document.getElementById("e-id").value = id;
    document.getElementById("e-name").value = name;
    document.getElementById("e-email").value = email;
    document.getElementById("e-country").value = country;
}

function openDeleteModal(id) {
    document.getElementById("d-id-container").innerHTML = id;
    document.getElementById("d-id-body").innerHTML = id;
    document.getElementById("d-id").value = id;
}