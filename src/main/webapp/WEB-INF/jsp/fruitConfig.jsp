<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8" charset="utf-8">
	<title>水果配置参数</title>
	
	<jsp:include page="jqgrid-public.jsp" flush="true"/>
	<jsp:include page="public.jsp" flush="true"/>
    
    <script type="text/javascript" src="../static/js/fruitConfig.js"></script> 
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>

	<div class="container">
	    <table id="jqGrid" twidth="1170" theight="300"></table>
	    <div id="jqGridPager"></div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/> 
	


	<div id="dialog" title="水果配置参数信息" dialogWidth="850" dialogHeight="520">
	
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
			    <label for="lastname" class="col-sm-2 control-label">fruitName</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">fruitArea</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitArea">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">fruitMonth</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="fruitMonth">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">maxOrderDay</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="maxOrderDay">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">maxOrderNum</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="maxOrderNum">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">maxProvNum</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="maxProvNum">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">remark</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" name="remark" ></textarea>
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
