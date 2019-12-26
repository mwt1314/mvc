$(function () {
   init(); 
});

function init() {
    if (typeof WebSocket == "undefined") {
        alert("您的浏览器不支持WebSocket");
        return;
    }
    var socket = new WebSocket("ws://192.168.1.145:8086/ws");
    socket.onopen = function (ev) {
        //当网络连接建立时触发该事件
        alert("Socket已打开");
    };
    socket.onerror = function (ev) {
        // 当网络发生错误时触发该事件
        alert("Socket发生了错误");
    };
    socket.onclose = function (ev) {
        //当websocket被关闭时触发该事件
        alert("Socket已关闭");
    };
    socket.onmessage = function (ev) {
        //当websocket接收到服务器发来的消息的时触发的事件
        var state = ev.data.readyState;
        console.log(state);
    };

    socket.send("这是来自客户端的消息" + location.href + new Date());


}
