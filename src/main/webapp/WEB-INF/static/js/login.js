$(document).ready(function(){
	
	$("#loginBtn").on("click", function(){
		console.info("loginBtn click...");
		if(validate()){
			console.info("all validate pass...");
			
			$("#loginForm").submit();
//影响用户体验			
//			var n = notyCus('登录成功', 'success', 800);
//			setTimeout(function(){
//				console.log("================")
//				$("#loginForm").submit();
//			} , 2000);
			
		}else{
			console.info("validate not pass!");
		}
	});
	
	
});

function notyCus(text, type, timeout){
	noty({
		text: text,
		type: type,
		timeout: timeout
	});	
}


function validate() {
	
	var username = $("#username").val();
	var password = $("#password").val();
    var authcode = $("#authcode").val();
    
    if (!username) {
    	notyCus('请输入用户名', 'warning', 1500);
        return false;
    }
    
    if(!password){
    	notyCus('请输入密码', 'warning', 1500);
    	return false;
    }
    
    if (!authcode) {
    	notyCus('请输入验证码', 'warning', 1500);
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
			if(!flag){
				notyCus('用户名或密码错误', 'error', 2000);
			}
		},
		error: function(){
			notyCus('系统异常, 请联系管理员', 'notification', 2000);
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
			if(!flag){
				notyCus('验证码错误, 请重新输入', 'error', 2000);
			}
		},
		error: function(){
			notyCus('系统异常, 请联系管理员', 'notification', 2000);
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