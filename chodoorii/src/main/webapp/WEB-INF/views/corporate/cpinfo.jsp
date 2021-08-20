<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="/publish/corporate/css/basic.css" rel="stylesheet">
<jsp:include page="../header/header.jsp"></jsp:include>
<style>
	.selected{
		color : red;
	}
</style>

<body>


 <div class="list-wrap">
      <h2>회사 목록</h2>
       <c:choose>
       <c:when test="${userInfo.sort eq 1}">
       <div class="btn-list">
        <a href="/corporate/register">등록하기</a>
        </div>
      </c:when>
      <c:otherwise>
      </c:otherwise>
      </c:choose>
      

        <ul>  
        	<c:forEach var="item" items="${pageable.getContent()}">
	          <li class="photo">
	            <img src="${item.logo_img}" alt="">
	              <div class="co-info">
	                <strong>${item.companayName}</strong>
	                	<p>${item.welfare.welfare_first} ${item.welfare.welfare_second ==""?"":item.welfare.welfare_second}
	                	 ${item.welfare.welfare_third} ${item.welfare.welfare_forth}</p>
	          		
	                <a href="/corporate/detail/${item.info_id}">바로가기</a>
	              </div>
	          </li>
	         </c:forEach>
        </ul>
        <ol class="paging">
  
         <li><a href="/corporate/cpinfo?page=0"><<</a></li>
    	 <c:if test="${pageable.hasPrevious()}"><li><a href="#"><</a></li></c:if>
     
     <c:forEach var="i" begin="1" end="${pageable.getTotalPages()}">

     	      	<li><a class="${(i-1)==pageable.getPageable().getPageNumber()?'selected':''}" href="/corporate/cpinfo?page=${i-1}">${i}</a></li>
	     
     </c:forEach>
     
	     <c:if test="${pageable.hasNext()}"><li><a href="#">></a></li></c:if>
		 <li><a href="/corporate/cpinfo?page="${pageable.getTotalPages()}">>></a></li>

    
    </ol>
    </div>    
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


