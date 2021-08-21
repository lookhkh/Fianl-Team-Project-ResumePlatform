window.addEventListener('load',()=>{
    ////////////////////////////////////////버튼 이동///////
    const current_page_lists = ["first","second","third"];
    let current_page_num = 0;
    let allSection = document.querySelectorAll('section');
    const progressBar = document.querySelectorAll('header span');

    const formTag = document.querySelector('form');

        formTag.addEventListener('click',(e)=>{
            const target = e.target;
            let current_page;
            if(target.nodeName!=="BUTTON") return;
            
            e.preventDefault();
            

            if(target.classList.contains("next-btn")){
            
                current_page_num = (current_page_num+1)%3;

                current_page ="."+current_page_lists[current_page_num]+"-form";


            }else if(target.classList.contains("previous-btn")){
                                
            
                current_page_num = (current_page_num-1)%3;

                current_page ="."+current_page_lists[current_page_num]+"-form";
            }

            if(target.classList.contains("submit-btn")){
                if(confirm("이력서를 미리 보시겠습니까?")) formTag.submit();
            }


            let current_section = document.querySelector(current_page);
                

                current_section.classList.remove('hidden');
                allSection.forEach(a=>{
                    if(a!==current_section&&!a.classList.contains('hidden')){
                        a.classList.add("hidden")
                    }
                })
                progressBar.forEach(a=>{
                    if(current_section.classList.contains(a.dataset.target)){
                        a.classList.remove('bg-secondary')
                        a.classList.add('bg-primary')
                    }else{
                        a.classList.remove('bg-primary')

                        a.classList.add('bg-secondary')

                    }
                })
        })
//////////////////////////////버튼 이동//////////////////////////



})