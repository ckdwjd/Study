$(window).on('beforeunload', function() {
    $(window).scrollTop(0);
});

$(document).ready(function() {
    $(".safe-start").css("backgroundColor","transperent").fadeOut(4000);
    $(".video-wrap1").css("width","35%");
    $(".video-wrap2").css("width","35%");
    $(".safe-video-txt").slideDown(4000).css("display","block");
});

// ===========================================================================

$(window).scroll(function() {

    $(".txt-bot1, .txt-bot2, .chap01-header, .ctn2, .chap02-title, .ctn3-container, .chap03-title, .ctn4-container").each(function() {
    var element = $(this);

    // 애니메이션이 이미 실행된 경우, 해당 영역은 건너뜁니다.
        if (element.hasClass('ani-slide')) {
        return true; // continue
        }

        // 특정 영역이 스크롤에 보일 때 애니메이션 실행
        if (isElementInView(element)) {
        element.addClass('ani-slide');
        }
    });
});

// 특정 요소가 스크롤에 보이는지 확인하는 함수
function isElementInView(element) {
var windowHeight = $(window).height();
var scrollPosition = $(window).scrollTop();
var elementOffset = element.offset().top;

if (elementOffset < (scrollPosition + windowHeight)) {
    return true;
}

return false;
}