function toggleMenu() {
    document.getElementById("user-control").classList.toggle("show");
}

window.onclick = function(event) {
    if (!event.target.matches('.user-btn')) {
        let dropdowns = document.getElementsByClassName("dropdown-menu");
        for (let i = 0; i < dropdowns.length; i++) {
            let openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}