$(function(){
	var colNames =[ 'ID', '名称', '值','备注', '新建日期','新建人', '更新日期', '更新人' ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'name',index : 'name'}, 
		             {name : 'value',index : 'value'}, 
		             {name : 'remark',index : 'remark'}, 
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "公共参数列表";
	
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
});

