window.addEventListener('load',function(){
    console.log("연결")
    const btn = document.querySelector('.port1');
    
    console.log(btn)
            btn.addEventListener('click',function(){
                console.log("ㅎㅇ")
                var change1 = document.querySelector(".portpolio-div2");
                var change2 = document.querySelector(".portpolio-div3");
                if(change1.style.display=='none'){
                    change1.style.display = 'flex';
                }else if(change2.style.display=='none'){
                    change2.style.display = 'flex';
                }else if(change2.style.display=='flex'){
                    alert('포트폴리오는 최대 3개까지 등록가능합니다.');
                }
            })    
        })
