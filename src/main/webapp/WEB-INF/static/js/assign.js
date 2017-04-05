$(function(){
	var colNames = [ 'ID', 
	                 'isVirtual', 
	                 'slavePhone',
	                 'isActive',
	                 
	                 'slaveName', 
	                 'initialUnit', 
	                 'balanceUnit', 
	                 'weecharOpenid', 
	                 'effectivePeriod', 
	                 'expireDate', 
	                 'remark', 
	                 'extendData', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'isVirtual',index : 'isVirtual'}, 
		             {name : 'slavePhone',index : 'slavePhone'}, 
		             {name : 'isActive',index : 'isActive'}, 
		             
		             {name : 'slaveName',index : 'slaveName'}, 
		             {name : 'initialUnit',index : 'initialUnit'}, 
		             {name : 'balanceUnit',index : 'balanceUnit'}, 
		             {name : 'weecharOpenid',index : 'weecharOpenid'}, 
		             {name : 'effectivePeriod',index : 'effectivePeriod'}, 
		             {name : 'expireDate',index : 'expireDate'}, 
		             {name : 'remark',index : 'remark'}, 
		             {name : 'extendData',index : 'extendData'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "assign列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
});







