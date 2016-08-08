package com.csmy.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.csmy.bean.*;
import com.csmy.db.*;
public class CourseDao {
	public void insert(Course c) throws SQLException{
        Connection conn = DbConn.getDbConn();		
		String sql="insert into course(code,name,deptId,teacherId,remark)"
				+ "values(?,?,?,?,?)";
		if (conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getCode());
			pstm.setString(2, c.getName());
			
			if(c.getDepartmentid()==0){
				pstm.setNull(3, Types.INTEGER);
			}else{
				pstm.setInt(3, c.getDepartmentid());
			}
			
			if(c.getTeacherid()==null){
				pstm.setNull(4, Types.INTEGER);
			}else{
				pstm.setInt(4, c.getTeacherid());
			}
			
			if (c.getRemark()==null){
				pstm.setNull(5, Types.INTEGER);
			}else{
				pstm.setString(5, c.getRemark());
			}
			pstm.executeUpdate();
			DbConn.closeConn(conn);
		}
	}
	
	public void update(Course c) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql="update  course"
				+ " set code=?,name=?,deptId=?,teacherId=?,remark=?)"
				+ " where id=?";
		if (conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getCode());
			pstm.setString(2, c.getName());
			
			if(c.getDepartmentid()==0){
				pstm.setNull(3, Types.INTEGER);
			}else{
				pstm.setInt(3, c.getDepartmentid());
			}
			
			if(c.getTeacherid()==0){
				pstm.setNull(4, Types.INTEGER);
			}else{
				pstm.setInt(4, c.getTeacherid());
			}
			
			if (c.getRemark()==null){
				pstm.setNull(5, Types.INTEGER);
			}else{
				pstm.setString(5, c.getRemark());
			}
			pstm.setInt(5, c.getId());
			pstm.executeUpdate();
			DbConn.closeConn(conn);
		} 
	  } 
	public void delete(int id) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql="delete from course where id=?";
		if (conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
			DbConn.closeConn(conn);
		}			
	}
	
	public PagerModel list(String order,int pageSize, int pageIndex, String where) throws SQLException{
		String sql = "select * from Course " + where;
		Connection conn = DbConn.getDbConn();
		List<Course> list = new ArrayList<Course>();
		CallableStatement pstm;
		pstm = conn.prepareCall("{call sp_pager('Course',' id,code,name,deptId,teacherId,remark,courseStatus ',?,?,?,?,?)}");  
		pstm.setString(1, order);
		pstm.setInt(2, pageSize);
		pstm.setInt(3, pageIndex);
		pstm.setString(4, where);
		pstm.registerOutParameter(5, Types.INTEGER); 
		
		ResultSet rs = pstm.executeQuery();
		int total = pstm.getInt(5);
		while(rs.next()){
			Course c = new Course(rs.getInt(1),rs.getString(2),rs.getString(3));
			c.setDepartmentid(rs.getInt(4));
			c.setTeacherid(rs.getInt(5));
			c.setRemark(rs.getString("remark"));
			c.setCourseStatus(rs.getInt(7));
			list.add(c);
			
		}
		PagerModel pm = new PagerModel<>(total, list);
		return pm;
		
	}
}
