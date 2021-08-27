<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <link href="/publish/corporate/css/basic.css" rel="stylesheet">
    
<jsp:include page="../header/header.jsp"></jsp:include>

<body>



 <div class="Detail-info">
      <div class="Summary">
        <div class="content">
          <dl>
 
            <h1><Strong>${detail.companayName}</Strong></h1>
          </dl>
          <dl>
            <dt>평균연봉</dt>
            <dd>${detail.salary}</dd>
          </dl>
          <dl>
            <dt>종업원 수</dt>
            <dd>${detail.staff_number}</dd>
          </dl>
          <dl>
            <dt>복지</dt>
            
            <dd class="rest">
              <c:forEach var="item" items="${welfare}">
                 <div>
                 <img src="/publish/corporate/img/${item}.jpg" alt="">
                 <p>${item}</p>
                 </div>
              </c:forEach>
            </dd>
          </dl>
        </div>
          <div class="co-img">
            <img src="${detail.logo_img }" width="500px" height="500px" alt="자연">
          </div>
        </div>
        <div class="SI">
          <div class="content">
          <dl style="position : absolute; top : 660px; left : 205px">
            <dt>Summary</dt>
            <dd>
               ${detail.summary}
            </dd>
          </dl>
          </div>
        </div>
        <div class="SI-btn">
		      <c:choose>
		         <c:when test="${userInfo.id eq null}">
		             <div class="signupAndLogin">
			            <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
			                이력서보내기
			             </button>        
		             </div>    
		          </c:when>
		          
		          <c:when test="${userInfo.id eq detail.userid.id}">
		             <div class="signupAndLogin">
			            <button type="button" onclick="location.href='/corporate/update/${detail.info_id}'">
			                수정하기
			             </button>        
		          	</div>    
		          </c:when>
		          
			          <c:when test="${userInfo.sort eq 1}">
				      </c:when>
			         
		          <c:otherwise>
		        		<div class="signupAndLogin">
		           			<button type="button" data-bs-toggle="modal" data-bs-target="#shareModal" data-bs-whatever="@mdo">공유하기</button>
		            	</div>        
		    	</c:otherwise>
			</c:choose>
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

	const loginForm = document.querySelector("#loginForm");                    
    const presentPath = location.pathname;

    loginForm.action = "/login?type=loginRedirect&redirect="+presentPath;
    
});
</script>