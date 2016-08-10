package com.csmy.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
				+ " set code=?,name=?,deptId=?,teacherId=?,remark=?"
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
	public void delete(String ids) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql="delete from course where id IN ("+ids+")";
		if (conn!=null){
			Statement stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			DbConn.closeConn(conn);
		}			
	}
	
	public void audit(String ids, int status) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql=String.format("update Course set courseStatus=%d  where id IN (%s)",status,ids);
		if (conn!=null){
			Statement stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			DbConn.closeConn(conn);
		}			
	}
	
	public List<Course> list(int pageSize, int pageIndex,int userDeptId) throws SQLException{
		List<Course> list =new ArrayList<Course>();
		  Connection conn = DbConn.getDbConn();
		  /*
		   * 分页算法（SQL SERVER）
		   * 假设页大小为m条记录，查询第n页。
		   *SELECT TOP  m  字段列表   FROM <table> WHERE <条件> and id not IN (
           SELECT  TOP (n-1)*m  id  FROM <table> 
           WHERE <条件>  ORDER BY id  )  
           ORDER BY id 
             -–id为主键
		   */		 
		  
		   int num=(pageIndex-1)*pageSize;
		  String sql ="select top "+pageSize+" c.id,c.code,c.name,c.deptid,d.name,"
		  		+ " c.teacherid,t.name,c.remark,"
		  		+ " c.courseStatus"
		  		+ "	from course c,department d,teacher t"
		  		+ " where c.deptId=d.id and c.teacherId=t.id"
		  		+ "	and c.deptId=?"
		  		+ "	and c.id not in ("
		  		+ " select top "+num+"  c.id"
		  		+ " from course c,department d,teacher t"
		  		+ " where c.deptId=d.id and c.teacherId=t.id"
		  		+ " and c.deptId=?"
		  		+ " order by c.id"
		  		+ ")"
		  		+ "order by c.id";
		  if(conn==null  ) return null;
		  PreparedStatement pstm = conn.prepareStatement(sql);
		  //pstm.setInt(1, pageSize);
		  pstm.setInt(1, userDeptId);
		  //pstm.setInt(3, num);
		  pstm.setInt(2, userDeptId);
		  
		  ResultSet rs=pstm.executeQuery();
		  Course c ;
		  while(rs.next()){
			 c=new Course(); 
			 c.setId(rs.getInt(1));
			 c.setCode(rs.getString(2));
			 c.setName(rs.getString(3));
			 c.setDepartmentid(rs.getInt(4));
			 c.setDeptName(rs.getString(5));
			 c.setTeacherid(rs.getInt(6));
			 c.setTeacherName(rs.getString(7));
			 c.setRemark(rs.getString(8));
			 c.setCourseStatus(rs.getInt(9));
			 list.add(c);
			 }
		  rs.close();
		  DbConn.closeConn(conn);
		return list ;
	}

	public int getCourseSize(int deptid) throws SQLException{
		int result=0;
		  Connection conn = DbConn.getDbConn();
		  String sql="select count(*) from course where deptid=?";
			if (conn==null) return 0;
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.setInt(1, deptid);
			  ResultSet rs=pstm.executeQuery();
			  if(rs.next())
				  result=rs.getInt(1);
			  rs.close();
			  DbConn.closeConn(conn);
		return result;
	}
	
	public PagerModel<Course> list2(int deptid, int pageSize, int pageIndex) throws SQLException
	{
			int total = getCourseSize(deptid);
			List<Course> list = list(pageSize,pageIndex,deptid);
			PagerModel<Course> pm = new PagerModel<Course>(total, list);
			return pm;
	}
	public PagerModel<Course> list(int uid, String order,int pageSize, int pageIndex, String where) throws SQLException{
		
		Connection conn = DbConn.getDbConn();
		List<Course> list = new ArrayList<Course>();
		CallableStatement pstm;
		pstm = conn.prepareCall("{call sp_Pager('Course',' id,code,name,deptId,teacherId,remark,courseStatus ',?,?,?,?,?)}");  
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
				Course c = new Course(rs.getInt(1),rs.getString(2),rs.getString(3));
				c.setDepartmentid(rs.getInt(4));
				c.setTeacherid(rs.getInt(5));
				c.setRemark(rs.getString("remark"));
				c.setCourseStatus(rs.getInt(7));
				list.add(c);				
			}
			total = pstm.getInt(5);
		}
		PagerModel<Course> pm = new PagerModel<Course>(total, list);
		return pm;
		
	}
}
