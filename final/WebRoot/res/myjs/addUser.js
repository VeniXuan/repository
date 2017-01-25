$(document).on("click","#reg",function(e){
   
	//get data
	var name=$("#NA").val();
	var gender=$("#GD").val();
	var email=$("#EM").val();
	var password=$("#PW").val();
	var mobile=$("#MB").val();
	alert("Infor Received!\n"+"name:"+name);
	var method="add.html";
	var	data={
			"name":name,
			"gender":gender,
			"mobile":mobile,
			"email":email,
			"password":password
		};	
	
	ope(method,data);

});
// login button click
$(document).on("click","#login",function(e){
	 
	//get data
	var un=$("#LNA").val();
	var pw=$("#PWD").val();
	var method="check.html";
	var	data={
			"name":un,
			"password":pw
		};	
	var htmlRes= $.ajax({
		url:method,
		contentTypr:"application/x-www-form-urlencoded;charset=uft-8",
		type:"post",
		data:data,	
		async:false
	});
	var text=htmlRes.responseText;
	
	
	if(text=='true')
	{	
	window.location="account.html"
	
	}else{	
		
		window.location="register.html"
		}

});


function ope(method,data){

	var htmlRes= $.ajax({
		url:method,
		contentTypr:"application/x-www-form-urlencoded;charset=uft-8",
		type:"post",
		data:data,	
		async:false
	});
	var text=htmlRes.responseText;
	//alert(text);
	if(text=='true')
	{	$("#tipMessage").html("Operation Succeed");		
	}else{
		$("#tipMessage").html("Operation failed");	
	}
	$("#tip").modal();
	//refresh
	location.reload(true);
}

