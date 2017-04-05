$(function(){
	var colNames = [ 'ID', 
	                 'assignId',
	                 'isVirtual',
	                 
	                 'unitUpdate',
	                 
	                 'masterPhone', 
	                 'masterName', 
	                 'slavePhone', 
	                 'slaveName', 
	                 
	                 'remark', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             
		             {name : 'assignId',index : 'assignId'}, 
		             {name : 'isVirtual',index : 'isVirtual'}, 
		             
		             {name : 'unitUpdate',index : 'unitUpdate'},
		             
		             {name : 'masterPhone',index : 'masterPhone'}, 
		             {name : 'masterName',index : 'masterName'}, 
		             {name : 'slavePhone',index : 'slavePhone'}, 
		             {name : 'slaveName',index : 'slaveName'}, 
		             
		             {name : 'remark',index : 'remark'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "assignDetail列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
});







