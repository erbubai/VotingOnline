package cn.edu.fzu.sm.vot.server;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.entity.server;
import cn.edu.fzu.sm.vot.entity.user;
import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/ServerListServlet")
public class ServerListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=(String) req.getParameter("username");
		if(username==null)
		{
			username="";
		}
		String sql="select * from server where username like '%"+username +"' or username like '"
+username+"%'" +" or username like '%"+username+"%'";
		// page
		// select * from user limit pagw*5,5
		// where name like id +'%'+
	
		try{
			ResultSet rs=dbutil.getConn().createStatement().executeQuery(sql);
			List<server> serv=null;
			while(rs.next()){
				if(serv==null)
				{
					serv=new ArrayList<server>();
				}
				server s=new server();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setName(rs.getString("name"));
				s.setRole(rs.getString("role"));
				s.setTime(rs.getString("time"));
				serv.add(s);
			}
			req.setAttribute("serverlist",serv);
			req.getRequestDispatcher("/serverlist.jsp").forward(req, resp);
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
