package com.csmy.dao;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.csmy.bean.*;
import com.csmy.db.DbConn;

public class QuestionDao {
	private  String colums=" id "
			+ ",title"
			+ " ,courseId"
			+ ",dbo.getcourseNameByid(courseId) courseName"
			+ " ,courseunitId"
			+ " ,dbo.getUnitNameByid(courseunitId) unitName"
			+ " ,typeId"
			+ " ,dbo.getQuestionTypeByid(typeId) questionType"
			+ " ,deleteFlag"
			+ "  ,answer"
			+ " ,defficulty"
			+ " ,explanin"
			+ " ,teacherId,"
			+ "  dbo.getTeacherByid(teacherId) teacher"
			+ ", createDate";
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
	
	
	//-------------------------------------------
	/*
    存储过程参数
    @title text,
    @courseId int,
    @courseunitId int,
    @typeId int,          
    @answer varchar(100),
    @defficulty int,
    @explanin text,
    @teacherId int,         
	  @questionOption varchar(500)
	  ----asscii 9 和 11 作为分离符
    --选项之间用 11 
    --选项内容与是否正确用 9
*/

/*
* 选择题插入 ，参数qo为所有选项对象。选项对象的“是否正确答案”属性必需是 0（不正解）或 1（正解答案）值
*/
public void insert(Question q,List<QuestionOption> qo) throws SQLException{
  Connection conn = DbConn.getDbConn();		
	java.sql.CallableStatement cstm=conn.
			prepareCall("{call insertQuestion(?,?,?,?,?,?,?,?,?)}");
	cstm.setString(1, q.getTitle());
	cstm.setInt(2, q.getCourseId());
	if(q.getCourseunitId()==0){
		cstm.setNull(3, Types.INTEGER);
	}else{
		cstm.setInt(3, q.getCourseunitId());
	}
	
	if(q.getTypeId()==0){
		cstm.setNull(4, Types.INTEGER);
	}else{
		cstm.setInt(4, q.getTypeId());
	}
	if(q.getAnswer()  ==null){
		cstm.setNull(5, Types.VARCHAR);
	}else{
		cstm.setString(5, q.getAnswer());
	}
	
	if(q.getDefficulty()==null){
		cstm.setNull(6, Types.INTEGER);
	}else{
		cstm.setInt(6, q.getDefficulty());
	}
	if(q.getExplanin()==null){
		cstm.setNull(7, Types.VARCHAR);
	}else{
		cstm.setString(7, q.getExplanin());
	}
	if (q.getTeacherId()==0){
		cstm.setNull(8, Types.INTEGER);
	}else{
		cstm.setInt(8, q.getTeacherId());
	}
	//------生成选项串---------------
	String optionStr="";
	   Byte isRight;
	   String name="";
	   for(int i=0;i<qo.size();i++){
		   isRight=qo.get(i).getIsRight() ;
		   name=qo.get(i).getName();
		   optionStr=optionStr+name+String.valueOf((char)9)
		   +isRight+String.valueOf((char)11);
				   
	   }
	 
	//---------------
	   cstm.setString(9, optionStr);
	   cstm.execute();
	   DbConn.closeConn(conn);
}
/*
 * 非选择题的插入
 */
public void insert(Question q) throws SQLException{
	  Connection conn = DbConn.getDbConn();	
	  String sql="INSERT INTO question(title ,courseId"
	  		+ " ,courseunitId ,typeId ,answer ,defficulty"
	  		+ " ,explanin ,teacherId )"
	  		+ "  VALUES(?,?,?,?,?,?,?,?) ";
	  if (conn!=null){
		  PreparedStatement pstm = conn.prepareStatement(sql);
		    pstm.setString(1, q.getTitle());
		    
			pstm.setInt(2, q.getCourseId());
			if(q.getCourseunitId()==null || q.getCourseunitId()==0){
				pstm.setNull(3, Types.INTEGER);
			}else{
				pstm.setInt(3, q.getCourseunitId());
			}
			
			if(q.getTypeId()==0){
				pstm.setNull(4, Types.INTEGER);
			}else{
				pstm.setInt(4, q.getTypeId());
			}
			if(q.getAnswer()  ==null){
				pstm.setNull(5, Types.VARCHAR);
			}else{
				pstm.setString(5, q.getAnswer());
			}
			
			if(q.getDefficulty()==null){
				pstm.setNull(6, Types.INTEGER);
			}else{
				pstm.setInt(6, q.getDefficulty());
			}
			if(q.getExplanin()==null){
				pstm.setNull(7, Types.VARCHAR);
			}else{
				pstm.setString(7, q.getExplanin());
			}
			if (q.getTeacherId()==0){
				pstm.setNull(8, Types.INTEGER);
			}else{
				pstm.setInt(8, q.getTeacherId());
			}
			
			pstm.executeUpdate();
			DbConn.closeConn(conn);
	  }
			
}
/*
 * 修改试题
 */
public void update(Question q) throws SQLException{
	  
	    Connection conn = DbConn.getDbConn();	
	  
		String sql="update question "
				+ "  set title=?,courseunitId=?,"
				+ "  answer=?,defficulty=?,"
				+ "  explanin=?"
				+ "  where id=?";
	   
		if(conn!=null){
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.setString(1, q.getTitle());
			 
			 if (q.getCourseunitId() ==0  ){
				 pstm.setNull(2, Types.INTEGER);
			 }else{
				 pstm.setInt(2, q.getCourseunitId());
			 }
			 
			 pstm.setString(3, q.getAnswer());
			 
			 pstm.setInt(4, q.getDefficulty());
			 
			 if(q.getExplanin()==null){
				 pstm.setNull(5, Types.VARCHAR);
			 }else{
				 pstm.setString(5, q.getExplanin());
			 }
			pstm.setInt(6, q.getId());	
			pstm.executeUpdate();
			DbConn.closeConn(conn);
			if(q.getList()!=null && !q.getList().isEmpty()) {
				updateOption(q.getList());
			}
			DbConn.closeConn(conn);
		}
}

/*
 * 更新选项 
 */

private  void updateOption(List<QuestionOption> qo) throws SQLException {
	  Connection conn = DbConn.getDbConn();	
	  String sql="update questionOption set name=?,isright=? where id=?";
	  if(conn!=null){
		  PreparedStatement pstm = conn.prepareStatement(sql);
		  for(int i=0;i<qo.size();i++){
			  pstm.setString(1, qo.get(i).getName());
			  pstm.setByte(2, qo.get(i).getIsRight());
			  pstm.setInt(3, qo.get(i).getId());
			  pstm.executeUpdate();
		  }
		  DbConn.closeConn(conn);
	  }
}

/*
 * 删除，一次删除一条或多条记录
 * @param ids  为ID号，多个ID用豆号分隔
 */
public void delete(String ids) throws SQLException{
		Connection conn = DbConn.getDbConn();		
		String sql="delete from Question where id IN ("+ids+")";
		if (conn!=null){
			Statement stmt = conn.createStatement();			
			stmt.executeUpdate(sql);
			DbConn.closeConn(conn);
		}			
	}
/*
 * 分页查询
 *  存储过程参数
 *  @tableName varchar(64),  --分页表名
    @columns varchar(512),  --查询的字段
    @order varchar(256),    --排序方式
    @pageSize int,  --每页大小
    @pageIndex int,  --当前页
    @where varchar(max) = '1=1',  --查询条件
    @totalCount int output  --总记录数
 */
public PagerModel<Question> list(int uid, String order,int pageSize, int pageIndex, String where) throws SQLException{
		
		Connection conn = DbConn.getDbConn();
		List<Question> list = new ArrayList<Question>();
		
		CallableStatement pstm;
		pstm = conn.prepareCall("{call sp_Pager('question','"
				+ colums + " ',?,?,?,?,?)}");  
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
				  Question q = new Question();
				  q.setId(rs.getInt(1));
				  q.setTitle(rs.getString(2));
				  q.setCourseId(rs.getInt(3));
				  q.setCourseName(rs.getString(4));
				  
				  q.setCourseunitId(rs.getInt(5));
				  q.setNuitName(rs.getString(6));
				 
				  q.setTypeId(rs.getInt(7));
				  q.setTypeName(rs.getString(8));
				 
				  
				  q.setDeleteFlag(rs.getInt(9));
				  q.setAnswer(rs.getString(10));
				  q.setDefficulty(rs.getInt(11));
				  q.setExplanin(rs.getString(12));
				  
				  q.setTeacherId(rs.getInt(13));
				  q.setTeacherNmae(rs.getString(14));			 
				  
				 
				 //处理选项
				  if(rs.getInt("typeid")==1 || rs.getInt("typeid")==2){
					  List<QuestionOption> qo=findOptionByQuestionId(q.getId());
					  q.setList(qo);
				  }
				  list.add(q);
			}
			total = pstm.getInt(5);
			rs.close();
		}
		 DbConn.closeConn(conn);
		PagerModel<Question> pm = new PagerModel<Question>(total, list);
		return pm;
		
	}

