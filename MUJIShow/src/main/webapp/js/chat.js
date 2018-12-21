

var websocket = null;
var yip = null;

//1.判断当前浏览器是否支持WebSocket
if ('WebSocket' in window) {
    websocket = new WebSocket("ws://localhost:8080/websocketController");//注意此处的ws要加上项目名JavaWebSocket再加@ServerEndpoint注解的值websocket
} else {
    alert('当前浏览器 Not support websocket');
}

//连接发生错误的回调方法
websocket.onerror = function() {
    setMessageInnerHTML("WebSocket连接发生错误");
};

//2.连接成功建立的回调方法
websocket.onopen = function() {
    setMessageInnerHTML("<center style='color: white;position: relative;top: 18px'>尊敬的 "+yip + " 欢迎您~</center>");
}

//接收到消息的回调方法
websocket.onmessage = function(event) {
    setMessageInnerHTML(event.data);
}

//连接关闭的回调方法
websocket.onclose = function() {
    setMessageInnerHTML("WebSocket连接关闭");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
    closeWebSocket();
}

//将消息显示在网页上
var yipms="";
function setMessageInnerHTML(innerHTML) {
    document.getElementById('message').innerHTML +=yipms;
    yipms="<span style='display: inline-block;text-indent: 15px;color: white'>"+yip+new Date().toLocaleTimeString()+" sent a message：</span>";
    /*document.getElementById('message').innerHTML += innerHTML + '<br/>'
    * */
    document.getElementById('message').innerHTML += "<font style='color: white'>"+innerHTML+"</font>" + '<br/>';
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//3.发送消息
function send() {
   /* var message = document.getElementById('text').value;
    websocket.send(message);*/
    var message = editor.txt.html();
    console.log(message);
    websocket.send(message);
}

//获取ip
$(function(){
    $.ajax({
        url : 'getIp',
        type : 'post',
        success : function(data) {
            var dataip = JSON.parse(data);
            yip = dataip.ip;
            console.log(yip);
        }
    })
})