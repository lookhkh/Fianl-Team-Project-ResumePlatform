<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자기소개템플릿6</title>
    <style>    
  .box {
  padding: 50px;
  background: rgba(0, 0, 0, .4);
}
p {
    color: rgb(223, 56, 83);
    margin-bottom: 10px;
}
p:hover {
    color: rgb(192, 94, 111);
}
span {
    position: relative;
    font-weight: bold;
    color:rgb(223, 56, 83);
}
span::after {
    content: '';
    display: block;
    width: 0;
    height: 5px;
    position: absolute;
    left: 0;
    bottom: 0px;
    background: rgb(243, 89, 114);
}
p:hover span::after {
    width: 100%;
    transition: width .3s;
}

/*resumeTemBox1 */
.Header h1 {
    font-family: "Apple SD Gothic Neo", sans-serif;
    font-weight: 700;
    font-size: 64px;
    text-align: center;
    padding: 0.7rem 0.7rem 0.7rem 2rem;
    color: #fff;
    background: linear-gradient(45deg, rgb(254, 107, 139) 30%, rgb(255, 142, 83) 90%);
    box-shadow: rgba(255, 105, 135, 0.3) 0px 3px 5px 2px;
    border-radius: 10px;
    
} 

.main{
    
    height:100%;
    width:100%;
    background:#ffe6e6;
    position:relative;
    margin-top:100px;
}

.circle{
    position:absolute;
    height:200px;
    width:200px;
    border-radius:20px;
    border:5px solid white;
    top: -50px;
    margin-left: 80%;
}

/* resumeTemBox2 */
#INTRODUCTION_HEADER {
    -webkit-flex: 1;
    flex: 1;
    margin-top: 5%;
    margin-left: 100px;
    vertical-align: middle;
}
#INTRODUCTION_HEADER h1 {
    
    font-family: "Apple SD Gothic Neo", sans-serif;
    font-weight: 700;
    font-size: 64px;
    
    
      text-align: center;
    }
    #INTRODUCTION_MAIN p {
        font-family: "Apple SD Gothic Neo", sans-serif;
        font-weight: 400;
        font-size: 18px;
      line-height: 1.5;
      
      text-align: center;
      
    }
    #portfoliosite {
        text-decoration: none;
        
        font-weight: 600;
    }
    
    .name {
        padding-top: 5%;
        font-size: 30px;
        line-height: 1.5;
        font-style: italic;
        margin-bottom: 20px;
        text-align: center;
    }
    
    .name-job {
        display: inline-block;
        color: white;
        vertical-align: top;
        height: 1.5em;
        overflow: hidden;
        padding-right: 0.5em;   
    }
    
    
    
    .name-job-list {
        animation-name: rolling;
        animation-duration: 3s;
        animation-iteration-count: infinite;
        animation-direction: reverse;
    }
    
    
    /* resumeTemBox3 */
    .SKIL_SET {
        display: -webkit-flex;
        display: flex;
        margin-top: 150px;
    }
    .SKIL_SET_BOX {
        -webkit-flex: 1;
        flex: 1;
        text-align: center;
        -webkit-align-items: center;
        align-items: center;
        -webkit-justify-content: center;
        justify-content: center;
    }
    .SKIL_SET_BOX_img {
        max-width: 100px;
        display : inline;
    }
    
    
    /* resumeTemBox4 */
    #resumeTemBox3 h1 {
        padding-top: 80px;
        font-family: "Apple SD Gothic Neo", sans-serif;
        font-weight: 700;
        font-size: 64px;
      line-height: 1.5;
      color: black;
      text-align: center;
    }
    #resumeTemBox3 h1 span {
        font-family: 'Palanquin Dark', sans-serif;
        font-weight: 400;
    }
    .tmicontainer {
        display: -webkit-flex;
        text-align: center;
        margin-top: 80px;
        line-height:1.5;
        margin-left: 30%;
    }
    .tmilist {
        -webkit-flex: 1;
        flex: 1;
        text-align: center;
        -webkit-align-items: center;
        align-items: center;
        -webkit-justify-content: center;
        justify-content: center;
    }
    
    .tmilist ul{
        list-style:none
    }
    
    
    /* resumeTemBox5 */
    .PORTFOLIOTem {
        display: -webkit-flex;
        border: 1px solid red;
        
    }
    
    .PORTFOLIOTem h1{
        text-align: center;
    }
    .PORTFOLIO {
        -webkit-flex: 1;
        flex: 1;
        text-align: center;
        -webkit-align-items: center;
        align-items: center;
        -webkit-justify-content: center;
        justify-content: center;
        padding-top: 5%;
        text-align: center;
        
    }
    .PORTFOLIO_FIRST_IMG {
        max-width: 300px;
        display : inline;
    }
    
    /* resumeTemBox6 */
    
    #resumeTemBox6 {
        background-color: #ffe6e6;
        padding-left: 80px;
    }
    
    .imglist {
        text-align: center;
        
    }
    .imglist img {
        width: 100px;
        
    }
    .imglist a {
        text-decoration: none;
    }
    </style>


