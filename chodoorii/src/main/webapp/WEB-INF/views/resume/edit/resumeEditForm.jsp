<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="/publish/resume/js/resumeform-pagejump.js"></script>
    <style>

        *{
            padding: 0;
            margin: 0 auto;
        }

        .wrapper{
            width: 100vw;
            height: 100vh;
        }

        form{
            width: 90%;
            height: 90%;
            position: relative;
        }

        section{
            width: 100%;
            height: 100%;
            transition: 0.5s;
        }

        section.hidden{
          display: none;

        }

        button{
            width: 100px;
            height: 100%;
        }

        header{
            height: 7%;
            margin-bottom: 50px;
            display: flex;
            justify-content: center;
            align-items: center;
            border-bottom: 1px solid;
        }

        .form-section{
            width: 100%;
            height: 92%;
        }

        .button-wrapper{
            width: 400px;
            height: 6%;
            display: flex;
            justify-content: space-around;
            align-items: center;
        }

        button.checked{
            background-color: red;
        }

       
        
    </style>
</head>
<body>
    <div class="wrapper">
     
        <header>
            <span data-target="first-form" style="width: 200px; height: 50px; display: flex; justify-content: center; align-items: center; font-size: 1.2rem;" class="badge rounded-pill bg-primary ">자기소개</span>
            <span data-target="second-form" style="width: 200px; height: 50px; display: flex; justify-content: center; align-items: center; font-size: 1.2rem;"class="badge rounded-pill bg-secondary ">기술스택 및 SNS</span>
            <span data-target="third-form" style="width: 200px; height: 50px; display: flex; justify-content: center; align-items: center; font-size: 1.2rem;" class="badge rounded-pill bg-secondary ">포트폴리오</span>
        </header>
        <form method="POST" enctype="multipart/form-data" action="/resume/edit/form" >
            
            <section class="first-form">
				<div class="meta-data-set" style="display: none;">
				     <input type="hidden" name="template_kind" value="${template}">
				</div>
                <div class="form-section">
                    <h2 style="text-align: center;">자기소개에 사용될 사진을 올려주세요</h2>
                    <img src="/publish/resume/img/defaultpic.png" class="img-pic rounded mx-auto d-block" alt="..."  width="300px" height ="300px">
                    <input type="file" name="introduction_img_path" style="display: none;">
                    <div class="input-group" style="width: 800px; margin-top: 50px;">
                        <span class="input-group-text" id="inputGroup-sizing-sm">제목</span>
                        <input name="introduction_header" type="text" maxlength="10" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${resume.intro_dto.introduction_header}">
                      </div>
                      <div class="input-group" style="width: 800px; margin-top: 50px;">
                        <span class="input-group-text">자기소개</span>
                        <textarea name="introduction_main" class="form-control" aria-label="With textarea" rows="10" value="${resume.intro_dto.introduction_main}">${resume.intro_dto.introduction_main}</textarea>
                      </div>

                </div>
                
                <div class="button-wrapper">
                    <button class="backtolist-btn btn btn-primary" onclick="location.href='/resume'">목록으로</button>
                    <button class="next-btn btn btn-primary">다음으로</button>
                </div>

            </section>
            <section class="second-form hidden">
                <div class="form-section">
                  
                    <div class="language" style="margin-bottom: 150px;width: 100%; height: 100px; display: flex; flex-direction: column; justify-content: center;align-items: center;">
                        <h2>사용가능한 기술을 선택해주세요. 최대 8개까지 선택 가능합니다</h2>
                        <div class="check">
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox1" value="/publish/resume/img/자바.JPG">
                                <label class="form-check-label" for="inlineCheckbox1">자바</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox2" value="/publish/resume/img/파이썬.JPG">
                                <label class="form-check-label" for="inlineCheckbox2">파이썬</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/HTML.JPG">
                                <label class="form-check-label" for="inlineCheckbox3">HTML</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/CSS.JPG" >
                                <label class="form-check-label" for="inlineCheckbox3">CSS</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/자바스크립트.JPG">
                                <label class="form-check-label" for="inlineCheckbox3">JavaScript</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/스프링.JPG">
                                <label class="form-check-label" for="inlineCheckbox3">Spring</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/오라클.JPG">
                                <label class="form-check-label" for="inlineCheckbox3">Oracle</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" name="skil_set" type="checkbox" id="inlineCheckbox3" value="/publish/resume/img/자바서블릿.JPG">
                                <label class="form-check-label" for="inlineCheckbox3">JSP&Servlet</label>
                            </div>
                        </div>
                    </div>
                    <div class="sns-form" style="width: 40%; height: 300px; margin-top: 40px; display: flex; justify-content: center; flex-direction: column; align-items: center;">
                        <h2>SNS 주소를 입력해주세요.</h2>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><img src="/publish/resume/img/블로그.png" width="40px" height="40px"></span>
                            <input type="text" class="form-control" name="blog_address" placeholder="블로그 주소를 적어주세요" aria-label="Username" name="blog_address" aria-describedby="basic-addon1" value="${resume.sns_dto.blog_address}">
                          </div>
                          <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><img src="/publish/resume/img/20210727_143131.png" width="40px" height="40px"></span>
                            <input type="text" class="form-control" placeholder="깃허브 주소를 적어주세요" name="github_address" aria-label="Username" aria-describedby="basic-addon1" value="${resume.sns_dto.github_address}">
                          </div>
                          <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><img src="/publish/resume/img/인스타.png" width="40px" height="40px"></span>
                            <input type="text" class="form-control" placeholder="인스타 주소를 적어주세요" name="instagram_address" aria-label="Username" aria-describedby="basic-addon1" value="${resume.sns_dto.facebook_address}">
                          </div>
                          <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><img src="/publish/resume/img/페이스북.png" width="40px" height="40px"></span>
                            <input type="text" class="form-control" placeholder="페이스북 주소를 적어주세요" name="facebook_address" aria-label="Username" aria-describedby="basic-addon1" value="${resume.sns_dto.instagram_address}">
                          </div>
                    </div>

                </div>     
                <div class="button-wrapper">
                    <button class="previous-btn btn btn-primary">이전으로</button>
                    <button class="next-btn btn btn-primary">다음으로</button>
                </div>

            </section>
            <section class="third-form hidden">
                <div class="form-section" style="padding-left: 100px;">

                    <div class="portpolio-div" style="display: flex; width: 90%; margin-bottom: 10px; padding-left: 150px;">
                        <img width="180px" height="180px" src="/publish/resume/img/defaultpic.png" class="img-pic img-thumbnail" alt="...">
                        <input type="file" name ="portfolio_first_img" style="display: none;" />
                        <div style="display: flex; flex-direction: column; justify-content: flex-start; margin-left: 0; width: 70%;">
                            <div style="display: flex; flex-direction: column; width: 400px; margin-left: 0;">
                                <input name="portfolio_first_name" style="margin-left: 0; margin-bottom: 20px;" placeholder="제목을 입력해주세요" value="${resume.portfolio_first_name}"/>
                                <input name="portfolio_first_github" style="margin-left: 0; margin-bottom: 20px;" placeholder="github 주소를 입력해주세요" value="${resume.portfolio_first_github }"/>
                            </div>
                            <div style="width: 500px; margin-left :0">
                                <textarea name="portfolio_first_desc" rows="5" cols="70" style="margin-left: 0;" placeholder="내용을 입력해주세요" value="${resume.portfolio_first_desc}">${resume.portfolio_first_desc}</textarea>
                            </div>
                        </div>
                    </div>

                    <div class="portpolio-div" style="display: flex; width: 90%; margin-bottom: 10px; padding-left: 150px;">
                        <img width="180px" height="180px" src="/publish/resume/img/defaultpic.png" class="img-pic img-thumbnail" alt="...">
                        <input type="file" name ="portfolio_second_img" style="display: none;"  />
                        <div style="display: flex; flex-direction: column; justify-content: flex-start; margin-left: 0; width: 70%;">
                            <div style="display: flex; flex-direction: column; width: 400px; margin-left: 0;">
                                <input name="portfolio_second_name" style="margin-left: 0; margin-bottom: 20px;" placeholder="제목을 입력해주세요" value="${resume.portfolio_second_name}"/>
                                <input name="portfolio_second_github" style="margin-left: 0; margin-bottom: 20px;" placeholder="github 주소를 입력해주세요" value="${resume.portfolio_second_github}"/>
                            </div>
                            <div style="width: 500px; margin-left :0">
                                <textarea name="portfolio_second_desc"  rows="5" cols="70" style="margin-left: 0;" placeholder="내용을 입력해주세요" value="${resume.portfolio_second_desc}">${resume.portfolio_second_desc}</textarea>
                            </div>
                        </div>
                    </div>
                        

                    <div class="portpolio-div" style="display: flex; width: 90%; margin-bottom: 10px; padding-left: 150px;">
                        <img width="180px" height="180px" src="/publish/resume/img/defaultpic.png" class="img-pic img-thumbnail" alt="...">
                        <input type="file" name ="portfolio_third_img" style="display: none;"/>
                        <div style="display: flex; flex-direction: column; justify-content: flex-start; margin-left: 0; width: 70%;">
                            <div style="display: flex; flex-direction: column; width: 400px; margin-left: 0;">
                                <input name="portfolio_third_name" style="margin-left: 0; margin-bottom: 20px;" placeholder="제목을 입력해주세요" value="${resume.portfolio_third_name}"/>
                                <input name="portfolio_third_github" style="margin-left: 0; margin-bottom: 20px;" placeholder="github 주소를 입력해주세요" value="${resume.portfolio_third_github}"/>
                            </div>
                            <div style="width: 500px; margin-left :0">
                                <textarea name="portfolio_third_desc"  rows="5" cols="70" style="margin-left: 0;" placeholder="내용을 입력해주세요" value="${resume.portfolio_third_desc}">${resume.portfolio_third_desc}</textarea>
                            </div>
                        </div>
                    </div>   
                    <div class="resume-openform" style="display: flex; font-size: 20px;">
                        <div class="form-check form-switch"  style="margin: 0 auto;">
                            <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="disclosure" >
                            <label class="form-check-label" for="flexSwitchCheckDefault">이력서 공개</label>
                          </div>
                        </div>  
                </div>
                
                        
                    
               

                    
                <div class="button-wrapper">
                    <button class="previous-btn btn btn-primary">이전으로</button>
                    <button class="submit-btn btn btn-primary" >미리보기</button>
                </div>

            </section>


        </form>

    </div>
</body>
</html>
<script>
    window.addEventListener('load',function(){
        const query = location.href.substring(location.href.indexOf("=")+1)
		const inputvalue= document.getElementsByName("template-kind");
        inputvalue.value=query
    	
        console.log(inputvalue.value)
        
        const form = document.querySelector('form');
        form.addEventListener('click',(e)=>{
            const target = e.target;
            if(target.nodeName!=="IMG") return;

            const inputFile = target.parentElement.querySelector('input[type="file"]');
            inputFile.click();

            inputFile.addEventListener('input',(e)=>{
                const input = inputFile.files[0];

                let fReader = new FileReader();
                fReader.readAsDataURL(input);
                fReader.onloadend=(e)=>{
                    target.src=e.target.result;

                }

            })
        })


    })
 
</script>
