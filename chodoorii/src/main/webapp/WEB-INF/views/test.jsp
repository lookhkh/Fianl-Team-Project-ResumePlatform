<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>


</head>
<body>

 <a id="create-kakao-link-btn" href="javascript:;">
  <img
    src="https://developers.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"
  />
      
</body>
</html>
<script type="text/javascript">
   
   Kakao.init("8752b44cb1ecb060fcef5c42962e4953");
   console.log(Kakao.isInitialized());

   
   const test = document.querySelector('a');
   test.onclick= function sendLink(){

    Kakao.Link.createScrapButton({
      container: '#create-kakao-link-btn',
      requestUrl: 'https://developers.kakao.com',
    }

    )
}

// SDK 초기화 여부를 판단합니다.
   
  </script>