package krh.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("겟 도착");
		String id = request.getParameter("id");
		MemberDAO memberdao=new MemberDAO();
		boolean check = memberdao.checkId(id);
		System.out.println(check);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(check) {
        	out.println("이미 사용중인 아이디입니다.");	
        }else {
        	out.println("사용 가능한 아이디입니다.");	
        }
        out.close();  
	}
	
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String id = request.getParameter("id");
 		String password = request.getParameter("password");
 		String gender = request.getParameter("gender");
 		String age = request.getParameter("age");
 		String phone = request.getParameter("phone");
 		String email = request.getParameter("email");
 		String kakaotalk = request.getParameter("kakaotalk");
 		
 		MemberDTO memberDTO = new MemberDTO();
 		
 		memberDTO.setId(id);
 		memberDTO.setPassword(password);
 		memberDTO.setGender(gender);
 		memberDTO.setAge(age);
 		memberDTO.setPhone(phone);
 		memberDTO.setEmail(email);
 		memberDTO.setKakaotalk(kakaotalk);
 		
 		MemberDAO memberDAO = new MemberDAO();
 		System.out.println(memberDAO.memberInsert(memberDTO));
    }
}
