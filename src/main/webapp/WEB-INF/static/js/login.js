$(document).ready(function(){
	//get captcha when page loaded
	getImgCode();
	$("#getImgCode").on('click', getImgCode);
	$("#login").on('click', login);
	
	//register
	$("#regist").on('click', function(){
		window.location.href = $("#regist").attr("url");
	});
});
	
function getImgCode() {
	$.ajax({
		type:"get",
		dataType:"json",
		url:"code",
		success: function(data){
			console.log(data);
			$("#imgUrl").attr("src","..//"+data.captchaName);
		}
	});
}

function login() {
	var username = $("#username").val();
	var password = $("#password").val();
	var code = $("#imgcode").val();
	console.log(username, password, code);
	
	$.ajax({
		type:"get",
		dataType:"json",
		url:"login?username="+username+"&password="+password+"&imgcode="+code,
		success: function(data){
			console.log(data);
			if(data.logined){
				console.info("go to charts");
				window.location.href = "gocharts";
			}else{
				alert(data.logined +": login failed!");
			}
		}
	});
	
}

window.onload = function () {
	console.log("load...");
}