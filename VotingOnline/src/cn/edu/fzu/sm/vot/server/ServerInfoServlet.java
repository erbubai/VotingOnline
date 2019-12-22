package cn.edu.fzu.sm.vot.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.entity.server;
import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/ServerInfoServlet")
public class ServerInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("UTF-8");
		String username=req.getParameter("username");
		
		String sql="select * from server where username='"+username+"'";
		try{
			ResultSet rs=dbutil.getConn().createStatement().executeQuery(sql);
			server s=new server();
			s.setId(rs.getInt("id"));
			s.setUsername(rs.getString("username"));
			s.setName(rs.getString("name"));
			s.setRole(rs.getString("role"));
			s.setTime(rs.getString("time"));
			req.setAttribute("server",s);
			req.getRequestDispatcher("serverinfo.jsp").forward(req, resp);
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
