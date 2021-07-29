window.addEventListener('load',function(){
    let target = document.querySelector('.nav')
    let dropdowncheck =document.querySelectorAll('.dropdown-content');
    let header = document.querySelector('#header');

    target.onmouseover = function(e){
      let target = e.target;

      if(target.className!=='target-a') return;

      dropdowncheck.forEach(a=>{
        if(a.classList.contains('show')){
          a.classList.remove('show');
        }
      })
      
      target.parentNode.parentNode.lastElementChild.classList.toggle('show');
      
    }

    header.onmouseleave=()=>{

      dropdowncheck.forEach(a=>{
        if(a.classList.contains('show')){
          a.classList.remove('show');
        }
      })
    }

    
    
  })