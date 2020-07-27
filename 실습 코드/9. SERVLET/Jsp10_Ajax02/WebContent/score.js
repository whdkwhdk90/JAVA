function getParameterValues(){
	var name = "name=" + $("#name").val();
	var kor = "kor=" + $("#kor").val();
	var eng = "eng=" + $("#eng").val();
	var math = "math=" + $("#math").val();
	
	return "?"+name+"&"+kor+"&"+eng+"&"+math;
	
}


function load(){
	var url = "CalScore"+getParameterValues();
	
	httpRequest = new XMLHttpRequest(); //서버와 통신하는 객체
	httpRequest.onreadystatechange=callback;	//서버로 보낸 요청에 대한 응답을 받았을 때
												//어떤 동작을 할 것인지
	
	httpRequest.open("GET",url,true);		//true : 비동기통신
	httpRequest.send();
}

function callback(){
	alert("readystate: " + httpRequest.readyState);
	
	if(httpRequest.readyState == 4){
		alert("status: " + httpRequest.status);
		if(httpRequest.status=200){
			var obj = JSON.parse(httpRequest.responseText);
			$("#result").html(obj.name+"의 총점은"+obj.sum+"이고, 평균은 "+obj.avg+"입니다.");
		}else{
			alert("데이터를 계산할 수 없습니다.");
		}
		
	}

}

$(function(){
	$("#process").click(function(){
		load();
	});
});

/*
 readyState 
 1: loading - 로드 중
 2: loaded - 로드 됨      이부분쯤 toJSONString이 됨
 3: interactive - 통신 됨
 4: complete - 통신 완료    이 때 화면에 html 출력

-status
200 : 성공
404 : not found
500 : internal server error
 
 */



