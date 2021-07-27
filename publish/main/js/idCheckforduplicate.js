window.addEventListener('load',function(){

    const idCheckBtn = this.document.querySelector('.idcheck');
     
    idCheckBtn.addEventListener('click',function(e){
        const input = idCheckBtn.parentElement.firstElementChild;
        const id = input.value;
        const idCheckFlag = document.querySelector('#id-duplicate-check-flag')

        idCheckforduplicate(id).then(()=>confirm("사용하실 수 있는 ID입니다")).then(()=>{
            idCheckFlag.value=1;
            input.setAttribute("readonly",true)
            idCheckBtn.disabled=true}).catch(result=>confirm(result));

    })
    

function idCheckforduplicate(id){
        return new Promise((resolve,reject)=>{
            const http = new XMLHttpRequest();
            const URL = `http://localhost:8088/idcheck?id=${id}`;
            console.log(URL);
            http.open("GET",URL);
            http.timeout = 5000;
            http.send();

            http.onload=()=>{
                if(http.status===200){
                    resolve(http.response)
                }else if(http.status===500||http.status===400){
                    reject(http.response);
                }
            }

            http.ontimeout=()=>{
                reject("현재 서버에 접속량이 많습니다. 잠시 후에 다시 시도해주세요");
            }
        })
    }




})