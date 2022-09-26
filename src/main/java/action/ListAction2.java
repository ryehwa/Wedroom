package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import krh.board.*;//BoardDAO, BoardDTO

import java.util.*;

//1.requestPro()을 공통메서드로 사용 2.객체형변환 때문에(상속기법)
public class ListAction2 implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1. /list.jsp에서 처리했던 자바코드를 대신 처리해주고 그 결과->전달
		
		int pageSize=10;//numPerPage=>페이지당 보여주는 게시물수(=레코드수) 10
	    int blockSize=5;//pagePerBlock=>블럭당 보여주는 페이지수 10

	  //게시판을 맨 처음 실행시키면 무조건 1페이지부터 출력->가장 최근의 글이 나오기때문에 
	  String pageNum=request.getParameter("pageNum");
	  if(pageNum==null){
		  pageNum="1";//default(무조건 1페이지는 선택하지 않아도 보여줘야 되기때문에)
	  }
	  int currentPage=Integer.parseInt(pageNum);//"1"->1(=nowPage)(현재페이지)
	  //                  (1-1)*10+1=1,(2-1)*10+1=11,(3-1)*10+1=21
	  int startRow=(currentPage-1)*pageSize+1;//시작 레코드번호
	  int endRow=currentPage*pageSize;//1*10=10,2*10=20,3*10=30
	  
	  int count=0;//총레코드수
	  int number=0;//beginPerPage->페이지별로 시작하는 맨 처음에 나오는 게시물번호
	  List<BoardDTO> articleList=null;//화면에 출력할 레코드를 저장할 변수
	  
	  BoardDAO dbPro=new BoardDAO();
	  count=dbPro.getArticleCount();//select count(*) from board->member
	  System.out.println("현재 레코드수(count)=>"+count);
	  if(count > 0){
		  articleList=dbPro.getArticles(startRow,pageSize);//첫번째레코드번호,불러올갯수
		  System.out.println("ListAction의 articleList=>"+articleList);//null->메서드 내용확인
	  }
	  //           122-(1-1)*10=122,121,120,119,,,
	  //           122-(2-1)*10=122-10=
	  number=count-(currentPage-1)*pageSize;
	  System.out.println("페이지별 number=>"+number);

	  //2.처리한 결과를 공유(서버메모리에 저장)=>이동할 페이지에 공유(request)
	  request.setAttribute("currentPage", currentPage);//${currentPage}
	  request.setAttribute("startRow", startRow);//시작레코드 번호
	  request.setAttribute("count", count);//총 레코드 수
	  request.setAttribute("pageSize", pageSize);//페이지당 10개
	  request.setAttribute("blockSize", blockSize);//블럭당 5페이지
	  request.setAttribute("number", number);//페이지 당 시작 게시물번호
	  request.setAttribute("articleList", articleList);//출력할 레코드값들 ${articleList}
	  
	  //3.공유해서 이동할 수 있도록 페이지를 지정
	  	return "/list.jsp";//컨트롤러가 이동시키면서 공유시켜준다.->view
	}

}
