var stompClient = null;


$(document).ready(function() {
    console.log("Index page is ready");
    connect();
});

function connect() {
    var socket = new SockJS('/our-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
		let userid = document.querySelector('#userid').textContent;

        stompClient.subscribe('/topic/alram/'+userid, function (message) {
        var coment = message.body;
            console.log(coment);
            showMessage(coment);
        });
    });
}

function showMessage(coment) {
    $("#messages").prepend("<tr><td>" + coment + "</td></tr>");
}