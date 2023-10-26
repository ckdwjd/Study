$(window).on('beforeunload', function() {
    $(window).scrollTop(0);
});

$(function () {
    $(".header-menuList dt").hover(function(){
        $(this).find("dd").stop(true,true).slideDown();
    }, function(){
        $(this).find("dd").stop(true,true).slideUp();
    })
});

$(function(){
    $(".header *").css("backgroundColor", "transparent");
    $(".header *").css("color", "white")
    $(".header-logo img").css("filter", "invert(100%)");
    $(".header").css("borderBottom", "none");

    
    
    $(window).scroll(function(){
        let sc = $(this).scrollTop();
        $(".header *").css("backgroundColor", "transparent");
        $(".header *").css("color", "white")
        $(".header-logo img").css("filter", "invert(100%)");
        $(".header").css("borderBottom", "none");
        
        if(sc > 0){
            $(".header *").css("backgroundColor", "white");
            $(".header *").css("color", "rgb(102,102,102)");
            $(".header-logo img").css("filter", "invert(0%)");
            $(".header").css("borderBottom", "1px solid lightgray");
        } 
    })


    $(".header").hover(function(){
        $(".header *").css("backgroundColor", "white");
        $(".header *").css("color", "rgb(102,102,102)");
        $(".header-logo img").css("filter", "invert(0%)");
        $(".header").css("borderBottom", "1px solid lightgray");
    },function(){
        let sc = $(this).scrollTop();
        if(!(sc > 0)) {
            $(".header *").css("backgroundColor", "transparent");
            $(".header *").css("color", "white")
            $(".header-logo img").css("filter", "invert(100%)");
            $(".header").css("borderBottom", "none");
        } 
    })
});

