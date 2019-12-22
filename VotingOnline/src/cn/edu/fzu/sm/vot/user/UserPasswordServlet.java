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

@WebServlet("/UserPasswordServlet")
public class UserPasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		String oldpass=req.getParameter("oldpass");
		String newpass=req.getParameter("newpass");
		
		String sql="update user set password='"+newpass+"' where username='"+username+"'";
		String sql1="select username,password from user where username='"+username+"'";
		try{
			Statement stmt=dbutil.getConn().createStatement();//获取数据库连接，并创建一个数据库连接状态
			ResultSet rs = stmt.executeQuery(sql1);//执行数据库的查询语句
			if(rs.next()){//至少有一条记录
				user u=new user();
				u.setPassword(rs.getString("password"));
				if(!u.getPassword().equals(oldpass)){
					out.write("error");
				}
				else{//没有任何查询结果
					stmt.executeUpdate(sql);
					out.write("success");
				}
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
