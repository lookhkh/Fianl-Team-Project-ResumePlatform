window.addEventListener('load',()=>{

    const url = new URL(window.location.href);
    console.log(url)
    const param = url.searchParams;
    const loginBtn = document.querySelector('.signup');
    const form = document.querySelector('#loginForm');
    
    const urlParams = new URLSearchParams(param);

// value 목록
    const keys = urlParams.keys();

    for(let i of keys){
        switch(i){
            case "loginRedirect" : {
                alert("로그인이 필요한 서비스입니다. 로그인해주세요")
                loginBtn.click();
                form.action = form.action+"?"+"type="+i+"&"+"redirect="+urlParams.get(i);
                break;
            }
        }
    }


})