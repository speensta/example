<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test</title>
<script
        src="https://code.jquery.com/jquery-1.12.4.min.js"
        integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
        crossorigin="anonymous"></script>
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script>
    var sendCheck = 0;
    var checkVal = undefined;
    $(document).ready(function() {
        $('input:checkbox[name=time]').click(function () {alert($(this).val());
            sendCheck = $(this).val();
            checkVal = $(this).val();
            $('input:checkbox[name="time"]').each(function() {
                if($(this).val() != checkVal) {
                    $(this).prop('checked',false);
                }
            });

            sendMessage();
        })

        connect();

    });


    //Open the web socket connection to the server
	// var socketConn = new WebSocket('ws://localhost:80/socketHandler');


    let sock = null;
    function connect() {
        sock = new SockJS("/socketHandler");
        sock.onmessage = onMessage;
        sock.onclose = onClose;
    }

    // 메시지 전송
    function sendMessage() {
        sock.send(checkVal);
    }

    // 서버로부터 메시지를 받았을 때
    function onMessage(msg) {
        var data = msg.data;

        if(sendCheck !== data) {
            $('#time'+data).attr('disabled',true);
        }

        $('input:checkbox[name="time"]').each(function() {
            if($(this).val() == data) {
                if($(this).is(':checked') == true) {
                    $(this).prop('checked', false);
                } else {
                    $(this).prop('checked', true);
                }
            }
        });

        $('#time'+data).prop('checked',true);
    }
    // 서버와 연결을 끊었을 때
    function onClose(evt) {
        alert("연결 끊김");
        setTimeout(connect, 1000);
        $("#messageArea").append("연결 끊김");

    }

	// //Send Message
	// function send() {alert('send');
	// 	// var clientMsg = document.getElementById('clientMsg');
    //
    //     var time = $('input:checkbox[name=time]').val();
    //     socketConn.send(time);
	// 	// if (clientMsg.value) {
	// 	// 	socketConn.send(clientMsg.value);
	// 	// 	clientMsg.value = '';
	// 	// }
	// }
    //
	// // Recive Message
	// socketConn.onmessage = function(event) {
	// 	var serverMsg = document.getElementById('serverMsg');
	// 	serverMsg.value = event.data;
    //
    //     $('input:checkbox[name="time"]').each(function() {
    //         if(this.value == event.data){
    //             this.checked = true;
    //         } else {
    //             this.checked = false;
    //         }
    //     });
	// 	// if(event.data == '1') {
    //     //     $('#time1').prop('checked',true);
    //     //     $('#time2').prop('checked',false);
    //     //     $('#time3').prop('checked',false);
    //     // } else if(event.data == '2') {
    //     //     $('#time1').prop('checked',false);
    //     //     $('#time2').prop('checked',true);
    //     //     $('#time3').prop('checked',false);
    //     // } else if(event.data == '3') {
    //     //     $('#time1').prop('checked',false);
    //     //     $('#time2').prop('checked',false);
    //     //     $('#time3').prop('checked',true);
    //     // }

	// }
</script>
</head>
<body>
<h1>Spring MVC 5 + WebSocket + Hello World example</h1>
<hr />
<label>Message</label>
<br>
<textarea rows="8" cols="50" id="clientMsg"></textarea>
<br>
<button onclick="send()">Send</button>
<br>
<label>Response from Server</label>
<br>
<textarea rows="8" cols="50" id="serverMsg" readonly="readonly"></textarea>

예약시간선택
<input type="checkbox" id="time1" name="time" value="1"/>01:00
<input type="checkbox" id="time2" name="time" value="2"/>02:00
<input type="checkbox" id="time3" name="time" value="3"/>03:00

</body>
</html>