window.onload = function () {
    id = localStorage.getItem("id");
    $.ajax({
        url: "http://localhost:8080/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            $('.view-first-name').text("First name: " + data.firstName);
            $('.view-last-name').text("Last name: " + data.lastName);
        }
    })
}

$(function() {
    $(".back").click(function() {
        localStorage.removeItem("id");
    })
})