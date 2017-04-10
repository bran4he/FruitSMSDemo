$(function(){
	var colNames = [ 'ID', 
	                 '收礼详细ID',
	                 
	                 '送礼人号码', 
	                 '送礼人手机', 
	                 '收礼人手机', 
	                 '收礼人号码', 
	                 
	                 '虚拟号码',
	                 '虚拟号码2',
	                 
	                 '增加量',
	                 
	                 '备注', 
	                 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'assignId',index : 'assignId'}, 
		             
		             {name : 'masterPhone',index : 'masterPhone'}, 
		             {name : 'masterName',index : 'masterName'}, 
		             {name : 'slavePhone',index : 'slavePhone'}, 
		             {name : 'slaveName',index : 'slaveName'}, 
		             
		             {name : 'isVirtual',index : 'isVirtual',formatter:  formateYesOrNo}, 
		             {name : 'isVirtual',index : 'isVirtual', hidden:true}, 
		             
		             {name : 'unitUpdate',index : 'unitUpdate'},
		             
		             
		             {name : 'remark',index : 'remark'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "送礼详细列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
	
	//搜索操作相关
	initSelect();
	bindBtnClear();
	bindBtnSearch();
});







