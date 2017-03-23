$(document).ready(function(){
	$("#user").on("click", function(){
		$.get($(this).attr("action"));
	});
});


window.onload = function () {
	console.log("load...");
}