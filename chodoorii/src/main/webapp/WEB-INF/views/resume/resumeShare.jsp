<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
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
                <a href="/share/mail"><img src="/publish/resume/Img/메일.JPG" alt="이메일로공유"></a>
                <p> <div classs="hiddenmodal">
<a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">이메일로 공유하기</a>
            <br>
                  웹사이트링크+비밀번호 형태로 간단하게 이메일 보내기가 가능합니다.</p>
              </div>  
              <div class="button">   
                <button type="button" class="signup btn btn-primary" onclick="location.href='/resume'">
                이력서 목록
                </button>
                
              </div>      
            </div>
            
    </div>
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

<form method="POST" action="/resume/share/mail">
 <div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
		받으시는 분 : <input name="to" placeholder="받으시는 분의 메일주소를 작성해주세요">
		<br/>
		간단한 소개 문구를 작성해주세요 : <input name="what" placeholder="이력서를 소개해주세요">
		
      </div>
      <div class="modal-footer">
		<input class="btn btn-primary" type="submit" value="공유하기"/>
      </div>
    </div>
  </div>
</div>
</form>

</body>
</html>


