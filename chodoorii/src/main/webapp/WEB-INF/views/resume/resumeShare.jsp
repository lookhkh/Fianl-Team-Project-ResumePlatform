<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../header/header.jsp"></jsp:include>
 <style>

        *{
          margin: 5;
          box-sizing: border-box;
          text-align: center;
        }

        .wrapper{    
          width: 100vw;
          height: 900px;
        }

         
        .ResuemeShare{
                    display: inline-block;
                    
        }
        
        div.ResuemeShare img{
              width: 100px;
              height: 100px;
        }
      

     
    </style>
<body>



 <div class="wrapper">
        <div class="row first">
           <h1>이력서 공유하기</h1>
           <p>내가 작성한 이력서를 카카오톡이나 이메일을 통해 공유가 가능합니다.</p>>
            <div class="content">
              
              <div class="ResuemeShare">
                <img src="/publish/resume/Img/카카오톡.JPG" alt="카톡으로공유">
                <p>카카오톡으로 공유하기<br>
                   웹사이트링크+비밀번호 형태로 간단하게 카톡 공유가 가능합니다.</p>
              </div>
              <br><br>
              <div class="ResuemeShare">
                <img src="/publish/resume/Img/메일.JPG" alt="이메일로공유">
                <p>이메일로 공유하기<br>
                  웹사이트링크+비밀번호 형태로 간단하게 이메일 보내기가 가능합니다.</p>
              </div>  
              <div class="button">   
                <button type="button" class="signup btn btn-primary" onclick="location.href='./1ResumeList.html'">
                이력서 목록
                </button>
                
              </div>      
            </div>
            
    </div>
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


