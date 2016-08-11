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

public class QuestionTypeDao {
	public void insert(QuestionType o) throws SQLException {
		// TODO Auto-generated method stub
		
				
	}

	
	public void update(QuestionType o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(String ids) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public List<QuestionType> select(String where) throws SQLException {
		// TODO Auto-generated method stub
		 List<QuestionType> list=null;
		 if(where==null ) where="1=1";
		 Connection conn = DbConn.getDbConn();		
			String sql="select typeid,typeName,isObjective,remark from QuestionType ";
			sql=String.format(sql + " where %s",where);
			if (conn!=null){
				PreparedStatement pstm = conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				QuestionType qt=null;
				list=new ArrayList<QuestionType>();
				while(rs.next()){
					qt=new QuestionType();
					qt.setTypeId(rs.getInt(1));
					qt.setTypeName(rs.getString(2));
					qt.setIsObjective(rs.getBoolean(3));
					qt.setRemark(rs.getString(4));
					list.add(qt);
				}
				rs.close();
				DbConn.closeConn(conn);
			}
		return null;
	}

	
	public PagerModel<QuestionType> list(int uid, String order, int pageSize, int pageIndex, String where)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
