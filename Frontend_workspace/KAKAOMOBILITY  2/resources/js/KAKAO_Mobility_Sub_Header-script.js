$(function () {
    $(".header-menuList dt").hover(function(){
        $(this).find("dd").stop(true,true).slideDown();
    }, function(){
        $(this).find("dd").stop(true,true).slideUp();
    })
});
