$(function(){
	var colNames = [ 'ID', 
	                 '虚拟号', 
	                 '虚拟号2', 
	                 '收礼人号码',
	                 '收礼人姓名', 
	                 '激活',
	                 '激活2',
	                 '微信ID', 
	                 
	                 '初始量', 
	                 '余额', 
	                 '生效期(年)', 
	                 '过期时间', 
	                 '备注', 
	                 '扩展', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'isVirtual',index : 'isVirtual',formatter:  formateYesOrNo}, 
		             {name : 'isVirtual', hidden:true}, 
		             {name : 'slavePhone',index : 'slavePhone'}, 
		             {name : 'slaveName',index : 'slaveName'}, 
		             {name : 'isActive',index : 'isActive',formatter:  formateYesOrNo}, 
		             {name : 'isActive', hidden:true}, 
		             {name : 'weecharOpenid',index : 'weecharOpenid'}, 
		             
		             {name : 'initialUnit',index : 'initialUnit'}, 
		             {name : 'balanceUnit',index : 'balanceUnit'}, 
		             {name : 'effectivePeriod',index : 'effectivePeriod'}, 
		             {name : 'expireDate',index : 'expireDate'}, 
		             {name : 'remark',index : 'remark'}, 
		             {name : 'extendData',index : 'extendData'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "收礼详细列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
	
	//搜索操作相关
	initSelect();
	bindBtnClear();
	bindBtnSearch();
});







