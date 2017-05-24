<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; UTF-8">

	<script type="text/javascript" src="../static/js/jquery/jquery-1.10.0-min.js"></script>
	<!-- 
	<script type="text/javascript" src="../static/js/jquery.validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../static/js/jquery.validate/localization/messages_zh.min.js"></script>
	 -->

	<!-- noty -->
	<script type="text/javascript" src="../static/js/noty/packaged/jquery.noty.packaged.min.js"></script>
		
	<link rel="stylesheet" href="../static/css/bootstrap/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="../static/css/fontawesome/css/font-awesome.min.css">
	<script type="text/javascript" src="../static/css/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- 
    <script type="text/javascript" src="../static/js/jquery.form/jquery.form.min.js"></script>
	 -->
	
	<link rel="stylesheet" href="../static/css/login.css" type="text/css" />
    <script type="text/javascript" src="../static/js/login.js"></script>
    
</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form id="loginForm" class="form-horizontal" action="login" method = "post">
                <span class="heading">用户登录</span>
                
                <div class="form-group">
                	<i class="icon-user"></i>
                    <input class="form-control" id="username" name="username" placeholder="用户名或电子邮件">
                </div>
                
                <div class="form-group help">
					<i class="icon-key"></i>                    
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                </div>
                
                <div class="form-group">
                	<i class="icon-barcode"></i>
        			<input class="form-control" id="authcode" type="text" placeholder="验证码" />
   				 </div>
     			<img type="image" src="authcode" id="codeImage" onclick="chageCode()" title="点击重新得到验证码" style="cursor:pointer;"/>
                
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" value="None" id="checkbox1" name="rememberMe"/>
                        <label for="checkbox1"></label>
                    </div>
                    <span class="text">记住我</span>
                    <button type="button" id="loginBtn" class="btn btn-default">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
