function openEditModal(id, name, price, description, brand) {
    document.getElementById("e-id-container").innerHTML = id;
    document.getElementById("e-id").value = id;
    document.getElementById("e-name").value = name;
    document.getElementById("e-price").value = price;
    document.getElementById("e-description").value = description;
    let focusElements = document.getElementsByClassName("focus");
    for (let focusElement of focusElements) {
        focusElement.removeAttribute("selected");
    }
    document.getElementById("focus-" + brand).setAttribute("selected", null);
}

function openDeleteModal(id) {
    document.getElementById("d-id-container").innerHTML = id;
    document.getElementById("d-id-body").innerHTML = id;
    document.getElementById("d-id").value = id;
}