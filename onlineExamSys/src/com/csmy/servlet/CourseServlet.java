package com.csmy.servlet;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.Course;
import com.csmy.bean.PagerModel;
import com.csmy.bean.PagerModel2;
import com.csmy.bean.ResultModel;
import com.csmy.bean.Teacher;
import com.csmy.service.CourseService;
@WebServlet("/admin/courseServlet.do")
public class CourseServlet extends BaseServlet {
	
	private CourseService courseService = new CourseService();
	
	
	@Override
	protected void other(HttpServletRequest req, HttpServletResponse resp) {
		String action = req.getParameter("action");
		if("audit".equals(action)){
			audit(req,resp);
		}else{
			doNothing(req,resp);
		}
	}

	protected void audit(HttpServletRequest req, HttpServletResponse resp){
		PrintWriter out =null;
		String ids = req.getParameter("ids");
		String json = null;
		try {
			out = resp.getWriter();
			courseService.audit(ids, 1);
			ResultModel rm = new ResultModel(0,"审核成功！");
			json = Utils.toJson(rm);
		} catch (Exception e) {
			ResultModel rm = new ResultModel(1,"审核失败！");
			json = Utils.toJson(rm);	
			e.printStackTrace();
		}
		out.write(json);
		out.flush();	
		
	}
	
	protected void list(HttpServletRequest req, HttpServletResponse resp) {			
		List<Course>  list = null;
		PrintWriter out = null;
		try {				
			out = resp.getWriter();
			Teacher user = Utils.getCurrentUser(req);
			list = courseService.list(user.getDeptId());
			String json = Utils.toJson(list);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("[]");
		}
		out.flush();		
	}
	
	protected void search(HttpServletRequest req, HttpServletResponse resp) {
		PagerModel<Course>  pm = null;
		PrintWriter out = null;
		try {			
			 out = resp.getWriter();
			PagerModel2 pm2 = Utils.formToBean(req, PagerModel2.class);
			Teacher user = Utils.getCurrentUser(req);
			pm = courseService.search(user.getId(),pm2.getSort()+" "+pm2.getOrder(), pm2.getPageSize(), pm2.getPageIndex(), pm2.getWhere());			
			String json = Utils.toJson(pm);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("{total:0,rows:[]}");
		}
		out.flush();
		
	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp)  {
		PrintWriter out = null;
		String ids = req.getParameter("ids");
		String json = null;
		try {
			out = resp.getWriter();
			courseService.delete(ids);
			ResultModel rm = new ResultModel(0,"删除成功！");
			json = Utils.toJson(rm);
		} catch (Exception e) {
			ResultModel rm = new ResultModel(1,"修改失败！");
			json = Utils.toJson(rm);	
			e.printStackTrace();
		}
		out.write(json);
		out.flush();		
	}

	protected void edit(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;
		Course c = null;		
		String json = null;
		try {			
			out = resp.getWriter();
			c = Utils.formToBean(req, Course.class);	
			Teacher currentUser = Utils.getCurrentUser(req);
			c.setTeacherid(currentUser.getId());
			c.setDepartmentid(currentUser.getDeptId());
			courseService.update(c);
			ResultModel rm = new ResultModel(0,"修改成功！");
			json = Utils.toJson(rm);
			
		} catch (Exception e) {		
			ResultModel rm = new ResultModel(1,"修改失败！");
			json = Utils.toJson(rm);			
		}
		out.print(json);
		out.flush();
		
	}

	protected void add(HttpServletRequest req, HttpServletResponse resp)  {
		
		PrintWriter out = null;
		Course c = Utils.formToBean(req, Course.class);		
		String json = null;
		try {			
			out = resp.getWriter();
			Teacher currentUser = Utils.getCurrentUser(req);
			c.setTeacherid(currentUser.getId());
			c.setDepartmentid(currentUser.getDeptId());
			courseService.insert(c);
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
