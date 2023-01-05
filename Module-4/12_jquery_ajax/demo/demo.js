$(function() {
    $(".toggle").click(function() {
        $(".para").toggle();
    })
})

$(function() {
    $(".animate-toggle").click(function () {
        let item = $(".item");
        item.animate({left: '340px'}, 'slow');
        item.animate({top: '210px'}, 'slow');
        item.animate({left: 0}, 'slow');
        item.animate({top: 0}, 'slow');
    }) 
})