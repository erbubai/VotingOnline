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

import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");//获取网页传递过来的参数，该参数为提交表单时获取的
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String sex=req.getParameter("sex");
		String phone=req.getParameter("phone");
		String time=req.getParameter("time");
		
		String sql="insert into user(name,username,password,sex,phone,time)"+
				" value('"+name+"','"+username+"','"+password+"','"+sex+"','"+phone+"','"+time+"')";
		String sql1="select username from user where username='"+username+"'";
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
	doGet(req,resp);//调用doGet,统一用doGet函数来处理业务
	}
}