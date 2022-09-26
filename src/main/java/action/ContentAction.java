package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

//추가
import krh.board.*;

// /content.do?num=3&pagenum=1
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.content.jsp에서 처리한 자바코드를 대신 실행
		//글상세보기=>게시판(쇼핑물 상품의 정보를 자세히(SangDetial.jsp?sangid=3&pageNum=1))
		int num=Integer.parseInt(request.getParameter("num"));//게시물번호 정수
		String pageNum=request.getParameter("pageNum");//페이지 번호
		System.out.println("contentAction의 pageNum=>"+pageNum+",num=>"+num);
		
		BoardDAO dbPro=new BoardDAO();
		BoardDTO article=dbPro.getArticle(num);
		//링크문자열의 길이를 줄이기위해서
		int ref=article.getRef();
		int re_step=article.getRe_step();
		int re_level=article.getRe_level();
		System.out.println("content.jsp의 매개변수 확인용");
		System.out.println("ref=>"+ref+",re_step=>"+re_step+",re_level=>"+re_level);
		
		//2.실행결과 서버메모리에 저장
		request.setAttribute("num", num);//${키명}
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);//${article.ref}~
		//${ref}		
		//3.페이지 공유
		
		return "/content.jsp"; //경로에 맞게 설계 ex)/member/~.jsp
	}

}
