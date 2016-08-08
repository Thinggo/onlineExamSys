package com.csmy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.Course;
import com.csmy.bean.ResultModel;
import com.csmy.dao.CourseDao;
import com.sun.xml.internal.fastinfoset.stax.events.Util;
@WebServlet("/admin/courseServlet.do")
public class CourseServlet extends HttpServlet {

	private CourseDao courseDao = new CourseDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if("add".equals(action)){
			add(req,resp);
		}else if("edit".equals(action)){
			edit(req,resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("details".equals(action)){
			details(req,resp);
		}else{
			list(req,resp);
		}
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) {
		String where = req.getParameter("where");
		String pageIndexStr = req.getParameter("pageIndexStr");
		String pageSizeStr = req.getParameter("pageSizeStr");
		String orderStr = req.getParameter("order");
		String sortStr =  req.getParameter("sort");
		if(Util.isEmptyString(where)) where = "1=1";
        int pageIndex = Utils.GetPageIndex(pageIndexStr);
        int pageSize = Utils.GetPageSize(pageSizeStr);
        String mySort = orderStr + " " + sortStr;
        
		
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		
		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		Course c = Utils.formToBean(req, Course.class);
		PrintWriter out = null;
		String json = null;
		try {
			resp.setContentType("text/plain");
			out =  resp.getWriter();
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
