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

	<input id="director" type="hidden" value="${director}">

    
		
        <div class="wrapper">
          <div class="row first">
            <div class="resumebox">
                <div class="resumeUp" style="float:center;"  >
                   <button type="button" class="btn btn-primary" style="height: 100px; width: 300px; font-size:40px; margin-top: -10%;" onclick="location.href='/resume/display'">이력서 보기</button>
                </div>
                <div class="resumeTotal" style="padding-top: 20px;">
                  <div class="resumeEdit" style="display: inline;">
                    <input type="button" class="btn btn-primary" value="수정" onclick="location.href='/resume/edit'">
                  </div>
                  <div class="resumeDelete" style="display: inline;">
                  <input type="button"  class="btn btn-primary" value="삭제">
                   </div>
                   <div class="resumeShare" style="display: inline;">
                    <input type="button" class="btn btn-primary" value="공유" onclick="location.href='/resume/share'">
                    </div>
                  </div>     
        </div>
    </div>
    </div>


     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
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
				
		const director = document.querySelector('#director').value
	
			if(director === "register"){
				alert("등록이 완료되었습니다");
			}else if(director === "share"){
				alert("이력서 공유를 완료하였습니다")
			}else if(director=== "edit"){
				alert("이력서 수정을 완료하였습니다");
			}
	});
</script>

