package com.csmy.dao;

import java.sql.*;
import com.csmy.object.*;
import com.csmy.db.*;
import java.util.*;
public class QuestionDao {
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
		cstm.setInt(2, q.getCourse().getId());
		if(q.getCourseUnit()==null){
			cstm.setNull(3, Types.INTEGER);
		}else{
			cstm.setInt(3, q.getCourseUnit().getId());
		}
		
		if(q.getType()==null){
			cstm.setNull(4, Types.INTEGER);
		}else{
			cstm.setInt(4, q.getType().getTypeId());
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
		if (q.getTeacher()==null){
			cstm.setNull(8, Types.INTEGER);
		}else{
			cstm.setInt(8, q.getTeacher().getId());
		}
		//------生成选项串---------------
		String optionStr="";
		   boolean isRight;
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
			    
				pstm.setInt(2, q.getCourse().getId());
				if(q.getCourseUnit()==null){
					pstm.setNull(3, Types.INTEGER);
				}else{
					pstm.setInt(3, q.getCourseUnit().getId());
				}
				
				if(q.getType()==null){
					pstm.setNull(4, Types.INTEGER);
				}else{
					pstm.setInt(4, q.getType().getTypeId());
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
				if (q.getTeacher()==null){
					pstm.setNull(8, Types.INTEGER);
				}else{
					pstm.setInt(8, q.getTeacher().getId());
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
				 
				 if (q.getCourseUnit() ==null  ){
					 pstm.setNull(2, Types.INTEGER);
				 }else{
					 pstm.setInt(2, q.getCourseUnit().getId());
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
		  String sql="update questionOption set name=?,isrigth=? where id=?";
		  if(conn!=null){
			  PreparedStatement pstm = conn.prepareStatement(sql);
			  for(int i=0;i<qo.size();i++){
				  pstm.setString(1, qo.get(i).getName());
				  pstm.setBoolean(2, qo.get(i).getIsRight());
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
			String columns ="id,title,courseId,"
					+ "  typeid,"
					+ "  deleteFlag,answer,defficulty ,"
					+ "  explanin,"
					+ "  teacherId,"
					+ "  createDate";
			CallableStatement pstm;
			pstm = conn.prepareCall("{call sp_Pager('question','"
					+ columns + " ',?,?,?,?,?)}");  
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
					  List<Course> c=new CourseDao().select("id="+rs.getInt(3));
					  if(c!=null && !c.isEmpty())
					  q.setCourse(c.get(0));
							 
					  List<QuestionType> qt=new QuestionTypeDao().select("id="+rs.getInt(4));
					  if(qt!=null && !qt.isEmpty())
						 q.setType(qt.get(0));
					  
					  q.setDeleteFlag(rs.getInt(5));
					  q.setAnswer(rs.getString(6));
					  q.setDefficulty(rs.getInt(7));
					  q.setExplanin(rs.getString(8));
					  
					  List<Teacher> t=new TeacherDao().select("id="+rs.getInt(9));
					  if(t!=null && !t.isEmpty())
						  q.setTeacher(t.get(0));
					 
					  q.setCreateDate(rs.getDate(10));
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
				  qo.setId(rs.getInt(3));
				  qo.setIsRight(rs.getBoolean(4));				 
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
			String columns ="id,title,courseId,"
					+ "  typeid,"
					+ "  deleteFlag,answer,defficulty ,"
					+ "  explanin,"
					+ "  teacherId,"
					+ "  createDate";
			String  sql=String.format("select " +columns+ " from question where %s",where);
			if(conn!=null){
				 list = new ArrayList<Question>();
				 PreparedStatement pstm = conn.prepareStatement(sql);
				 ResultSet rs=pstm.executeQuery();				 
				 while(rs.next()){
					  Question q = new Question();
					  q.setId(rs.getInt(1));
					  q.setTitle(rs.getString(2));
					  List<Course> c=new CourseDao().select("id="+rs.getInt(3));
					  if(c!=null && !c.isEmpty())
					  q.setCourse(c.get(0));
							 
					  List<QuestionType> qt=new QuestionTypeDao().select("id="+rs.getInt(4));
					  if(qt!=null && !qt.isEmpty())
						 q.setType(qt.get(0));
					  
					  q.setDeleteFlag(rs.getInt(5));
					  q.setAnswer(rs.getString(6));
					  q.setDefficulty(rs.getInt(7));
					  q.setExplanin(rs.getString(8));
					  
					  List<Teacher> t=new TeacherDao().select("id="+rs.getInt(9));
					  if(t!=null && !t.isEmpty())
						  q.setTeacher(t.get(0));
					 
					  q.setCreateDate(rs.getDate(10));
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

