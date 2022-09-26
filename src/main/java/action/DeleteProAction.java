package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import krh.board.BoardDAO;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		 String pageNum=request.getParameter("pageNum");//hidden
	     //추가
	     String passwd=request.getParameter("passwd");//입력 O
	     int num=Integer.parseInt(request.getParameter("num"));
	     System.out.println("deletePro.do의 num="+num
	    		      +",passwd="+passwd+",pageNum="+pageNum);
	     
	     BoardDAO dbPro=new BoardDAO();
	     int check=dbPro.deleteArticle(num,passwd);
	     //2개의 공유값이 필요
	     request.setAttribute("pageNum", pageNum);//페이지 이동
		 request.setAttribute("check", check);
	     
		 return "/deletePro.jsp";
	}

}
