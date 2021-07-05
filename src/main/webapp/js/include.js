$(function () {
    $.get("header.html",function (data) {
        $("#azen-header").html(data);
    });
    $.get("footer.html",function (data) {
        $("#azen-footer").html(data);
    });
    $.get("link.html",function (data) {
        $("#link").html(data);
    });
});