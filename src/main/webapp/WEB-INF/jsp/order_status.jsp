<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>jqGrid Loading Data - JSON</title>
	
	<meta http-equiv="Content-Type" content="text/html; UTF-8" charset="utf-8">
	<script type="text/javascript" src="../static/js/jquery/jquery-1.10.0-min.js"></script>
	<script type="text/javascript" src="../static/js/bootstrap/shine-0.2.7.js"></script>
	<!-- 
	 -->

    <script type="text/javascript" src="../static/js/jqgrid/i18n/grid.locale-en.js"></script>
    <script type="text/javascript" src="../static/js/jqgrid/jquery.jqGrid.js"></script>
    <!-- 
	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css">
     -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> 
    
    <link rel="stylesheet" type="text/css" media="screen" href="../static/css/ui.jqgrid/ui.jqgrid-bootstrap.css" />
    <!-- 
     -->
	<script>
		$.jgrid.defaults.width = 780;
		$.jgrid.defaults.styleUI = 'Bootstrap';
	</script>
	<!-- 
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	    
    <script type="text/javascript" src="../static/js/order_status.js"></script> 
</head>
<body>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>
</body>
</html>
