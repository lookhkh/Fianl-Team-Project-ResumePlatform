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
          <dl>
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
          <c:otherwise>
        <div class="signupAndLogin">
           <button type="button" onclick="resumesubmission()">이력서 보내기</button>
            </div>        
           </div> 
         </div>
    </c:otherwise>
</c:choose>  
		

     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>
<script>
	function resumesubmission(){
		alert("이력서보내기 성공");
	}
</script>