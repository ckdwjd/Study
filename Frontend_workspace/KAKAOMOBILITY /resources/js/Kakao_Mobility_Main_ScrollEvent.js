$(function() {

  $(window).scroll(function() {
  
      $(".txt-bot1, .txt-bot2, .chap01-header, .tech-ctn2-1 .ctn1-txt-wrap, .tech-ctn2-2 .ctn2-txt-wrap, .tech-ctn2-3 .ctn3-txt-wrap, .tech-ctn2-4 .ctn4-txt-wrap, .chap02-title, .chap02-subtitle, .tech-ctn3-1 .ctn1-txt-wrap, .tech-ctn3-2 .ctn2-txt-wrap, .chap03-title, .chap03-subtitle, .tech-ctn4-1 .ctn1-txt-wrap, .tech-ctn5 .ctn5-left>.ctn5-txt, .tech-ctn5 .ctn5-img>img, .tech-ctn5 .ctn5-title, .tech-ctn5 .ctn5-right>.ctn5-txt, .tech-ctn5 .ctn5-btn").each(function() {
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

      $(".tech-ctn2-1 .img-wrap1, .tech-ctn2-2 .img-wrap2, .tech-ctn2-3 .img-wrap3, .tech-ctn2-4 .img-wrap4, .tech-ctn3-1 .img-wrap1, .tech-ctn3-2 .img-wrap2, .tech-ctn4-1 .img-wrap1").each(function() {
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
