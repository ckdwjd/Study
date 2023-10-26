$(function () {
    $(".toggle-button").click(function () {
        $(this).next(".more-options").slideToggle(250);
    });

    $(document).mouseup(function (e) {
        var container = $(".more-options");
        var buttons = $(".toggle-button");
        if (!container.is(e.target) && container.has(e.target).length === 0
            && !buttons.is(e.target) && buttons.has(e.target).length === 0) {
            container.slideUp(250);
        }
    });


    var checkboxAdded = false;
    var button = $('#deleteBtn');
    var chatList = $('.chat-list');

    button.click(function () {
        if (!checkboxAdded) {
            var checkbox = $('<input type="checkbox" name="deleteRoom" class="deleteCheck"/>');
            var checkbtn = $('<button id="deleteList" class="deleteListBtn">삭제하기</button>')
            chatList.find(".list-info").prepend(checkbox);
            chatList.closest(".chat-list").prepend(checkbtn);
            checkboxAdded = true;
        } else {
            chatList.find('.deleteCheck').remove();
            chatList.find('.deleteListBtn').remove();
            checkboxAdded = false;
        }
    });

    $("#input-search-chat").on("keyup", () => {
        let keyword = $("#input-search-chat").val();

        $.ajax({
            url: "/dot/chat/chatRoomList",
            data: { keyword: keyword },
            method: "post",
            dataType: "json", // 데이터 형식을 JSON으로 지정
            success: (data) => {
                displayChatRooms(data); // 받아온 JSON 데이터로 화면 갱신 함수 호출
            },
            error: console.log
        });
    });

    // 받아온 JSON 데이터로 화면 갱신하는 함수
    function displayChatRooms(data) {
        let chatRoomListDiv = $(".chat-list");

        chatRoomListDiv.empty(); // 기존 내용 비우기

        if (data.length === 0) {
            chatRoomListDiv.append(`<dl>
										<dt>
											<div class="list-info-wrap">
												<div class="list-info">
													<span>조회된 채팅방이 없습니다.</span>
												</div>
											</div>
										</dt>
									</dl>`);
        } else {
            for (let i = 0; i < data.length; i++) {
                let chatRoom = data[i];
                let chatRoomHtml = `
	                <dl>
	                    <dt>
	                        <div class="list-info-wrap">
	                            <div class="list-info">
	                                <img src="../resources/images/KakaoTalk_Photo_2020-12-19-23-39-15.jpg">
	                                <div class="list-text">
	                                    <div class="list-top">
	                                        <span>${chatRoom.title}</span> <span>8월 17일</span>
	                                    </div>
	                                    <div class="list-bot">
	                                        <span>밥은 먹엇냐</span>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </dt>
	                </dl>
	            `;
                chatRoomListDiv.append(chatRoomHtml);
            }
        }
    }



    $(".joinChatRoom").on("click", "dt", (e) => { // 클래스 선택자 사용
        const focus = $(e.currentTarget);
        const chatRoomNo = focus.find("[name=chatRoom]").val();

        console.log(chatRoomNo);

        $.ajax({
            url: "/dot/chat/chatRoomList/" + chatRoomNo,
            data: { chatRoomNo: chatRoomNo },
            method: "POST",
            success: (data) => {
                console.log(data);
            },
            error: (error) => {
                console.error(error);
            }
        });
    });

    function displayMsgList(data) {
        let chatRoomDiv = $(".room-wrap");

        let joinRoom = data[0];
        let msgList = data[1];

        chatRoomDiv.empty(); // 기존 내용 비우기

        if (joinRoom.length === 0 && msgList.length === 0) {
            chatRoomDiv.append(`<dl>
									<dt>
										<div class="list-info-wrap">
											<div class="list-info">
												<span>조회된 채팅방이 없습니다.</span>
											</div>
										</div>
									</dt>
								</dl>`);
        } else {
            for (let i = 0; i < data.length; i++) {
                
                let chatRoomHtml = `
	                <div class="room-wrap">
					<div class="room-header">
						<div class="header-wrap">
							<img src="resources/img/KakaoTalk_Photo_2020-12-19-23-39-15.jpg" />
							<span class="user-id"> <a>${data.joinRoom[0].title}</a>
							</span> <span class="status">접속중</span> <label></label>
						</div>
					</div>
					<div class="room-body">
						<ul class="display-chatting">
                            <li class="myChat">
                                <span class="chatDate">오전 9:33</span>
                                <p class="chat">만나서 반갑습니다.</p>
                            </li>
							<li class="otherChat">
								<div>
									<img class="img" src="resources/img/karina1.jpeg" /> <b>TomNTom</b>
								</div>
								<div>
									<p class="chat">보기 좋네여</p>
									<span class="chatDate">오전 9:33</span>
								</div>
							</li>
						</ul>
					</div>
					<div class="room-footer">
						<div class="chat-input">
							<textarea id="inputChatting" placeholder="전송하실 메세지를 입력하세요."></textarea>
						</div>
						<div class="chat-tool">
							<input type="file" class="upload-file" /> <span
								class="material-symbols-outlined add_box"> attach_file </span>
							<button id="chatSend">전송</button>
						</div>
					</div>
				</div>
	            `;
                chatRoomDiv.append(chatRoomHtml);
            }
        }



    }

});

