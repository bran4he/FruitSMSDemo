<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<title>尝鲜后台管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">
	<script type="text/javascript" src="../static/js/jquery/jquery-1.10.0-min.js"></script>
	
	<link rel="stylesheet" href="../static/css/bootstrap/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../static/css/bootstrap/css/bootstrap-theme.min.css" type="text/css" />
	<script type="text/javascript" src="../static/css/bootstrap/js/bootstrap.min.js"></script>
    
    <script type="text/ecmascript" src="../static/js/index.js"></script> 
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#">尝鲜</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <p class="navbar-text">更好更快的水果派送</p>  
    <!-- 居中按钮 -->
      <ul class="nav navbar-nav">
        <li><a href="#">主单管理</a></li>
        <li><a href="#">详单管理</a></li>
        <li><a href="#" id ="user" action="/user/index">用户管理</a></li>
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

		
</body>
</html>
