<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="krh.member.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

 <%//새로고침
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Pragma","no-cache");//메모리
 response.setDateHeader("Expires",0);//보관하지마라
%>

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script language="JavaScript" src="script.js?ver=123"></script>
  <script language="JavaScript" src="prototype.js?ver=123"></script>
  <script language="JavaScript" src="searchWord.js?ver=123"></script>
  
  
  <title>회원가입</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/register.css" type="text/css" />

</head>

<body onLoad="document.forms['validation-form'].id.focus()">
  <div class="container">
    <div class="input-form-background row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-4"><img src="image/logo.png" id="logo"></h4>
        
        <form class="validation-form" name="validation-form" action="/member" method="post" novalidate>
            <div class="col-md-8 mb-4">
             <div class="input-group">
              <input type="text" class="form-control" name="id" placeholder="아이디" value="" required>
              &nbsp;
              <span class="input-group-lg">
              <button class="btn btn-outline-info btn-default" type="button" onClick="idCheck(this.form.id.value)">중복확인</button>
	     	  </span>
              <!-- <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div> -->
              
            </div>
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="password" class="form-control" name="password" placeholder="비밀번호 입력" required>
            <!-- <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div> -->
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="password" class="form-control" name="repassword" placeholder="비밀번호 재입력" required>
            <!-- <div class="invalid-feedback">
              비밀번호가 일치하지 않습니다.
            </div> -->
          </div>
          
          <div id="gendercheck">
            <label for="gender">성별</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="m" id="male">
            <label for="male">남자</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="f" id="female">
            <label for="female">여자</label>
            <!-- <div class="invalid-feedback">
            </div> -->
          </div>
          <br>

		  <div class="col-md-8 mb-4">
            <input type="text" class="form-control" name="age" placeholder="생년월일(YYYYMMDD)" required>
            <!-- <div class="invalid-feedback">
              생년월일을 입력해주세요.
            </div> -->
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="number" class="form-control" name="phone" placeholder="휴대폰 번호 입력( '-' 제외 11자리 입력)" required>
            <!-- <div class="invalid-feedback">
              휴대폰 번호를 입력해주세요.
            </div> -->
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="email" class="form-control" name="email" placeholder="이메일주소@wedroom.com" required>
            <!-- <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div> -->
          </div>

          <div class="col-md-8 mb-4">
            <input type="text" class="form-control" name="kakaotalk" placeholder="카카오톡 오픈채팅 아이디" required>
            <!-- <div class="invalid-feedback">
              카카오톡 오픈채팅 아이디를 입력해주세요.
            </div> -->
          </div>
          <!-- 
          <div class="custom-control custom-checkbox mb-4">
            <input type="checkbox" class="custom-control-input" name="agreement" required>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label class="custom-control-label" for="agreement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
           -->
          
          <div class="col-md-8 mb-1 text-center">
          <button class="btn btn-info btn-lg" type="button" onclick="inputCheck()">가입하기</button>
        </div>
        
        </form>
      </div>
    </div>
    
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; WedRoom Corp.</p>
    </footer>
  </div>
  
  <script>
     /* window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);  */
     
     
    function inputCheck(){
    	debugger;
    	if(document.forms['validation-form'].id.value==""){
    		alert("아이디를 입력해주세요.");
    		document.forms['validation-form'].id.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].password.value==""){
    		alert("비밀번호를 입력해주세요.");
    		document.forms['validation-form'].password.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].repassword.value==""){
    		alert("비밀번호를 확인해주세요");
    		document.forms['validation-form'].repassword.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].gender.value==""){
    		alert("성별을 체크해주세요.");
    		document.forms['validation-form'].gender.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].age.value==""){
    		alert("생년월일을 입력해주세요.");
    		document.forms['validation-form'].age.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].phone.value==""){
    		alert("연락처를 입력해주세요.");
    		document.forms['validation-form'].phone.focus();
    		return false;
    	}
    	if(document.forms['validation-form'].email.value==""){
    		alert("이메일을 입력해주세요.");
    		document.forms['validation-form'].email.focus();
    		return false;
    	}
    	
    	if(document.forms['validation-form'].kakaotalk.value==""){
    		alert("카카오톡 아이디를 입력해주세요.");
    		document.forms['validation-form'].kakaotalk.focus();
    		return false;
    	}
    	/*
    	if(document.forms['validation-form'].agreement.value==""){
    		alert("개인정보 수집 동의에 체크해주세요.");
    		document.forms['validation-form'].agreement.focus();
    		return;
    	}
    	*/
    	if(document.forms['validation-form'].password.value != document.forms['validation-form'].repassword.value){
    		alert("비밀번호가 일치하지 않습니다.");
    		document.forms['validation-form'].repassword.focus();
    		return false;
    	}
    	document.forms['validation-form'].submit();
    	
    } 
  </script>
</body>

</html>