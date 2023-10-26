

$(".sec1-header").addClass("sec1-header-effect");
setTimeout(() => {
    $(".sec1-t1").addClass("sec1-text");
    setTimeout(() => {
        $(".sec1-t2").addClass("sec1-text");
        setTimeout(() => {
            $(".sec1-t3").addClass("sec1-text");
            setTimeout(() => {
                $(".start-wrap").addClass("end-wrap");
                setTimeout(() => {
                    $(".start-wrap").removeClass("start-wrap");
                    $(".start-wrap").css("display","none");
                }, 1500);
            }, 1200);
        }, 900);
    }, 900);
}, 1500);






const prevTimestampRef = {};
const isScrolling = {};
const timerIdRef = {};
const scrollHandler = (timestamp) => {

    if(prevTimestampRef.current === timestamp) return;


    if (isScrolling.current) {
        prevTimestampRef.current = timestamp;

    requestAnimationFrame(scrollHandler);
    }
};

const onScroll = () => {
    isScrolling.current = true;
    requestAnimationFrame(scrollHandler);

    if (timerIdRef.current) window.clearTimeout(timerIdRef.current);

    timerIdRef.current = window.setTimeout(() => {
        isScrolling.current = false;

        var sec1Header = $('.sec1-header');
        var section2Wrap = $('.section2-wrap');
        var sec1Bottom = sec1Header.offset().top + sec1Header.outerHeight();
        
        if (section2Wrap.offset().top <= sec1Bottom) {
            sec1Header.css({'opacity': 0,'z-index': '-10'});
        } else {
            sec1Header.css('opacity', 1);
        }
    })
}