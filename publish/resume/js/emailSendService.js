window.addEventListener('load',function(){
    const emailAuthBtn = document.querySelector('.emailAuth')
    let emailInput = document.querySelectorAll('input[type="email"]');
    let timerElement = document.querySelector('.emailAuthCheckTimer');
    let authResult = document.querySelector('.authResult')
    


    emailAuthBtn.addEventListener('click',function(){
        alert('인터넷 상황에 따라 인증번호 수신에 수 분이 걸릴 수 있습니다')
        const emailCheck = document.querySelector('.emailCheck');
        emailCheck.style.display = '';
        emailAuthBtn.style.backgroundColor = 'blue'
        emailAuthBtn.style.color ='white';

        let address = emailInput[0].value;
    
        requestEmailSend(address);

    })


    function requestEmailSend(address){
    
        const url = "http://localhost:8088/email";

        const xhr = new XMLHttpRequest();
        
        xhr.open("POST",url);
        xhr.timeout=10000;
        xhr.send(address);

        xhr.onreadystatechange = ()=>{
            if(xhr.readyState===XMLHttpRequest.DONE&&xhr.status===200){
                console.log("요청이 성공적으로 완료되었습니다");
            }
        }

        xhr.ontimeout=()=>{
            alert("서버의 이상으로 인하여 요청에 실패하였습니다");
        }

    }

    const emailAuthCheckBtn = document.querySelector('.emailAuthCheck');
    

    emailAuthCheckBtn.addEventListener('click',function(){

        const url = "http://localhost:8088/email/"+emailInput[1].value;

        const xhr = new XMLHttpRequest();
        
        xhr.open("GET",url);
        xhr.send(null);

        xhr.onreadystatechange = ()=>{
            if(xhr.readyState===XMLHttpRequest.DONE&&xhr.status===200){
                alert("요청이 성공적으로 완료되었습니다");
                authResult.value=1;
                emailAuthCheckBtn.classList.add('checked')
                emailAuthBtn.classList.add('checked')
                emailInput.forEach(a=>
                    a.readOnly = true);

            }
        }

    })



    
})