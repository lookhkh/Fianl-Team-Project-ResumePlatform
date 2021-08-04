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
        
        div.resumeBox img{
              width: 150px;
              height: 150px;
        }


    </style>
<body>



    <div class="wrapper">
        <div class="row first">
             <div class="resumeBox">
              <h2>선택한 템플릿의 이력서를 작성해보세요.</h2>
               <img src="/publish/resume/img/sam.JPG" alt="이력서 작성">
              </div>
             <div class="button">   
              <button type="button" class="signup btn btn-primary">
              이전으로
              </button>
              <button type="button" class="signup btn btn-primary">
              저장하기
              </button>
              <button type="button" class="signup btn btn-primary">
              선택완료
              </button>
            </div>
        </div>
    </div>


    
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


