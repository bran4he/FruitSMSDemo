$(function(){
	var colNames = [ 'ID', 
	                 '收礼人详细ID',
	                 '收礼人姓名',
	                 '收礼人电话',
	                 
	                 
	                 '订单状态ID', 
	                 '订单状态', 
//	                 '水果ID', 
//	                 '水果', 
//	                 '订单量', 
	                 
	                 
	                 '计划送达时间', 
	                 '地址', 
	                 '联系人', 
	                 '联系电话', 
	                 '送达时间', 
	                 '送达人', 
	                 '送达备注', 
	                 '结束时间', 
	                 '结束人', 
	                 '结束备注', 
	                 
	                 '备注', 
	                 '扩展', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'assignId',index : 'assignId', hidden:true}, 
		             {name : 'slaveName',index : 'slaveName'}, 
		             {name : 'slavePhone',index : 'slavePhone'}, 
		             
		             {name : 'statusId',formatter: formateOrderStatus}, 
		             {name : 'statusId',index : 'statusId', hidden:true}, 
		             
//		             {name : 'fruitId',index : 'fruitId', hidden:true}, 
//		             {name : 'fruitName',index : 'fruitName'}, 
//		             {name : 'orderUnit',index : 'orderUnit'}, 
		             
		             {name : 'planDeliveryDate',index : 'planDeliveryDate'}, 
		             {name : 'address',index : 'address'}, 
		             {name : 'contactName',index : 'contactName'}, 
		             {name : 'contactPhone',index : 'contactPhone'}, 
		             {name : 'deliveryDate',index : 'deliveryDate'}, 
		             {name : 'deliveryBy',index : 'deliveryBy'}, 
		             {name : 'deliveryRemark',index : 'deliveryRemark'}, 
		             {name : 'finishDate',index : 'finishDate'}, 
		             {name : 'finishBy',index : 'finishBy'}, 
		             {name : 'finishRemark',index : 'finishRemark'}, 
		             
		             {name : 'remark',index : 'remark'}, 
		             {name : 'extendData',index : 'extendData', hidden:true}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "订单列表";
	
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	
//	jQuery("#jqGrid").jqGrid({
//		//双击行时触发。
//		//rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
//		ondblClickRow: function(rowId,iRow,iCol,e){
//			console.info('ondblClickRow:' + rowId );
//			initCustomDialog($("#jqGrid").jqGrid('getRowData',rowId));
//		}
//	});
	
	$("#dialog").dialog({ autoOpen: false });
	$("#customDialog").dialog({ autoOpen: false });
	
	//搜索操作相关
	initSelect();
	bindBtnClear();
	bindBtnSearch();
	
	//快速操作
	$("#quickOpt button").on('click', function(){
//		console.info($(this).attr('statusValue'));
		var rowIds = $("#jqGrid").jqGrid('getGridParam','selarrrow');
		console.info(rowIds);
		console.info(rowIds.length);
		var param;
		if(rowIds.length == 0){
			myInformNoty('请至少选择一行数据');
		}else{
			var ids ='';
			for(var i =0; i<rowIds.length; i++){
				var rowData = $("#jqGrid").jqGrid('getRowData',rowIds[i]);
				console.info(rowData);
				ids = ids + rowData.id +",";
			}
			param = ids.substring(0, ids.length -1);
			console.info("ids:" + param);
			console.info("status:" + $(this).attr('statusValue'));
			
			var data = {
	    		"ids": param,
	    		"status":$(this).attr('statusValue')
	    	};
			
			//request
		    $.ajax({
		    	type: "POST",
		    	url:  $("#jqGrid").attr('mutiUpdateUrl'),
//		    	contentType: 'application/json',
		    	dataType: 'json',
//		    	data: JSON.stringify(data),
		    	data: data,	//wrong
//		    	data: "{'ids':" + ids + ", 'status':" + status + "}",
		        success: function(data) {
		        	console.log(data);
		        	if(data.result){
		        		jQuery("#jqGrid").trigger("reloadGrid");
		        		var msg = '更新成功,选择'+data.msg.requestCount+'条更新'+data.msg.updateCount+'条';
		    			myNoty(msg, 'success', 1500);
		        	}else{
		        		var msg = '更新失败,选择'+data.msg.requestCount+'条更新'+data.msg.updateCount+'条';
		        		myNoty("更新失败", 'error', 1500);
		        	}
		        },
		        error: function(xhr) {
		        	myNoty('系统异常, 请联系管理员', 'error', 3000);
		        } 
		    });
			
		}
	});
	
	
	
});

//点击订单详细按钮
function btnCustomClick(){
	var rowId = $("#jqGrid").jqGrid('getGridParam','selrow');
	console.info("update row:" + rowId);
	
	if(!rowId){
		myInformNoty('请选择一行数据');
		return false;
	}
	
	console.info("row id:" + rowId);
	
	//json data
	initCustomDialog($("#jqGrid").jqGrid('getRowData',rowId));
}

function initCustomDialog(rowData){
	console.info(rowData);
	
	var opts = {
			width: $("#customDialog").attr('dialogWidth'),
			height: $("#customDialog").attr('dialogHeight'),
			modal: true,
			open: setCustomDialogData(rowData),
			close: cleanCustomDialog,	//clean #cutomeBody data
			buttons: [
			          {
			        	  text:'关闭',
			        	  icons: {
			        		  primary: "ui-icon-circle-close"
			        	  },
			        	  click: function (){
			        		  $("#customDialog").dialog('close');
			        	  }
			          }
			          ]

	};
	$("#customDialog")
	.dialog(opts)
	.dialog("open");
}

function cleanCustomDialog(){
	console.log("cleanCustomDialog");
	$("#cutomeBody").html("");
}


function setCustomDialogData(rowData){
	console.log("setCustomDialogData");
	
	$.ajax({
		type:"GET",
		dataType:"json",
		url:"../orderDetail/detail/" + rowData.id,
		success:function(data){
			console.info(data);
			var msg = data.msg.data;
			var trs ="";
			for(var i=0; i< msg.length; i++){
				console.log(msg[i]);
				var tr = "<tr><td>"
						+ msg[i].id + "</td><td>"
						+ msg[i].fruitId + "</td><td>"
						+ msg[i].fruitName + "</td><td>"
						+ msg[i].orderUnit + "</td></tr>";
				trs = trs + tr;
			}
			$("#cutomeBody").html(trs);
		},
		error: function(){
			notyCus('加载/orderDetail/detail/列表异常, 请联系管理员', 'notification', 2000);
		}
	});
	
}

//格式化订单状态
function formateOrderStatus(cellValue, options, rowObject){
	console.log("cellValue: " + cellValue);
	switch(cellValue){
	case "1":
		return "待派送";
		break;
	case "2":
		return "派送中";
		break;
	case "3":
		return "派送成功";
		break;
	case "4":
		return "用户取消";
		break;
	case "5":
		return "派送失败";
		break;
	default:
		return "未定义"; 
	}
	
/*	ajax不通过
 * $.ajax({
		type:"GET",
		async: false,//同步
		dataType:"json",
		url:"../orderStatus/all",
		success:function(data){
			console.info(data);
			for(var i=0; i< data.length; i++){
				console.log(data[i].id);
				console.log(data[i].id == cellValue);
				console.log(data[i].name);
				if(data[i].id == cellValue){
					return data[i].name;
				}
			}
			return "未定义";
		},
		error: function(){
			notyCus('加载orderStatus/all列表异常, 请联系管理员', 'notification', 2000);
		}
	});*/
	
}





