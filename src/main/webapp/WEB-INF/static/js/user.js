$(document).ready(function () {
        $("#jqGrid").jqGrid({
        url: 'all',
		// we set the changes to be made at client side using predefined word clientArray
        editurl: 'clientArray',
        datatype: "json",
        colModel: [
            {
				label: 'id',
                name: 'id',
				key: true,
				editable: false,
				editrules : { required: true}
            },
            {
				label: 'username',
                name: 'username',
                editable: true // must set editable to true if you want to make the field editable
            },
            {
				label : 'email',
                name: 'email',
                editable: true
            },
            {
				label: 'insertDate',
                name: 'insertDate',
            },
            {
				label: 'insertBy',
                name: 'insertBy',
            },
            {
            	label: 'updateDate',
            	name: 'updateDate',
            },
            {
            	label: 'updateBy',
            	name: 'updateBy',
            }
        ],
		sortname: 'id',
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

