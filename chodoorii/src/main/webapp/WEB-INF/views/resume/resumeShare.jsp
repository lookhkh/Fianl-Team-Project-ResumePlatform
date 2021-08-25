<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyResueme</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="/publish/main/css/index.css" rel="stylesheet">
    <link href="/publish/main/css/header.css" rel="stylesheet">
    <link href="/publish/main/css/footer.css" rel="stylesheet">    
    <script src="/publish/main/js/index.js" ></script>
    <script src="/publish/main/js/dropdown.js"></script>
    <script src="/publish/main/js/LoginFormDetection.js"></script>

    <style>

     
    </style>
</head>
<jsp:include page="../header/header.jsp"></jsp:include>
<body>
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
            <div class="content">
              
            
              <div class="ResuemeShare">
                <img src="/publish/resume/Img/메일.JPG" alt="이메일로공유" onclick>
                <p>이메일로 공유하기<br>
                  웹사이트링크 형태로 간단하게 이메일 보내기가 가능합니다.</p>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#shareModal" data-bs-whatever="@mdo">공유하기</button>
<button type="button" class="btn btn-primary" onclick="history.go(-1)">목록으로</button>

                  
              </div>  
              <div class="button">   
             
                	
              </div>      
            </div>
            
    </div>

     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

<div class="modal fade" id="shareModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="height : 500px">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">공유하기</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form style="width:500px" method="post" action="/resume/share/mail">
      <div class="  modal-body">
            <div class="mb-3">
            <label for="recipient-name" class="col-form-label">받으시는 분 메일</label>
            <input type="text" class="form-control" id="recipient-name" name="to">
          </div>
          <div class="mb-3">
            <label for="message-text" class="col-form-label">소개</label>
            <input class="form-control" id="message-text" name="what"></input>
          </div>
		
          <div class="modal-footer" style="margin-top : 50px">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            <input type="submit" class="btn btn-primary" value="Send message"/>
          </div>
      </div>
      </form>
     
    </div>
  </div>
</div>

 
</body>
</html>
<script>
	window.addEventListener('load',function(){
		
		const removeBtn = document.querySelector("input[value='삭제']");
		removeBtn.onclick=()=>{
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href="/resume/remove";
				alert("성공적으로 삭제하였습니다")

			}
		}
		


	});
</script>

