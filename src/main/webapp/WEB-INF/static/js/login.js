$(document).ready(function(){
	// 绑定表单提交事件处理器
	$('#loginForm').submit(function() {
		// prepare Options Object
		var options = {
			success: function(){
				console.info('login success!');
			},
			beforeSubmit:validate
		};
	    // 提交表单
	    $(this).ajaxSubmit(options);
	    // 为了防止普通浏览器进行表单提交和产生页面导航（防止页面刷新？）返回false
//	    return false;
	   });
	
});

function validate(formData, jqForm, options) {
	
	//validate username and password not null
	var username = $("#username").val();
	var password = $("#password").val();

    if (!username || !password) {
        alert('请输入用户名和密码');
        return false;
    }
    console.log('用户名和密码已经输入');
    
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
			console.log(data);
			flag = data.result;
		}
	});
	
	return flag;
}

function validateCode(){
    var flag;
    
    var authcode = $("#authcode").val();
    
    if (!authcode) {
        alert('请输入验证码');
        return false;
    }
    console.log('验证码已经输入');
    
	$.ajax({
		type:"POST",
		async: false,//同步
		dataType:"json",
		url:"verifyAuthCode",
		data:{
			"authcode": $("#authcode").val()
		},
		success: function(data){
			console.log(data);
			flag = data.result;
		}
	});
	
	return flag;
}



window.onload = function () {
	console.log("load...");
}