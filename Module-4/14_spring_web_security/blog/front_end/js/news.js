let newPage = 0
let totalPage;
let totalElement;
let size;
let last;

function openModal() {
    $(".modal").show();
}

function closeModal() {
    $(".modal").hide();
}

$(function() {
    $(".modal-close").click(closeModal);
})

function clearForm() {
    $(".modal-header").empty();
    $(".modal-submit").empty();
    $(".modal-submit").attr("onclick", "");
    $("#title").val("");
    $("#author").val("");
    $("#contents").val("");
    $(".category").attr("selected", false);
}

function getNews() {
    let title = $("#title").val();
    let author = $("#author").val();
    let contents = $("#contents").val();
    let category = {
        id: $("#category").val()
    }
    let news = {
        title: title,
        contents: contents,
        author: author,
        category: category
    }
    return news;
}

window.onload = function() {
    listNews(0);
}

$(function() {
    $(".load-more").click(function() {
        newPage++;
        listNews(newPage);
    })
})

// List news

function listNews(page) {
    $.ajax({
        url: "http://localhost:8080/api/new?page=" + page,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let html = "";
            totalPage = data[0].totalPages;
            totalElement = data[0].totalElements;
            size = data[0].size;
            last = data[0].last;
            for (const n of data[0].content) {
                html += renderNew(n);
            }
            $(".list-new").append(html);
            $("#category").html(renderCategory(data[1]));
            if (newPage + 1 == totalPage) {
                $(".load-more").hide();
            }
        }
    })
}

function renderNew(news) {
    return `<tr class="new-${news.id}">` + 
           `<td>${news.id}</td>` + 
           `<td><a onclick="viewproduct(${news.id})" href="view.html">${news.title}</a></td>` + 
           `<td>${news.dateUpload}</td>` + 
           `<td>${news.author}</td>` + 
           `<td>${news.category.name}</td>` + 
           `<td><a onclick="deleteNews(${news.id})" class="modal-toggle delete-form">Delete</a></td>` + 
           `<td><a onclick="openEditForm(${news.id})" class="modal-toggle edit-form">Edit</a></td>`;
}

function renderCategory(categories) {
    let content = "";
    for (const c of categories) {
        content += `<option class="category" id="category-${c.id}" value="${c.id}">${c.name}</option>`
    }
    return content;
}

// Add news

function openAddForm() {
    clearForm();
    $(".modal-header").html("Add news");
    $(".modal-submit").text("Add");
    $(".modal-submit").attr("onclick", "addNews()");
    openModal();
    event.preventDefault();
}

function addNews() {
    let news = getNews();
    $.ajax({
        type: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=utf-8'
        },
        dataType: "json",
        url: "http://localhost:8080/api/new/save",
        data: JSON.stringify(news),
        success: function() {
            if ((totalElement + 1) / size > totalPage) {
                $(".load-more").show();
            }
        }
    })
    event.preventDefault();
    closeModal();
    clearForm();
}

// Edit new
let newsId;

function fillForm(news, id) {
    $("#title").val(news.title);
    $("#author").val(news.author);
    $("#contents").val(news.contents);
    $(".category").attr("selected", false);
    $("#category-" + id).attr("selected", true)
}

function openEditForm(id) {
    newsId = id;
    $.ajax({
        url: "http://localhost:8080/api/new/" + id,
        type: "GET",
        dataType: "json",
        success: function(data) {
            fillForm(data, id);
        }
    })
    $(".modal-header").html("Edit news");
    $(".modal-submit").text("Edit");
    $(".modal-submit").attr("onclick", "editNews()");
    openModal();
}

function editNews() {
    let news = getNews();
    $.ajax({
        type: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json; charset=utf-8'
        },
        dataType: "json",
        url: "http://localhost:8080/api/new/save/" + newsId,
        data: JSON.stringify(news),
        success: function() {}
    })
    event.preventDefault();
    closeModal();
    clearForm();
}

// Delete news

function deleteNews(id) {
    if (confirm("Do you want to delete news #" + id)) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/api/new/delete/" + id,
            success: function() {
                $(".new-" + id).remove();
                totalElement--;
                if (totalElement / size < totalPage) {
                    totalPage--;
                    newPage--;
                }
            }
        })
        event.preventDefault();
    }
}

// search
function search() {
    let search = $("#search-input").val();
    $.ajax({
        url: "http://localhost:8080/api/new/search?search=" + search,
        type: "GET",
        dataType: "json",
        success: function(data) {
            let html = "";
            for (const n of data) {
                html += renderNew(n);
            }
            $(".list-new").html(html);
        }
    })
}

