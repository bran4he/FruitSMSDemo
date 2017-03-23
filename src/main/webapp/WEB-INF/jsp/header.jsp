<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#" id="index">
       	<form id="indexAction" action="<%=request.getContextPath()%>/index/index" method="get">
       	</form>尝鲜
      </a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <p class="navbar-text">更好更快的水果派送</p>  
    <!-- 居中按钮 -->
      <ul class="nav navbar-nav">
        <li><a href="#">主单管理</a></li>
        <li><a href="#">详单管理</a></li>
        <li>
        	<a href="#" id ="user">
	        	<form id="userAction" action="<%=request.getContextPath()%>/user/index" method = "get">
	        	</form>用户管理
        	</a>
        </li>
        <li><a href="#">参数管理</a></li>
        <li><a href="#" id ="log" action="/log/index">登录日志</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他功能 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">功能1</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">功能2</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">功能3</a></li>
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
            <li><a href="#">锁定屏幕</a></li>
            <li><a href="#">其他功能</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">退出</a></li>
          </ul>
        </li>
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>