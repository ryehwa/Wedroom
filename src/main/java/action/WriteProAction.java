package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//추가
import krh.board.*;//BoardDAO,BoardDTO
import java.sql.Timestamp;//DB에서의 필드의 날짜 자료형 때문에


public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//1.writePro.jsp의 자바 처리 구문
		 request.setCharacterEncoding("utf-8");//한글처리
	     
		 BoardDTO article=new BoardDTO();
		 
		 article.setNum(Integer.parseInt(request.getParameter("num")));//hidden
		 article.setWriter(request.getParameter("writer"));
		 article.setEmail(request.getParameter("email"));
		 article.setSubject(request.getParameter("subject"));
		 article.setPasswd(request.getParameter("passwd"));
		 
		 
	    //readcount(0)(생략),오늘날짜,원격주소ip 
	    Timestamp temp=new Timestamp(System.currentTimeMillis());//컴퓨터계산(날짜,시간)
	    article.setReg_date(temp);//오늘 날짜 수동저장=>~.getReg_date() ->now()
	    article.setRef(Integer.parseInt(request.getParameter("ref")));//원격 ip주소 저장
	    article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
	    article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
	    //조회수->자동으로 0을 default
	    article.setContent(request.getParameter("content"));
	    article.setIp(request.getRemoteAddr());//원격ip주소 저장
	    
	    BoardDAO dbPro=new BoardDAO();
	    dbPro.insertArticle(article);
	    //3.공유->페이지 이동
			return "/writePro.jsp";// /list.do로 처리-> /list.jsp
		}

}
