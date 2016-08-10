package com.csmy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.Course;
import com.csmy.bean.PagerModel;
import com.csmy.bean.PagerModel2;
import com.csmy.bean.ResultModel;
import com.csmy.bean.Teacher;
import com.csmy.dao.CourseDao;
import com.sun.xml.internal.fastinfoset.stax.events.Util;
@WebServlet("/admin/courseServlet.do")
public class CourseServlet extends HttpServlet {
	
	private CourseDao courseDao = new CourseDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		resp.setContentType("text/plain");
		
		if("add".equals(action)){
			add(req,resp);
		}else if("edit".equals(action)){
			edit(req,resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("details".equals(action)){
			details(req,resp);
		}else if("audit".equals(action)){
			audit(req,resp);
		}else if("list".equals(action)){
			list(req,resp);
		}else if("listUnit".equals(action)){
			listUnit(req,resp);
		}else{
			listEx(req,resp);
		}
	}

	

	private void listUnit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("[]");
		out.flush();		
	}

	private void audit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String ids = req.getParameter("ids");
		String json = null;
		try {
			courseDao.audit(ids, 2);
			ResultModel rm = new ResultModel(0,"审核成功！");
			json = Utils.toJson(rm);
		} catch (SQLException e) {
			ResultModel rm = new ResultModel(1,"审核失败！");
			json = Utils.toJson(rm);	
			e.printStackTrace();
		}
		out.write(json);
		out.flush();	
		
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException {			
		List<Course>  list = null;
		PrintWriter out = resp.getWriter();
		try {						
			Teacher user = Utils.getCurrentUser(req);
			list = courseDao.list(Integer.MAX_VALUE, 1,user.getDeptId());
			String json = Utils.toJson(list);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("[]");
		}
		out.flush();		
	}
	
	private void listEx(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PagerModel<Course>  pm = null;
		PrintWriter out = resp.getWriter();
		try {			
			PagerModel2 pm2 = Utils.formToBean(req, PagerModel2.class);
			Teacher user = Utils.getCurrentUser(req);
			//pm = courseDao.list(user.getId(),pm2.getSort()+" "+pm2.getOrder(), pm2.getPageSize(), pm2.getPageIndex(), pm2.getWhere());
			pm = courseDao.list2(user.getDeptId(), pm2.getPageSize(), pm2.getPageIndex());
			String json = Utils.toJson(pm);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("{total:0,rows:[]}");
		}
		out.flush();
		
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String ids = req.getParameter("ids");
		String json = null;
		try {
			courseDao.delete(ids);
			ResultModel rm = new ResultModel(0,"删除成功！");
			json = Utils.toJson(rm);
		} catch (SQLException e) {
			ResultModel rm = new ResultModel(1,"修改失败！");
			json = Utils.toJson(rm);	
			e.printStackTrace();
		}
		out.write(json);
		out.flush();		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		Course c = null;		
		String json = null;
		try {			
			c = Utils.formToBean(req, Course.class);	
			Teacher currentUser = Utils.getCurrentUser(req);
			c.setTeacherid(currentUser.getId());
			c.setDepartmentid(currentUser.getDeptId());
			courseDao.update(c);
			ResultModel rm = new ResultModel(0,"修改成功！");
			json = Utils.toJson(rm);
			
		} catch (Exception e) {		
			ResultModel rm = new ResultModel(1,"修改失败！");
			json = Utils.toJson(rm);			
		}
		out.print(json);
		out.flush();
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		Course c = Utils.formToBean(req, Course.class);		
		String json = null;
		try {			
			Teacher currentUser = Utils.getCurrentUser(req);
			c.setTeacherid(currentUser.getId());
			c.setDepartmentid(currentUser.getDeptId());
			courseDao.insert(c);
			ResultModel rm = new ResultModel(0,"添加成功！");
			json = Utils.toJson(rm);
			
		} catch (Exception e) {		
			ResultModel rm = new ResultModel(1,"添加失败！");
			json = Utils.toJson(rm);
			
		}
		out.print(json);
		out.flush();
	}
}
