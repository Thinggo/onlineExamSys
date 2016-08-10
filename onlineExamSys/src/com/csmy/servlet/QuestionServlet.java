package com.csmy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.QuestionType;
import com.csmy.dao.QuestionDao;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/admin/questionServlet.do")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDao questionDao = new QuestionDao();
	private PrintWriter out = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		out = resp.getWriter();
		String action = req.getParameter("action");
		if("questionType".equals(action)){
			questionTypeList(req,resp);
		}
	}

	private void questionTypeList(HttpServletRequest req, HttpServletResponse resp) {
		List<QuestionType> list = null;
		String json = "[]";
		try {
			list = questionDao.questionTypeList();
			json = Utils.toJson(list);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		out.print(json);
		out.flush();		
	}

}
