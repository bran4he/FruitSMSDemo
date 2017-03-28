$(function(){
	//页面加载完成之后执行
	pageInit();
});
function pageInit(){
//	console.log(jQuery("#jqGrid").attr('width'));
	//创建jqGrid组件
	jQuery("#jqGrid").jqGrid(
			{
				width: jQuery("#jqGrid").attr('twidth'),
				height: jQuery("#jqGrid").attr('theight'),
				url : 'all',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				colNames : [ '序列号', '水果名', '水果月份', '可订时间', '产地','最大可订', '总数', '补充', 
				             '新建日期','新建', '更新日期', '更新' ],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'id',index : 'id',width : 55}, 
				             {name : 'fruitName',index : 'fruitName',width : 80}, 
				             {name : 'fruitMonth',index : 'fruitMonth',width : 100, formatter:unFormateUpdateDate}, 
				             {name : 'maxOderDay',index : 'maxOderDay',width : 100, formatter:unFormateUpdateDate}, 
				             
				             {name : 'fruitArea',index : 'fruitArea'}, 
				             {name : 'maxOrderNum',index : 'maxOrderNum'}, 
				             {name : 'maxProvNum',index : 'maxProvNum'}, 
				             
				             {name : 'remark',index : 'remark'}, 
				             
				             {name : 'insertDate',index : 'insertDate',width : 100, formatter:unFormateUpdateDate,sortable : true}, 
				             {name : 'insertBy',index : 'insertBy',width : 80,sortable : false}, 
				             {name : 'updateDate',index : 'updateDate',width : 100, formatter:unFormateUpdateDate,sortable : true}, 
				             {name : 'updateBy',index : 'updateBy',width : 80, sortable : false}
				           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#jqGridPager',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				loadonce:true,
				caption : "水果列表"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#jqGrid").jqGrid('navGrid', '#jqGridPager', 
		{
        edit: true,
        add : true,
        del : true,
//        search :true,
//        searchtext: "查找",
        addtext: "新建",
        edittext: "编辑",
        deltext: "删除",
        refreshtext:"刷新"
		}
	);
//	jQuery("#jqGrid").jqGrid('inlineNav', "#jqGridPager");
}
