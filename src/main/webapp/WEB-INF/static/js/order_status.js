$(document).ready(function () {
//	var json_data;
//	$.ajax({
//		url:'data.json', 
//		type:'get',
//		dataType:'json',
//		success: function(data){
//		console.info(data);
//		loadData(data);
//	}});
	
//	function loadData(mydata){
//	}		
		$("#jqGrid").jqGrid({
        url: 'all',
//			data: mydata,
			// we set the changes to be made at client side using predefined word clientArray
			editurl: 'clientArray',
			datatype: "json",
			colModel: [
			           {
			        	   label: 'Code Value',
			        	   name: 'id',
			        	   width: 20,
			        	   editable: false // must set editable to true if you want to make the field editable
			           },
			           {
			        	   label : 'Code Desc',
			        	   name: 'name',
			        	   width: 90,
			        	   editable: true
			           }
			           ],
//			           sortname: 'id',
//			           sortorder : 'asc',
			           loadonce: true,
			           viewrecords: true,
			           width: 780,
			           height: 200,
			           rowNum: 10,
			           pager: "#jqGridPager",
			           // set caption to any string you wish and it will appear on top of the grid
			           caption: "Order Status Settings"
		});

	

    $('#jqGrid').navGrid('#jqGridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
            editCaption: "The Edit Dialog",
            recreateForm: true,
			checkOnUpdate : true,
			checkOnSubmit : true,
            closeAfterEdit: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            closeAfterAdd: true,
            recreateForm: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        });
});

