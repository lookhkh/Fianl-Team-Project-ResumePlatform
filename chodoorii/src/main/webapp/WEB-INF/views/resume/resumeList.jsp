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
          
          background-image: url('/publish/resume/img/이력서등록하기.png');
          background-position: center;
          background-repeat: no-repeat;
        }
    </style>
<body>



    
		
        <div class="wrapper">
          <div class="row first">
            <div class="resumebox">
                <div class="resumeUp" style="float:center;"  >
                   <input type="button" class="btn btn-primary" style="height: 100px; width: 300px; font-size:40px; margin-top: -10%;" value="이력서 보기">
                </div>
                <div class="resumeTotal" style="padding-top: 20px;">
                  <div class="resumeEdit" style="display: inline;">
                    <input type="button" class="btn btn-primary" value="수정">
                  </div>
                  <div class="resumeDelete" style="display: inline;">
                  <input type="button"  class="btn btn-primary" value="삭제">
                   </div>
                   <div class="resumeShare" style="display: inline;">
                    <input type="button" class="btn btn-primary" value="공유">
                    </div>
                  </div>     
        </div>
    </div>


     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


