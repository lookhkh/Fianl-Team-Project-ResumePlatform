<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../header/header.jsp"></jsp:include>
  <style>

      *{
        text-align: center;
      }    
      
      .wrapper{    
          width: 100vw;
          height: 900px;
        }
    </style>
<body>



    
		
    <div class="wrapper">
        <div class="row first">
                <div class="resumebox">
                    <h2>등록된 이력서 목록입니다.</h2><br>
                    <img src="/publish/resume/img/sam.JPG" alt="등록된 이력서" height="400px" width="300px">
                       <P class="title">개발자를 꿈꾸는 나를 소개합니다.
                       <br>
                        전공 : OO <br>
                        학과 : oo <br>
                        개발을 시작한 이유 : oo <br>
                        실제 프로젝트 수행한 경험 등 <br>
                       <br>
                       <button type="button" class="signup btn btn-primary" style="margin-top: 10px;" onclick="location.href='./6ResumeEdit.html'">
                        수정
                       </button>
                       <button type="button" class="signup btn btn-primary" style="margin-top: 10px;"> <!--삭제하시겠습니까? 화면 뜨고 삭제-->
                        삭제
                       </button>
                       <button type="button" class="signup btn btn-primary" style="margin-top: 10px;" onclick="location.href='./8ResumeShare.html'">
                        공유
                       </button>
                       </P> 
            </div>
        </div>
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


