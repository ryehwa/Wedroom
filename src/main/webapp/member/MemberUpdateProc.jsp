<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.*"%>
<!DOCTYPE html>
<%
//MemberUpdate.jsp->MemberUpdateProc.jsp(수정메서드호출)
request.setCharacterEncoding("utf-8");

%>
<jsp:useBean id="mem" class="hewon.MemberDTO" />
<jsp:setProperty name="mem" property="*" />
<%
//추가
String mem_id=request.getParameter("mem_id");
System.out.println("MemberUpdateProc.jsp의 mem_id=>"+mem_id);
//-----------------------------------------------------------
MemberDAO memMgr=new MemberDAO();
boolean check=memMgr.memberUpdate(mem);//회원수정
System.out.println("MemberUpdateProc.jsp의 회원 수정 유무=>"+check);

%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body bgcolor="#FFFFCC">
<br>
<center>
<%
	if(check){//회원수정에 성공
%>
		<script>
		alert("성공적으로 수정되었습니다.");
		location.href="Login.jsp";//아직 로그아웃하지 않은 상태
		</script>	
	<% }else{%>
		<script>
		alert("수정 도중 에러가 발생되었습니다.");
		history.back();//history.go(-1) 전의 페이지에서 다시 수정하라.
		</script>
	<% } %>
</center>
</body>
</html>