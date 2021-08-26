<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../../header/header.jsp"></jsp:include>
<style>





   .wrapper{
        width: 99vh;
        height: 297vh;
        display: flex;
        flex-direction: column;
        margin-top: 80px;
      }

      img{
        margin-left: 8px;
      }

</style>
<body>

	<div class="wrapper">

      <div class="placeholder first">
        <img src="/publish/main/img/개발자(1).png">
      </div>
     
      <div class="placeholder second">
        <img src="/publish/main/img/개발자(2).png">
      </div>

      <div class="placeholder third">
        <img src="/publish/main/img/개발자(3).png">
      </div>

      <div class="placeholder forth">
        <img src="/publish/main/img/개발자(4).png">
      </div>

    </div>

   

 
<jsp:include page="../../header/footer.jsp"></jsp:include>

 
</body>
</html>
<script>
window.addEventListener('load',()=>{
    
	const query = new URL(location.href).searchParams

	if(query.get("error")){
		document.querySelector('.signup').click();
		
	}

	

	 
	  
    const lookupForm = document.querySelector('.id-lookup');
    const lookUpBtn = lookupForm.querySelector('button');
    const pwlookupForm = document.querySelector('.pw-lookupForm');
    const lookUpPwBtn = pwlookupForm.querySelector('button');

    lookUpBtn.addEventListener('click',(e)=>{
      const email = lookupForm.querySelector('input').value 
      const url = "/email/lookupid/"+email;
      alert("요청이 완료되었습니다");
      findUserIdByEmail(url).catch((result)=>alert(result));
    }

    )

    lookUpPwBtn.addEventListener('click',(e)=>{
      const email = pwlookupForm.querySelector('input[type="email"]').value 
      const id = pwlookupForm.querySelector('input[type="text"]').value
      const url = "/email/lookuppw?email="+email+"&id="+id;

	
      if(confirm("비밀번호를 찾으시겠습니까?")){
   		alert("요청이 완료되었습니다")
      findUserIdByEmail(url).catch(result=>alert(result));
      }else{
        alert("취소되었습니다.")
      }
})


    
    function findUserIdByEmail(url){
      return new Promise((resolve,reject)=>{
        const http = new XMLHttpRequest();
        http.open("GET",url);
        http.timeout=5000;
        http.send(null);


        http.onload=()=>{
          if(http.status===200){
            resolve(http.responseText);
          }else{
            reject(http.responseText)
          }
        }

        http.ontimeout=()=>{
          reject("현재 부하가 많습니다. 잠시 후에 다시 시도해주세요");
        }

      })
    }



  })
</script>



