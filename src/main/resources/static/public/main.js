"use strict";
(function () {
///////////////////////Fade in/Out Navbar


    var opac;
    // Keeps breaking
    function fadeInEffect() {
        $('.navbar').animate({
            opacity: 1,
        }, 200, "linear", {
            step: function () {
            }
        })
    }

    function fadeOutEffect() {
        $('.navbar').animate({
            opacity: opac,
        }, 100, "linear", {
            step: function () {
            }
        })
    }

    $(window).scroll(function () {
        $(".jumbotron").css("opacity", 1 - $(window).scrollTop() / 800);
        $(".navbar").css("opacity", 1 - $(window).scrollTop() / 800);
        if (($('.navbar').css("opacity")) < .2) {
            $('.navbar').css("opacity", ".2")
        }
    });
    $(document).ready(function () {


        $('.navbar').hover(function () {
            opac = $('.navbar').css("opacity");
            //remove for func version to work
            // $('.navbar').css("opacity", "1");

            fadeInEffect()
        }, function () {

            //remove for func version to work
            // $('.navbar').css("opacity", opac);

            fadeOutEffect()

        });
    });

    $(document).ready(function() {
        var footer = $('#footer');
        setInterval(function() {
            var docHeight = $(window).height();
            var footerHeight = footer.height();
            var footerTop = footer.position().top + footerHeight;
            var marginTop = (docHeight - footerTop + 10);

            if (footerTop < docHeight)
                footer.css('margin-top', marginTop + 'px'); // padding of 30 on footer
            else
                footer.css('margin-top', '0px');
            // console.log("docheight: " + docHeight + "\n" + "footerheight: " + footerHeight + "\n" + "footertop: " + footerTop + "\n" + "new docheight: " + $(window).height() + "\n" + "margintop: " + marginTop);
        }, 250);
    });



})();
