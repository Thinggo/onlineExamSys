package com.csmy.service;

import java.util.List;

import com.csmy.bean.QuestionType;
import com.csmy.dao.QuestionDao;

public class QuestionService {
	QuestionDao questionDao = new QuestionDao();
	public List<QuestionType> questionTypeList() throws Exception {
		return questionDao.questionTypeList();
		
	}
}
