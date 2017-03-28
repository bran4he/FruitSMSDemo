$(function(){
	//页面加载完成之后执行
	pageInit();
	$("#dialog").dialog({ autoOpen: false });
});
function pageInit(){
	//创建jqGrid组件
	jQuery("#jqGrid").jqGrid(
			{
				width: jQuery("#jqGrid").attr('twidth'),
				height: jQuery("#jqGrid").attr('theight'),
				url : 'all',
				datatype : "json",
				colNames : [ 'ID', 'userId', 'username','loginDate', 'loginIP'],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'id',index : 'id'}, 
				             {name : 'userId',index : 'userId'}, 
				             {name : 'username',index : 'username'}, 
				             {name : 'loginDate',index : 'loginDate'}, 
				             {name : 'loginIP',index : 'loginIP'}, 
				           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#jqGridPager',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				loadonce:true,
				caption : "订单状态参数列表"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#jqGrid")
	.jqGrid('navGrid','#jqGridPager', 
		{
		edit: false,
        add : false,
        del : false,
        search :false,
        refresh: false
        }
	);
}
