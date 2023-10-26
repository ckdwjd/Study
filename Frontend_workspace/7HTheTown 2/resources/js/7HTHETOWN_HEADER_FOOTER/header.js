$(document).ready(function(){
    $(".headerLi").css("display","none");
});

$(document).ready(function(){
    $(".header").children().not(".notArea").hover(function(){
        $(".header").css("height", "230px");
        $(".naviBack").css("height", "230px");
        $(".headerLi").css("display","block");
    }, function(){
        $(".header").css("height", "100px");
        $(".naviBack").css("height", "100px");
        $(".headerLi").css("display","none");
    });
})


$(document).ready(function(){
    // $(".myPage").hide();
    $(".menuIcon").hover(function(){
        $(".myPage").css("height", "310px");
    }, function(){
        $(".myPage").css("height", "0px");
    });
})