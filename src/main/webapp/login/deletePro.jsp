<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="hewon.*"%>
<!DOCTYPE html>

<%
//추가
String mem_id=request.getParameter("mem_id");//입력X
String passwd=request.getParameter("passwd");//입력 O
System.out.println("deletePro.jsp의 mem_id="+mem_id+"passwd="+passwd);
//-----------------------------------------------------------
MemberDAO memMgr=new MemberDAO();
int check=memMgr.memberDelete(mem_id,passwd);//회원탈퇴
System.out.println("deletePro.jsp의 회원 탈퇴 유무=>"+check);//1 or 0(실패)
%>

<%
	if(check==1){//회원탈퇴에 성공
		session.invalidate();//세션종료(메모리 해제)
%>
		<script>
		alert("<%=mem_id%>님 성공적으로 탈퇴 처리되었습니다.");
		location.href="Login.jsp";//로그인 안 된 상태
		</script>	
	<% }else{%>
		<script>
		alert("비밀번호가 틀립니다.\n다시 한번 확인하시기 바랍니다.");
		history.back();//history.go(-1) 전의 페이지에서 다시 수정하라.
		</script>
	<% } %>
