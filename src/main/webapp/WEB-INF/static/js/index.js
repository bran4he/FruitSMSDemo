$(document).ready(function(){

	
	
	$("a[role='menu']").each(function(index, ele){
		$(ele).on("click", function(){
			console.info(ele);
			$(ele).find('form:first').submit();
		});
	});
	
});


//日期反格式化  - 公用方法
function unFormateUpdateDate(cellValue, options, rowObject){  
    var d = new Date(cellValue);
    return d.toString('yyyy-MM-dd HH:mm:ss');  
}

//customized noty
function myNoty(text, type, timeout){
	noty({
		text: text,
		type: type,
		timeout: timeout
	});	
}


function myInformNoty(text,layout){
	var tmpLayout = 'center';
	if(layout){
		tmpLayout = layout;
	}
	noty({
		text: text,
		modal: true,
		layout: tmpLayout,
		buttons: [
		          {
		        	  addClass: 'btn btn-primary', 
		        	  text: '确定', 
		        	  onClick: function($noty) {
		        	  // this = button element 也就是当前的按钮
		        	  // $noty = $noty element 也就是当前这个提示信息对象
		        	  $noty.close();
		        	  }
		          }
		          ]
	});	
}

//form to js json object
function formToJson(form){
	var arr = form.serializeArray();
	var formObject = {};
	$.each(arr, function(i, v){
		formObject[v.name] = v.value;
	});
	return formObject
}




window.onload = function () {
	console.log("load index.js...");
}