$(function(){
    $(".c2_textbox_link a").hover(function(){
        $(this).css("color","rgb(255, 205, 0)");
        $(this).next().animate({ marginLeft: "30px" }, 300);
        $(this).next().css("backgroundImage","url('https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more_yellow.svg')");
       

        
    },function(){
        $(this).css("color","black");
        $(this).next().animate({ marginLeft: "20px" }, 300);
        $(this).next().css("backgroundImage","url('https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more.svg')");
    })
})

// $(document).ready(function() {
//     var videoWidth = $("#video").width();

//     function revealVideo() {
//       $(".whitebox").css("left", videoWidth + "px");
//     }

//     revealVideo();
//   });
  

$(function() {

    $(window).scroll(function() {
    
        $(".c2_textbox_title, .c2_textbox_sc, .c2_textbox_link").each(function() {
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
  