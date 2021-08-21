<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/publish/corporate/css/basic.css" rel="stylesheet">

<jsp:include page="../header/header.jsp"></jsp:include>

<body>



	<div class="ResuemeBoard">
		<div class="resueme">
			<c:forEach var="dto" items="${dto.getContent()}">
				<div class="one">
					<c:choose>
						<c:when test="${empty dto.user.imgPath}">
						<!-- style="height: 130px;"width="130px" -->
							<img src="#">
						</c:when>
						<c:otherwise>
							<img src="${dto.user.imgPath}" style="height: 130px;"
								width="130px">
						</c:otherwise>
					</c:choose>
					<div class="info">
						<span style="font-size: 20px;">${dto.user.name}</span><br>
						<h3>${dto.intro_dto.introduction_header}</h3>
					</div>
					<div class="btn-res">
						<button type="button" class="btn btn-primary"
							onclick="location.href='/resume/display/${dto.id}'">열람하기</button>
					</div>
				</div>
			</c:forEach>
		</div>
		<ol class="paging">
			
			<li><a href="/resume/lists?page=0"><<</a></li>
			<c:if test="${dto.hasPrevious()}"><li><a href="#"><</a></li></c:if>
			
			  <c:forEach var="i" begin="1" end="${dto.getTotalPages()}">

     	      	<li><a class="${(i-1)==dto.getPageable().getPageNumber()?'selected':''}" href="/resume/lists?page=${i-1}">${i}</a></li>
	     
    		 </c:forEach>
			<c:if test="${dto.hasNext()}"><li><a href="#">></a></li></c:if>
			<li><a href="/corporate/resume?page='${dto.getTotalPages()}'">>></a></li>
		</ol>
	</div>









	<jsp:include page="../header/footer.jsp"></jsp:include>


</body>
</html>


