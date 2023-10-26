$(function() {
    $(".ctn3-btn").hover(function() {
        $(this).css("color","rgb(255, 205, 0)");
        $(".ctn3-btn>.btn-arrow").css("backgroundImage","url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more_yellow.svg)").animate({marginLeft:"30px"},300);
    }, function () {
        $(this).css("color","white");
        $(".ctn3-btn>.btn-arrow").css("backgroundImage","url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more_white.svg)").animate({marginLeft:"20px"},300);
    });

   
    $(window).scroll(function() {
    
        $(".ctn3-txt1, .ctn3-txt2, .ctn3-btn-wrap").each(function() {
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
    
    $(window).scroll(function() {
  
        $(".whitebox").each(function() {
            var ele = $(this);
  
            // 애니메이션이 이미 실행된 경우, 해당 영역은 건너뜁니다.
            if (ele.hasClass('ani-left')) {
            return true; // continue
            }
  
            // 특정 영역이 스크롤에 보일 때 애니메이션 실행
            if (isElementInView(ele)) {
                ele.addClass('ani-left ');
            }
        });
    });
  
  
  
    // ===================================================================
    // ===================================================================
    // ===================================================================
  
  
  
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
});