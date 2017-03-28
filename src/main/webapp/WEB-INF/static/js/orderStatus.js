$(function(){
	var colNames =[ '序列号', '名称', '新建日期','新建人', '更新日期', '更新人' ];
	var colModel = [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'id',index : 'id'}, 
		             {name : 'name',index : 'name'}, 
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "订单状态参数列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
});
