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

//编辑时触发【复制jqgrid内容到对话框】
function setDialogData(rowData){
	$("#form input").each(function(idx, ele){
		var name = $(ele).attr('name');
		console.info(name);
		if(name){
			$(ele).val(rowData[name]);
		}
	});
}

//【清除对话框内容】，防止再次加载
function cleanDialog(){
	$("#form input").each(function(idx, ele){
		var name = $(ele).attr('name');
		if(name){
			$(ele).val('');
		}
	});
}

//初始化【编辑对话框】
function initUpdateDialog(rowData){
	console.info(rowData);
	console.info(rowData.id);
	console.info(rowData.name);
	
	var opts = {
			width: $("#dialog").attr('dialogWidth'),
			height: $("#dialog").attr('dialogHeight'),
			modal: true,
			open: setDialogData(rowData), //auto set data from jqgrid to dialog
			close: cleanDialog,	//close auto remove input value
			buttons: {
					"取消": btnCancle,
					"保存": btnOk
			   }
	};
	$("#dialog")
		.dialog(opts)
		.dialog("open");
}

//点击jqgird【新建】按钮,初始化【新建对话框】
function btnAddClick(){
	
	var opts = {
			width: $("#dialog").attr('dialogWidth'),
			height: $("#dialog").attr('dialogHeight'),
			modal: true,
			close: cleanDialog,	//close auto remove input value
			buttons: {
					"取消": btnCancle,
					"保存": btnOk
			   }
	};
	$("#dialog")
		.dialog(opts)
		.dialog("open");
}

//点击jqgird【编辑】按钮
function btnUpdateClick(){

	var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
	console.info("update row:" + rowId);
	
	if(!rowId){
		myInformNoty('请选择一行数据操作');
		return false;
	}
	
	console.info("row id:" + rowId);
	
	//json data
	initUpdateDialog($("#jqGrid").jqGrid('getRowData',rowId));
}

//点击jqgird【删除】按钮
function btnDeleteClick(){
	console.log("this is del operation");
	
	var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
	console.info("del row:" + rowId);
	if(!rowId){
		myInformNoty('请选择一行数据操作');
		return false;
	}

	var operFlag = false;
	noty({
		text: '确认继续操作?',
		modal: true,
		layout: 'center',
		buttons: [
		          {addClass: 'btn btn-primary', text: '确定', onClick: function() {
		              // this = button element 也就是当前的按钮
		              // $noty = $noty element 也就是当前这个提示信息对象
		        	  operFlag = true;
		            }
		          },
		          {addClass: 'btn btn-danger', text: '取消', onClick: function() {
		        	  operFlag = false;
		            }
		          }
		        ],
		 callback: {
			 onClose: function(){
				 console.log("callback:onClose");
				 if(operFlag){
					 del(rowId);
				 }
			 }
		 }
	});	

	
}

//点击【确定删除】内容事件
function del(rowId){
	var postUrl = $("#form").attr('deleteAction');

	//update
    $.ajax({
    	type: "GET",
    	url:  postUrl + "/" + rowId,
    	contentType: 'application/json',
    	dataType: 'json',
        success: function(data) {
        	console.log(data);
        	if(data.result){
        		console.info("删除成功");
        		jQuery("#jqGrid").jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid');
//        		jQuery("#jqGrid").trigger("reloadGrid"); 
//    			location.reload(true);
    			myNoty('删除成功', 'success', 1500);
        	}else{
        		console.warn("删除失败！");
        		myNoty("删除失败", 'error', 1500);
        	}
        },
        error: function(xhr) {
        	myNoty('系统异常, 请联系管理员', 'error', 3000);
        } 
    });
}

//点击新建和更新窗口的【确认】按钮事件
function btnOk(){
	console.log("click ok save btn");
	//判断是update还是save
	var idValue = $("#form [name=id]").val();
	console.log(idValue);
	
	var postData = JSON.stringify(formToJson($("#form")));
	var postUrl;
	
	
	if($("#form [name=id]").val()){
		console.log("this is update operation");
		
		postUrl = $("#form").attr('updateAction');
		console.log(postData);
		console.log(postUrl);
	}else{
		//add
		console.log("this is add operation");
		var postUrl = $("#form").attr('addAction');
	}
	
    $.ajax({
    	type: "POST",
    	url:  postUrl,
    	data: postData,
    	contentType: 'application/json',
    	dataType: 'json',
        success: function(data) {
        	console.log(data);
        	if(data.result){
        		console.info("更新成功");
        		$("#dialog").dialog('close');
//        		location.reload(true);
//        		jQuery("#jqGrid").trigger("reloadGrid"); 
        		jQuery("#jqGrid").jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid');
        		myNoty('保存成功', 'success', 1500);
        	}else{
        		console.warn("更新失败！");
        		myNoty('保存失败', 'error', 1500);
        		
        	}
        },
        error: function(xhr) {
        	myNoty('系统异常, 请联系管理员', 'error', 3000);
        }
    });
}

//点击新建和更新窗口的【取消】按钮事件
function btnCancle(){
	$("#dialog").dialog('close');
}

window.onload = function () {
	console.log("load index.js...");
}