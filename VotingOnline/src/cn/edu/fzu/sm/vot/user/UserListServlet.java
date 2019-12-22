package cn.edu.fzu.sm.vot.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.edu.fzu.sm.vot.entity.user;
import cn.edu.fzu.sm.vot.util.dbutil;


@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		if(username==null)
		{
			username="";
		}
		String sql="select * from user where username like '%"+username +"' or username like '"
+username+"%'" +" or username like '%"+username+"%'";
		// page
		// select * from user limit pagw*5,5
		// where name like id +'%'+
	
		try{
			ResultSet rs=dbutil.getConn().createStatement().executeQuery(sql);
			List<user> use=null;
			while(rs.next()){
				if(use==null)
				{
					use=new ArrayList<user>();
				}
				user u=new user();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setPhone(rs.getString("phone"));
				u.setTime(rs.getString("time"));
				use.add(u);
			}
			req.setAttribute("userlist",use);
			req.getRequestDispatcher("/userlist.jsp").forward(req, resp);
			
		}
		catch(Exception e){
		e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
