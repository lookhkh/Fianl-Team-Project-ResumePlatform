window.addEventListener('load',function(){
    const lookUpModal = document.querySelector('.lookup.btn')
    const loginModal =document.querySelector('.signup.btn')
    const signupinstatic = document.querySelector('.signupinstatic');
    const lookupId = document.querySelector('.lookupId');
    const lookupPw = document.querySelector('.lookupPw');

    const idLookupForm = document.querySelector('.id-lookupForm')
    const pwLookupForm = document.querySelector('.pw-lookupForm')

    console.log(idLookupForm)
    console.log(pwLookupForm)


    

    lookUpModal.addEventListener('click',function(){
        const click = new Event('click');
        loginModal.dispatchEvent(click);

    })

    signupinstatic.addEventListener('click',function(){
        const click = new Event('click');
        lookUpModal.dispatchEvent(click)

    })

    lookupId.addEventListener('click',function(){

        console.log(pwLookupForm.className)
        
        if(pwLookupForm.classList.contains('show')){
            pwLookupForm.classList.remove('show')
        }

        idLookupForm.classList.toggle('show')
       
        
    })

    lookupPw.addEventListener('click',function(){
        


        if(idLookupForm.classList.contains('show')){
            idLookupForm.classList.remove('show')
        }
        pwLookupForm.classList.toggle('show')
       
    })
})