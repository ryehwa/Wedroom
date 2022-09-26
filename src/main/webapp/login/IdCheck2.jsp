getParameterValues<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.MemberDAO" %>
 <%//새로고침
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Pragma","no-cache");//메모리
 response.setDateHeader("Expires",0);//보관하지마라
%>
    
 <%
 //script.js(idCheck(id)->IdCheck.jsp?mem_id='nup')
 String mem_id=request.getParameter("mem_id");//null
 System.out.println("IdCheck.jsp의 mem_id=>"+mem_id);
 MemberDAO memMgr=new MemberDAO();
 boolean check=memMgr.checkId(mem_id);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복 ID 체크</title>
</head>
<body bgcolor="FFFFCC">
<br>
<center>
<b><%=mem_id %></b>
<%
	if(check){//이미 존재하는 아이디가 있다면
		out.println("는 이미 존재하는 아이디입니다.<p>");
	}else{//false->존재하는 아이디가 아니면
		out.println("는 사용가능한 아이디입니다.<p>");
	}
%>
<a href="#" onclick="self.close()">닫기</a><!-- 열려있는 창을 가리킴 -->

</center>

</body>
</html>