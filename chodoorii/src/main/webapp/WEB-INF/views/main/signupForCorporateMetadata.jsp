<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="/publish/main/css/signupRequired.css" rel="stylesheet">    

    <title>회원가입</title>
    
</head>
<body>
    <div class="wrapper">

        <div class="content">

            <div class="progressWhere">
                <span data-target="sort" ><img src="/publish/main/img/2025986.svg" style="visibility:hidden ;" width="30px" height="10px" alt="">회원유형선택</span>
                <span data-target="required"><img src="/publish/main/img/2025986.svg"  style="visibility: hidden;" width="30px" height="10px" alt="">필수정보입력</span>
                <span data-target="metadata"><img src="/publish/main/img/2025986.svg"  width="30px" height="10px" alt="">메타정보입력</span>
            </div>

                <div class="form sort show ">

                <form method="POST" action="/signup/corporate/metadata">
                    <input data-target="id" type="hidden" name="id" value="${userId}">
                  
                    <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button">사업자번호</button>
                        <input type="text" name="bussinessNum" class="form-control" placeholder="사업자 번호를 입력해주세요" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      </div>

                      <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button">주소</button>
                        <input type="text" name="address" class="form-control" placeholder="상세주소를 입력해주세요" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      </div>

                      <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button">담당자 이름</button>
                        <input type="text" class="form-control" name="managerName" placeholder="담당자 이름을 입력해주세요" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      
                    </div> 
                
                      <div class="input-group mb-3">
                        <button class="btn btn-outline-secondary" type="button">담당자 연락처</button>
                        <input type="email" name="managerContactNum" class="form-control" placeholder="담당자 연락처를 입력해주세요" aria-label="Example text with button addon" aria-describedby="button-addon1">
                      </div>

                      <div class="seperator" style="border-bottom: 1px solid; margin-top: 50px; margin-bottom: 40px;"></div>
               
                </form>

                </div>

    
                <div class="actions">
                    <button class="next btn btn-primary">다음으로</button>
                    <button class="back btn btn-primary" >이전으로</button>
                </div>
        
    </div>
      

    </div>
    
</body>
</html>
<script>
   window.addEventListener('load',function(){
        const actionBtn = document.querySelector('.actions');

        actionBtn.addEventListener('click',function(e){
            if(e.target.nodeName!=="BUTTON") return;
            

                const form = document.querySelector('form');

                if(e.target.textContent ==="다음으로"){
                document.querySelector('form').submit();
                }
            })

    })
</script>