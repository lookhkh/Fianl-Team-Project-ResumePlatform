<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MyResueme</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link href="/publish/main/css/index.css" rel="stylesheet">
<link href="/publish/main/css/header.css" rel="stylesheet">
<link href="/publish/main/css/footer.css" rel="stylesheet">
<script src="/publish/main/js/index.js"></script>
<script src="/publish/main/js/dropdown.js"></script>
<script src="/publish/main/js/LoginFormDetection.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- STOMP -->
<c:if test="${userInfo.sort eq 1}">
	<script src="/publish/main/js/corporate.js"></script>
</c:if>
<c:if test="${userInfo.sort eq 0}">
	<script src="/publish/main/js/develop.js"></script>
</c:if>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
<script
	src=https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js></script>



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
						<a>MyResume란?</a> <a>MyResume란?</a> <a>MyResume란?</a> <a>MyResume란?</a>

					</div>
				</div>

				<div class="dropdown">
					<li><a class="target-a" href="/corporate/cpinfo">기업홍보관</a></li>
					<div class="dropdown-content">
						<a>MyResume란?</a> <a>MyResume란?</a>
					</div>
				</div>

				<div class="dropdown">
					<li><a class="target-a" href="/resume">이력서관리</a></li>
					<div class="dropdown-content"></div>
				</div>
			</ul>
		</nav>
		<c:choose>
			<c:when test="${userInfo.id eq null}">
				<div class="signupAndLogin">
					<button type="button" class="signup btn signupAndLoginBtn"
						data-bs-toggle="modal" data-bs-target="#exampleModal">
						회원가입/로그인</button>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<a class="dropdown-item" href="chat" data-bs-toggle="modal"
						data-bs-target="#moaModal"> <i class="fas fa-arrow-right">모달</i>
					</a>
				</div>
				<div class="signupAndLogin">
					<div class="infoBox">
						<div class="infoImg">
							<img src="${userInfo.imgPath}" width="50px" height="50px"flex:center;>
						</div>
						<div class="infoButton">
							<h4 id="userid">${userInfo.id}</h4>
							<button type="button" class="btn btn-primary"
								onclick="location.href='/logout'">로그아웃</button>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>







		<!--공통 헤더부분-->

		<!-- Button trigger modal -->
		<!-- Moa Modal-->
		<div class="modal fade" id="moaModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">알림</h5>
					</div>
					<div class="container" style="margin-top: 50px">
						<div class="row">
							<div class="col-md-12">
								<table id="message-history" class="table table-striped">
									<thead>
										<tr>
											<th>Messages</th>
										</tr>
									</thead>
									<tbody id="messages">
									<c:forEach var="alram" items="${dto}">
										<tr><td>${alram.message}</td></tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="button"
							data-bs-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Login Modal -->
		<div class="loginModal modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">MyResueme</h5>
					</div>
					<div class="modal-body">

						<c:if test="${errors!=null}">
							<p style="color: red">${errors.error}</p>
						</c:if>

						<form id="loginForm" method="POST" action="/login">
							<div class="form-floating mb-3">
								<input name="id" type="text" class="id-input form-control"
									id="floatingInput" placeholder="name@example.com"
									value="${errors.id==null?'':errors.id}"> <label
									for="floatingInput">ID</label>
							</div>
							<div class="form-floating">
								<input name="pw" type="password" class="pw-input form-control"
									id="floatingPassword" placeholder="Password"> <label
									for="floatingPassword">Password</label>
							</div>
						</form>
						<div class="actions">
							<button type="button" class="login-btn btn btn-primary">로그인</button>
							<button type="button" class="btn btn-primary"
								onclick="location.href='/signup'">회원가입</button>
							<button type="button" class="lookup btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#staticBackdrop">
								회원정보 찾기</button>
						</div>



					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Login Modal -->


		<!-- lookUp Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="height: 940px">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">회원정보 찾기</h5>
					</div>

					<div class="lookup modal-body">

						<div class="id-lookupForm">
							<div class="id-lookup">
								<div class="form-floating mb-3">
									<input type="email" class="form-control" id="floatingInput"
										placeholder="name@example.com"> <label
										for="floatingInput">등록 시 입력한 Email을 입력해주세요</label>
								</div>
								<button type="button" class="lookupid_btn btn btn-primary">아이디찾기</button>
							</div>
						</div>

						<div class="pw-lookupForm">
							<div class="pw-lookup">
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="floatingInput"
										placeholder="ID"> <label for="floatingInput">ID를
										입력해주세요</label>
								</div>
								<div class="form-floating mb-3">
									<input type="email" class="form-control" id="floatingInput"
										placeholder="name@example.com"> <label
										for="floatingInput">등록 시 입력한 Email을 입력해주세요</label>
								</div>
								<button type="button" class="btn btn-primary">비밀번호 찾기</button>

							</div>
						</div>


						<div class="actions">
							<button type="button" class="lookupId btn btn-primary">아이디
								찾기</button>
							<button type="button" class="lookupPw btn btn-primary">비밀번호
								찾기</button>
							<button type="button" class="signupinstatic btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#exampleModal">
								로그인하기</button>
							<button type="button" class="btn btn-primary"
								onclick="location.href='/signup'">회원가입</button>

						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
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