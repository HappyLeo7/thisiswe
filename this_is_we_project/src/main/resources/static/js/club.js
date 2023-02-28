/**
 * 
 */
 
 
 function clubNameCheck(){
 var clubName= $(".clubName").val();
	console.log("중복체크 모임이름 : "+clubName);
	
	
	$.ajax({
		url: "/thisiswe/club/clubNameCheck",
		method : "POST",
		data:JSON.stringify({clubName:clubName}),
		contentType:"application/json; charset=UTF-8",
		dataType:"json",
		success : function(result){
			console.log("??: "+result);
			/*
			if(result=="success"){
				alert("중복되는 모임명이 있습니다.")
			}
			*/
			alert("사용가능한 모임명 입니다.");
		},
		error : function(result){
			console.log(result);
			alert("이미있는 모임명 입니다.")
		}
		
		
		
	})
	
}