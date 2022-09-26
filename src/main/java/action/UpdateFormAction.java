package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import krh.board.BoardDAO;
import krh.board.BoardDTO;


// /updateForm.do?num=3&pageNum=1
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		 //content.jsp->글수정->updateForm.jsp?num=3&pageNum=1
	    int num=Integer.parseInt(request.getParameter("num"));//게시물번호 정수
		String pageNum=request.getParameter("pageNum");//페이지 번호
		System.out.println("UpdateFormAction에서의 pageNum=>"+pageNum);
		BoardDAO dbPro=new BoardDAO();
		BoardDTO article=dbPro.updateGetArticle(num);//조회수가 증가X
		//2.서버에 저장
		request.setAttribute("pageNum",pageNum);
		request.setAttribute("article",article);
		
		return "/updateForm.jsp";
	}

}