/**
 * 
 */
 //페이지 로딩 완료후 채팅창 제일 밑으로 내리기
 // 즉시 실행 함수(IIFE, 속도 빠름, 변수명 중복 문제 해결) 
 (
    function(){
       const display = document.getElementsByClassName("display-chatting")[0];
       
       if(display != null){
          display.scrollTop = display.scrollHeight;
       }
    }
 )();
 
 
 // 채팅메세지 보내기 기능
 document.getElementById("send").addEventListener("click" , sendMessage);
 
 // 채팅메세지 보내기 함수
 function sendMessage(){
    
    // 채팅이 입력되고 있는 textarea
    const inputChatting = document.getElementById("inputChatting");
    
    if(inputChatting.value.trim().length == 0){
       //입력이 되지 않은 경우
       alert("채팅을 입력해주세요 ㅎ");
       
       inputChatting.value = ""; // 공백문자 삭제
       inputChatting.focus();
    }else{
       // 입력이 된 경우
       
       // 메세지 입력시 필요한 데이터를 객체로 생성
       const chatMessage = {
          "userNo" : userNo,
          "userName" : userName,
          "chatRoomNo" : chatRoomNo,
          "message" : inputChatting.value
       };
       
       const parsedMessage = JSON.stringify(chatMessage);
       
       // send(값) : 웹 소켓 핸들러로 값을 보냄 ==> 웹소켓 핸들러 내부의 handleTextMessage가 받아줌.
       chattingSock.send(parsedMessage);
       
       inputChatting.value = "";
    }
 }
 
 // 웹소켓 핸들러에서 클라이언트 소켓으로 메세지를 전달하는 구문을 감지하는 이벤트 핸들러
 // s.sendMessage()함수가 호출되는 시점을 감지
 chattingSock.onmessage = function(e){
    console.log(e , e.data);
    // e.data : 전달된 메세지(JSON 형태)
    
    // 전달받은 메세지를 JS객체로 변환
    const chatMessage = JSON.parse(e.data);
    console.log(chatMessage);
    
    const li = document.createElement("li");
    
    const p = document.createElement("p");
    p.classList.add("chat");

    // 글 내용 추가 + 개행처리
    p.innerHTML = chatMessage.message.replace(/\\n/gm, "<br/>");

    const span = document.createElement("span");
    span.classList.add("chatDate");
    span.innerText = currentTime(); // 날짜 추가

    // 내가 쓴 채팅 , 남이 쓴 채팅

    if(chatMessage.userNo == userNo) {

        li.classList.add("myChat"); // 내가 쓴 글
        li.append(span, p);

    } else {

        li.innerHTML = "<b>" + chatMessage.userName + "</b><br>";
        li.append(p, span);
    }

    // 채팅창
    const display = document.getElementsByClassName("display-chatting")[0];

    // 채팅창에 내용 추가
    display.append(li);
    
    // 채팅창 아래로 내리기
    display.scrollTop = display.scrollHeight;

 }

// 현재 시간 출력함수
function currentTime() {

    const now = new Date();
    let time = "";

    time = now.getFullYear() + "-" + addZero(now.getMonth() + 1) + "-" + addZero(now.getDate());

    return time;
}
 
function addZero(time) {
    return time < 10 ? "0" + time : time;
}
 
 
 
 
 
 
 