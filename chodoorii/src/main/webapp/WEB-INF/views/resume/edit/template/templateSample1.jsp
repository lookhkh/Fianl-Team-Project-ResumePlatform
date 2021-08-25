	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<jsp:include page="./templateHeaderForEdit.jsp"></jsp:include>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
    <style>
        input{
    background-color: transparent;
    border: 0px solid;
    height: 20px;
    width: 160px;
    color:black;
        }

        *{
            margin: 0;
            padding: 0;
            font-family: fantasy
        }

        textarea {
    border: none;
    overflow: auto;
    outline: none;

    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;

    resize: none; /*remove the resize handle on the bottom right*/
}

        .wrapper{
            width: 99vw;
            height: 110vh;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        section{
            width: 100%;
            height: 100%;
            position: absolute;
            opacity: 1;
            z-index: 1;
            transition: 0.8s;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #F3F3F3;
        }

        section.hidden{
            opacity: 0;
            z-index: 100;
            visibility: hidden;
        }

        .intro img{
            width: 450px; 
            height: 450px; 
            border-radius: 300px;
            position: absolute;
            left: 500px;
            top: 240px;
        }

        .jump-btn{
            position: absolute;
            top: 50px;
            left: 780px;
        }

        .btn{
            width: 120px;
        }

        .btn.selected{
            background-color: rosybrown;
        }

        .self-desciption{
            position: absolute;
            left: 1060px;
            top: 310px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            
        }

        header{
            width: 100%;
            height: 30px;
            position: absolute;
            z-index: 2;
            left: 27px;
            display: flex;
            flex-direction: row;
        }

        header h4{
            margin: 0;
            margin-left: 10px;
            margin-right: 10px;
        }


        footer{
            width: 100%;
            height: 90px;
            border-top: 1px solid;
            top: 93%;
            position: absolute;
            z-index: 1;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
        }

        footer .contact-info{
            display: flex;
            flex-direction: column;
            z-index: 1;
        }

 

        .portfolios{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 300px;
            position: relative;
            top: 55px;
        }

        




    </style>
</head>
<body>

            <div class="wrapper btn-area">
              
                <section class="intro">
                    <div  class="jump-btn">
                        <button id="intro-btn" class="btn btn-secondary selected">Intro</button>
                        <button id="skil-stack-btn" class="btn btn-secondary">Skill Stack</button>
                        <button id="portfolio-btn" class="btn btn-secondary">Portfolio</button>
                    </div>
                        <img src="${resume.intro_dto.introduction_img_path}" alt="">
                        <input type="file" name="introduction_img_path" style="display: none;">
                        <div class="self-desciption">
                             <h1>${resume.intro_dto.introduction_header}</h1>
                             <p>${resume.intro_dto.introduction_main}</p>                         
                    </div>
                     
                </section>

                <section class="skil-stack hidden">


                    <div class="jump-btn">
                        <button id="intro-btn" class="btn btn-secondary">Intro</button>
                        <button id="skil-stack-btn" class="btn btn-secondary selected">Skill Stack</button>
                        <button id="portfolio-btn" class="btn btn-secondary">Portfolio</button>

                    </div>
                    <div class="skill-stack-set">
                        <img src="/publish/resume/img/스프링.JPG">
                        <img src="/publish/resume/img/오라클.JPG">
                        <img src="/publish/resume/img/자바.JPG">
                        <img src="/publish/resume/img/자바스크립트.JPG">
                        <img src="/publish/resume/img/파이썬.JPG">
                        <img src="/publish/resume/img/HTML.JPG">
                        <img src="/publish/resume/img/css.JPG">
                    </div>
                 </section>


                <section class="portfolio hidden" style=" display: flex; flex-direction: row; justify-content: space-around; align-items: center;">

                    <div class="portfolios">
                        <div class="portfolio-description" style="display: flex; flex-direction: column; align-items: center;">
                            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_first_img}" alt="" width="400px" height="300px">
            				<a href="${resume.portfolio_first_github}" target=_blank>
           					 <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
           					 <p>${resume.portfolio_first_name }</p>
        					   <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_first_desc}</p>
           				</div>
                    </div>

                    <div class="portfolios">
                        <div class="portfolio-description" style="display: flex; flex-direction: column; align-items: center;">
                            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_first_img}" alt="" width="400px" height="300px">
            				<a href="${resume.portfolio_first_github}" target=_blank>
           					 <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
           					 <p>${resume.portfolio_first_name }</p>
        					   <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_first_desc}</p>
           				</div>
                    </div>


                    <div class="portfolios">
                        <div class="portfolio-description" style="display: flex; flex-direction: column; align-items: center;">
                            <img class="PORTFOLIO_FIRST_IMG" src="${resume.portfolio_first_img}" alt="" width="400px" height="300px">
            				<a href="${resume.portfolio_first_github}" target=_blank>
           					 <p class="PORTFOLIO_FIRST_GITHUB">깃허브</p></a>
           					 <p>${resume.portfolio_first_name }</p>
        					   <p class="PORTFOLIO_FIRST_NAME">${resume.portfolio_first_desc}</p>
           				</div>
                    </div>




                    <div class="jump-btn">
                        <button id="intro-btn" class="btn btn-secondary">Intro</button>
                        <button id="skil-stack-btn" class="btn btn-secondary">Skill Stack</button>
                        <button id="portfolio-btn" class="btn btn-secondary selected">Portfolio</button>
                    </div>
                </section>

            <footer>
                <div class="contact-info">
                    <span style="font-weight: 600;">Phone</span>
                    <span>010-9932-1967</span>
                </div>
                <div class="contact-info">
                    <span  style="font-weight: 600;">Email</span>
                    <span>lookhkh37@gmail.com</span>
                </div>
                <div class="contact-info">
                   <img onclick="location.href='#'" src="/publish/resume/img/20210727_143131.png" width="50px" height="50px">
            </footer>
        </div>
              
       <div data-input="${preview=='on'?'on':'none'}" class="action_btn" style="position: fixed; top: 0px; left: 50%; display: none;">
        <button class="btn btn-primary">등록하기</button>
        <button class="btn btn-primary">돌아가기</button>
      </div>
</body>
</html>

<script>
    window.addEventListener('load',function(){

        const btn_area = document.querySelector(".btn-area");

        btn_area.addEventListener('click',(e)=>{
            const target = e.target;
            const target_name = target.id;
            const target_section_name = "."+target_name.substring(0,target_name.lastIndexOf("-"));


             //ë²í¼ í´ë¦­ ì ì´ëíëë¡!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
            if(target.nodeName==="BUTTON"){


            const target_class_hidden = document.querySelector(target_section_name)

            setTimeout(()=>{target_class_hidden.classList.remove('hidden');},500);
            target.parentElement.parentElement.classList.add('hidden');
            }




            else if(target.nodeName==="IMG"){
                const parent = target.parentElement;
                const hidden_input = parent.querySelector('input[type="file"]')
                hidden_input.click();
                hidden_input.addEventListener('input',function(e){
                let input = hidden_input.files[0];

                let fReader = new FileReader();
                fReader.readAsDataURL(input);
                fReader.onloadend=function(e){
                    target.src=e.target.result;
                  

                }
                console.log(input)
                console.log(target.src)

 

})

            }

     })



       
    })
</script>