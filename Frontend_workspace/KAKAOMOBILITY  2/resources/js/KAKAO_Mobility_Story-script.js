$(window).on('beforeunload', function() {
  $(window).scrollTop(0);
});

$(function() {
  $(document).ready(function() {
      $(".story-start").css("backgroundColor","transperent").fadeOut(4000);
  });
});


$(document).ready(function () {
    setTimeout(function () {
      $(".whitebox-left").css("transform", "translateX(0)");
      $(".whitebox-right").css("transform", "translateX(0)");
    }, 2000);
  });

  $(function(){
    $(".text-wrap").slideDown(4000).css("display", "block");
  });

  $(function(){
    $(".nemo-link a").hover(function(){
      $(this).css("color", "rgb(255,205,0)");
      $(this).next().css("backgroundImage", "url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more_yellow.svg)");
      $(this).next().animate({ marginLeft: "30px" }, 300);
    },function(){
      $(this).css("color", "black");
      $(this).next().css("backgroundImage", "url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more.svg)");
      $(this).next().animate({ marginLeft: "20px" }, 300);
    })
  });

  $(function(){
    $(".sec3-links a").hover(function(){
      $(this).css("color", "rgb(255,205,0)");
      $(this).next().css("backgroundImage", "url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more_yellow.svg)");
      $(this).next().animate({ marginLeft: "30px" }, 300);
    },function(){
      $(this).css("color", "black");
      $(this).next().css("backgroundImage", "url(https://t1.kakaocdn.net/kakaomobility/company_website/icons/ic_16_more.svg)");
      $(this).next().animate({ marginLeft: "20px" }, 300);
    })
  });

  $(function(){

    $(".more-btn, #more-arrow").on("click", function(){
      $(".easter-egg").show();
      $(".more-btn, #more-arrow").hide();
      $("section").css("height", "6500px");
    });

  });

  $(window).scroll(function() {

    $(".1, .2, .3, .4, .5, .6").each(function() {
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


$(window).scroll(function() {
  
  $(".whitebox1, .whitebox2").each(function() {
      let ele = $(this);

      // 애니메이션이 이미 실행된 경우, 해당 영역은 건너뜁니다.
      if (ele.hasClass('ani-left')) {
      return true; // continue
      }

      // 특정 영역이 스크롤에 보일 때 애니메이션 실행
      if (isElementInView(ele)) {
          ele.addClass('ani-left');
      }

  });

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








