<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#" role="menu">
       	<form action="<%=request.getContextPath()%>/index/index" method="get">
       	</form>尝鲜
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <p class="navbar-text">更好更快的水果派送</p>  
    <!-- 居中按钮 -->
      <ul class="nav navbar-nav">
      	<li>
	      	<a href="#" role="menu">
	      	<form action="<%=request.getContextPath()%>/fruitConfig/index" method="get">
	      	</form>
	      	水果配置
	      	</a>
      	</li>
        <li>
        	<a href="#" role="menu">
        	<form action="<%=request.getContextPath()%>/assign/index" method="get">
        	</form>
        	Assign管理
        	</a>
        </li>
        <li>
        	<a href="#" role="menu">
        		Order管理
        		<form action="<%=request.getContextPath()%>/order/index" method="get">
        		</form>
        	</a>
        </li>
        <li>
        	<a href="#" role="menu">
        		AssignDetail管理
        		<form action="<%=request.getContextPath()%>/assignDetail/index" method="get">
        		</form>
        	</a>
        </li>
        <li>
        	<a href="#" role="menu">
	        	<form action="<%=request.getContextPath()%>/user/index" method="get">
	        	</form>
	        	用户管理
        	</a>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他功能 <span class="caret"></span></a>
          <ul class="dropdown-menu">
	            <li>
	            	<a href="#" role="menu">
		            	<form action="<%=request.getContextPath()%>/orderStatus/index" method="get">
		        		</form>
		            	订单状态参数
	            	</a>
	            </li>
	            <li>
		            <a href="#" role="menu">
			            <form action="<%=request.getContextPath()%>/pubConfig/index" method="get">
		        		</form>
		            	公共参数管理
		            </a>
	            </li>
	            <li role="separator" class="divider"></li>
	            <li>
	            <a href="#" role="menu">
	            	<form action="<%=request.getContextPath()%>/loginLog/index" method="get">
	        		</form>
	            	登录日志
	            </a>
	            </li>
          </ul>
        </li>
      </ul>
      
      <!-- 
      <p class="navbar-text navbar-right">admin</p>
       -->
      
      <!-- 右侧按钮 -->
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#" role="menu">其他功能</a></li>
            <li role="separator" class="divider"></li>
            <li>
            <a href="#" role="menu">
            	<form action="<%=request.getContextPath()%>/login/logout" method="get">
	        	</form>
            	退出
            </a>
            </li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>