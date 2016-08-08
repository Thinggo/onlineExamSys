package com.csmy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
	private final static  String userName="sa";
	private final static String password="123456";
	private final  static String url="jdbc:sqlserver://127.0.0.1:1433;database=onlineExam";
	private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 /**
	  * getDbConn() 获得连接
	  * @return  Connection 返回连接对象
	 * @throws SQLException 
	  * */
	 public static Connection getDbConn() throws SQLException {
		
			
			return DriverManager.getConnection(url, userName, password);
		
	 }
	 
	 /**
	  * closeConn 关闭连接
	  * @param  conn 连接对象
	  * */
	 public static void  closeConn(Connection conn) {
		 if(conn != null) {
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	 }
}
