<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="/publish/main/js/emailSendService.js"></script>
    <script src="/publish/main/js/idCheckforduplicate.js"></script>
    <link href="/publish/main/css/signupRequired.css" rel="stylesheet">    
    <script src="/publish/main/js/imgChange.js"></script>

    <title>회원가입</title>
    
</head>
<body>
    <div class="wrapper">

        <div class="content">

            <div class="progressWhere">
                <span data-target="sort" ><img src="/publish/main/img/2025986.svg" style="visibility:hidden ;" width="30px" height="10px" alt="">회원유형선택</span>
                <span data-target="required"><img src="/publish/main/img/2025986.svg"  width="30px" height="10px" alt="">필수정보입력</span>
                <span data-target="metadata"><img src="/publish/main/img/2025986.svg" style="visibility: hidden;" width="30px" height="10px" alt="">메타정보입력</span>
            </div>

                <div class="form sort show ">

                <form method="POST" enctype="multipart/form-data" action="http://localhost:8088/signup?sort=0">
                     <div class="input-group" style="display: flex; flex-direction: row;">
                        <img src="/publish/main/defaultpic.png" class="img-thumbnail userpic" alt="..." width="150px" height="80px">
                        <input style="display: none;" name="file" type="file" class="form-control" id="inputGroupFile04" height="50px" aria-describedby="inputGroupFileAddon04" aria-label="Upload">  
                        <button style="width: 170px;" class="uploadbtn btn btn-primary" type="button">프로필 사진 업로드</button>
                    </div>

                    <div class="input-group mb-3">
                        <input data-target="required" type="text" class="form-control" minlength="5" placeholder="ID를 입력해주세요" name="id" aria-label="Example text with button addon" aria-describedby="button-addon1">
                        <input type="hidden" id="id-duplicate-check-flag" value=0/>
                        <button class="idcheck btn btn-outline-secondary" type="button" id="button-addon1">중복확인</button>
                    </div>

                    <div class="input-group mb-3">
                        <input data-target="required"  type="text" class="form-control" placeholder="이름을 입력해주세요" name="name" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>

                    <div class="password-set">
                      <div class="input-group mb-3">
                        <input data-target="required"  type="text" class="form-control" placeholder="패스워드를 입력해주세요" aria-label="Username" aria-describedby="basic-addon1" name="pw">
                      </div>
                      <div class="input-group mb-3">
                        <input data-target="required"  type="text" class="form-control" placeholder="패스워드를 확인해주세요" aria-label="Username" aria-describedby="basic-addon1" name="confirmedPw">
                      </div>
                    </div>

                      <div class="email-auth">
                        <div class="input-group mb-3">
                            <input data-target="required"  type="email" class="form-control" placeholder="이메일을 입력해주세요" name="email" aria-label="Example text with button addon" aria-describedby="button-addon1">
                            <button class="emailAuth btn btn-outline-secondary" type="button" id="button-addon1">인증하기</button>    
                        </div>
                        <div style="display: none;" class="emailCheck input-group mb-3">
                            <input data-target="required"  type="email" class="form-control" placeholder="인증번호를 입력해주세요"  aria-label="Example text with button addon" aria-describedby="button-addon1">
                            <button class="emailAuthCheck btn btn-outline-secondary " type="button" id="button-addon1">확인하기</button> 
                            <input class="authResult" type="hidden" value="0">
                        </div>
                    </div>     
                    <div class="input-group mb-3">
                        <input data-target="required"  type="tel" class="form-control" placeholder="전화번호를 입력해주세요(-제외)" name="contactInfo" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <input data-target="required"  type="text" class="form-control" placeholder="사는 지역을 입력해주세요(ex 서울)" name="address" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <input data-target="required"  type="text" class="form-control" placeholder="생년월일을 입력해주세요(ex 92년 5월)" name="birth" aria-label="Example text with button addon" aria-describedby="button-addon1">
                    </div>
                    
                    <input type="hidden" class="check" value="0" />
              
                    
                
                      
                      <div style="visibility: hidden;" class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Username" aria-label="Username">
                        <span class="input-group-text">@</span>
                        <input type="text" class="form-control" placeholder="Server" aria-label="Server">
                      </div>
                      
                      <div style="display: none; margin-bottom: 0px;" class="input-group">
                        <span class="input-group-text">With textarea</span>
                        <textarea class="form-control" aria-label="With textarea"></textarea>
                      </div>
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
        const inputGroups = document.querySelectorAll('input');
        let array= Array.from(inputGroups)
        array = array.filter((a)=>a.dataset.target);
        const check = document.querySelector('input[class="check"]')

        console.log(check)

        actionBtn.addEventListener('click',function(e){
            if(e.target.nodeName!=="BUTTON") return;
            
            let btn = e.target;

            if(btn.textContent==="다음으로"){
                
                for(let i=0; i<array.length; i++){
                    if(array[i].value===''){
                        array[i].classList.add('required');
                        check.value=1;
                    }else{
                        array[i].classList.remove('required');
                    }
                }

                if(check.value==='0'){
                    console.log(document.querySelector('form'))
                    check.value=0;

                    document.querySelector('form').submit();
                }

                

            

            }else{
                location.href="./signupSort.html"
            }
        })


     
        
      
     

    })
</script>

