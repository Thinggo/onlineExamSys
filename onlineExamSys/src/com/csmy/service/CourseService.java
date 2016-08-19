package com.csmy.service;
import java.util.List;

import com.csmy.bean.Course;
import com.csmy.dao.CourseDao;
import com.csmy.vo.PagerModel;

public class CourseService {
	private CourseDao courseDao = new CourseDao();
	public void insert(Course c) throws Exception{
		courseDao.insert(c);		
	}
	public void update(Course c) throws Exception{
		courseDao.update(c);
	}
	
	public void delete(int id) throws Exception{
		courseDao.delete(id);
	}
	
	public void delete(String ids) throws Exception{
		courseDao.delete(ids);
	}
	
	public void audit(String ids, int status) throws Exception{
		courseDao.audit(ids, status);
	}
	
	public List<Course> list(int uid) throws Exception{
		return courseDao.select("1=1");
	}
	
	
	public PagerModel<Course> search(int uid, String order,int pageSize, int pageIndex, String where) throws Exception{
		return courseDao.list(uid, order, pageSize, pageIndex, where);
	}		
}
