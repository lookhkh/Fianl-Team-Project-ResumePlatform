<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="../header/header.jsp"></jsp:include>
<style>
	.fail{
	border : 1px solid red}
</style>
<body>


 <div class="wrapper">
        <div class="introduce" style="text-align: center;">
            <form action="/corporate/register" method="POST">
                <h3>${userName}</h3><br>
                <c:if test="${error.hasFieldErrors('summary')}"><p style="color : red">${error.getFieldError('summary').getDefaultMessage()}</p></c:if>
                <textarea  id="" cols="80" rows="10" style="resize: none;" maxlength="500" name="summary" placeholder="최대 500자 까지 입력가능.">${detail.summary}</textarea>
                <br>
                <label for="hireNum">채용 인원 </label>
                                <c:if test="${error.hasFieldErrors('staffNumber')}"><p style="color : red">${error.getFieldError('staffNumber').getDefaultMessage()}</p></c:if>
                    <input type="text" name="staffNumber" placeholder="최대 300" maxlength="300" style="text-align: right; value="${detail.staffNumber}">명
                    <button type="button" onClick="javascript:this.form.amount.value++;" style="border: none;outline: none;background-color: white;"><img src="/publish/corporate/img/위.png" alt=""></button>
                    <button type="button" onClick="javascript:this.form.amount.value--;" style="border: none;outline: none;background-color: white;"><img src="/publish/corporate/img/아래.png" alt=""></button> 
                    <hr>
                    <label for="Salary">종업원 평균 연봉</label><br>
                                                    <c:if test="${error.hasFieldErrors('salary')}"><p style="color : red">${error.getFieldError('salary').getDefaultMessage()}</p></c:if>
                    <label><input type="radio" name="Salary" value="2500~3000만원">2500~3000만원</label>
                    <label><input type="radio" name="Salary" value="3000~3500만원">3000~3500만원</label>
                    <label><input type="radio" name="Salary" value="3500~4000만원">3500~4000만원</label>
                    <label><input type="radio" name="Salary" value="회사 내규에 따름">회사 내규에 따름</label>
                    <hr>
                <div>
                <label for="SelectWelfare">복지</label><br>
               <c:if test="${error.hasFieldErrors('wlfare')}"><p style="color : red">${error.getFieldError('wlfare').getDefaultMessage()}</p></c:if>
                
                <label><input type="checkbox" ${i=="연차"?'checked':''} name="wlfare" value="연차"><img src="/publish/corporate/img/연차.jpg" alt=""><br>자유로운 연차 사용</label>
                <label><input type="checkbox" ${i=="식대제공"?'checked':''} name="wlfare" value="식대제공"><img src="/publish/corporate/img/식대제공.jpg"><br>식대 제공</label>
                <label><input type="checkbox" ${i=="유연근무제"?'checked':''} name="wlfare" value="유연근무제"><img src="/publish/corporate/img/유연근무제.jpg" alt=""><br>유연근무제 운영</label>
                <label><input type="checkbox" ${i=="도서지원"?'checked':''}  name="wlfare" value="도서지원"><img src="/publish/corporate/img/도서지원.png" alt=""><br>자기계발 도서 지원</label>
              </div>
              <input type="submit" class="btn btn-primary" value="등록하기"/>
            </form>
        </div>
		
    
     

 
<jsp:include page="../header/footer.jsp"></jsp:include>

 
</body>
</html>



