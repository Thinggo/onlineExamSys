package com.csmy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.csmy.bean.QuestionType;
import com.csmy.db.DbConn;

public class QuestionDao {
	public List<QuestionType> questionTypeList() throws Exception {
		List<QuestionType> list = new ArrayList<QuestionType>();
		Connection conn = DbConn.getDbConn();
		String sql = "select typeId,typeName,isObjective,remark from QuestionType";
		if (conn == null)
			return list;
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);
		QuestionType c;
		while (rs.next()) {
			c = new QuestionType();
			c.setTypeId(rs.getInt(1));
			c.setTypeName(rs.getString(2));
			c.setIsObjective(rs.getByte(3));
			c.setRemark(rs.getString(4));
			list.add(c);
		}
		rs.close();
		DbConn.closeConn(conn);
		return list;
	}

}
