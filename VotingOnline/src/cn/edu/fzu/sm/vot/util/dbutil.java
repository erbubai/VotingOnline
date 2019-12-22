package cn.edu.fzu.sm.vot.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutil {
	static String JDBC_DRIVER="com.mysql.jdbc.Driver";//数据库驱动
	static String DB_URL="jdbc:mysql://localhost:3306/voting?useUnicode=true&charactorEncoding=UTF-8";//连接字符串
	static String USER="root";//数据库的用户名
	static String PASS="haosql";//数据库的密码
	static Connection conn=null;//创建一个数据库的连接
	public static Connection getConn(){//静态还是，获取数据库连接，该函数是
		if(conn==null){//第一次调用，还没有创建连接
			try{
				Class.forName(JDBC_DRIVER);//注册数据库连接驱动
				conn=DriverManager.getConnection(DB_URL, USER, PASS);//
			}catch(SQLException e){
			     e.printStackTrace();
		    }catch(ClassNotFoundException e){
			     e.printStackTrace();
		    }
		}	
		return conn;//返回连接
	}

}
