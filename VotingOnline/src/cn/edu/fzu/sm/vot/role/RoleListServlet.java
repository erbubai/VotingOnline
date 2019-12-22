package cn.edu.fzu.sm.vot.role;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.entity.role;
import cn.edu.fzu.sm.vot.entity.server;
import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/RoleListServlet")
public class RoleListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql="select * from role";
		// page
		// select * from user limit pagw*5,5
		// where name like id +'%'+
	
		try{
			ResultSet rs=dbutil.getConn().createStatement().executeQuery(sql);
			List<role> rol=null;
			while(rs.next()){
				if(rol==null)
				{
					rol=new ArrayList<role>();
				}
				role r=new role();
				r.setId(rs.getInt("id"));
				r.setRole(rs.getString("role"));
				r.setRit(rs.getString("rit"));
				r.setDes(rs.getString("des"));
				rol.add(r);
			}
			req.setAttribute("rolelist",rol);
			req.getRequestDispatcher("/rolelist.jsp").forward(req, resp);
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
