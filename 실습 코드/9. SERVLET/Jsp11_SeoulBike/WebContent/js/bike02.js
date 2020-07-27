$(function(){
	parseJson();
});

//	json/bike.json의 파일을 가져와서 읽은 후 data를 서버로 보낸다.
// JSON 형태의 text로 보냄   ==> obj는 변수명
function parseJson(){
	$.getJSON("json/bike.json",function(data){
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			data: {"obj":JSON.stringify(data)},
			success:function(msg){
				alert(msg);
				
				if(msg>0){
					//$.getJSON 한 결과(data)를 가지고 table을 채워보자.
					   $.each(data,function(key,val){
					         if(key=="DESCRIPTION"){
					            $("table").attr("border","1");
					            $("thead").append("<tr>"+
					            "<th>"+val.ADDR_GU+"</th>"+
					            "<th>"+val.CONTENT_ID+"</th>"+
					            "<th>"+val.CONTENT_NM+"</th>"+
					            "<th>"+val.NEW_ADDR+"</th>"+
					            "<th>"+val.CRADLE_COUNT+"</th>"+
					            "<th>"+val.LONGITUDE+"</th>"+
					            "<th>"+val.LATITUDE+"</th>"+
					            "</tr>");
					         }else{
					            var list = val;
					            for(var i=0; i<list.length; i++){
					               var str = list[i];
					               $("tbody").append("<tr>"+
					                  "<td>"+str.addr_gu+"</td>"+
					                  "<td>"+str.content_id+"</td>"+
					                  "<td>"+str.content_nm+"</td>"+
					                  "<td>"+str.new_addr+"</td>"+
					                  "<td>"+str.cradle_count+"</td>"+
					                  "<td>"+str.longitude+"</td>"+
					                  "<td>"+str.latitude+"</td>"+
					                  "</tr>"
					               );
					               
					            }
					         }
					         
					      });
				}
				
				
			},
			error:function(){
				alert("data 저장 실패!");
			}
		});
		
		
	});
	
	
}