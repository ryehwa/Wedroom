package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//deleteForm.jsp?num=2&pageNum=1->deletePro.jsp(deleteArticle()호출)
		   int num=Integer.parseInt(request.getParameter("num"));//게시물번호
		   String pageNum=request.getParameter("pageNum");//페이지 번호
		   System.out.println("DeleteFormAction의 num=>"+num+",pageNum=>"+pageNum);
		   
		   request.setAttribute("pageNum", pageNum);
		   request.setAttribute("num", num);
		   
		return "/deleteForm.jsp";
	}

}
