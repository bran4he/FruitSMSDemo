$(function(){
	var colNames =[ 'ID', 
	                '水果', 
	                '产地',
	                '月份', 
	                '最大订单日', 
	                '一单最大量', 
	                '供应量', 
	                
	                '备注',
	                '扩展', 
	                '新建日期',
	                '新建人', 
	                '更新日期', 
	                '更新人' ];
	var colModel = [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'id',index : 'id'}, 
		             {name : 'fruitName',index : 'fruitName'}, 
		             {name : 'fruitArea',index : 'fruitArea'}, 
		             {name : 'fruitMonth',index : 'fruitMonth'}, 
		             {name : 'maxOrderDay',index : 'maxOrderDay'}, 
		             {name : 'maxOrderNum',index : 'maxOrderNum'}, 
		             {name : 'maxProvNum',index : 'maxProvNum'},
		             
		             {name : 'remark',index : 'remark'}, 
		             {name : 'extendData',index : 'extendData'}, 
		             
		             {name : 'insertDate',index : 'insertDate'}, 
		             {name : 'insertBy',index : 'insertBy'}, 
		             {name : 'updateDate',index : 'updateDate'}, 
		             {name : 'updateBy',index : 'updateBy'}
		           ];
	var caption = "水果配置参数列表";
	//页面加载完成之后执行
	jqGridInit(colNames, colModel, caption);
	$("#dialog").dialog({ autoOpen: false });
	
	//搜索操作相关
	initSelect();
	bindBtnClear();
	bindBtnSearch();
});
