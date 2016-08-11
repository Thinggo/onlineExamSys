package com.csmy.dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;


import com.csmy.db.*;
import com.csmy.object.*;
public class CourseDao {
	
	
	public void insert(Course c) throws SQLException{
        Connection conn = DbConn.getDbConn();		
		String sql="insert into course(code,name,deptId,teacherId,remark)"
				+ "values(?,?,?,?,?)";
		if (conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getCode());
			pstm.setString(2, c.getName());
			
			if(c.getDepartment()==null){
				pstm.setNull(3, Types.INTEGER);
			}else{
				pstm.setInt(3,c.getDepartment().getId() );
			}
			
			if(c.getTeacher()==null){
				pstm.setNull(4, Types.INTEGER);
			}else{
				pstm.setInt(4,c.getTeacher().getId());
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
				+ " set code=?,name=?,deptId=?,teacherId=?,remark=?"
				+ " where id=?";
		if (conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getCode());
			pstm.setString(2, c.getName());
			
			if(c.getDepartment()==null){
				pstm.setNull(3, Types.INTEGER);
			}else{
				pstm.setInt(3, c.getDepartment().getId());
			}
			
			if(c.getTeacher()==null){
				pstm.setNull(4, Types.INTEGER);
			}else{
				pstm.setInt(4, c.getTeacher().getId());
			}
			
			if (c.getRemark()==null){
				pstm.setNull(5, Types.INTEGER);
			}else{
				pstm.setString(5, c.getRemark());
			}
			pstm.setInt(6, c.getId());
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
	/*
	 * 一次删除多条记录，ids为“，”分隔的id号
	 */
	public void delete(String ids) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql="delete from course where id IN ("+ids+")";
		if (conn!=null){
			Statement stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			DbConn.closeConn(conn);
		}			
	}
	/*
	 * 修改课程状态
	 * @para ids为豆号分隔的ID号，status为新的状态
	 */
	public void audit(String ids, int status) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql=String.format("update Course set courseStatus=%d  where id IN (%s)",status,ids);
		if (conn!=null){
			Statement stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			DbConn.closeConn(conn);
		}			
	}
	/*
	 * 查询任意给定条件的记录
	 * @param where 为满足SQL语法的查询条件，如果没有条件，就传null
	 */
	public List<Course> select(String where) throws SQLException{
		List<Course> list=null;
		Connection conn = DbConn.getDbConn();
		if(where ==null) where="1=1";
		String conums=" id,code ,name , deptId, teacherId, remark ,courseStatus ";
		String sql=String.format("SELECT " +conums	+ " FROM dbo.course "
				+ " where %s",where);
		if(conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			list = new ArrayList<Course>();
			while(rs.next()){
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				List <Department> d=new DepartmentDao().select("id="+rs.getInt(4));
				if(d!=null && !d.isEmpty())
				c.setDepartment(d.get(0));
				List<Teacher> t=new TeacherDao().select("id="+rs.getInt(5));
				if(t!=null && !t.isEmpty()){
				c.setTeacher(t.get(0));
				}				
				c.setRemark(rs.getString(6));
				c.setCourseStatus(rs.getInt(7));
				list.add(c);
			}
			rs.close();
			DbConn.closeConn(conn);
		}
		
		return list;
	}
	
		
	
	/*
	 * 分页查询
	 * 存储过程参
	  @tableName varchar(64),  --分页表名
	  @columns varchar(512),  --查询的字段
	  @order varchar(256),    --排序方式
	  @pageSize int,  --每页大小
	  @pageIndex int,  --当前页
	  @where varchar(max) = '1=1',  --查询条件
	  @totalCount int output  --总记录数
	 */
	 
	
public PagerModel<Course> list(int uid, String order,int pageSize, int pageIndex, String where) throws SQLException{
		
		Connection conn = DbConn.getDbConn();
		List<Course> list = new ArrayList<Course>();
		CallableStatement pstm;
		String conums=" id,code,name,deptId,teacherId, remark,courseStatus ";
		pstm = conn.prepareCall("{call sp_Pager('Course','"
				+conums+ "',?,?,?,?,?)}");  
		pstm.setString(1, order);
		pstm.setInt(2, pageSize);
		pstm.setInt(3, pageIndex);
		pstm.setString(4, where);
		pstm.registerOutParameter(5, Types.INTEGER); 
		boolean f =  pstm.execute();
		int total = 0;
		if(f){						
			ResultSet rs = pstm.getResultSet();
			while(rs.next()){
				Course c = new Course();
				c.setId(rs.getInt(1));
				c.setCode(rs.getString(2));
				c.setName(rs.getString(3));
				
				List<Department> d=new DepartmentDao().select("id="+rs.getInt(4));
				if(d!=null && !d.isEmpty())
					c.setDepartment(d.get(0));
				

				List<Teacher> t=new TeacherDao().select("id="+rs.getInt(5));
				if(t!=null && !t.isEmpty()){
				c.setTeacher(t.get(0));
				}
				
				c.setRemark(rs.getString(6));
				c.setCourseStatus(rs.getInt(7));
				list.add(c);				
			}
			total = pstm.getInt(5);
			rs.close();
		}
		DbConn.closeConn(conn);
		PagerModel<Course> pm = new PagerModel<Course>(total, list);
		return pm;
		
	}
}
