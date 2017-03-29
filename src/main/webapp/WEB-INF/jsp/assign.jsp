<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8" charset="utf-8">
	<title>主分配管理</title>
	
	<jsp:include page="jqgrid-public.jsp" flush="true"/>
	<jsp:include page="public.jsp" flush="true"/>
    
    <script type="text/javascript" src="../static/js/assign.js"></script> 
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>

	<div class="container">
	    <table id="jqGrid" twidth="1170" theight="300"></table>
	    <div id="jqGridPager"></div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/> 
	


	<div id="dialog" title="水果分配信息" dialogWidth="780" dialogHeight="490">
	
	<!-- 面板框 -->
	<div class="panel panel-default">
	    <div class="panel-body">
			<!-- form显示所有信息 -->
		  <form class="form-horizontal" role="form" id="form" 
		  	addAction="add" updateAction="update" deleteAction="delete">
			  <div class="form-group">
			    <label for="firstname" class="col-sm-2 control-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="id" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">masterPhone</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="masterPhone">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">masterName</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="masterName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">slavePhone</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slavePhone">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">slaveName</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slaveName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">initialUnit</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="initialUnit">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">balanceUnit</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="balanceUnit">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">weecharOpenid</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="weecharOpenid" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">effectivePeriod</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="effectivePeriod">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">expireDate</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="expireDate" dateFlag="true" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">remark</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="remark">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">extendData</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="extendData">
			    </div>
			  </div>
			  
			  <div class="hidden">
				  <input type="text" name="insertDate">
				  <input type="text" name="insertBy">
				  <input type="text" name="updateDate">
				  <input type="text" name="updateBy">
			  </div>
			  
			</form>
	    
	    </div>
	    <!-- 
    	<div class="panel-footer">面板脚注</div>
	     -->
	</div>
		
	</div>

</body>
</html>
