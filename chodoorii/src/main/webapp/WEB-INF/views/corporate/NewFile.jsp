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
         ���̵� : <input type="text" name="id" id="id">
        �н����� : <input type="password" name="pw" id="pw">
        �̸� : <input type="text" name="name" id="name">
        <button>
            ���
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

    // 1. login ��ü�� ���� �� �ִ� ��Ʈ�ѷ� ����.
    // 2. Ajax�� login ��ü ������
    // 3. 2������ ������ �����͸� ó���� �� �ִ� ��Ʈ�ѷ��� �����
    // JSON �����͸� �޾Ƽ�, sysout �α� ���.
    
    
})
})
    

</script>