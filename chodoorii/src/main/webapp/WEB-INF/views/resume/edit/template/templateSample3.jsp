	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:include page="./templateHeader.jsp"></jsp:include>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <style>

       /*ì ëë©ì´ì*/   
       @keyframes rolling {
             0% {
                 transform: translateY(0);
             }
             25% {
                transform: translateY(-20%);
             }
             50%{
                transform: translateY(-40%);
             }
             75%{
                transform: translateY(-60%);
             }
             100% {
                transform: translateY(-80%);
             }
         }
      * {margin: 0; padding: 0;background-color: black; color: white;}
      
     
    /* resumeTemBox1 */
    #INTRODUCTION_IMG_PATH {
      float: left;
      width: 50%;
      height: 20%;
      
    }
    #INTRODUCTION_HEADER {
      -webkit-flex: 1;
      flex: 1;
      margin-top: auto;
      margin-left: 100px;
      vertical-align: middle;
    }
    #INTRODUCTION_HEADER h1 {
      
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
     
     
      text-align: center;
    }
    #INTRODUCTION_MAIN p {
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 400;
      font-size: 18px;
      line-height: 1.5;
   
      text-align: center;
      
    }
    #portfoliosite {
      text-decoration: none;
   
      font-weight: 600;
    }

    .name {
            padding-top: 5%;
            font-size: 30px;
            line-height: 1.5;
            font-style: italic;
            margin-bottom: 20px;
            text-align: center;
        }

    .name-job {
            display: inline-block;
            color: white;
            vertical-align: top;
            height: 1.5em;
            overflow: hidden;
            padding-right: 0.5em;   
        }

       

    .name-job-list {
            animation-name: rolling;
            animation-duration: 3s;
            animation-iteration-count: infinite;
            animation-direction: reverse;
        }

    /* resumeTemBox2 */
   
    
    .SKIL_SET {
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 400;
      font-size: 64px;
      line-height: 1.5;
     
      text-align: center;
      display: -webkit-flex;
      display: flex;
      
    }
    .SKIL_SET_BOX {
      -webkit-flex: 1;
      flex: 1;
      text-align: center;
      -webkit-align-items: center;
      align-items: center;
      -webkit-justify-content: center;
      justify-content: center;
    }
    .SKIL_SET_BOX_img {
      max-width: 50px;
      display : inline;
    }
    
    
    /* resumeTemBox3 */
    #resumeTemBox3 {
      
      text-align: center;
    }
    #resumeTemBox3 h1 {
      padding-top: 200px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      text-align: center;
      line-height: 100px;
    }
    

     /* resumeTemBox5 */
    
    .PORTFOLIOTem h1 {
     
      padding-top: 200px;
      padding-left: 50px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      line-height: 1.5;
      
      text-align: center;
    }
    
    .PORTFOLIO {
      -webkit-flex: 1;
      flex: 1;
      text-align: center;
      -webkit-align-items: center;
      align-items: center;
      -webkit-justify-content: center;
      justify-content: center;
      padding-top: 100px;
      padding-bottom: 50px;
      text-align: center;
    }
    .PORTFOLIO_FIRST_IMG {
      max-width: 300px;
      display : inline;
    }

    /* resumeTemBox6 */
    #resumeTemBox6 {
   
      height: 100%;
    }
    
    .imglist {
      text-align: center;
    }
    .imglist img {
      width: 100px;
      margin-top: 140px;
      padding: 50px;
    }
    .imglist a {
      text-decoration: none;
    }
  </style>  
  
  </head>
  <body>
    
      <!--ë©ì¸ 1íì´ì§-->
      <div id="resumeTemBox1">
        <img id="INTRODUCTION_IMG_PATH" src="${resume.intro_dto.introduction_img_path}" alt="">
        <div id="INTRODUCTION_HEADER">
        	<h1>${resume.intro_dto.introduction_header}</h1>
          <div class="name">
            I`m a 
            <div class="name-job">
                <ul class="name-job-list">
                    <li>Desinger</li>
                    <li>Developer</li>
                    <li>Tutor</li>
                    <li>Creator</li>
                    <li>Desinger</li>
                </ul>

            </div>
        </div>  
        <div id="INTRODUCTION_MAIN">
        <p> ${resume.intro_dto.introduction_main}</p>
        
        </div>
      </div>


      <!--ë©ì¸ 2íì´ì§-->
      <div id="resumeTemBox2">

			<div class="SKIL_SET">
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/스프링.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/오라클.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바서블릿.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바스크립트.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/파이썬.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/HTML.JPG"
						alt="">
				</div>
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="/publish/resume/img/CSS.JPG"
						alt="">
				</div>
			</div>
		</div>

      <!--ë©ì¸ 3íì´ì§-->
      <div id="resumeTemBox3">
        <h1><span>My Self</span></h1>
        <div class="tmicontainer">
          <div class="tmilist">
            <p class="CONTACT_INFO_NAME">이름</p> 
            <p class="CONTACT_INFO_NUMBER">전화번호</p>   
            <p class="CONTACT_INFO_EMAIL">이메일</p>  
            <p class="CONTACT_INFO_BIRTH">생일</p> 
            <p class="CONTACT_INFO_CITY">거주지</p>
            <br><br>  
          </div>
          
        </div>
      </div>
      
      

      <!--ë©ì¸ 5íì´ì§-->
      <div id="resumeTemBox5">
      <div class="PORTFOLIOTem">
        <h1>PORTFOLIO</h1>
        <c:if test="${!empty resume.portfolio_first_name&&resume.portfolio_first_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_first_img}" alt="">
            <a href="${resume.portfolio_first_github}">
            <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
            <p>${resume.portfolio_first_name }</p>
            <p class="PORTFOLIO_FIRST_NAME"> ${resume.portfolio_first_desc}</p>
          </div>
          </c:if>
          <c:if test="${!empty resume.portfolio_second_name&&resume.portfolio_second_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_second_img}" alt="">
            <a href="${resume.portfolio_second_github}">
            <a href="#"><p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
            <p>${resume.portfolio_second_name }</p>
            <p class="PORTFOLIO_FIRST_NAME"> ${resume.portfolio_second_desc}</p>
          </div>
          </c:if>
           <c:if test="${!empty resume.portfolio_third_name&&resume.portfolio_third_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_third_img}" alt="">
            <a href="${resume.portfolio_third_github}">
            <a href="#"><p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
            <p>${resume.portfolio_third_name }</p>
            <p class="PORTFOLIO_FIRST_NAME"> ${resume.portfolio_third_desc}</p>
          </div>
          </c:if>
        </div>   
      </div>

      
      <!--ë©ì¸ 6íì´ì§-->
      <div id="resumeTemBox6">
    
        <div class="imglist">
          <a href="${resume.sns_dto.blog_address}">
            <img src="/publish/resume/img/블로그.png" alt="">
          </a>
          <a href="${resume.sns_dto.instagram_address}">
            <img src="/publish/resume/img/인스타.png" alt="">
          </a>
          <a href="${resume.sns_dto.facebook_address}">
            <img src="/publish/resume/img/페이스북ㄴ.JPG" alt="">
          </a>
        </div>
      </div> 
       <div data-input="${preview=='on'?'on':'none'}" class="action_btn" style="position: fixed; top: 0px; left: 50%; display: none;">
        <button class="btn btn-primary">등록하기</button>
        <button class="btn btn-primary">돌아가기</button>
      </div>
  </body>
</html>