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
});







