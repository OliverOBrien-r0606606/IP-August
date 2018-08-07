
var url = window.location.protocol+"//"+window.location.hostname+":"+window.location.port+"/Foodz/";

$(document).ready(function () {
    $("body").fadeIn(1000);
    $(".subNote").each(function () {
        $(this).hide();
    });
    $(".languageSelect").mouseenter(function () {
        $(".subnote",this).show();
        $("#welcome").text($(".welcomeNote",this).text());
    });
    $(".languageSelect").mouseleave(function () {
        $(".subnote",this).hide();
        $(this).removeClass("click");
    })
    $(".languageSelect").mousedown(function () {
       $(this).addClass("click");
        $(".languageSelect").mouseup(function () {
            $(this).removeClass("click");
            clickHome($(".lang",this).text())
        })
    })

});

function clickHome(lang) {
    console.log(lang);

    $("body").load(url+"home")
}