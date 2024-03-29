<%@page import="cn.edu.fzu.sm.vot.entity.allvote"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page
    import="java.util.*"%>
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
</head>
<body>
        <div class="x-body">
            <blockquote class="layui-elem-quote">欢迎使用VotingOnline 树莓电子投票系统!</blockquote>
            <fieldset class="layui-elem-field">
              <legend>最新投票</legend>
              <div class="layui-field-box">
              <table class="layui-table" lay-even>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>投票主题</th>
                            <th>作者</th>
                            <th>目前投票数</th>
                            <th>发布时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<allvote> list=(List<allvote>)request.getAttribute("votelist");
        	                for(allvote v:list)
        	                {
                        %>
                        <tr>
                            <td><%=v.getvId()%></td>
                            <td><%=v.getvTitle()%></td>
                            <td><%=v.getvName()%></td>
                            <td><%=v.getvNumber()%></td>
                            <td><%=v.getvTime()%></td>
                        </tr>
                        <%
        	            }
                        %>
                        </tbody>
                    </table>
            </fieldset>
            <blockquote class="layui-elem-quote layui-quote-nm">本后台系统由网络提供前端技术支持。</blockquote>
        </div>
</body>
</html>