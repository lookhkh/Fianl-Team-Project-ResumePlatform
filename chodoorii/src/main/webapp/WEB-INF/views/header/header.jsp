<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyResueme</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="/publish/main/css/index.css" rel="stylesheet">
    <link href="/publish/main/css/header.css" rel="stylesheet">
    <link href="/publish/main/css/footer.css" rel="stylesheet">    
    <script src="/publish/main/js/index.js" ></script>
    <script src="/publish/main/js/dropdown.js"></script>
    <script src="/publish/main/js/LoginFormDetection.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

    <style>

     
    </style>
</head>

<body>


    <!--공통 헤더부분-->
    <div id="header">
        <div class="logo">
            <a href="/"><h3 class="name">MyResueme</h3></a>
        </div>

        <nav>
            <ul class="nav">
              <div class="dropdown">
                <li><a class="target-a" href="">About Us</a></li>
                <div class="dropdown-content">
                  <a>MyResume란?</a>  
                  <a>MyResume란?</a>
                  <a>MyResume란?</a>  
                  <a>MyResume란?</a>  
  
                </div>
              </div> 

              <div class="dropdown">
                <li><a class="target-a" href="/corporate/cpinfo">기업홍보관</a></li>
                <div class="dropdown-content">
                  <a>MyResume란?</a>  
                  <a>MyResume란?</a>  
                </div>
              </div>

              <div class="dropdown">
                <li><a class="target-a" href="/resume">이력서관리</a></li>
                <div class="dropdown-content">
                </div>
              </div>
            </ul>
        </nav>
        <div><a class="dropdown-item" href="chat" data-bs-toggle="modal" data-bs-target="#moaModal">
	<i class="fas fa-arrow-right">모달</i>
	</a></div>
	<c:choose>
	    <c:when test="${userInfo.id eq null}">
	    <div class="signupAndLogin">
	            <button type="button" class="signup btn signupAndLoginBtn" data-bs-toggle="modal" data-bs-target="#exampleModal">
	                회원가입/로그인
	             </button>        
	          </div>    
	     </c:when>
    <c:otherwise>
        <div class="signupAndLogin">
          <div class="infoBox">
            <div class="infoImg">
            <img src="${userInfo.imgPath}" width="50px" height="50px" flex: center;> 
            </div>  
            <div class="infoButton">
            <button type="button" class="btn btn-primary">${userInfo.id}</button>
            <button type="button" class="btn btn-primary" onclick="location.href='/logout'">로그아웃</button> 
            </div>        
           </div> 
         </div>
    </c:otherwise>
</c:choose>
	
	    
          	
          
	


    <!--공통 헤더부분-->
    
    <!-- Button trigger modal -->
 <!-- Moa Modal-->
  <div class="modal fade" id="moaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">알림</h5>
        </div>
        <body>
	<th:block th:replace="~{/layout/basic :: setContent(~{this :: content})}">
		<th:block th:fragment="content">
		
		<div class="container">
			<div class="col-6">
				<label><b>채팅방</b></label>
			</div>
		</div>
			<div id="msgArea" class="col"></div>
			<div class="col-6">
				<div class="input-group mb-3">
					<input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
						<button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
					</div>
				</div>
			</div>
		</th:block>
	</th:block>
