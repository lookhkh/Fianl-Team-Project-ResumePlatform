window.addEventListener('load',function(){

const userPic = document.querySelector('.userpic');
const picInput = document.querySelector('input[type="file"]');

picInput.addEventListener('input',function(e){
    let input = picInput.files[0];
    console.log(input)
    let fReader = new FileReader();
    fReader.readAsDataURL(input);
    fReader.onloadend=function(e){
        userPic.src=e.target.result;
    }
 

})

const imgIploadBtn = document.querySelector('.uploadbtn');
imgIploadBtn.onclick=()=>{
    picInput.click();
}

})