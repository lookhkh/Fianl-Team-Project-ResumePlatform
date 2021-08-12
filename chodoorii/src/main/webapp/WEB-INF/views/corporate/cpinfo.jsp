<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="/publish/corporate/css/basic.css" rel="stylesheet">
<jsp:include page="../header/header.jsp"></jsp:include>


<body>



 <div class="list-wrap">
      <h2>회사 목록</h2>
       <div class="btn-list">
        <a href="">등록하기</a>
      </div>
        <ul>  
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>${dto.userName}</strong>
                <p>${dto.welare_first}
                	${dto.welare_second}
                	${dto.welare_third}
                </p>
                <a href="/corporate/detail">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
          <li class="photo">
            <img src="/publish/corporate/img/자연.jpg" alt="">
              <div class="co-info">
                <strong>회사명</strong>
                <p>복지</p>
                <a href="">바로가기</a>
              </div>
          </li>
        </ul>
        <ol class="paging">
      <li><a href="#"><<</a></li>
      <li><a href="#"><</a></li>
      <li><a href="#">1</a></li>
      <li><a href="#">2</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">4</a></li>
      <li><a href="#">5</a></li>
      <li><a href="#">></a></li>
      <li><a href="#">>></a></li>
    </ol>
    </div>    
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


