	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<jsp:include page="./templateHeader.jsp"></jsp:include>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <style>
      * {margin: 0; padding: 0;}
      div {width: 100vw; height: 100vh;}
     
    /* resumeTemBox1 */
    #resumeTemBox1 {
      background: #FEAC5E;
      background: -webkit-linear-gradient(to right, #4BC0C8, #C779D0, #FEAC5E);
      background: linear-gradient(to right, #4BC0C8, #C779D0, #FEAC5E);
      display: -webkit-flex;
      display: flex;
      -webkit-align-items: center;
      align-items: center;
      -webkit-justify-content: center;
      justify-content: center;
    }
    #INTRODUCTION_IMG_PATH {
      max-width: 800px;
      margin-left: 70px;
      -webkit-flex: 1;
      flex: 1
    }
    #INTRODUCTION_HEADER {
      -webkit-flex: 1;
      flex: 1;
      margin-top: auto;
      margin-left: 100px;
      vertical-align: middle;
    }
    #INTRODUCTION_HEADER h1 {
      margin-top: 50%;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      line-height: 1.5;
      color: #fff;
      text-align: center;
    }
    #INTRODUCTION_MAIN p {
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 400;
      font-size: 18px;
      line-height: 1.5;
      color: #fff;
      text-align: center;
      margin-top: 30%;
    }
    #portfoliosite {
      text-decoration: none;
      color: #7319F3;
      font-weight: 600;
    }
    #portfoliosite:hover {
      color: yellow;
    }
    /* resumeTemBox2 */
    #resumeTemBox2 {
      background: #70e1f5;
      background: -webkit-linear-gradient(to right, #ffd194, #70e1f5);
      background: linear-gradient(to right, #ffd194, #70e1f5);
    }
    #resumeTemBox2 h1 {
        padding-top: 200px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 400;
      font-size: 64px;
      line-height: 1.5;
      color: white;
      text-align: center;
    }
    .SKIL_SET {
      display: -webkit-flex;
      display: flex;
      margin-top: 150px;
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
      max-width: 100px;
      display : inline;
    }
    
    
    /* resumeTemBox3 */
    #resumeTemBox3 {
      background: #eee;
    }
    #resumeTemBox3 h1 {
      padding-top: 80px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      line-height: 1.5;
      color: black;
      text-align: center;
    }
    #resumeTemBox3 h1 span {
      font-family: 'Palanquin Dark', sans-serif;
      font-weight: 400;
    }
    .tmicontainer {
      display: -webkit-flex;
      display: flex;
      margin-top: 80px;
    }
    .tmilist {
      -webkit-flex: 1;
      flex: 1;
      text-align: center;
      -webkit-align-items: center;
      align-items: center;
      -webkit-justify-content: center;
      justify-content: center;
    }
    .tmilist p {
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 400;
      color: black;
      font-size: 25px;
      line-height: 5.5;
    }
    .tmilist p:hover {
      font-size: 0;
    }
    .tmilist p:hover::before {
      font-size: 25px;
      font-weight: bold;
      color: #7319F3;
    }
    .tmilist #tmi1:hover:before {    
      content: '${resume.user.name}';
    }
    .tmilist #tmi2:hover:before {
      content: '${resume.user.contact_num}';
    }
    .tmilist #tmi3:hover:before {
      content: '${resume.user.email}';
    }
    .tmilist #tmi4:hover:before {
      content: '${resume.user.birth}';
    }
    .tmilist #tmi5:hover:before {
      content: '${resume.user.city}';
    }
    
 

     /* resumeTemBox5 */
     #resumeTemBox5 {
      background: #70e1f5;
      background: -webkit-linear-gradient(to right, #ffd194, #70e1f5);
      background: linear-gradient(to right, #ffd194, #70e1f5);
    }
    .PORTFOLIOTem h1 {
     
      padding-top: 140px;
      padding-left: 50px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      line-height: 1.5;
      color: white;
      text-align: center;
    }
    .PORTFOLIOTem {
      display: -webkit-flex;
      
    }
    .PORTFOLIO {
      -webkit-flex: 1;
      flex: 1;
      text-align: center;
      -webkit-align-items: center;
      align-items: center;
      -webkit-justify-content: center;
      justify-content: center;
      padding-top: 20%;
      text-align: center;
    }
    .PORTFOLIO_FIRST_IMG {
      max-width: 300px;
      display : inline;
    }

    /* resumeTemBox6 */
    #resumeTemBox6 {
      background: #B993D6;
      background: -webkit-linear-gradient(to right, #8CA6DB, #B993D6);
      background: linear-gradient(to right, #8CA6DB, #B993D6);
      height: 100%;
    }
    #resumeTemBox6 h1 {
      padding-top: 140px;
      font-family: "Apple SD Gothic Neo", sans-serif;
      font-weight: 700;
      font-size: 64px;
      line-height: 1.5;
      color: white;
      text-align: center;
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
    
      <div id="resumeTemBox1">
        <img id="INTRODUCTION_IMG_PATH" src="${resume.intro_dto.introduction_img_path}" width="556px" height="742px" alt="">
        <div id="INTRODUCTION_HEADER">
          <h1>${resume.intro_dto.introduction_header}</h1>
        </div>  
        <div id="INTRODUCTION_MAIN">
        <p>	${resume.intro_dto.introduction_main} </p>
        
        </div>
      </div>


      <!--ë©ì¸ 2íì´ì§-->
      <div id="resumeTemBox2">

			<div class="SKIL_SET">
				<c:forEach var="i" items="${resume.skill_dto.makeSkillSetList()}">
				<div class="SKIL_SET_BOX">
					<img class="SKIL_SET_BOX_img" src="${i}" alt="">
				</div>
				</c:forEach>
			</div>
		</div>

      <div id="resumeTemBox3">
        <h1><span>My Self</span></h1>
        <div class="tmicontainer">
          <div class="tmilist">
            <p id="tmi1">이름 : ${resume.user.name} </p>     
            <p id="tmi2">전화번호 : ${resume.user.contact_num}</p>
            <p id="tmi3">메일 : ${resume.user.email}</p>
            <p id="tmi4">생일 : ${resume.user.birth}</p>
            <p id="tmi5">거주지 : ${resume.user.city}</p>
          </div>
        </div>
      </div>
      
      

      <!--ë©ì¸ 4íì´ì§-->
      <div id="resumeTemBox5">
      <div class="PORTFOLIOTem">
        <h1>PORTFOLIO</h1>        
		<c:if test="${!empty resume.portfolio_first_name&&resume.portfolio_first_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_first_img}" alt="" width="400px" height="300px">
            <a href="${resume.portfolio_first_github}" target=_blank>
            <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
			<p>${resume.portfolio_first_name }</p>
           <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_first_desc}</p>
          </div>
        </c:if>
		<c:if test="${!empty resume.portfolio_second_name&&resume.portfolio_second_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_second_img}" alt="" width="400px" height="300px">
            <a href="${resume.portfolio_second_github}" target=_blank>
            <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
			<p>${resume.portfolio_second_name }</p>
           <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_second_desc}</p>
          </div>
         </c:if>
		<c:if test="${!empty resume.portfolio_third_name&&resume.portfolio_third_name ne null}">
          <div class="PORTFOLIO">
            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_third_img}" alt="" width="400px" height="300px">
            <a href="${resume.portfolio_third_github}" target=_blank><p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
			<p>${resume.portfolio_third_name }</p>
           <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_third_desc}</p>
          </div>
         </c:if>
        </div>   
      </div>

      
      <!--ë©ì¸ 5íì´ì§-->
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
        <button class="btn btn-primary">뒤로가기</button>
      </div>
  </body>
</html>