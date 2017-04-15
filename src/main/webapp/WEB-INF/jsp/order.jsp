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
	    <label for="slaveName">收礼人:</label>
	    <input type="text" class="form-control" name="slaveName" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="slavePhone">收礼人手机:</label>
	    <input type="text" class="form-control" name="slavePhone" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <br>
	  <br>
	  
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
	  <div class="form-group">
	    <label for="statusId">订单状态:</label>
	    <input type="text" class="form-control hidden" name="statusId" >
	    <select class="form-control" id="statusId" url="../orderStatus/all" keyName="name" keyValue="id">
		</select>
	  </div>
	  &nbsp;
	  &nbsp;
	  <!-- 技术原因不能搜索水果
	  <div class="form-group">
	    <label for="fruitId">水果名称:</label>
	    <input type="text" class="form-control hidden" name="fruitId" >
	    <select class="form-control" id="fruitId" url="../fruitConfig/all" keyName="fruitName" keyValue="id">
	    </select>
	  </div>
	  &nbsp;
	  &nbsp;
	   -->
	  <div style="float: right">
		  <button id="btnSearch" type="button" class="btn btn-success">搜索</button>
		  &nbsp;
		  &nbsp;
		  <button id="btnClear" type="button" class="btn btn-default">清除</button>
	  </div>
	</form>
	<br>
	
	    <table id="jqGrid" twidth="1170" theight="280"
	    multiselect="true" mutiUpdateUrl="mutiUpdate" viewCaption="查看"
	    customCaption="订单详细" ondblClickRow="true"
	    
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
			    <label for="id" class="col-sm-2 control-label">ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="id" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="statusId" class="col-sm-2 control-label">订单状态ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="statusId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="assignId" class="col-sm-2 control-label">收礼人详细ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="assignId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="slaveName" class="col-sm-2 control-label">收礼人姓名</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slaveName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="slavePhone" class="col-sm-2 control-label">收礼人电话</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slavePhone">
			    </div>
			  </div>
			  
			  <!-- 
			  <div class="form-group">
			    <label for="fruitId" class="col-sm-2 control-label">水果ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitId">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="fruitName" class="col-sm-2 control-label">水果</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="orderUnit" class="col-sm-2 control-label">订单量</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="orderUnit">
			    </div>
			  </div>
			   -->
			   
			   
			  <div class="form-group">
			    <label for="planDeliveryDate" class="col-sm-2 control-label">计划送达时间</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="planDeliveryDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="address" class="col-sm-2 control-label">地址</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="address">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="contactName" class="col-sm-2 control-label">联系人</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="contactName">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="contactPhone" class="col-sm-2 control-label">联系电话</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="contactPhone">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="deliveryDate" class="col-sm-2 control-label">送达时间</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="deliveryDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="deliveryBy" class="col-sm-2 control-label">送达人</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deliveryBy">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="deliveryRemark" class="col-sm-2 control-label">送达备注</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="deliveryRemark">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="finishDate" class="col-sm-2 control-label">结束时间</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="finishDate">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="finishBy" class="col-sm-2 control-label">结束人</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="finishBy">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="finishRemark" class="col-sm-2 control-label">结束备注</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="finishRemark">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="remark" class="col-sm-2 control-label">备注</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" name="remark" ></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="extendData" class="col-sm-2 control-label">扩展</label>
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
	
	<!-- 订单详细信息 -->
	<div id="customDialog" title="订单详细" dialogWidth="780" dialogHeight="490">
	
		<div class="panel panel-default">
		    <div class="panel-body">
		    	<table class="table table-hover">
		    		<caption>订单水果明细表</caption>
		    		<thead>
			    		<tr>
			    			<td>ID</td>
			    			<td>水果ID</td>
			    			<td>水果名</td>
			    			<td>订单量</td>
			    		<tr>
		    		</thead>
		    		<tbody id="cutomeBody">
			    		<!-- 
			    		<tr>
			    			<td>3</td>
			    			<td>2</td>
			    			<td>香蕉</td>
			    			<td>3</td>
			    		</tr>
			    		 -->
		    		</tbody>
		    	</table>
		    </div>
		</div>
		
	</div>

</body>
</html>
