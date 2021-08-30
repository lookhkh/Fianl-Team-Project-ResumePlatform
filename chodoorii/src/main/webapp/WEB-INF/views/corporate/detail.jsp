<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/publish/corporate/css/basic.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js></script>
<jsp:include page="../header/header.jsp"></jsp:include>

<body>



	<div class="Detail-info">
		<div class="Summary">
			<div class="content">
				<dl>
					<h1>
						<Strong>${detail.companayName}</Strong>
					</h1>
				</dl>
				<dl>
					<dt>평균연봉</dt>
					<dd>${detail.salary}</dd>
				</dl>
				<dl>
					<dt>종업원 수</dt>
					<dd>${detail.staff_number}</dd>
				</dl>
				<dl>
					<dt>복지</dt>

					<dd class="rest">
						<c:forEach var="item" items="${welfare}">
							<div>
								<img src="/publish/corporate/img/${item}.jpg" alt="">
								<p>${item}</p>
							</div>
						</c:forEach>
					</dd>
				</dl>
			</div>
			<div class="co-img">
				<img src="${detail.logo_img }" width="500px" height="500px" alt="자연">
			</div>
		</div>
		<div class="SI">
			<div class="content">
				<dl>
					<dt>Summary</dt>
					<dd>${detail.summary}</dd>
				</dl>
			</div>
		</div>
		<div class="SI-btn">
			<c:choose>
				<c:when test="${userInfo.id eq null}">
					<div class="signupAndLogin">
						<button type="button" data-bs-toggle="modal"
							data-bs-target="#exampleModal">이력서보내기</button>
					</div>
				</c:when>
				<c:when test="${userInfo.id eq detail.userid.id}">
					<div class="signupAndLogin">
						<button type="button"
							onclick="location.href='/corporate/update/${detail.info_id}'">
							수정하기</button>
					</div>
				</c:when>
				<c:when test="${userInfo.sort eq 0}">
					<div class="signupAndLogin">
						<button type="button" data-bs-toggle="modal"
							data-bs-target="#shareModal" data-bs-whatever="@mdo" id="share">공유하기
						</button>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>



			<jsp:include page="../header/footer.jsp"></jsp:include>

			<div class="modal fade" id="shareModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content" style="height: 500px">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">공유하기</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form style="width: 500px" method="post"
							action="/resume/share/mail" id="frm">
							<div class="spinner-border" role="status"
								style="margin-top: 100px; display: none;">
								<span class="visually-hidden">Loading...</span>
							</div>
							<div class="modal-body email">
								<div class="mb-3">
									<input type="hidden" id="toUser" name="toUser"
										value="${detail.userid.id}">
									<!-- 보낼 상대 id값  -->
									<input type="hidden" id="fromUser" name="fromUser"
										value="${userInfo.id}">
									<!-- 내 id값  -->
									<label for="recipient-name" class="col-form-label">받으시는
										분 메일</label> <input type="text" class="form-control"
										id="recipient-name" name="to" value="${detail.userid.email}"
										readonly>
								</div>
								<div class="mb-3">
									<label for="message-text" class="col-form-label">소개</label> <input
										class="form-control" id="message-text" name="what"></input>
								</div>

								<div class="modal-footer" style="margin-top: 50px">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button id="sendMessage" class="btn btn-primary">보내기</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
</body>
</html>

<script>
	var stompClient = null;

	$(document).ready(function() {
		console.log("Index page is ready");
		connect();

		$("#sendMessage").click(function() {
			const modalBody = document.querySelector(".modal-body.email");
			const spinner = document.querySelector('.spinner-border');
			spinner.style.display = 'flex';
			modalBody.style.display = 'none';
			sendMessage();
		});

		$("#share").click(function() {
			const modalBody = document.querySelector(".modal-body");
			console.log(modalBody)
			modalBody.style.display = 'none';
		});
	});

	function connect() {
		var socket = new SockJS('/our-websocket');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			console.log('Connected: ' + frame);
		});
	}

	function sendMessage() {
		var toUser = $('#toUser').val();
		var fromUser = $('#fromUser').val();
		console.log("sending message");
		stompClient.send("/ws/share", {}, JSON.stringify({
			'fromwhom' : fromUser,
			'towhom' : toUser
		}));
		var form = document.getElementById("frm");
		form.submit();
	}
</script>