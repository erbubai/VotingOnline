package cn.edu.fzu.sm.vot.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.entity.user;
import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String phone=req.getParameter("phone");
		
		String sql="update user set name='"+name+"',sex='"+sex+"',phone='"+phone+"' where username='"+username+"'";
		try{
			Statement stmt=dbutil.getConn().createStatement();//获取数据库连接，并创建一个数据库连接状态
			stmt.executeUpdate(sql);//执行数据库的查询语句
			out.write("success");
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
