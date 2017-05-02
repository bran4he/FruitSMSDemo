<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8" charset="utf-8">
	<title>送礼详细管理</title>
	
	<jsp:include page="jqgrid-public.jsp" flush="true"/>
	<jsp:include page="public.jsp" flush="true"/>
    
    <script type="text/javascript" src="../static/js/assignDetail.js"></script> 
</head>
<body>
	<jsp:include page="header.jsp" flush="true"/>

	<div class="container">
	
	<form class="form-inline" id="search">
	  <div class="form-group">
	    <label for="masterName">送礼人:</label>
	    <input type="text" class="form-control" name="masterName" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="masterPhone">送礼人手机:</label>
	    <input type="text" class="form-control" name="masterPhone" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <br>
	  <br>
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
	  <div class="form-group">
	    <label for="isVirtual">虚拟号码:</label>
	    <input type="text" class="form-control hidden" name="isVirtual" >
	    <select class="form-control" id="statusId" url="../common/virtualList" keyName="name" keyValue="id">
		</select>
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
	    addCaption="新建" updateCaption="编辑" viewCaption="查看"
	    >
	    </table>
	    <div id="jqGridPager"></div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/> 
	


	<div id="dialog" title="assignDetail信息" dialogWidth="780" dialogHeight="490"
	>
	
	<!-- 面板框 -->
	<div class="panel panel-default">
	    <div class="panel-body">
		  	<div class="ui-widget">
				<div class="ui-state-error ui-corner-all" style="padding: 0.8em;">
					<p style="margin: auto"><span class="ui-icon ui-icon-alert" ></span>
					<strong>收礼人手机号码信息警示:</strong></p>
					<p style="margin: auto" >&nbsp;&nbsp;&nbsp;&nbsp;1.新建时为真实号,编辑时仍为真实,不允许修改为虚拟号</p>
					<p style="margin: auto">&nbsp;&nbsp;&nbsp;&nbsp;2.新建时为虚拟号,编辑时强制置为真实号码.请务必修改否则取消保存</p>
				</div>
			</div>
			<br>
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
			    <label for="lastname" class="col-sm-2 control-label">收礼人详细ID</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="assignId" readonly="readonly">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">增加量<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="unitUpdate" editForbidden="true" required="true"
						 sliderFlag="true" initValue="0" minValue="-10000" maxValue="10000" >
					<!--
					<div></div>
					-->
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">送礼人手机<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="masterPhone" required="true">

			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">送礼人姓名<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="masterName" required="true">
			    </div>
			  </div>
			  
			  
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">收礼人号码<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slavePhone" required="true">
			    </div>
			  </div>
  			  <div class="form-group">
			    <label for="isVirtual" class="col-sm-2 control-label">虚拟号码</label>
			     <div class="checkbox">
				     <label>
						<input type="text" class="form-control" name="isVirtual" readonly="readonly">
						<input type="checkbox" class="specialCheck" >
						如果是虚拟号码请务必勾选
				     </label>
				 </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">收礼人姓名<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="slaveName" required="true">
			    </div>
			  </div>

			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">备注</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" name="remark" ></textarea>
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
