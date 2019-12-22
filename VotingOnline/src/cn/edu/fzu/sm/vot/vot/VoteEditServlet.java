package cn.edu.fzu.sm.vot.vot;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/VoteEditServlet")
public class VoteEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String title=req.getParameter("title");
		String name=req.getParameter("name");

		String sql="update allvote set vname='"+name+"',vtitle='"+title+"' where vid='"+id+"'";
		String sql1="select vtitle from allvote where vtitle='"+title+"'";
		try{
			Statement stmt=dbutil.getConn().createStatement();//获取数据库连接，并创建一个数据库连接状态
			ResultSet rs = stmt.executeQuery(sql1);//执行数据库的查询语句
			if(rs.next()){//至少有一条记录
				out.write("error");
			}else{//没有任何查询结果
				stmt.executeUpdate(sql);
				out.write("success");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
}
