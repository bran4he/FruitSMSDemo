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
	
		<form class="form-inline" id="search">
	  <div class="form-group">
	    <label for="fruitName">水果名字:</label>
	    <input type="text" class="form-control" name="fruitName" >
	  </div>
	  &nbsp;
	  &nbsp;
	  <div class="form-group">
	    <label for="fruitArea">水果产地:</label>
	    <input type="text" class="form-control" name="fruitArea" >
	  </div>
	  &nbsp;
	  &nbsp;
  	  <div class="form-group">
	    <label for="remark">备注信息:</label>
	    <input type="text" class="form-control" name="remark" >
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
	    addCaption="新建" updateCaption="编辑" deleteCaption="删除" viewCaption="查看"
	    >
	    </table>
	    <div id="jqGridPager"></div>
	</div>
	<jsp:include page="footer.jsp" flush="true"/> 
	


	<div id="dialog" title="水果配置参数" dialogWidth="850" dialogHeight="520">
	
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
			    <label for="lastname" class="col-sm-2 control-label">水果<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitName" required="true">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">产地<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="fruitArea" required="true">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">月份<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="fruitMonth" required="true">
			    </div>
			  </div>
			  <!-- remove this field

			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">最大定单日<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" dateFlag="true" name="maxOrderDay" required="true">
			    </div>
			  </div>
			  -->
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">一单最大量<span style="color:red">*</span></label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="maxOrderNum" sliderFlag="true" initValue="0" minValue="0" maxValue="10000" required="true">
					<!--
					<div></div>
					-->
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">供应量</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="maxProvNum" sliderFlag="true" initValue="0" minValue="0" maxValue="10000">
					<!--
					<div></div>
					-->
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">备注</label>
			    <div class="col-sm-10">
			      <textarea class="form-control" rows="3" name="remark" ></textarea>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="lastname" class="col-sm-2 control-label">扩展</label>
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
