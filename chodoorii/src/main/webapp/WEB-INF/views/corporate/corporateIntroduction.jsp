<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../header/header.jsp"></jsp:include>
<body>


 <div class="wrapper">
        <div class="introduce" style="text-align: center;">
            <form action="" method="">
                <h3>회사이름</h3><br>
                <textarea name="" id="" cols="80" rows="10" style="resize: none;" maxlength="500" placeholder="최대 500자 까지 입력가능."></textarea>
                <br>
                <label for="hireNum">채용 인원 </label>
                    <input type="text" name="amount" placeholder="최대 300" maxlength="300" style="text-align: right;">명
                    <button type="button" onClick="javascript:this.form.amount.value++;" style="border: none;outline: none;background-color: white;"><img src="/publish/corporate/img/위.png" alt=""></button>
                    <button type="button" onClick="javascript:this.form.amount.value--;" style="border: none;outline: none;background-color: white;"><img src="/publish/corporate/img/아래.png" alt=""></button> 
                    <hr>
                    <label for="Salary">종업원 평균 연봉</label><br>
                    <label><input type="radio" name="Salary" value="1">2500~3000만원</label>
                    <label><input type="radio" name="Salary" value="2">3000~3500만원</label>
                    <label><input type="radio" name="Salary" value="3">3500~4000만원</label>
                    <label><input type="radio" name="Salary" value="4">회사 내규에 따름</label>
                    <hr>
                <div>
                <label for="SelectWelfare">복지</label><br>
                <label><input type="checkbox" name="wlfare" value="vacation"><img src="/publish/corporate/img/연차.jpg" alt=""><br>자유로운 연차 사용</label>
                <label><input type="checkbox" name="wlfare" value="rice"><img src="/publish/corporate/img/식대제공.jpg"><br>식대 제공</label>
                <label><input type="checkbox" name="wlfare" value="work"><img src="/publish/corporate/img/잠.jpg" alt=""><br>유연근무제 운영</label>
                <label><input type="checkbox" name="wlfare" value="book"><img src="/publish/corporate/img/도서지원.png" alt=""><br>자기계발 도서 지원</label>
              </div>
              <button type="button" class="btn btn-primary">등록하기</button>
            </form>
        </div>
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>


