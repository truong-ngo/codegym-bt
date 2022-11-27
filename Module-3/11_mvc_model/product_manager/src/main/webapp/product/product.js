function openEditModal(id, name, price, description, supplier) {
    document.getElementById("e-id-container").innerHTML = id;
    document.getElementById("e-id").value = id;
    document.getElementById("e-name").value = name;
    document.getElementById("e-price").value = price;
    document.getElementById("e-description").value = description;
    document.getElementById("e-supplier").value = supplier;
}

function openDeleteModal(id) {
    document.getElementById("d-id-container").innerHTML = id;
    document.getElementById("d-id-body").innerHTML = id;
    document.getElementById("d-id").value = id;
}