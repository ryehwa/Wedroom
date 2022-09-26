<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
edit.html (회원정보 수정 및 탈퇴)
작성날짜:2022-09-12
작성자:김례화
 -->
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원수정</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="css/edit.css" type="text/css" />

</head>

<body>
  <div class="container">
    <div class="input-form-background row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-4"><img src="image/logo.png" id="logo"></h4>
        
        <form class="validation-form" novalidate>
            <div class="col-md-8 mb-4">
             <div class="input-group">
              <input type="text" class="form-control" id="name" placeholder="아이디" value="" required>
              &nbsp;
              <span class="input-group-lg">
              <button class="btn btn-outline-info btn-default" type="submit">중복확인</button>
	     	  </span>
              <div class="invalid-feedback">
                아이디를 입력해주세요.
              </div>
              
            </div>
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="password" class="form-control" id="password" placeholder="비밀번호 입력" required>
            <div class="invalid-feedback">
              비밀번호를 입력해주세요.
            </div>
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="password" class="form-control" id="password" placeholder="비밀번호 재입력" required>
            <div class="invalid-feedback">
              비밀번호가 일치하지 않습니다.
            </div>
          </div>
          
          <div id="gendercheck">
            <label for="gender">성별</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="male" id="male">
            <label for="male">남자</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" name="gender" value="female" id="female">
            <label for="female">여자</label>
            <div class="invalid-feedback">
            </div>
          </div>
          <br>

		  <div class="col-md-8 mb-4">
            <input type="text" class="form-control" id="address" placeholder="생년월일(YYYYMMDD)" required>
            <div class="invalid-feedback">
              생년월일을 입력해주세요.
            </div>
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="number" class="form-control" id="number" placeholder="휴대폰 번호 입력( '-' 제외 11자리 입력)" required>
            <div class="invalid-feedback">
              휴대폰 번호를 입력해주세요.
            </div>
          </div>
          
          <div class="col-md-8 mb-4">
            <input type="email" class="form-control" id="email" placeholder="이메일주소@wedroom.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="col-md-8 mb-5">
            <input type="text" class="form-control" id="kakaoid" placeholder="카카오톡 오픈채팅 아이디" required>
            <div class="invalid-feedback">
              카카오톡 오픈채팅 아이디를 입력해주세요.
            </div>
          </div>
          
          <div class="col-md-8 mb-1 text-center">
          <button class="btn btn-info btn-default" type="submit" >수정하기</button>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <button class="btn btn-info btn-default" type="submit">탈퇴하기</button>
       	</div>
        
        </form>
        
      </div>
    </div>
    
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; WedRoom Corp.</p>
    </footer>
  </div>
  <script>
    window.addEventListener('load', () => {
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
    }, false);
  </script>
</body>

</html>