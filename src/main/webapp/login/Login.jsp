<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//웹상에서 로그인했는지 안했는지 확인
String mem_id=(String)session.getAttribute("idKey");
System.out.println("LoginSuccess.jsp의 mem_id"+mem_id);
%>

<!doctype html>
<html>
  <head>
  	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">
    <!-- Bootstrap core CSS -->
<link href="./css/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      a {
  text-decoration-line: none;
  color:black;
}
    </style>

 <!-- Custom styles for this template -->
 <link href="./css/login.css" rel="stylesheet">
 
 <script>
 function memberRegister(){
		document.location="../member/agreement.jsp";
	}
 </script>
  </head>
  
  <body class="text-center" onload="document.login.mem_id.focus()">
      <!-- mem_id의 상태에따라 로그인 처리 -->
  <br><br><br>
 <%
if(mem_id!=null){//인증된 사람이라면
%>
<b><%=mem_id %></b>님 환영합니다.<p>
당신은 제한된 기능을 사용할 수가 있습니다.<p>
<a href="MemberUpdate.jsp">회원수정</a>
<a href="DelCheckForm.jsp?mem_id=<%=mem_id %>">회원탈퇴</a>
<a href="Logout.jsp">로그아웃</a>
	<%}else{ %>

<main class="form-signin">
  <form name="login" method="post" action="/login">
    <img class="mb-4" src="./image/logo.png" alt="" width="270" height="140">

    <div class="form-floating">
      <input type="text" class="form-control" name="id" id="id" placeholder="아이디">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" name="password" id="password" placeholder="비밀번호">
      <label for="floatingPassword">비밀번호</label>
    </div>
    
    <button class="w-100 btn btn-lg text-white" style="background-color:#57D2C4;" type="submit" onclick="loginCheck()">로그인</button>
    <div class="mb-4"></div>
    <div>
      <a href="#">아이디/비밀번호 찾기</a>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="#" onclick="memberRegister()">회원가입</a>
    </div>
    <p class="mt-5 mb-3 text-muted">&copy; WedRoom</p>
  </form>
</main>
<%} %>

    
  </body>
</html>