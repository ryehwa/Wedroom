package krh.board;

//import java.util.Date =>일반적인 날짜
import  java.sql.Timestamp;//DB상의 테이블의 필드와 연관이 있는 클래스(날짜와 시간을 설정)

public class BoardDTO {

	private int num;//게시물번호
	//                   작성자   글제목   이메일   글내용    암호(글쓰기->본인->글수정,글삭제)
	private String writer,subject,email,content,password;
	//직접 입력X
	private Timestamp reg_date;//작성날짜->sysdate <->now() (Mysql함수)
	private int readcount;//조회수=>default ->0
	private String ip;//작성자의 ip
	//답변형
	private int ref;//글 그룹번호(=게시물 번호)
	private int re_step;//답변글의 순서를 지정(=같은 그룹일때의 답변글 순서)->pos
	private int re_level;//답변글의 답변에 대한 깊이(=depth)
	//파일첨부->String fileName,fileSize=>스프링에서 
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}