</head>
<body>
    <div class="Header">
        <h1>개발자를 꿈꾸는 나</h1>
    </div>
    
    <div class="main">
        <div >
            <img class="circle" src="/publish/resume/img/사진.jpg" height="200px" width="200px">
        </div>
        
        
        
        
        
        <!--메인 1페이지-->
        <div id="resumeTemBox3">
            
            <div class="tmicontainer">
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.<br> 
                    Fugit illo excepturi fugiat ipsum,<br> 
                    cum ea perferendis consequuntur itaque necessitatibus quas eius voluptatum dolore eaque?<br> 
                    Nobis facilis quos praesentium sed quaerat!<br>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit.<br> 
                    Fugit illo excepturi fugiat ipsum,<br> 
                    cum ea perferendis consequuntur itaque necessitatibus quas eius voluptatum dolore eaque?<br> 
                    Nobis facilis quos praesentium sed quaerat!<br></p>
                </div>
            </div>
            <!--메인 5페이지-->
            <div id="resumeTemBox6">
                
                <div class="imglist">
                    <a href="#">
                        <img src="/publish/resume/img/블로그.png" alt="">
                    </a>
                    <a href="#">
                        <img src="/publish/resume/img/인스타.png" alt="">
                    </a>
                    <a href="#">
                        <img src="/publish/resume/img/카카오톡.JPG" alt="">
                    </a>
                    <a href="#">
                        <img src="/publish/resume/img/깃허브.JPG" alt="">
                    </a>
                </div>
            </div> 
            
            
            <!--메인 4페이지-->
            <div id="resumeTemBox5">
                <div class="PORTFOLIOTem">
                    <h1>My Portfolio</h1>
                    <div class="PORTFOLIO">
                        <img class="PORTFOLIO_FIRST_IMG" src="/publish/resume/img/회사.JPG" alt="">
                        <a href="#"><p class="PORTFOLIO_FIRST_GITHUB">깃허브 </p></a>
                        <a href="#"><p class="PORTFOLIO_FIRST_URL">URL</p></a>
                        <p class="PORTFOLIO_FIRST_NAME"> 내용</p>
                    </div>
                    <div class="PORTFOLIO">
                        <img class="PORTFOLIO_FIRST_IMG" src="/publish/resume/img/회사.JPG" alt="">
                        <a href="#"><p class="PORTFOLIO_FIRST_GITHUB">깃허브 </p></a>
                        <a href="#"><p class="PORTFOLIO_FIRST_URL">URL</p></a>
                        <p class="PORTFOLIO_FIRST_NAME"> 내용</p>
                    </div>
                    <div class="PORTFOLIO">
                        <img class="PORTFOLIO_FIRST_IMG" src="/publish/resume/img/회사.JPG" alt="">
                        <a href="#"><p class="PORTFOLIO_FIRST_GITHUB">깃허브 </p></a>
                        <a href="#"><p class="PORTFOLIO_FIRST_URL">URL</p></a>
                        <p class="PORTFOLIO_FIRST_NAME"> 내용</p>
                    </div>
                </div>   
            </div>
            <!--메인 1페이지-->
            <div id="resumeTemBox1">
                
                <div id="INTRODUCTION_HEADER">
                </div>  
    <div id="INTRODUCTION_MAIN">
      <p>이름 <span>이미숙</span></p>
      <p>전화번호 <span>01000000000</span></p>
      <p>메일 <span>misugar_@gamail.com</span></p>
      <p>생일 <span>1993.09.18</span></p>
      <p>거주지 <span>제주특별시</span></p>
      
      
    </div>
    
</div>


<!--메인 2페이지-->
<div id="resumeTemBox2">
    
    <div class="SKIL_SET">
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/스프링.JPG" alt="">    
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/오라클.JPG" alt="">
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바.JPG" alt="">
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바서블릿.JPG" alt="">    
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/자바스크립트.JPG" alt="">
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/파이썬.JPG" alt="">
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/HTML.JPG" alt="">    
        </div>
        <div class="SKIL_SET_BOX">
            <img class="SKIL_SET_BOX_img" src="/publish/resume/img/CSS.JPG" alt="">
        </div>
    </div>
</div>

</div>

</body>
</html>
</html>