$(document).ready(function(){
	
	$("a[role='menu']").each(function(index, ele){
		$(ele).on("click", function(){
			console.info(ele);
			$(ele).find('form:first').submit();
		});
	});
	
});


window.onload = function () {
	console.log("load index.js...");
}