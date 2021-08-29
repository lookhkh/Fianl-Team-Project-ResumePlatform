<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
    <form id="frm" action="" method="Post">
         아이디 : <input type="text" name="id" id="id">
        패스워드 : <input type="password" name="pw" id="pw">
        이름 : <input type="text" name="name" id="name">
        <button>
            등록
        </button>
    </form>
  
</body>
</html>
<script>
window.addEventListener('load' ,function(){
    
    const btn = document.querySelector("button");

    btn.addEventListener('click', function(e){ 
e.preventDefault();

    var id = document.getElementById("id").value;
    var pw = document.getElementById("pw").value;
	var name = document.getElementById("name").value;
    
    var login ={
        loginId : id,
        loginPw : pw,
        loginName : name
    }
    var form = document.getElementById("frm");

    var log = JSON.stringify(login);
    console.log(log);
    
    form.submit();

    // 1. login 객체를 받을 수 있는 컨트롤러 생성.
    // 2. Ajax로 login 객체 보내기
    // 3. 2번에서 전달한 데이터를 처리할 수 있는 컨트롤러를 만들고
    // JSON 데이터를 받아서, sysout 로그 찍기.
    
    
})
})
    

</script>