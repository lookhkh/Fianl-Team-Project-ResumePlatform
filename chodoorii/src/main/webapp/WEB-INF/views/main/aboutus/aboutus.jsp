<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="../../header/header.jsp"></jsp:include>

    
    <style>
    *{margin:0;padding:0;}
    .video-con {font-size:0;max-width:1000px;margin:0 auto;position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);}
    .video-con > h3 {font-size:40px;text-align:center;padding:30px;font-size:50px;font-weight:900;}
    .video-con > li {font-size:20px;display:inline-block;width:33.3%;vertical-align:top;}
    .textbox {max-width:350px;cursor:pointer;text-align:center;margin:10px; margin-left: 50px;}
    .thumb {width:auto;overflow:hidden;padding-bottom:56.25%;position:relative;}
    .thumb img {position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);max-width:100%;transition: .35s ease-in-out;}
    .thumb:before {content:'';display:block;width:100%;height:100%;position:absolute;top:50%;left:50%;transform:translate(-50%,-50%);background:rgba(0,0,0,.6) url('./img/eye.png') center center no-repeat;transition: .35s ease-in-out;z-index:20;opacity:0;}
    .title {display:inline-block;background-size: 200%;background-position: 0 0;transition: .35s ease-in-out;padding:10px;margin:10px auto;}
    .desc {display:inline;background: linear-gradient(to right, rgba(255,255,255,0) 50%, #f3ca00 50%);background-size: 200%;background-position: 0 0;transition: .35s ease-in-out;font-size:11px;line-height:1.6;color:#666;word-break:keep-all;}
    .textbox:hover .desc {background-position: -100% 0;}
    .textbox:hove	r .thumb img {max-width:105%;}
    .textbox:hover .thumb:before {opacity:1;}
    
    </style>
</head>
<body>
    <ul class="video-con">
        <h3>My Resume developer</h3> 
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">조현일</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt eveniet ad nisi suscipit, totam quasi facere nesciunt est nobis amet. Nulla iste quis asperiores ipsum natus! Numquam sed voluptates adipisci.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi optio delectus quia fugit provident impedit cupiditate necessitatibus veniam, error reprehenderit nam. Sapiente rerum quo fugiat quisquam necessitatibus placeat impedit amet!</p>
            </div>
        </li>
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">이홍섭</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt eveniet ad nisi suscipit, totam quasi facere nesciunt est nobis amet. Nulla iste quis asperiores ipsum natus! Numquam sed voluptates adipisci.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi optio delectus quia fugit provident impedit cupiditate necessitatibus veniam, error reprehenderit nam. Sapiente rerum quo fugiat quisquam necessitatibus placeat impedit amet!</p>
            </div>
        </li>
        <li>
            <div class="textbox">
                <div class="thumb"><img src="../img/회사.JPG"></div>
                <h3 class="title">이미숙</h3><br>
                <p class="desc">Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsa, facere atque. Voluptatem autem possimus nam soluta dolorum non quisquam incidunt. Quidem expedita iusto minus magni vero, aliquid voluptate a provident.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt eveniet ad nisi suscipit, totam quasi facere nesciunt est nobis amet. Nulla iste quis asperiores ipsum natus! Numquam sed voluptates adipisci.<br>
                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quasi optio delectus quia fugit provident impedit cupiditate necessitatibus veniam, error reprehenderit nam. Sapiente rerum quo fugiat quisquam necessitatibus placeat impedit amet!</p>
            </div>
        </li>
    </ul>
</body>
</html>
    
    
    