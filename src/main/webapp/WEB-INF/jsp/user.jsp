<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">

	<title>用户管理</title>
	
   	
		<!-- jqGrid组件基础样式包-必要 -->
		<link rel="stylesheet" href="../static/js/jqgrid/css/ui.jqgrid.css" />
		
		<!-- jqGrid主题包-非必要 --> 
		<!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
		<link rel="stylesheet" href="../static/js/jqgrid/css/css/redmond/jquery-ui-1.8.16.custom.css" />

		<!-- jquery插件包-必要 -->
		<!-- 这个是所有jquery插件的基础，首先第一个引入
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		 -->
   		<script type="text/javascript" src="../static/js/jquery/jquery-1.10.0-min.js"></script>
		
		<!-- jqGrid插件包-必要 -->
		<script type="text/javascript" src="../static/js/jqgrid/js/jquery.jqGrid.src.js"></script>
		
		<!-- jqGrid插件的多语言包-非必要 -->
		<!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
		<script type="text/javascript" src="../static/js/jqgrid/js/i18n/grid.locale-cn.js"></script>

		<jsp:include page="public.jsp" flush="true"/>
    
    <script type="text/javascript" src="../static/js/user.js"></script> 
</head>
<body>

<jsp:include page="header.jsp" flush="true"/>

<div class="container">
    <table id="jqGrid" twidth="1170" theight="300"></table>
    <div id="jqGridPager"></div>
</div>
<jsp:include page="footer.jsp" flush="true"/>    		
</body>
</html>
