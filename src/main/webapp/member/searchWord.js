/**
 * xhr객체를 생성->jsp로 요청->응답->콜백함수로 출력
 */
var xhrObject;//xhr객체(전역)

//1.xhr객체생성
function createXHR(){
	if(window.XMLHttpRequest){
		xhrObject=new XMLHttpRequest();//객체생성
		//alert(xhrObject);
	}
	}

//2.중복id체크->처리해주는 함수
function idCheck(id){
	if(id==""){//입력을 하지 않은 경우
		alert("아이디를 입력해주세요");
		return false;
	}
    createXHR()//xhrObject
	var url = "http://localhost:8090/member?id="+id;
	//alert(url);
	//2.콜백함수를 지정
	xhrObject.onreadystatechange=resultProcess;
	//3.open함수를 서버에 요청 준비
	xhrObject.open("Get",url,true);
	//4.send 호출
	xhrObject.send(null);
}

function resultProcess(){
	if(xhrObject.readyState==4){//서버가 요청을 다 받았다면
		if(xhrObject.status==200){//서버의 결과를 다 보내줬다면
			var result = xhrObject.responseText;
			alert(result);
		}
	}
}