window.addEventListener('load',e=>{
    const action_btns = document.querySelector('.action_btn');
    const msg = action_btns.dataset.input;
     
    if(msg==="on"){
      msg==="on"?action_btns.style.display='block':none;
      }

    const nextBtn = action_btns.firstElementChild;
    const previousBtn = action_btns.lastElementChild;

    nextBtn.onclick=()=>{
      if(confirm("이력서를 최종 저장하시겠습니까?")){
        location.href="/resume/form/confirm?register=on"
      }
    }

    previousBtn.onclick=()=>{
      if(confirm("이전으로 돌아가시겠습니까?")){
		history.back();
      }
    }
  })