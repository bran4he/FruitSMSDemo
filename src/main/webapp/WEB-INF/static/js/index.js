$(document).ready(function(){

	//搜索的select和input联调机制
	$("#search select").each(function(idx, ele){
		$(ele).on('change', function(){
			console.info('选择了：'+$(this).val());
			$(this).prev().val($(this).val());
		});
	});
	
	
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

//格式化是和否
function formateYesOrNo(cellValue, options, rowObject){
	if(cellValue == '0'){
		return '否';
	}
	return '是';
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

//查看时触发【复制jqgrid内容到对话框】
//setup datetime picker
function setViewDialogData(rowData){
	
	$("#form input, textarea").each(function(idx, ele){
		//input and remark
		var name = $(ele).attr('name');
		if(name){
			$(ele).val(rowData[name]);
		}
		
		//date time picker
		var dateFlag = $(ele).attr('dateFlag');
		if(dateFlag){
			$(ele).prop("readOnly", true)
			.datetimepicker({
				dateFormat: "yy-mm-dd",
				timeFormat: "HH:mm:ss",
				showButtonPanel: true,
				showHour: true,
				showMinute: true,
				showSecond: true
			});
		}
		
	});
	
	
	//根据input初始化checkbox的状态
	$("#form :checkbox").each(function(idx, ele){
		console.info($(this).prev().val());
		
		if('1' == $(this).prev().val()){
			$(this).prop('checked', true);
			$(this).prev().val(1);
		}else{
			$(this).prop('checked', false);
			$(this).prev().val(0);
		}
	});
	
}


//编辑时触发【复制jqgrid内容到对话框】
//setup datetime picker
function setDialogData(rowData){
	
	$("#form input, textarea").each(function(idx, ele){
		//input and remark
		var name = $(ele).attr('name');
		if(name){
			$(ele).val(rowData[name]);
		}
		
		//date time picker
		var dateFlag = $(ele).attr('dateFlag');
		if(dateFlag){
			$(ele).prop("readOnly", true)
				.datetimepicker({
					dateFormat: "yy-mm-dd",
					timeFormat: "HH:mm:ss",
					showButtonPanel: true,
					showHour: true,
					showMinute: true,
					showSecond: true
				});
		}
		
	});
	
	
	//根据input初始化checkbox的状态
	$("#form :checkbox").each(function(idx, ele){
		console.info($(this).prev().val());
		
		if('1' == $(this).prev().val()){
			$(this).prop('checked', true);
			$(this).prev().val(1);
		}else{
			$(this).prop('checked', false);
			$(this).prev().val(0);
		}
	});
	
	//虚拟号码特殊check
//	+ slavePhone允许编辑，新建是为真实，编辑时仍为真实
	$("#form").find(".specialCheck").each(function(){
		console.log($(this));
		if($(this).prop('checked')){
			console.info('is v');
			$(this).attr('disabled',true);
		}else{
			console.info('not v');
//	+ 新建时虚拟，编辑时强制虚拟号码改为真实号码
			$(this).prop('checked', true);
			$(this).prev().val(1);
			$(this).attr('disabled',true);
		}
		
	});
	
	//class = editForbidden, cannot edit
	$("#form .editForbidden").each(function(){
		$(this).prop("readOnly", true);
	});
	
	bindCheckBoxEvt();
}

//【清除对话框内容】，防止再次加载
function cleanDialog(){
	$("#form input, textarea").each(function(idx, ele){
		var name = $(ele).attr('name');
		var type = $(ele).attr('type');
		if(name){
			if(type == 'checkbox'){
				$(ele).prop("checked", false);
			}else{
				$(ele).val('');
			}
		}
	});
}

//初始化【新建对话框】
function initAddDialog(){
	
	$("#form input").each(function(idx, ele){
		
		//date time picker
		var dateFlag = $(ele).attr('dateFlag');
		if(dateFlag){
			$(ele).prop("readOnly", true)
				.datetimepicker({
					dateFormat: "yy-mm-dd",
					timeFormat: "HH:mm:ss",
					showButtonPanel: true,
					showHour: true,
					showMinute: true,
					showSecond: true
				});
		}
		
	});
	
	
	
	//新建窗口时默认为非虚拟号，即input value=0
	$("#form :checkbox").each(function(idx, ele){
		//允许修改，防止编辑时携带的属性仍然在
		$(this).attr('disabled',false);
		$(this).prop('checked', false);
		$(this).prev().val(0);
	});
	
	bindCheckBoxEvt();
}

//绑定checkbox的点击事件
function bindCheckBoxEvt(){
	
	$("#form :checkbox").change(function(){
		if($(this).prop("checked")){
			$(this).prev().val(1);
		}else{
			$(this).prev().val(0);
		}
	});
}


//初始化【查看对话框】
function initViewDialog(rowData){
	console.info(rowData);
	
	var opts = {
			width: $("#dialog").attr('dialogWidth'),
			height: $("#dialog").attr('dialogHeight'),
			modal: true,
			open: setViewDialogData(rowData), //auto set data from jqgrid to dialog
			close: cleanDialog,	//close auto remove input value
			buttons: [
			          {
			        	  text:'关闭',
			        	  icons: {
			        		  primary: "ui-icon-circle-close"
			        	  },
			        	  click:btnCancle
			          }
			          ]

	};
	$("#dialog")
	.dialog(opts)
	.dialog("open");
}
//初始化【编辑对话框】
function initUpdateDialog(rowData){
	console.info(rowData);
	
	var opts = {
			width: $("#dialog").attr('dialogWidth'),
			height: $("#dialog").attr('dialogHeight'),
			modal: true,
			open: setDialogData(rowData), //auto set data from jqgrid to dialog
			close: cleanDialog,	//close auto remove input value
			buttons: [
			          {
							text:'取消',
							icons: {
						        primary: "ui-icon-help"
						      },
						      click:btnCancle
						},{
							text:'保存',
							icons: {
						        primary: "ui-icon-check"
						      },
						      click:btnOk
						}
			          ]
//			{
//					"取消": btnCancle,
//					"保存": btnOk
//			   }
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
			open: initAddDialog,
			close: cleanDialog,	//close auto remove input value
			buttons: [
			          {
							text:'取消',
							icons: {
						        primary: "ui-icon-help"
						      },
						      click:btnCancle
						},{
							text:'保存',
							icons: {
						        primary: "ui-icon-check"
						      },
						      click:btnOk
						}
			          ]
	};
	$("#dialog")
		.dialog(opts)
		.dialog("open");
}

//点击jqgird【查看】按钮
function btnViewClick(){
	
	var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
	console.info("update row:" + rowId);
	
	if(!rowId){
		myInformNoty('请选择一行数据');
		return false;
	}
	
	console.info("row id:" + rowId);
	
	//json data
	initViewDialog($("#jqGrid").jqGrid('getRowData',rowId));
}

//点击jqgird【编辑】按钮
function btnUpdateClick(){

	var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
	console.info("update row:" + rowId);
	
	if(!rowId){
		myInformNoty('请选择一行数据');
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
        		jQuery("#jqGrid").trigger("reloadGrid"); 
//        		jQuery("#jqGrid").jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid');
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
	
	//校验必填选项
	var pass = true;
	$("#form input, textarea").each(function(idx, ele){
		if($(ele).attr('required') && !$(ele).val()){
			pass = false;
			myNoty($(ele).attr('name') + "是必填项", 'warning', 1500);
		}
	});
	
	if(!pass){
		return false;
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
        		jQuery("#jqGrid").trigger("reloadGrid"); 
//        		jQuery("#jqGrid").jqGrid('setGridParam', { datatype: 'json' }).trigger('reloadGrid');
        		myNoty('保存成功', 'success', 1500);
        	}else{
        		console.warn("更新失败！");
        		if(data.code){
        			myNoty(data.code + ',保存失败', 'error', 2000);
        		}else{
        			myNoty('保存失败', 'error', 1500);
        		}
        		
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

//init jqgrid
function jqGridInit(colNames, colModel, caption){
	//创建jqGrid组件
	jQuery("#jqGrid").jqGrid(
			{
				width: jQuery("#jqGrid").attr('twidth'),
				height: jQuery("#jqGrid").attr('theight'),
				url : 'list',
				datatype : "json",
				//jqGrid的列显示名字
				colNames : colNames,
				//jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				colModel : colModel,
	           jsonReader : {  
	        	    root: "list",   // json中代表实际模型数据的入口  
	        	    page: "pageNo",   // json中代表当前页码  
	        	    total: "totalPage", // json中代表页码总数
	        	    records: "totalRow", // json中代表数据行总数的数据
	        	},
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#jqGridPager',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				multiselect: $("#jqGrid").attr('multiselect'),//多选
//				loadonce:true,
				caption : caption //表格的标题名字
			});
	
	jQuery("#jqGrid").jqGrid('navGrid','#jqGridPager', 
		{
		edit: false,
        add : false,
        del : false,
        search :false,
        refresh: false
        }
	)
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	if($("#jqGrid").attr("addCaption")){
		jQuery("#jqGrid").jqGrid('navButtonAdd', '#jqGridPager',{
			id:"add",
			caption:$("#jqGrid").attr("addCaption"),
			buttonicon:"ui-icon-plus",
			onClickButton: btnAddClick,
			position:"last"
		})
	}
	

	
	if($("#jqGrid").attr("updateCaption")){
		jQuery("#jqGrid").jqGrid('navButtonAdd', '#jqGridPager',{
			id:"update",
			caption:$("#jqGrid").attr("updateCaption"),
			buttonicon:"ui-icon-pencil",
			onClickButton: btnUpdateClick,
			position:"last"
		})
	}
	
	if($("#jqGrid").attr("deleteCaption")){
		jQuery("#jqGrid").jqGrid('navButtonAdd','#jqGridPager',{
			id:"delete",
			caption:$("#jqGrid").attr("deleteCaption"),   
			buttonicon:"ui-icon-minus",   
			onClickButton: btnDeleteClick,   
			position:"last"  
		})
	}

	if($("#jqGrid").attr("viewCaption")){
		jQuery("#jqGrid").jqGrid('navButtonAdd', '#jqGridPager',{
			id:"view",
			caption:$("#jqGrid").attr("viewCaption"),
			buttonicon:"ui-icon-zoomin",
			onClickButton: btnViewClick,
			position:"last"
		})
	}
	if($("#jqGrid").attr("customCaption")){
		jQuery("#jqGrid").jqGrid('navButtonAdd', '#jqGridPager',{
			id:"custom",
			caption:$("#jqGrid").attr("customCaption"),
			buttonicon:"ui-icon-cart",
			onClickButton: btnCustomClick,
			position:"last"
		})
	}

//	.jqGrid('navButtonAdd','#jqGridPager',{
//		id:"refresh",
//		caption:"刷新",   
//		buttonicon:"ui-icon-refresh",   
//		onClickButton: function(){   
//			$(this).trigger("reloadGrid");  
//		},   
//		position:"last"  
//	})
	;
}


//触发检索
function bindBtnSearch(){
	$("#btnSearch").on('click', function(){
		var searchData = formToJson($("#search"));
		
		console.info("searchData:");
		console.info(searchData);
//		var searchData = {"statusId": "2"};
		
		$("#jqGrid").jqGrid('setGridParam',{
			search: true,
			postData:searchData,
			page: 1
		})
		.trigger('reloadGrid');
		
	});
}

//清除检索
function bindBtnClear(){
	$("#btnClear").on('click', function(){
		$("#search input").each(function(idx, ele){
			$(ele).val('');
		});
		$("#search select").each(function(idx, ele){
			$(ele).val(0);
		});
		location.reload();
	});
}


//检索创建select时加载list
function initSelect(){
	
	$("#search select").each(function(idx, ele){
		var name = $(this).attr("keyName");
		var value =$(this).attr("keyValue");
		var $select = $(ele);
		$.ajax({
			type:"GET",
			dataType:"json",
			url:$select.attr("url"),
			success:function(data){
				console.info(data);
				$select.append(CreateOpt("请选择一项", ""));	//必须设置为空，不然会携带值进入检索条件
				for(var i=0; i< data.length; i++){
//					console.log(data[i]);
//					console.log(data[i].id);
					$select.append(CreateOpt(data[i][name], data[i][value]));
				}
			},
			error: function(){
				notyCus('记载'+$select.attr("url")+'列表异常, 请联系管理员', 'notification', 2000);
			}
		});
	});
	

}

//用于检索select创建dom
function CreateOpt(name, value){
	return $("<option value='"+value+"'>"+name+"</option>");
}

function notyCus(text, type, timeout){
	noty({
		text: text,
		type: type,
		timeout: timeout
	});	
}

window.onload = function () {
	console.log("load index.js...");
}