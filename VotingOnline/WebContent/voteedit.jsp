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
<%
	String title=request.getParameter("title");
    title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
	
	String name=request.getParameter("name");
	name=new String(name.getBytes("ISO-8859-1"),"UTF-8");	
%>
    <div class="x-body">
        <form class="layui-form" action="VoteEditServlet" method="post">
        <div class="layui-form-item">
              <label for="L_id" class="layui-form-label">
                  <span class="x-red">*</span>序号</label>
              <div class="layui-input-inline">
                  <input type="text" id="L_id" name="id" disabled="" value="${param.id}" lay-verify="id"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_title" class="layui-form-label">
                  <span class="x-red">*</span>投票主题</label>
              <div class="layui-input-inline">
                  <input type="text" id="L_title" name="title" required="" value="<%=title%>" lay-verify="title"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_name" class="layui-form-label">
                  <span class="x-red">*</span>作者
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_name" name="name" required="" value="<%=name%>" lay-verify="name"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_number" class="layui-form-label">
                  <span class="x-red">*</span>目前投票数
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_number" name="number" disabled="" value="${param.number}" lay-verify="number"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_time" class="layui-form-label">
                  <span class="x-red">*</span>发布时间
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_time" name="time" disabled="" value="${param.time}" lay-verify="time"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_time" class="layui-form-label">
              </label>
              <button  class="layui-btn" type="button" onclick="save()">修改</button>
          </div>
       </form>
    </div>
    <script>
	function save(){
		var $id=$('#L_id').val();
		var $title=$('#L_title').val();
		var $name=$('#L_name').val();
		if($title == "")
		{
		alert("请输入新的投票主题!");
		}
	    else if($name == "")
			{
			alert("请输入新的作者!");
			}
		else{
			$.post(
			"/VotingOnline/VoteEditServlet",
			"id="+$id+"&title="+$title+"&name="+$name,
			function(result){
				if(result=='success')
					{
						alert("修改成功!");
					}
				if(result=='error')
				{
					alert("投票主题重复!");
				}
			},
			"text")
			}
		}
	</script>
</body>
</html>