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
    <link href="/publish/main/css/signupSort.css" rel="stylesheet">
    <title>회원가입</title>
</head>
<body>
    <div class="wrapper">

        <div class="content">

            <div class="progressWhere">
                <span data-target="sort" ><img src="/publish/main/img/2025986.svg"  width="30px" height="10px" alt=" ">회원유형선택</span>
                <span data-target="required"><img src="/publish/main/img/2025986.svg" style="visibility: hidden;" width="30px" height="10px" alt=" ">필수정보입력</span>
                <span data-target="metadata"><img src="/publish/main/img/2025986.svg" style="visibility: hidden;" width="30px" height="10px" alt=" ">메타정보입력</span>
            </div>

                <div class="form sort show ">

                    <button  class="choice btn btn-primary" >일반회원</button>
                    <button  class="choice btn btn-primary" >기업회원</button>
                    <input type="hidden" name="sort"/>

                </div>
                <div class="actions">
                    <button class="next btn btn-primary">다음으로</button>
                    <button class="back btn btn-primary">메인으로</button>
                </div>
        
        </div>
       
    

    </div>
    
</body>
</html>
<script>
    window.addEventListener('load',function(){
        let form = document.querySelector('.show');
        const formBtn = form.querySelectorAll('button')
        const actionBtn = document.querySelector('.actions');
        const sortValue = document.querySelector('input[name="sort"]');

        actionBtn.addEventListener('click',function(e){
            if(e.target.nodeName!=="BUTTON") return;
            
            let btn = e.target;


            if(btn.textContent==="다음으로"){


                    if(sortValue.value==="기업회원"){
                        location.href="/signup/corporate"

                    }else{
                        location.href="/signup/individual";
                    }

               
                }else{
                    location.href="/"
            }
        })


        form.addEventListener('click',function(e){
            if(e.target.nodeName!=="BUTTON") return;
            e.preventDefault();

            
            e.target.classList.add('selected');

            formBtn.forEach(a=>{
                if(a!==e.target&&a.classList.contains('selected')){
                    a.classList.remove('selected')
                }
            })

            const input = form.querySelector('input');
            input.value = e.target.textContent

            
        })


    })

</script>
</html>




