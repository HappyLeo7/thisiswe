/**
 * 
 */
 
 
 function clubNameCheck(){
 var clubName= $(".clubName").val();
	console.log("중복체크할 모임이름 : "+clubName);
	
	
	$.ajax({
		url: "/thisiswe/club/clubNameCheck",
		method : "POST",
		data: JSON.stringify({clubName:clubName}),
		contentType:"application/json; charset=UTF-8",
		dataType:"text",
		success: function(result){
			console.log("성공 콘솔 : "+result);
			
			if(result=="success"){
				alert("중복되는 모임명이 있습니다.")
			}
			else{
				
			alert(result+" : 사용가능한 모임명 입니다.");
			}
			
		}
		,
		error : function(result){
			console.log("에러 콘솔 : "+result[0]);
			alert("이미있는 모임명 입니다.")
		}
		
		
		
	})
	
}