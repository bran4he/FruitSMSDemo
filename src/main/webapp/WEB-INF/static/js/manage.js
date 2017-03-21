$(document).ready(function () {
        $("#jqGrid").jqGrid({
        url: 'data.json',
		// we set the changes to be made at client side using predefined word clientArray
        editurl: 'clientArray',
        datatype: "json",
        colModel: [
            {
				label: 'Customer ID',
                name: 'CustomerID',
//                width: 75,
				key: true,
				editable: true,
				editrules : { required: true}
            },
            {
				label: 'Company Name',
                name: 'CompanyName',
//                width: 140,
                editable: true // must set editable to true if you want to make the field editable
            },
            {
				label : 'Phone',
                name: 'Phone',
//                width: 100,
                editable: true
            },
            {
				label: 'Postal Code',
                name: 'PostalCode',
//                width: 80,
                editable: true
            },
            {
				label: 'City',
                name: 'City',
//                width: 140,
                editable: true
            }
        ],
		sortname: 'CustomerID',
		sortorder : 'asc',
		loadonce: true,
		viewrecords: true,
        width: 1200,
        height: 200,
        rowNum: 10,
        pager: "#jqGridPager"
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

