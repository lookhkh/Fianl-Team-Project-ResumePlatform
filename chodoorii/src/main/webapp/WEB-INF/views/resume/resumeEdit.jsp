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

         
        .wrapper
        {    
          width: 100vw;
          height: 900px;
        }

    </style>
<body>



<div class="wrapper">
        <div class="row first">
            <h1>수정이 완료되면<br>꼭 수정완료 버튼을 클릭해주세요.</h1>
              <div class="resumeTem">
               <img src="/publish/resume/Img/sam.JPG" alt="템플릿1">
              </div>
             <div class="button">   
              <a href="./1ResumeList.html"><button type="button" class="signup btn btn-primary">
              수정완료
              </button></a>
             <a href="./1ResumeList.html"> <button type="button" class="signup btn btn-primary">
              취 소
              </button></a>
            </div>   
    </div>    
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


