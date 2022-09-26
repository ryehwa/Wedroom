package controller;

import java.io.*;//FileInputStream
import java.util.*;//Map,Properties
import javax.servlet.*;
import javax.servlet.http.*;
//추가->다른 패키지의 클래스나 인터페이스를 참조
import action.CommandAction;

public class ControllerAction extends HttpServlet {
	
    //명령어와 명령어 처리클래스를 쌍으로 저장
    private Map commandMap = new HashMap();
    
	//서블릿을 실행시 서블릿의 초기화 작업->생성자
    public void init(ServletConfig config) 
                    throws ServletException {
    	
  //경로에 맞는 CommandPro.properties파일을 불러옴
    String props = config.getInitParameter("propertyConfig");
    System.out.println("불러온경로="+props);//콘솔에서 경로 확인
    
  //명령어와 처리클래스의 매핑정보를 저장할
  //Properties객체 생성
    Properties pr = new Properties();
    FileInputStream f = null;//파일불러올때 
    
        try {
           //CommandPro.properties파일의 내용을 읽어옴
        	f=new FileInputStream(props);
           
        	//파일의 정보를 Properties에 저장
        	pr.load(f);
        	
        }catch(IOException e){
          throw new ServletException(e);
        }finally{
        if(f!=null) try{f.close();}catch(IOException ex){}	
        }
        	
     //객체를 하나씩 꺼내서 그 객체명으로 Properties
     //객체에 저장된 객체를 접근
     Iterator keyiter = pr.keySet().iterator();
     
     while(keyiter.hasNext()){
       //요청한 명령어를 구하기위해
       String command = (String)keyiter.next();
       System.out.println("command="+command);
       //요청한 명령어(키)에 해당하는 클래스명을 구함
       String className=pr.getProperty(command);
       System.out.println("className="+className);
       
       try{
       //그 클래스의 객체를 얻어오기위해 메모리에 로드
       Class commandClass = Class.forName(className);
       System.out.println("commandClass="+commandClass);
       Object commandInstance = commandClass.newInstance();
       //실제로 요청한 명령어에 해당되는 객체가 생성
       System.out.println
              ("commandInstance="+commandInstance);
      
       //Map객체 commandMap에 저장
       commandMap.put(command, commandInstance);
       System.out.println("commandMap="+commandMap);
       
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }//while
    }

    public void doGet(//get방식의 서비스 메소드
                     HttpServletRequest request, 
                     HttpServletResponse response)
    throws ServletException, IOException {
    	    requestPro(request,response);
    }

    protected void doPost(//post방식의 서비스 메소드
                     HttpServletRequest request, 
                     HttpServletResponse response)
    throws ServletException, IOException {
    	    requestPro(request,response);
    }

    //시용자의 요청을 분석해서 해당 작업을 처리
    private void requestPro(HttpServletRequest request,
    		                HttpServletResponse response) 
    throws ServletException, IOException {
    
    	String view=null;//요청명령어에 따라서 이동할 페이지를 저장
    	// /list.do=action.ListAction-> /list.jsp
    	// /writeFrom.do=action.WriteFormAction->/writeForm.jsp
    	
    	//ListAction com=new ListAction();
    	//WriteFormAction com=null;
    	CommandAction com=null;//어떠한 자식클래스의 객체라도 부모형
    	//CommandAction com=new ListAction();
    	try {
    		//1.요청명령어 분리
    		String command=request.getRequestURI();
    		System.out.println("request.getRequestURI()=>"+request.getRequestURI());
    		System.out.println("request.getContextPath()=>"+request.getContextPath());
    		// /JspBoard2/list.do
    		// /JspBoard2
    		if(command.indexOf(request.getContextPath())==0) {
    			command=command.substring(request.getContextPath().length());
    			System.out.println("실질적인 command=>"+command);
    			// /list.do
    		}
    		//요청명령어->/list.do->action.ListAction객체->requestPro()
    		com=(CommandAction)commandMap.get(command); // /list.do
    		System.out.println("com=>"+com);//action.ListAction@~
    		view=com.requestPro(request, response);// /list.jsp
    		System.out.println("view=>"+view);
    	}catch(Throwable e) {
    		throw new ServletException(e);//서블릿 예외처리
    	}
    	//위에서 요청명령어에 해당하는 view로 데이터를 공유시키면서 이동-> forward
    	RequestDispatcher dispatcher=request.getRequestDispatcher(view);
    	dispatcher.forward(request, response);//Controller->View에게 전달
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}

