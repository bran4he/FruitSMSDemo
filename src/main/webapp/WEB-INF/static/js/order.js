$(function(){
	var colNames = [ 'ID', 
	                 'statusId', 
	                 'assignId', 
	                 'orderUnit', 
	                 'fruitId', 
	                 'fruitName', 
	                 
	                 
	                 
	                 'planDeliveryDate', 
	                 'address', 
	                 'contactName', 
	                 'contactPhone', 
	                 'deliveryDate', 
	                 'deliveryBy', 
	                 'deliveryRemark', 
	                 'finishDate', 
	                 'finishBy', 
	                 'finishRemark', 
	                 
	                 'remark', 
	                 'extendData', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'statusId',index : 'statusId'}, 
		             {name : 'assignId',index : 'assignId'}, 
		             {name : 'orderUnit',index : 'orderUnit'}, 
		             {name : 'fruitId',index : 'fruitId'}, 
		             {name : 'fruitName',index : 'fruitName'}, 
		             
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
		             {name : 'extendData',index : 'extendData'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "Order列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
	
	//快速操作
	$("#quickOpt button").on('click', function(){
//		console.info($(this).attr('statusValue'));
		var rows = $("#jqGrid").jqGrid('getGridParam','selarrrow');
		console.info(rows);
		console.info(rows.length);
		var param;
		if(rows.length == 0){
			myInformNoty('请至少选择一行数据');
		}else{
			var ids ='';
			for(var s in rows){
				ids = ids + s +",";
			}
			param = ids.substring(0, ids.length -1);
			console.info("ids:" + param);
			console.info("status:" + $(this).attr('statusValue'));
			
			//request
		    $.ajax({
		    	type: "POST",
		    	url:  $("#jqGrid").attr('mutiUpdateUrl'),
		    	data: {
		    		"ids": param,
		    		"status":$(this).attr('statusValue'),
		    	},
		    	contentType: 'application/json',
		    	dataType: 'json',
		        success: function(data) {
		        	console.log(data);
		        	if(data.result){
		        		jQuery("#jqGrid").trigger("reloadGrid");
		        		var msg = '更新成功,选择'+data.requestCount+'条更新'+data.updateCount+'条';
		    			myNoty(msg, 'success', 1500);
		        	}else{
		        		var msg = '更新失败,选择'+data.requestCount+'条更新'+data.updateCount+'条';
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







