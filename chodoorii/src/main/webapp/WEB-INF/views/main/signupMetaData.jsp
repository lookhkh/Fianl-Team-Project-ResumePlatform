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
    <title>회원가입</title>
    <link href="/publish/main/css/signupMetaData.css" rel="stylesheet">
</head>
<body>
    <div class="wrapper">

        <div class="content">

            <div class="progressWhere">
                <span data-target="sort" ><img src="/publish/main/img/2025986.svg" style="visibility:hidden ;" width="30px" height="10px" alt="">회원유형선택</span>
                <span data-target="required"><img src="/publish/main/img/2025986.svg"  width="30px" height="10px" alt="">필수정보입력</span>
                <span data-target="metadata"><img src="/publish/main/img/2025986.svg" style="visibility: hidden;" width="30px" height="10px" alt="">메타정보입력</span>
            </div>

            <form method="post" action="http://localhost:8088/signup/users/metadata">

                <div class="form metadata show ">

                    <input data-target="userid" type="hidden" name="userId">
                    
                    <div class="valuepicker row position">
                        <h2>포지션 구분</h2>
                        <div class='col'>
                            <button class="position btn btn-primary">백엔드</button>
                            <input  class="hidden-value position" type="hidden"  >
                        </div>
                        <div class='col'>
                            <div class='col'>
                                <button class="position btn btn-primary">프론트엔드</button>
                                <input  class="hidden-value position" type="hidden" >
                            </div>
                        </div>
                        <div class='col'>
                            <div class='col'>
                                <button class="position btn btn-primary">DBA</button>
                                <input  class="hidden-value position" type="hidden"  >
                            </div>
                        </div>
                        <div class='col'>
                            <div class='col'>
                                <button class="position btn btn-primary">퍼블리셔</button>
                                <input  class="hidden-value position" type="hidden" >
                            </div>
                        </div>
                        <div class='col'>
                            <div class='col'>
                                <button class="position btn btn-primary">풀스택</button>
                                <input  class="hidden-value position" type="hidden"  >
                            </div>
                        </div>
                    </div>

                    <div class="row skil-stack">
                        <div class="col checkBox language-range">
                            <h2>프로그래밍 언어<span>(최대 3개)</span></h2>
                            자바<input type="checkbox" name="language" value="java">
                            파이썬<input type="checkbox" name="language" value="python">
                            C#<input type="checkbox" name="language" value="c#">
                            자바스크립트<input type="checkbox" name="language" value="javascript">
                            HTML<input type="checkbox" name="language" value="html">
                            CSS<input type="checkbox" name="language" value="css">
                            루비<input type="checkbox" name="language" value="ruby">
                        </div>

                        <div class="col checkBox framework-range">
                            <h2>프레임워크<span>(최대 3개)</span></h2>
                            스프링<input type="checkbox" name="framework" value="spring">
                            express<input type="checkbox" name="framework" value="express">
                            장고<input type="checkbox" name="framework" value="django">
                            flask<input type="checkbox" name="framework" value="flask">
                            Ruby On Rails<input type="checkbox" name="framework" value="rubyonrails">
                            .NET<input type="checkbox" name="framework" value="net">
                        </div>

                        <div class="col checkBox db-range">
                            <h2>DB<span>(최대 3개)</span></h2>
                            오라클<input type="checkbox" name="db" value="oracle">
                            MySql<input type="checkbox" name="db" value="mysql">
                            Postgress<input type="checkbox" name="db" value="postgress">
                            Maria<input type="checkbox" name="db" value="maria">
                        </div>
                    </div>

                    <div class="valuepicker row carrer">
                        <div class="col carrer-choice">
                            <h2>경력사항 선택</h2>
                                <button style="width: 40%;" class="btn btn-primary veteran" onclick="{document.querySelector('.col.range').classList.add('show');}">경력</button>
                                <button style="width: 40%;" class="btn btn-primary rookie" onclick="{if(document.querySelector('.col.range').classList.contains('show')) document.querySelector('.col.range').classList.remove('show')  }">신입</button>
                                <input  class="hidden-value carrer" type="hidden" name="exp" >
                            </div>


                        <br/>
                        <div class="col range">
                            <button class="btn btn-primary">0~1년</button>
                            <button class="btn btn-primary">1~3년</button>
                            <button class="btn btn-primary">4~7년</button>
                            <button class="btn btn-primary">7~10년</button>
                            <button class="btn btn-primary">10년 이상</button>
                            <input  class="hidden-value carrer period" type="hidden" name="period" >

                        </div>

                    </div>
                    

                </div>

            </form>

    
                <div class="actions">
                    <button class="next btn btn-primary" >다음으로</button>
                    <button class="back btn btn-primary" onclick="location.href='index.html'">메인으로</button>
                </div>
        
    </div>
      

    </div>
    