</body>
        <div class="modal-footer">
          <button class="btn btn-primary" type="button" data-bs-dismiss="modal">Cancel</button>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Login Modal -->
  <div class="loginModal modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">MyResueme</h5>
        </div>
        <div class="modal-body">
        
        	<c:if test="${errors!=null}"><p style="color:red">${errors.error}</p></c:if>
        	
               <form id="loginForm" method="POST" action="/login">
	            <div class="form-floating mb-3">
		                <input name="id" type="text" class="id-input form-control" id="floatingInput" placeholder="name@example.com" value="${errors.id==null?'':errors.id}">
		                <label for="floatingInput">ID</label>
		              </div>
		              <div class="form-floating">
		                <input name="pw" type="password" class="pw-input form-control" id="floatingPassword" placeholder="Password">
		                <label for="floatingPassword">Password</label>
		              </div>
              </form>
              <div class="actions">
                <button type="button" class="login-btn btn btn-primary">로그인</button>
                <button type="button" class="btn btn-primary" onclick="location.href='/signup'">회원가입</button>
                <button type="button" class="lookup btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                    회원정보 찾기
                </button>
             </div>
             
  
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
  <!-- Login Modal -->


    <!-- lookUp Modal -->
  <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content" style="height: 940px">
        <div class="modal-header">
          <h5 class="modal-title" id="staticBackdropLabel">회원정보 찾기</h5>
        </div>
        
        <div class="lookup modal-body">
            
            <div class="id-lookupForm"> 
                <div class="id-lookup">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">등록 시 입력한 Email을 입력해주세요</label>
                    </div>  
                    <button type="button" class="lookupid_btn btn btn-primary">아이디찾기</button>
                </div>
              </div>

            <div class="pw-lookupForm"> 
                <div class="pw-lookup">
                    <div class="form-floating mb-3">
                        <input  type="text" class="form-control" id="floatingInput" placeholder="ID">
                        <label for="floatingInput">ID를 입력해주세요</label>
                    </div>     
                    <div class="form-floating mb-3">
                        <input  type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                        <label for="floatingInput">등록 시 입력한 Email을 입력해주세요</label>
                    </div>     
                    <button type="button" class="btn btn-primary">비밀번호 찾기</button>

                </div>
              </div>
                
            
                <div class="actions">
                <button type="button" class="lookupId btn btn-primary">아이디 찾기</button>
                <button type="button" class="lookupPw btn btn-primary">비밀번호 찾기</button>
                <button type="button" class="signupinstatic btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    로그인하기
                </button>                
                <button type="button" class="btn btn-primary" onclick="location.href='/signup'">회원가입</button>

             </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
        </div>
      </div>
    </div>
  </div>
    <!-- lookUp Modal -->
               <script>
               window.addEventListener('load',function(){
             		const loginBtn = document.querySelector(".login-btn");
             		loginBtn.addEventListener('click',(e)=>{
             			document.querySelector('#loginForm').submit();


             		})
             	})
             </script>
<!--              <script>
             	var ws = new WebSocket("ws://localhost:8088/chat");
             	
             	ws.onopen = function(){
             		console.log('Info : connectrion opened.');
             		setTimeout( function(){ connect(); },1000);	//1초마다 다시 연결
             	};
             	
             	ws.onmessage = function(event){
             		console.log(event.data+'\n');
             	};
             	
             	ws.onclose = function (event) {console.log('Info: connection closed.');};
             	ws.onerror = function (err) {console.log('Error:',err);};
             	
             	$('#btn.Send').on('click', function(evt){//send버튼 클릭 이벤트
             		evt.preventDefault();	//속성 중단 
             		if(socket.readyState !== 1) return;
             		let msg = ${'input#msg'}.val();
             		ws.send(msg);
             	});

             </script>
 -->            
 <script th:inline="javascript">

	$(document).ready(function(){

		const username = "<c:out value='${userInfo.id}'/>";

		$("#disconn").on("click",(e) =>{
			disconnect();
		})
		$("#button-send").on("click", (e) =>{
			send();
		});

		const websocket = new WebSocket("ws://localhost:8088/ws/chat");

		websocket.onmessage = onMessage;
		websocket.onopen = onOpen;
		websocket.onclose = onClose;

		function send(){
			let msg = document.getElementById("msg");

			console.log(username + ":" +msg.value);
			websocket.send(username + ":" +msg.value);
			msg.value = '';
		}
		
		//채팅창 퇴장
		function onClose(evt){
			var str = username + " : 님이 퇴장하셨습니다.";
			websocket.send(str);
		}
		//채팅창 입장
		function onOpen(evt){
			var str = username +" : 님이 입장하셨습니다."
			websocket.send(str);
		}
		//
		function onMessage(msg){
			var data = msg.data;
			var sessionId = null;
			//데이터를 보낸 사람
			var message = null;
			var arr = data.split(":");// 여기 공백주면 undifiend뜸

			for(var i=0;i<arr.length;i++){
				console.log('arr['+i+']: ' + arr[i]);
			}	
			
			var cur_session = username;
			//현재 세션에 로그인 한 사람
			console.log("cur_session : " + cur_session);
			sessionId = arr[0];
			message = arr[1];

			console.log("sessionID : "+sessionId);
			console.log("cur_session : "+cur_session);

			//로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
			if(sessionId == cur_session){
				var str = "<div class='col-6'>";
				str += "<div class='alert alert-secondary'>";
				str += "<b>" + sessionId + " : " + message + "</b>";
				str += "</div></div>";
				$("#msgArea").append(str);
			}else{
				var str = "<div class='col-6'>";
				str += "<div class='alert alert-warning'>";
				str += "<b>" + sessionId + " : " + message + "</b>";
				str += "</div></div>";
				$("#msgArea").append(str);
			}
		}
	})
</script>