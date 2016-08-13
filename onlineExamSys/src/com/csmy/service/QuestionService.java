package com.csmy.service;

import java.util.List;

import com.csmy.bean.PagerModel;
import com.csmy.bean.Question;
import com.csmy.bean.QuestionType;
import com.csmy.dao.QuestionDao;

public class QuestionService {
	QuestionDao questionDao = new QuestionDao();
	public List<QuestionType> questionTypeList() throws Exception {
		return questionDao.questionTypeList();
		
	}
	public PagerModel<Question> search(Integer uid, String order, int pageSize, int pageIndex, String where) throws Exception {
		
		return questionDao.list(uid, order, pageSize, pageIndex, where);
	}
	
	public void insert(Question question) throws Exception{
		if(question.getList()!=null){
			questionDao.insert(question,question.getList());
		}else{
			questionDao.insert(question);
		}
	}
	
	public void update(Question question) throws Exception{
		questionDao.update(question);
	}
	
	public void delete(int id)  throws Exception{		
		questionDao.delete(id+"");
	}
	
	public void delete(String ids) throws Exception{
		questionDao.delete(ids);
	}
	public int getQuestionQty(String courseId, String courseunitId, String questionTypeId, String difficulty) throws Exception {
		String where = "1=1";
		if(courseId!=null && courseId.length() >0){
			where += " AND courseId="+courseId;
		}
		if(courseunitId!=null && courseunitId.length() >0){
			where += " AND courseunitId="+courseunitId;
		}
		if(questionTypeId!=null && questionTypeId.length() >0){
			where += " AND typeId="+questionTypeId;
		}
		
		if(difficulty!=null && difficulty.length() >0){
			where += " AND defficulty="+difficulty;
		}
		int cnt = 0;
		List<Question> list = questionDao.select(where);
		if(list!=null) cnt = list.size();
		return cnt;
	}
		
}
