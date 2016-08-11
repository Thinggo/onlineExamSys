package com.csmy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.PagerModel;
import com.csmy.bean.PagerModel2;
import com.csmy.bean.Question;
import com.csmy.bean.QuestionOption;
import com.csmy.bean.QuestionType;
import com.csmy.bean.ResultModel;
import com.csmy.bean.Teacher;
import com.csmy.service.QuestionService;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/admin/questionServlet.do")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionService();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String action = req.getParameter("action");
		if("questionType".equals(action)){
			questionTypeList(req,resp);
		}else if("add".equals(action)){
			add(req,resp);
		}else if("edit".equals(action)){
			edit(req,resp);
		}else if("delete".equals(action)){
			delete(req,resp);
		}else if("search".equals(action)){
			search(req,resp);
		}else{
			ResultModel rm = new ResultModel(-1,"未知操作");
			String json = Utils.toJson(rm);
			out.println(json);
			out.flush();
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		String ids = req.getParameter("ids");
		try{
			questionService.delete(ids);
			ResultModel rm = new ResultModel(0,"删除成功！");
			String json = Utils.toJson(rm);
			out.println(json);
		}catch(Exception ex){
			ResultModel rm = new ResultModel(1,"删除失败！");
			String json = Utils.toJson(rm);
			out.println(json);
		}
		out.flush();
		
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
PrintWriter out = null;		
		
		try {						
			out = resp.getWriter();
			Question question = new Question();
			String qid = req.getParameter("id");
			question.setId(Integer.parseInt(qid));
			
			String title = req.getParameter("title");
			String explain = req.getParameter("explain");
			String difficulty = req.getParameter("difficulty");
			String courseId = req.getParameter("courseId");
			String courseunitId = req.getParameter("courseunitId");
			if(courseunitId==null || courseunitId.length()==0){
				courseunitId = "0";
			}
			String answerStr = req.getParameter("answer");
			question.setAnswer(answerStr);
			//题型 
			String typeIdStr = req.getParameter("typeId");
			int questionTypeId = Integer.parseInt(typeIdStr);
			question.setTypeId(questionTypeId);	
			
			question.setTitle(title);			
			question.setCourseId(Integer.parseInt(courseId));
			question.setCourseunitId(Integer.parseInt(courseunitId));
			question.setDefficulty(Integer.parseInt(difficulty));
			question.setExplanin(explain);
			Teacher currentUser = Utils.getCurrentUser(req);
			question.setTeacherId(currentUser.getId());

			if(questionTypeId==1 || questionTypeId == 2){
				//选择题答案: 选择： 1,2,3,4,5,... 
				String[] answers = answerStr.split(",");
				int[] ians = new int[answers.length];
				for(int i=0;i<answers.length;i++){
					ians[i] = Integer.parseInt(answers[i]);
				}
				String options = req.getParameter("options");
				if(options.length()>0){
					
					String[] opts = options.split("\t");				
					List<QuestionOption> optList = new ArrayList<QuestionOption>();
					for(int i=0;i<opts.length;i++){
						QuestionOption qo = new QuestionOption();
						String opt = opts[i];
						int x = opt.indexOf('|');
						String oid = opt.substring(0, x);
						String name = opt.substring(x+1);
						qo.setId(Integer.parseInt(oid));
						qo.setName(name);
						qo.setIsRight((byte)0);
						for(int k=0;k<ians.length;k++){
							if(ians[k]==i+1) {
								qo.setIsRight((byte)1);
								break;
							}
						}
						
						qo.setSeqNo(i+1);
						optList.add(qo);
					}				
					question.setList(optList);
				}
			}
			//Question q = Utils.formToBean(req, Question.class);							
			questionService.update(question);
			ResultModel rm = new ResultModel(0,"修改成功！");
			String json = Utils.toJson(rm);
			out.print(json);
			
		} catch (Exception e) {		
			ResultModel rm = new ResultModel(1,"修改失败！");
			String json = Utils.toJson(rm);		
			out.print(json);
		}		
		out.flush();		
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;		
		
		try {						
			out = resp.getWriter();
			Question question = new Question();
			
			String title = req.getParameter("title");
			String explain = req.getParameter("explain");
			String difficulty = req.getParameter("difficulty");
			String courseId = req.getParameter("courseId");
			String courseunitId = req.getParameter("courseunitId");
			if(courseunitId==null || courseunitId.length()==0){
				courseunitId = "0";
			}
			String answerStr = req.getParameter("answer");
			question.setAnswer(answerStr);
			//题型 
			String typeIdStr = req.getParameter("typeId");
			int questionTypeId = Integer.parseInt(typeIdStr);
			question.setTypeId(questionTypeId);	
			
			question.setTitle(title);			
			question.setCourseId(Integer.parseInt(courseId));
			question.setCourseunitId(Integer.parseInt(courseunitId));
			question.setDefficulty(Integer.parseInt(difficulty));
			question.setExplanin(explain);
			Teacher currentUser = Utils.getCurrentUser(req);
			question.setTeacherId(currentUser.getId());

			if(questionTypeId==1 || questionTypeId == 2){
				//选择题答案: 选择： 1,2,3,4,5,... 
				String[] answers = answerStr.split(",");
				int[] ians = new int[answers.length];
				for(int i=0;i<answers.length;i++){
					ians[i] = Integer.parseInt(answers[i]);
				}
				String options = req.getParameter("options");
				if(options.length()>0){
					
					String[] opts = options.split("\t");				
					List<QuestionOption> optList = new ArrayList<QuestionOption>();
					for(int i=0;i<opts.length;i++){
						QuestionOption qo = new QuestionOption();
						qo.setName(opts[i]);
						qo.setIsRight((byte)0);
						for(int k=0;k<ians.length;k++){
							if(ians[k]==i+1) {
								qo.setIsRight((byte)1);
								break;
							}
						}
						
						qo.setSeqNo(i+1);
						optList.add(qo);
					}				
					question.setList(optList);
				}
			}
			//Question q = Utils.formToBean(req, Question.class);							
			questionService.insert(question);
			
			ResultModel rm = new ResultModel(0,"添加成功！");
			String json = Utils.toJson(rm);
			out.print(json);
			
		} catch (Exception e) {		
			ResultModel rm = new ResultModel(1,"添加失败！");
			String json = Utils.toJson(rm);		
			out.print(json);
		}		
		out.flush();	
	}

	private void search(HttpServletRequest req, HttpServletResponse resp) {
		
		PagerModel<Question>  pm = null;
		PrintWriter out = null;
		try {			
			out = resp.getWriter();
			PagerModel2 pm2 = Utils.formToBean(req, PagerModel2.class);
			Teacher user = Utils.getCurrentUser(req);
			pm = questionService.search(user.getId(),pm2.getSort()+" "+pm2.getOrder(), pm2.getPageSize(), pm2.getPageIndex(), pm2.getWhere());
			String json = Utils.toJson(pm);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("{total:0,rows:[]}");
		}
		out.flush();
	}

	/**
	 * 获取全部习题类型列表
	 * @param req
	 * @param resp
	 */
	private void questionTypeList(HttpServletRequest req, HttpServletResponse resp) {
		List<QuestionType> list = null;
		String json = "[]";
		PrintWriter out = null;
		try {			
			out = resp.getWriter();
			list = questionService.questionTypeList();
			json = Utils.toJson(list);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		out.print(json);
		out.flush();		
	}
}
