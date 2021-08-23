<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Resume developer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="/publish/main/css/소개페이지index.css" rel="stylesheet">
    <link href="/publish/main/css/소개페이지header.css" rel="stylesheet">
    <link href="/publish/main/css/소개페이지footer.css" rel="stylesheet">    
    <script src="/publish/main/js/index.js" ></script>
    <script src="/publish/main/js/dropdown.js"></script>

    <style>
     
    .wrapper{ height: 900px;}
    .video-con {font-size:0;max-width:1000px;margin:0 auto;position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);}
    .video-con > h3 {font-size:40px;text-align:center;padding:30px;font-size:50px;font-weight:900;}
    .video-con > li {font-size:20px;display:inline-block;width:33.3%;vertical-align:top;}
    .textbox {width: 300px; height: 600px;cursor:pointer;text-align:center;margin:10px; margin-left: 50px;}
    .thumb {width:auto;overflow:hidden;padding-bottom:56.25%;position:relative;}
    .thumb img {position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);max-width:100%;transition: .35s ease-in-out;}
    .thumb:before {content:'';display:block;width:100%;height:100%;position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);background:rgba(0,0,0,.6) center center no-repeat;transition: .35s ease-in-out;z-index:20;opacity:0;}
    .title {display:inline-block;background-size: 100%;background-position: 0 0;transition: .35s ease-in-out;padding:10px;margin:10px auto;}
    .desc {display:inline;background: linear-gradient(to right, rgba(255,255,255,0) 50%, #f3ca00 50%);background-size: 200%;background-position: 0 0;transition: .35s ease-in-out;font-size:11px;line-height:1.6;color:#666;word-break:keep-all;}
    .textbox:hover .desc {background-position: -100% 0;}
    .textbox:hover .thumb img {max-width:105%;}
    .textbox:hover .thumb:before {opacity:1;}
    
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




    <!--공통 헤더부분-->
    <div class="wrapper">
        <div class="row first">
    <ul class="video-con" style="margin-top: 30px;">
        <h3>My Resume developer</h3> 
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">조현일</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
            </div>
        </li>
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">이홍섭</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consecteturadipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi optio delectus quia fugit provident impedit cupiditate necessitatibus veniam, error reprehenderit nam. Sapiente rerum quo fugiat quisquam necessitatibus placeat impedit amet!</p>
            </div>
        </li>
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">이미숙</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi optio delectus quia fugit provident impedit cupiditate necessitatibus veniam, error reprehenderit nam. Sapiente rerum quo fugiat quisquam necessitatibus placeat impedit amet!</p>
            </div>
        </li>
    </ul>
    </div>
    </div>

      <!--공통 Footer-->

      <footer>
        <span>프로젝트 깃허브 주소 : <a href="https://github.com/lookhkh/project">깃허브</a> </span>
        <div class="contributor">
            <span>제작자 : 이홍섭   이미숙   조현일</span>
        </div>
    </footer>

        <!--공통 Footer-->

<!-- Button trigger modal -->

  



</body>
</html>
</body>
</html>
<script>
               window.addEventListener('load',function(){
             		const loginBtn = document.querySelector(".login-btn");
             		loginBtn.addEventListener('click',(e)=>{
             			document.querySelector('#loginForm').submit();


             		})
             	})
             </script>