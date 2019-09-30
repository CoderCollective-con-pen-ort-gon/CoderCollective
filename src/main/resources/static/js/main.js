// "use strict";
// (function () {
// ///////////////////////Fade in/Out Navbar
//
//
//     var opac;
//     // Keeps breaking
//     function fadeInEffect() {
//         $('.navbar').animate({
//             opacity: 1,
//         }, 200, "linear", {
//             step: function () {
//             }
//         })
//     }
//
//     function fadeOutEffect() {
//         $('.navbar').animate({
//             opacity: opac,
//         }, 100, "linear", {
//             step: function () {
//             }
//         })
//     }
//
//     $(window).scroll(function () {
//         $(".jumbotron").css("opacity", 1 - $(window).scrollTop() / 800);
//         $(".navbar").css("opacity", 1 - $(window).scrollTop() / 800);
//         if (($('.navbar').css("opacity")) < .2) {
//             $('.navbar').css("opacity", ".2")
//         }
//     });
//     $(document).ready(function () {
//
//
//         $('.navbar').hover(function () {
//             opac = $('.navbar').css("opacity");
//             //remove for func version to work
//             // $('.navbar').css("opacity", "1");
//
//             fadeInEffect()
//         }, function () {
//
//             //remove for func version to work
//             // $('.navbar').css("opacity", opac);
//
//             fadeOutEffect()
//
//         });
//     });
//
//     $(document).ready(function() {
//         var footer = $('#footer');
//         setInterval(function() {
//             var docHeight = $(window).height();
//             var footerHeight = footer.height();
//             var footerTop = footer.position().top + footerHeight;
//             var marginTop = (docHeight - footerTop + 10);
//
//             if (footerTop < docHeight)
//                 footer.css('margin-top', marginTop + 'px'); // padding of 30 on footer
//             else
//                 footer.css('margin-top', '0px');
//             // console.log("docheight: " + docHeight + "\n" + "footerheight: " + footerHeight + "\n" + "footertop: " + footerTop + "\n" + "new docheight: " + $(window).height() + "\n" + "margintop: " + marginTop);
//         }, 250);
//     });
//
//
//
// })();

/* Set the width of the side navigation to 250px and the left margin of the page content to 250px */
function openNav() {
    document.getElementById("mySidenav").style.width = "50%";
    document.getElementById("main").style.marginLeft = "50%";
    // var editor = ace.edit("editor");
    // editor.setTheme("ace/theme/monokai");
    // editor.session.setMode("ace/mode/javascript");
    var aceEditor = ace.edit("editor");

    // defines the style of the editor
    aceEditor.setTheme("ace/theme/monokai");
    // hides line numbers (widens the area occupied by error and warning messages)
    aceEditor.renderer.setOption("showLineNumbers", false);
    // ensures proper autocomplete, validation and highlighting of JavaScript code
    aceEditor.getSession().setMode("ace/mode/javascript");


}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft = "0";
}