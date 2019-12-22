package cn.edu.fzu.sm.vot.vot;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.fzu.sm.vot.entity.allvote;
import cn.edu.fzu.sm.vot.util.dbutil;

@WebServlet("/NewVoteServlet")
public class NewVoteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sql="select * from allvote";
		// page
		// select * from user limit pagw*5,5
		// where name like id +'%'+
	
		try{
			ResultSet rs=dbutil.getConn().createStatement().executeQuery(sql);
			List<allvote> allv=null;
			while(rs.next()){
				if(allv==null)
				{
					allv=new ArrayList<allvote>();
				}
				allvote v=new allvote();
				v.setvId(rs.getInt("vid"));
				v.setvTitle(rs.getString("vtitle"));
				v.setvName(rs.getString("vname"));
				v.setvNumber(rs.getString("vnumber"));
				v.setvTime(rs.getString("vtime"));
				allv.add(v);
			}
			req.setAttribute("votelist",allv);
			req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			
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
