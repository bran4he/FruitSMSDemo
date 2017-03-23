$(document).ready(function(){

	$("#loginBtn").on("click", function(){
		console.info("loginBtn click...");
		if(validate()){
			console.info("all validate pass...");
			$("#loginForm").submit();
		}else{
			console.info("validate not pass!");
		}
	});
	
	
});

function validate() {
	
	var username = $("#username").val();
	var password = $("#password").val();
    var authcode = $("#authcode").val();
    
    if (!username) {
        alert('请输入用户名');
        return false;
    }
    
    if(!password){
    	alert('请输入密码');
    	return false;
    }
    
    if (!authcode) {
    	alert('请输入验证码');
    	return false;
    }
    
    var flag = validateCode();
    
    if(!flag){
    	return false;
    }
    
    //validate username and password match
	$.ajax({
		type:"POST",
		async: false,//同步
		dataType:"json",
		url:"verify",
		data:{
			"username": username,
			"password": password
		},
		success: function(data){
			console.log("verify username/password()...");
			console.info(data);
			flag = data.result;
		}
	});
	
	return flag;
}

function validateCode(){
    var flag;
    
	$.ajax({
		type:"POST",
		async: false,//同步
		dataType:"json",
		url:"verifyAuthCode",
		data:{
			"authcode": $("#authcode").val()
		},
		success: function(data){
			console.info("validateCode()...");
			console.info(data);
			flag = data.result;
		}
	});
	
	return flag;
}

function chageCode(){
	var t = new Date();
	$("#codeImage").attr("src", "authcode?time=" + t);
}

window.onload = function () {
	console.log("load...");
}