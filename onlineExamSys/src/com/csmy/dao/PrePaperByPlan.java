package com.csmy.dao;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import com.csmy.db.*;


public class PrePaperByPlan {
	private int planId;
	private boolean examPattern ; 
	//考试方式，同批同题或同批不同题（0 false：同题；1  true：不同题）
	private boolean isDiffOrunit=true; 
	//按难度系数或知识单元,1 true 难度系数（默认）, 0  false 单元
	private int courseId;
	//计划对应的课程ID
	private Map<String,List<Integer>>  questionMap;
	//与计划对应的课程所有题号，key为试题类型+难度系数或为试题类型+单元id
	private Map<String,Integer>  paramMap;
	//参数MAP key 为试题类型+难度系数或为试题类型+单元id  value为题数
	private List<Integer> studentList;
	// 对应考试计划的所有考生列表
	/*
	 * 构造函数
	 * @param 考试计划编号
	 */
	public PrePaperByPlan(int planId) {
		this.planId=planId;
		 //对MAP和list 进行初始化
		 questionMap=new HashMap<String, List<Integer>>();
		 paramMap=new HashMap<String,Integer>();
		 studentList=new ArrayList<Integer>();
		 
	}
	
	 
	
	public void  makeAllPaper() throws Exception{
		try {
			init();
			
			    Map<Integer,List<Integer>> paper=createOnePaper();
		        //paper 是Map<类型，题号列表>
				for(int i=0;i<studentList.size();i++){					
					 makePaper(studentList.get(i), paper); 
					 //---如果同批不同题
					if(examPattern){
						paper=createOnePaper();
					}
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("预发试卷失败！！");
		}
		
	}
	
	/*
	 * 初始所有属性
	 */
	private void init() throws SQLException{
		setExamPattern(); //初始化examPattern、isDiffOrunit、courseId属性
		setQuestionMap();
		setParamMap();
		setStudentList();
	}
	
		
	/*
	 * 查询examPattern、isDiffOrunit、courseId的并给这些属性值
	 */
	
	 private void setExamPattern() throws SQLException {
		
		Connection conn = DbConn.getDbConn();
		
		String sql="select examPattern,isDiffOrunit,courseId"
				+ " from examStrategy"
				+ " where id =(select strategyId"
				+ " from examPlan  where id=?)";
		if (conn!=null){
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.setInt(1,planId);
			 ResultSet rs=pstm.executeQuery();
			 if(rs.next()){
				
				 examPattern=rs.getBoolean(1);
				 isDiffOrunit=rs.getBoolean(2);
				 courseId=rs.getInt(3);
			 }
			 rs.close();
			 DbConn.closeConn(conn);
		} 
		
		
	}
	/*
	 * 查询与计划对应的课程所有题号，设置 questionMap<>;
	 * key为试题类型+难度系数或为试题类型+单元id
	 */
	private void setQuestionMap() throws SQLException {
		
		Connection conn = DbConn.getDbConn();
		String sql ;
		if (isDiffOrunit){//按难度系数抽题
			sql="select  str(typeid)+'@'+str(defficulty) typeAndDiff , id"
					+ " from [dbo].[question]"
					+ "  where courseId=? "
					+ " order by typeid,defficulty";
			/*
			 sql= select  str(typeid)+'@'+str(defficulty) typeAndDiff , id
              from [dbo].[question]
              where courseId=?  and defficulty is not null and typeid in(
              select   [questionType]
              from  [dbo].[examStrategyDetail]
               where [strategyId] = (
               select strategyId
               from examPlan
               where id=?))         //id为计划ID
               order by typeid,defficulty
			 */
			
		}else{//按课程单元抽题
			sql="select  str(typeid)+'@'+str(courseunitId) typeAndDiff,id"
					+ " from [dbo].[question]"
					+ " where courseId=?"
					+ " order by typeid,courseunitId";
		}
		if(conn!=null){
		   PreparedStatement pstm = conn.prepareStatement(sql);
		   pstm.setInt(1, courseId);	
		   ResultSet rs=pstm.executeQuery();
		   //----------------------------------
		   List<Integer> list=null;
		   String typeAndDiff="";
		   String key="";
		   int id;
		   //-----读第一条----------------
		   if(rs.next()){
			   list=new ArrayList<Integer>();
			   typeAndDiff=rs.getString(1);
			   key=typeAndDiff;
			   id=rs.getInt(2);
			   list.add(id);
		   }else{
			   return;
		   }
		   //---------------------------
		   while(rs.next()){
			   
			   typeAndDiff=rs.getString(1);
			   id=rs.getInt(2);
			   //如果类型+系数与上一条记录相同，把题号加到list中
			   if(typeAndDiff.equals(key)){
				   list.add(id)  ; 
			   }else{//如果类型+系数与上一条记录不同，说明同一个类型+系数的题处理完了
				   questionMap.put(key, list); 
				   key=typeAndDiff;
				   list=new ArrayList<Integer>();
				   list.add(id);
				   
			   }			   
		   }
		   //最后一个list
		   questionMap.put(key, list); 
		   rs.close();
		   //------关闭连接------
		   DbConn.closeConn(conn);
		}
		
	}
	/*
	 * 生成参数Map
	 */
	private void setParamMap() throws SQLException {
		Connection conn = DbConn.getDbConn();
		//根据计划号 从组卷策略详细中查询 类型+难度系数和抽题数量
		String sql="select str(questionType) +'@'+str(unitId)  typeAndDiff , quantity"
				+ " from examStrategyDetail"
				+ " where strategyId = (select strategyId from examPlan where id=?)"
				+ " order by questionType,unitId";
		if(conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, planId);
			ResultSet rs=pstm.executeQuery();
			while (rs.next()){
				paramMap.put(rs.getString(1), rs.getInt(2));
			}
			//-----------------关闭连接------
			rs.close();
			DbConn.closeConn(conn);
		}		   
	}
	/*
	 * 生成考生list
	 */
	private void setStudentList() throws SQLException {
		Connection conn = DbConn.getDbConn();
		
		String sql="select studentId"
				+ " from examStudent"
				+ " where examplanId=? and examstatus!=1";
		//examstatus!=1 表示没有发放试卷
		if(conn!=null){
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, planId);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				studentList.add(rs.getInt(1));
			}
			//-----------------关闭连接------
			rs.close();
			DbConn.closeConn(conn);
		}
			
	}
		
	/*
	 * 生成一份试卷
	 */
	private Map<Integer,List<Integer>> createOnePaper(){
		//Map<试题类型，list<题号>>
		Map<Integer,List<Integer>> paperMap =new HashMap<Integer, List<Integer>>(); //初始化试卷
	    Iterator<String> it=paramMap.keySet().iterator(); 
	    String typeAndDiff=""; //试题类型+难度系数
	    String temp[];
	    int type=0;  //试题类型
	    int typekey=0; //试题类型，保存前一个值
	    List<Integer> list=null;  //对应特定试题类型+难度系数的所有题号
	    List<Integer>  questionNo=new ArrayList<Integer>();//每种类型抽的题号
	    int count=0;  //对应特定试题类型+难度系数的抽题数量
	    
	    //--------------处理第一条 --------------------------
	    if(it.hasNext()){	    	
	    	 typeAndDiff=it.next(); 
	    	 count=paramMap.get(typeAndDiff);//抽取数量
	    	 list=questionMap.get(typeAndDiff); //总题
	    	 java.util.Collections.shuffle(list);//将list的顺序打乱
	    	 temp=typeAndDiff.split("@"); //分离类型与难度系数
	    	 type=Integer.parseInt(temp[0].trim());
	    	 typekey=type;
	    	 //----------------------
	    	
	    	 for(int i=0;i<count;i++){
	    		 questionNo.add(list.get(i)); 
	    	 }
	    	 //----------------------
	    	
	    }  else{
	    	return null;
	    }  
	    
	    //------------------------------------------
		while(it.hasNext()){
			 typeAndDiff=it.next();
	    	 count=paramMap.get(typeAndDiff);
	    	 list=questionMap.get(typeAndDiff);
	    	 Collections.shuffle(list);
	    	 temp=typeAndDiff.split("@"); //分离类型与难度系数
	    	 type=Integer.parseInt(temp[0].trim());
	    	//------------------------------------ 
	    	 if(type==typekey){
	    		 
	    		 for(int i= 0;i<count;i++){
		    		 questionNo.add(list.get(i)); 
		    	 } 
	    	 }else{
	    		 paperMap.put(typekey,  questionNo);
	    		 typekey=type;
	    		 questionNo=new ArrayList<Integer>();
	    		 
	    		 for(int i= 0;i<count;i++){
		    		 questionNo.add(list.get(i)); 
		    	 } 
	    	 }
			
		}		
		//--------------加最后一个---		
		 paperMap.put(typekey,  questionNo);	
		 return  paperMap;
	}
	
	/*
	 * 给一个学生发试卷  ---写一套试卷
	 */
     private boolean  makePaper(int studentId, Map<Integer,List<Integer>> paperMap) throws SQLException{
    	
    	// paperMap 为Map<试题类型，list<题号>>
    	 int count=1; //计数器  作为显示号
    	 int type=0 ; //类型编号
    	 List<Integer> questionList=null; //每种类型的试题列表
    	 //生成试卷
    	 // Map<Integer,List<Integer>> paperMap = createOnePaper();
    	 //------------如果没有试卷--------------
    	 if(paperMap==null && paperMap.size()==0) return false;
    	 Iterator<Integer> types=paperMap.keySet().iterator();
    	 
    	 while(types.hasNext()){
    		 type=types.next();
    		 questionList=paperMap.get(type);
    		 Collections.shuffle(questionList);
    		 //写一种类型    		
    			 for(int i=0;i<questionList.size();i++){
        			 //写一题,学生、题号，显示顺序号、计划号
        			 savePaper(studentId,questionList.get(i),count);
        			 count++;
        			 //-------写选项----
        			 if(type==1 || type ==2 ){
        			 int no=findPaperDetailId(studentId,planId,questionList.get(i));
        			 List<Integer> optionList=findoOptionId(questionList.get(i));
        			 savePaperOption(no, optionList);
        			 }
            	 }     		 	 
    	 }   
    	 updateStudentStatus(studentId,planId) ;
        return true; 	 
     }
     
     /*
      * 查询试卷详细编号，按考生号、计划号、题号
      */
     private int findPaperDetailId(int studentId,int planId,int questionId) throws SQLException{
    	 int result=-1;
    	 Connection conn = DbConn.getDbConn();
    	 String sql="select pagerId"
    	 		+ " from paperDetail"
    	 		+ "  where studentId=? and questionId=? and planId=?";
    	 if(conn!=null){
    		 PreparedStatement pstm = conn.prepareStatement(sql); 
    		 pstm.setInt(1, studentId);
    		 pstm.setInt(2, questionId);
    		 pstm.setInt(3, planId);
    		 ResultSet rs=pstm.executeQuery();
    		 if(rs.next()){
    			 result=rs.getInt(1);
    		 }
    		 
    		//-----------------关闭连接------
 			rs.close();
 			DbConn.closeConn(conn);
    	 }
    	 return result;
     }
     /*
      * 给定题号、学生，把试卷写入数据库   --写一题
      */
         private void savePaper(int studentId,int questionId,int displayId) throws SQLException{
        	 Connection conn = DbConn.getDbConn();
        	 String sql="insert into paperDetail(studentId,planId,questionId,displayId)"
        	 		+ " values(?,?,?,?)";
        	 if(conn!=null){
        		 PreparedStatement pstm = conn.prepareStatement(sql); 
        		 pstm.setInt(1, studentId);
        		 pstm.setInt(2, planId);
        		 pstm.setInt(3, questionId);
        		 pstm.setInt(4, displayId);
        		 pstm.executeUpdate();
        		 //--------------------------        		
      			DbConn.closeConn(conn);
        	 }
      			
         }
     
     /*
      * 给定选择题的题号，查询对应的选项编号
      */
     private List<Integer> findoOptionId(int questionId) throws SQLException{
    	 List<Integer> optionList=new ArrayList<Integer>();
    	 Connection conn = DbConn.getDbConn();
    	 String sql="select id from  questionOption where questionId=?";
 		if(conn!=null){
 			PreparedStatement pstm = conn.prepareStatement(sql);
 			pstm.setInt(1, questionId);
 			ResultSet rs=pstm.executeQuery();
 			while(rs.next()){
 				optionList.add(rs.getInt(1));
 			}
 			//-----------------
 			rs.close();
 			DbConn.closeConn(conn);
 			Collections.shuffle(optionList);
 		}
    	 return optionList;
     }
     /*
      * 保存试卷选项
      */
     private void savePaperOption(int paperId, List<Integer> list) throws SQLException{
    	 Connection conn = DbConn.getDbConn();
    	 String sql="insert into  paperOption(paperDetailId,optionId,label)"
    	 		+ " values(?,?,?)";
    	 if(conn!=null){
    		 PreparedStatement pstm = conn.prepareStatement(sql);
    		for(int i=65;i<65+list.size();i++){
    		 pstm.setInt(1, paperId);
    		 pstm.setInt(2, list.get(i-65));
    		 pstm.setString(3, String.valueOf((char)i));
    		 pstm.executeUpdate();
    		} 
    		DbConn.closeConn(conn);
    		
    	 }
     }
     
     /*
      * 改写考生状态
      */
     private void updateStudentStatus(int studentId,int planId) throws SQLException{
    	 Connection conn = DbConn.getDbConn();
    	 String sql="update examStudent"
    	 		+ " set examstatus=1"
    	 		+ "  where studentId=? and examplanId=?";
    	 if(conn!=null){
    		 PreparedStatement pstm = conn.prepareStatement(sql);
    		 pstm.setInt(1, studentId);
    		 pstm.setInt(2, planId);
    		 pstm.executeUpdate();
    		 
    		 DbConn.closeConn(conn);
    	 }
     }
     
    
}
