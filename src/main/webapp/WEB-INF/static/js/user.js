$(function(){
	var colNames = [ 'ID', 
	                 'username', 
	                 'password', 
	                 'email', 
	                 '新建日期',
	                 '新建人', 
	                 '更新日期', 
	                 '更新人' 
	                 ];
	var colModel = [
		             {name : 'id',index : 'id'}, 
		             {name : 'username',index : 'username'}, 
		             {name : 'password',index : 'password'}, 
		             {name : 'email',index : 'email'}, 
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







