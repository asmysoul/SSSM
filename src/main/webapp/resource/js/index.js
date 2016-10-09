$(window).load(function(){
    $("#loading").fadeOut();
});

$('#menu').tree({
    url: realpath+ '/menu'
});