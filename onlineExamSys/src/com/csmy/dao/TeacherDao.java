package com.csmy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csmy.db.DbConn;
import com.csmy.db.PagerModel;
import com.csmy.object.*;

public class TeacherDao {
	public void insert(Teacher o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void update(Teacher o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(String ids) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public List<Teacher> select(String where) throws SQLException {
		// TODO Auto-generated method stub
		List<Teacher> list=null;
		Connection conn = DbConn.getDbConn();
		if(where ==null) where="1=1";
		String conums=" id ,no ,password ,name ,deptId ,sex ,phone "
				+ ",email ,identityCard ,roleId ,photoUrl"
				+ " ,remark ,teacherstatus ,regTime ,loginTime ,loginIp  ";
		String sql=String.format("SELECT " +conums	+ " FROM teacher "
				+ " where %s",where);
		if(conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs=pstm.executeQuery();
			list = new ArrayList<Teacher>();
			while(rs.next()){
				Teacher c = new Teacher();
				c.setId(rs.getInt(1));
				
				c.setNo(rs.getString(2));
				
				c.setName(rs.getString(3));
				
				List <Department> d=new DepartmentDao().select("id="+rs.getInt(4));
				if(d!=null && !d.isEmpty())
				c.setDepartment(d.get(0));
				
				c.setSex(rs.getString(5));
				c.setPhone(rs.getString(6));
				c.setEmail(rs.getString(7));
				c.setIdentityCard(rs.getString(8));
				//--------------------------------
				//c.setUserrole(userrole);
				//--------------------------------
				 c.setUserrole(null);
				 c.setPhotoUrl(rs.getString(10));
				 c.setRemark(rs.getString(11));
				 c.setTeacherstatus(rs.getString(12));
				 c.setRegTime(rs.getDate(13));
				 c.setLoginTime(rs.getDate(14));
				 c.setLoginIp(rs.getString(15));
				List<Teacher> t=new TeacherDao().select("id="+rs.getInt(5));
				
				list.add(c);
			}
			rs.close();
			DbConn.closeConn(conn);
		}
		
		return list;
	}

	
	public PagerModel<Teacher> list(int uid, String order, int pageSize, int pageIndex, String where)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}	
}
