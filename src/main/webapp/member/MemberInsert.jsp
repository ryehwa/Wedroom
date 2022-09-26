<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.*"%>
<!DOCTYPE html>
<%
//Register.jsp->RegisterProc.jsp->MemberInsert.jsp
request.setCharacterEncoding("utf-8");
/*
MemberDTO mem=new MemberDTO();
mem.setMem_id(request.getParameter("mem_id"));
mem.setMem_passwd(request.getParameter("mem_passwd"));
,,,
*/
%>
<jsp:useBean id="mem" class="hewon.MemberDTO" />
<jsp:setProperty name="mem" property="*" />
<%
MemberDAO memMgr=new MemberDAO();
boolean check=memMgr.memberInsert(mem);//회원가입
%>
<html>
<head>
<meta-charset="UTF-8">
</head>
<body bgcolor="#FFFFCC">
<br>
<center>
<%
	if(check){//회원가입에 성공
		out.println("<b>회원가입을 축하드립니다.</b><p>");
		out.println("<a href=Login.jsp>로그인</a>");		
	}else{//check=false
		out.println("<b>다시 입력하여 주십시오.</b><p>");
		out.println("<a href=Register.jsp>다시 가입</a>");
	}
%>
</center>
</body>
</html>