private List<QuestionOption>  findOptionByQuestionId(int questionId) throws SQLException{
	  List<QuestionOption> list=null;
	  Connection conn = DbConn.getDbConn();
	  String sql="select id,name,seqNo,isRight "
	  		+ " from questionOption "
	  		+ " where questionId=?";
	   if(conn!=null){
		   list = new ArrayList<QuestionOption>() ; 
		   QuestionOption qo=null;
		   PreparedStatement pstm = conn.prepareStatement(sql);
		   pstm.setInt(1, questionId);
		   ResultSet rs=pstm.executeQuery();
		   while(rs.next()){
			  qo=new QuestionOption();
			  qo.setId(rs.getInt(1));
			  qo.setName(rs.getString(2));
			  qo.setSeqNo(rs.getInt(3));			 
			  qo.setIsRight(rs.getByte(4));				 
			  list.add(qo);
		   }
		   rs.close();
		   DbConn.closeConn(conn);
	   }
		
	 return list;		  
}
/*
 * 带条件查询
 */
public List<Question>  select(String where) throws SQLException{
	    if(where ==null) where="1=1";
	    List<Question> list=null;
		Connection conn = DbConn.getDbConn();
		
		String  sql=String.format("select " +colums+ " from question where %s",where);
		if(conn!=null){
			 list = new ArrayList<Question>();
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 ResultSet rs=pstm.executeQuery();				 
			 while(rs.next()){
				 Question q = new Question();
				  q.setId(rs.getInt(1));
				  q.setTitle(rs.getString(2));
				  q.setCourseId(rs.getInt(3));
				  q.setCourseName(rs.getString(4));
				  
				  q.setCourseunitId(rs.getInt(5));
				  q.setNuitName(rs.getString(6));
				 
				  q.setTypeId(rs.getInt(7));
				  q.setTypeName(rs.getString(8));
				 
				  
				  q.setDeleteFlag(rs.getInt(9));
				  q.setAnswer(rs.getString(10));
				  q.setDefficulty(rs.getInt(11));
				  q.setExplanin(rs.getString(12));
				  
				  q.setTeacherId(rs.getInt(13));
				  q.setTeacherNmae(rs.getString(14));				  
				 
				 //处理选项
				  if(rs.getInt("typeid")==1 || rs.getInt("typeid")==2){
					  List<QuestionOption> qo=findOptionByQuestionId(q.getId());
					  q.setList(qo);
				  }
				  
				  list.add(q); 
			 }
			 rs.close();
			 DbConn.closeConn(conn);
		}
		
	return list;	
} 

}
