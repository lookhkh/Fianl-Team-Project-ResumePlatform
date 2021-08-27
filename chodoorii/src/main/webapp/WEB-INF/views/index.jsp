<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="./header/header.jsp"></jsp:include>
<style>

	.row{
		border : 1px solid;
	}
</style>
<body>

	

    <div class="wrapper" style="height : 670px">


        <div class="row second" style="border-style:none; padding:0px">
            <div class="content">
              <div class="section">
                <input type="radio" name="slide" id="slide01" checked>
                <input type="radio" name="slide" id="slide02">
                <input type="radio" name="slide" id="slide03">
                <div class="slidewrap">
                  
                  <ul class="slidelist">
                    <!-- 슬라이드 영역 -->
                    <li class="slideitem">
                      <a>
                        <div class="textbox">
                          <h3>My Resueme</h3>
                          <p>다양한 템플릿으로 만드는 이력서</p>
                          <c:choose>
	   						 <c:when test="${userInfo.id eq null}">
	                          	<button type="button" class="signup btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	                            	시작하기
	                        	</button>
	                        </c:when>
                        <c:otherwise>
                          
                        </c:otherwise>
                       </c:choose>
                        
                        </div>
                        <img src="/publish/main/img/메인사진1.png">
                      </a>
                    </li>
                    <li class="slideitem">
                      <a>
                        
                        <div class="textbox">
                          <h3>링크 형태의 이력서</h3>
                          <p>이력서 공개여부 설정으로 더 많은 기회를</p>
                           <c:choose>
	   						 <c:when test="${userInfo.id eq null}">
	                          	<button type="button" class="signup btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	                            	시작하기
	                        	</button>
	                        </c:when>
                        <c:otherwise>
    
                        </c:otherwise>
                       </c:choose>
                        </div>
                        <img src="/publish/main/img/메인사진2.png">
                      </a>
                    </li>
                    <li class="slideitem">
                      <a>
                        
                        <div class="textbox3">
                          <h3>당신의 처음을 응원합니다.</h3>
                                  <c:choose>
	   						 <c:when test="${userInfo.id eq null}">
	                          	<button type="button" class="signup btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
	                            	시작하기
	                        	</button>
	                        </c:when>
                        <c:otherwise>
                           
                        </c:otherwise>
                       </c:choose>
                        </div>
                        <img src="/publish/main/img/메인사진3.png">
                      </a>
                    </li class="slideitem">
              
                    <!-- 좌,우 슬라이드 버튼 -->
                    <div class="slide-control">
                      <div>
                        <label for="slide03" class="left"></label>
                        <label for="slide02" class="right"></label>
                      </div>
                      <div>
                        <label for="slide01" class="left"></label>
                        <label for="slide03" class="right"></label>
                      </div>
                      <div>
                        <label for="slide02" class="left"></label>
                        <label for="slide01" class="right"></label>
                      </div>
                    </div>
              
                  </ul>
                  <!-- 페이징 -->
                  <ul class="slide-pagelist">
                    <li><label for="slide01"></label></li>
                    <li><label for="slide02"></label></li>
                    <li><label for="slide03"></label></li>
                  </ul>
                </div>
              </div>
            </div>

    </div>
           
    
	

        <!--공통 Footer-->

 
    <footer style="margin-top : 0px">
        <span>프로젝트 깃허브 주소 : <a href="https://github.com/lookhkh/project">깃허브</a> </span>
        <div class="contributor">
            <span>제작자 : 이홍섭   이미숙   조현일</span>
        </div>
    </footer>

        <!--공통 Footer-->

 
</body>
</html>
<script>
window.addEventListener('load',()=>{
    
	const query = new URL(location.href).searchParams

	if(query.get("error")){
		document.querySelector('.signup').click();
		
	}

	

	 
	  
    const lookupForm = document.querySelector('.id-lookup');
    const lookUpBtn = lookupForm.querySelector('button');
    const pwlookupForm = document.querySelector('.pw-lookupForm');
    const lookUpPwBtn = pwlookupForm.querySelector('button');

    lookUpBtn.addEventListener('click',(e)=>{
      const email = lookupForm.querySelector('input').value 
      const url = "/email/lookupid/"+email;
      alert("요청이 완료되었습니다");
      findUserIdByEmail(url).catch((result)=>alert(result));
    }

    )

    lookUpPwBtn.addEventListener('click',(e)=>{
      const email = pwlookupForm.querySelector('input[type="email"]').value 
      const id = pwlookupForm.querySelector('input[type="text"]').value
      const url = "/email/lookuppw?email="+email+"&id="+id;

	
      if(confirm("비밀번호를 찾으시겠습니까?")){
   		alert("요청이 완료되었습니다")
      findUserIdByEmail(url).catch(result=>alert(result));
      }else{
        alert("취소되었습니다.")
      }
})


    
    function findUserIdByEmail(url){
      return new Promise((resolve,reject)=>{
        const http = new XMLHttpRequest();
        http.open("GET",url);
        http.timeout=5000;
        http.send(null);


        http.onload=()=>{
          if(http.status===200){
            resolve(http.responseText);
          }else{
            reject(http.responseText)
          }
        }

        http.ontimeout=()=>{
          reject("현재 부하가 많습니다. 잠시 후에 다시 시도해주세요");
        }

      })
    }



  })
</script>



