<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VotingOnline</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="x-body">
        <form class="layui-form" action="UserPasswordServlet" method="post">
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                <span class="x-red">*</span>账号</label>
              <div class="layui-input-inline">
                  <input type="text"  id="L_username" name="username" disabled="" value="${param.username}" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_password" class="layui-form-label">
                  <span class="x-red">*</span>原密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_password" name="oldpass" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>新密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="newpass" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" type="button" onclick="save()">修改</button>
          </div>
      </form>
    </div>
    <script>
    		
    		function save(){
    			var $oldpass=$('#L_password').val();
    			var $newpass=$('#L_pass').val();
    			var $repass=$('#L_repass').val();
    			var $username=$('#L_username').val();
    			if($newpass == "")
    				{
    				alert("请输入新的密码!");
    				}
    			else if($newpass != $repass)
    				{
    				alert("两次密码不一致!");
    				}
    			else{
    				$.post(
    				"/VotingOnline/UserPasswordServlet",
    				"username="+$username+"&newpass="+$newpass+"&oldpass="+$oldpass,
    				function(result){
    					if(result=='success')
    						{
    							alert("修改成功!");
    						}
    					if(result=='error')
						{
							alert("原密码错误!");
						}
    				},
    				"text")
    				}
    			}
        </script>
</body>
</html>