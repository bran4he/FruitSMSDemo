<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8" charset="utf-8">
	<title>订单管理</title>
	
	<jsp:include page="jqgrid-public.jsp" flush="true"/>
	<jsp:include page="public.jsp" flush="true"/>
    
    <script type="text/javascript" src="../static/js/order.js"></script> 
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>

	<div class="container">
	
	<form class="form-inline" id="search">
	  <div class="form-group">
	    <label for="statusId">订单状态:</label>
	    <input type="text" class="form-control hidden" name="statusId" >
	    <select class="form-control" id="statusId" url="../orderStatus/all" keyName="name" keyValue="id">
		</select>
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="fruitId">水果名称:</label>
	    <input type="text" class="form-control hidden" name="fruitId" >
	    <select class="form-control" id="fruitId" url="../fruitConfig/all" keyName="fruitName" keyValue="id">
	    </select>
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="contactName">联系人:</label>
	    <input type="text" class="form-control" name="contactName" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="contactPhone">联系人手机:</label>
	    <input type="text" class="form-control" name="contactPhone" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <div style="float: right">
		  <button id="btnSearch" type="button" class="btn btn-success">搜索</button>
		  &nbsp;
		  &nbsp;
		  <button id="btnClear" type="button" class="btn btn-default">清除</button>
	  </div>
	</form>
	<br>
	
	    <table id="jqGrid" twidth="1170" theight="300"
	    multiselect="true" mutiUpdateUrl="mutiUpdate" viewCaption="查看"
	    >
	    </table>
	    <div id="jqGridPager"></div>
	    
	    <br>
	    <div id="quickOpt" style="float: right">
		<button type="button" class="btn btn-primary" statusValue="2">一键"派送中"</button>
		<button type="button" class="btn btn-success" statusValue="3">一键"派送成功"</button>
	    </div>
	</div>
	
	
	<jsp:include page="footer.jsp" flush="true"/> 
	


	<div id="dialog" title="订单信息" dialogWidth="780" dialogHeight="490">
	
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
			    <label for="lastname" class="col-sm-2 control-label">statusId</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="statusId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">assignId</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="assignId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">fruitId</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">fruitName</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">orderUnit</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="orderUnit">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">planDeliveryDate</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="planDeliveryDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">address</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="address">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">contactName</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="contactName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">contactPhone</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="contactPhone">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">deliveryDate</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="deliveryDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">deliveryBy</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deliveryBy">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">deliveryRemark</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deliveryRemark">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">finishDate</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="finishDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">finishBy</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="finishBy">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">finishRemark</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="finishRemark">
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
