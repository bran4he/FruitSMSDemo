$(function(){
	//页面加载完成之后执行
	
	var colNames = [ 'ID', '用户ID', '用户名','登录日期', '登录IP'];//jqGrid的列显示名字
	
	var colModel = [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
		             {name : 'id',index : 'id'}, 
		             {name : 'userId',index : 'userId'}, 
		             {name : 'username',index : 'username'}, 
		             {name : 'loginDate',index : 'loginDate'}, 
		             {name : 'loginIP',index : 'loginIP'}, 
		           ];
	var caption = "用户登录日志列表";
	jqGridInit(colNames, colModel, caption);
	
	$("#dialog").dialog({ autoOpen: false });
});
