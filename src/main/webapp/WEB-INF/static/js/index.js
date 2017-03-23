$(document).ready(function(){
	$("#user").on("click", function(){
		$("#userAction").submit();
	});
	$("#index").on("click", function(){
		$("#indexAction").submit();
	});
});


window.onload = function () {
	console.log("load...");
}