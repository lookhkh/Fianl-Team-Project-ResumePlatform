window.addEventListener('load',function(){
console.log("연결")
const btn = document.querySelector('.port1');

console.log(btn)
        btn.addEventListener('click',function(){
            console.log("ㅎㅇ")
        	var change = document.querySelector(".portpolio-div2");
        	if(change.style.display=='none'){
                change.style.display = 'flex';
            }else{
                change.style.display = 'none';
            }
        })


const btn2 = document.querySelector('.port2');
    btn2.addEventListener('click',function(){     

    var change2 = document.getElementById(".portpolio-div3");
        if(change2.style.display=='none'){
            change2.style.display = 'flex';
        }else{
            change2.style.display = 'none';
        }
    })

})