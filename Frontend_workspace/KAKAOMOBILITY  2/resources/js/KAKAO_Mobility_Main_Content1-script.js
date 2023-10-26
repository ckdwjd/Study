$(document).ready(function () {
    function countUp(target, start, end, duration) {
      var range = end - start;
      var current = start;
      var increment = Math.ceil(range / 100); // 100단위로 증가
      var stepTime = Math.abs(Math.floor(duration / range));
      var interval = 50; // 갱신 간격 (밀리초)
      var steps = Math.ceil(range / increment);
      var step = 0;
      var timer = setInterval(function () {
        current += increment;
        step++;
        $(target).text(current.toLocaleString()); // 숫자에 쉼표(,) 추가
        if (step >= steps) {
          clearInterval(timer);
          $(target).text(end.toLocaleString()); // 정확한 최종 숫자 표시
        }
      }, interval);
    }
  
    // 예시: 카운트를 시작할 버튼을 클릭했을 때 호출
    setTimeout(function () {
      var targetElement = $("#countTarget");
      var startNumber = parseInt(targetElement.text().replace(/,/g, "")); // 쉼표(,) 제거 후 숫자 추출
      var endNumber = 48543722; // 도달할 최종 숫자
      var duration = 3000; // 애니메이션의 지속 시간 (밀리초)
      countUp(targetElement, startNumber, endNumber, duration);
    },3000);

});