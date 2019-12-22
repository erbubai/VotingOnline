<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VotingOnline</title>
<!--图标库-->
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css'>

<!--响应式框架-->
<link rel='stylesheet' href='css/bootstrap.min.css'>

<!--主要样式-->
<link rel="stylesheet" href="css/style.css">

 <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">

	<div class="card-wrap">
	
		<div class="card border-0 shadow card--welcome is-show" id="welcome">
			<div class="card-body">
				<h2 class="card-title">VOTING ONLINE</h2>
				<p>欢迎使用 树莓电子投票系统 </p>
				<div class="btn-wrap"><a class="btn btn-lg btn-register js-btn" data-target="register">注册</a><a class="btn btn-lg btn-login js-btn" data-target="login">登录</a></div>
			</div>
		</div>
		
		<div class="card border-0 shadow card--register" id="register">
			<div class="card-body">
				<h2 class="card-title">用户注册</h2>
				<p>请输入您的相关信息进行注册</p>
				<form action="RegisterServlet" method="post">
					<div class="form-group">
						<input class="form-control" id="L_name" type="text" name="name"  placeholder="用户名" required="required">
					</div>
					<div class="form-group">
						<input class="form-control" id="L_username" type="text" name="username" placeholder="账号" required="required">
					</div>
					<div class="form-group">
						<input class="form-control" id="L_password" type="password" name="password" placeholder="密码" required="required">
					</div>
					<button class="btn btn-lg" type="button" onclick="rsave()">注册</button>
				</form>
			</div>
			<button class="btn btn-back js-btn" data-target="welcome"><i class="fas fa-angle-left"></i></button>
		</div>
		
		<div class="card border-0 shadow card--login" id="login">
			<div class="card-body">
				<h2 class="card-title">欢迎登录</h2>
				<p>请输入您的账号密码</p>
				<form action="LoginServlet" method="post">
					<div class="form-group">
						<input class="form-control" id="L_username1" type="text" name="username" placeholder="账号" required="required">
					</div>
					<div class="form-group">
						<input class="form-control" id="L_password1" type="password"  name="password" placeholder="密码" required="required">
					</div>
					<p><a href="#">忘记密码?</a></p>
					<button class="btn btn-lg" type="button" onclick="save()">登录</button>
				</form>
			</div>
			<button class="btn btn-back js-btn" data-target="welcome"><i class="fas fa-angle-left"></i></button>
		</div>
	</div>
</div>
  
<script src="js/index.js"></script>

<script type="text/javascript">
    		
    		function rsave(){
    			var $password=$('#L_password').val();
    			var $username=$('#L_username').val();
    			var $name=$('#L_name').val();
    			if($name == "")
				{
				alert("请输入用户名!");
				}
    			else if($username == "")
				{
				alert("请输入账号!");
				}
			    else if($password == "")
				{
				alert("请输入密码!");
				}else{
    				$.post(
    				"/VotingOnline/RegisterServlet",
    				"username="+$username+"&password="+$password+"&name="+$name,
    				function(result){
    					if(result=='success')
						{
    						alert("注册成功!");
							window.location.href="login.jsp";
						}
    					if(result=='error')
						{
							alert("用户名重复!");
						}
    				},
    				"text")
    			}
    		}
    		
    		function save(){
    			var $password=$('#L_password1').val();
    			var $username=$('#L_username1').val();
    			if($username == "")
				{
				alert("请输入账号!");
				}
			    else if($password == "")
				{
				alert("请输入密码!");
				}else{
    				$.post(
    				"/VotingOnline/LoginServlet",
    				"username="+$username+"&password="+$password,
    				function(result){
    					if(result=='success')
						{
    						alert("管理员 "+$username+" 登录成功!");
							window.location.href="backstage.jsp";
						}
    					if(result=='error')
						{
							alert("用户名或密码错误!");
						}
    				},
    				"text")
				}
    			}
        </script>

</body>
</html>