</body>
</html>
<script>
    window.addEventListener('load',function(){

        const nextBtn = document.querySelector('.next');
        nextBtn.onclick=()=>{
            const form = document.querySelector('form');
            form.submit();
        }
    

      const allButton = document.querySelector('.form.metadata.show');
      let carrerBtn = document.querySelector('.carrer-choice');
      let range = document.querySelector('.col.range');
      let languageRange = document.querySelector('.language-range');
      let frameworkRange = document.querySelector('.framework-range');
      let dbRange = document.querySelector('.db-range');
    


        languageRange.addEventListener('click',function(e){
            return countCheckboxLength(e,"language-range","language");
        });

        frameworkRange.addEventListener('click',function(e){
            return countCheckboxLength(e,"framework-range","framework");
        })

        dbRange.addEventListener('click',function(e){
            return countCheckboxLength(e,"db-range","db");
        })



        function countCheckboxLength(e,name,subname){
          let target = e.target;
          if(target.nodeName!=="INPUT") return;

          let targets = document.querySelector(`.${name}`).querySelectorAll(`input[name=${subname}]`);
          let counts = Array.from(targets).filter(a=>a.checked===true).length;

          if(counts>3){
              alert("최대 3개만 선택 가능합니다");
              e.target.checked=false;
              return;
          
          }  }



      

      carrerBtn.addEventListener('click',function(e){
          let target = e.target;
          const btns = carrerBtn.querySelectorAll('button');
          if(target.nodeName!=='BUTTON') return;

                range.addEventListener('click',function(e){
                const target = e.target;
                let allBtn = range.querySelectorAll('button');
                if(target.nodeName!=='BUTTON') return;

                allBtn.forEach(a=>{
                    if(a!==target){
                        if(a.classList.contains('selected')){
                            a.classList.remove('selected')
                        }
                    }
                })

                    })

          if(target.classList.contains('veteran')){


            if(btns[1].classList.contains('selected')) {
                btns[1].classList.remove('selected')}
            }else{
                if(btns[0].classList.contains('selected')){
                    btns[0].classList.remove('selected');
                   
                }
            }

            

      })

 

    allButton.addEventListener('click',function(e){

        let target = e.target;
        if(e.target.nodeName==="BUTTON"){
            e.preventDefault();

            target.classList.toggle('selected')
        }

        
    })


      
       
//리팩토링 필요//////////////////////////// 우선 임시로 이대로 진행

    let position_row = document.querySelectorAll('.valuepicker')

    position_row[1].addEventListener('click',function(e){

        console.log(position_row)

        const target = e.target;

        if(target.nodeName!=="BUTTON") return;
        const input_=target.parentNode.lastElementChild;

        if(!target.classList.contains('selected')){
        input_.setAttribute("value",target.textContent) 
        
        }
        
        else{
            input_.removeAttribute("value");
    }
  
    })

    position_row[0].addEventListener('click',function(e){

        console.log(position_row)

        const target = e.target;

        if(target.nodeName!=="BUTTON") return;
        const input_=target.parentNode.lastElementChild;

        if(!target.classList.contains('selected')){
        input_.setAttribute("value",target.textContent) 
        input_.setAttribute("name","position") 

        }

        else{
            input_.removeAttribute("value");

            input_.removeAttribute("name");
        }

        })

//리팩토링 필요//////////////////////////// 우선 임시로 이대로 진행




      
    })

