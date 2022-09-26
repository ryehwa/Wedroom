package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가
import krh.board.*;//BoardDAO,BoardDTO
import java.sql.Timestamp;//DB에서의 필드의 날짜 자료형 때문에


public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//1.updatePro.jsp의 자바 처리 구문
		 request.setCharacterEncoding("utf-8");//한글처리
		 //추가(수정할 페이지로 이동)
		 String pageNum=request.getParameter("pageNum");
		 System.out.println("UpdateProAction에서의 pageNum=>"+pageNum);
	     
		 BoardDTO article=new BoardDTO();
		 
		 article.setNum(Integer.parseInt(request.getParameter("num")));//hidden
		 article.setWriter(request.getParameter("writer"));
		 article.setEmail(request.getParameter("email"));
		 article.setSubject(request.getParameter("subject"));
		 article.setContent(request.getParameter("content"));
		 article.setPasswd(request.getParameter("passwd"));
		 
		 BoardDAO dbPro=new BoardDAO();
		 int check=dbPro.updateArticle(article);
		 //2.공유
		 request.setAttribute("pageNum", pageNum);//페이지 이동
		 request.setAttribute("check", check);//${check}수정성공유무
		 
		 //3.공유->페이지 이동
		 return "/updatePro.jsp";// /list.do로 처리-> /list.jsp
		}

}
