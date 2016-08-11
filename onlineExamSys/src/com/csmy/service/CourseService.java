package com.csmy.service;
import java.util.List;

import com.csmy.bean.Course;
import com.csmy.bean.PagerModel;
import com.csmy.dao.CourseDao;

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
	
	public List<Course> list(int pageSize, int pageIndex,int userDeptId) throws Exception{
		return courseDao.list(pageSize, pageIndex, userDeptId);
	}
	
	public PagerModel<Course> list2(int deptid, int pageSize, int pageIndex) throws Exception{
		return courseDao.list2(deptid, pageSize, pageIndex);
	}
	
	public PagerModel<Course> list(int uid, String order,int pageSize, int pageIndex, String where) throws Exception{
		return courseDao.list(uid, order, pageSize, pageIndex, where);
	}		
}
