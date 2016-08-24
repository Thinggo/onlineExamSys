package com.csmy.servlet;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import com.csmy.bean.Question;
import com.csmy.bean.QuestionOption;
import com.csmy.bean.QuestionType;
import com.csmy.bean.Teacher;
import com.csmy.bean.User;
import com.csmy.service.QuestionService;
import com.csmy.utils.MyProgressListener;
import com.csmy.utils.Utils;
import com.csmy.vo.PagerModel;
import com.csmy.vo.PagerModel2;
import com.csmy.vo.ResultModel;
import com.sun.net.httpserver.HttpServer;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/admin/questionServlet.do")
public class QuestionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionService();
		
	@Override
	protected void other(HttpServletRequest req, HttpServletResponse resp) {
		String action = req.getParameter("action");
		if("questionType".equals(action)){
			questionTypeList(req,resp);
		}else if("getQuestionQty".equals(action)){
			getQuestionQty(req,resp);
		}else{
			doNothing(req, resp);
		}
	}
	private void getQuestionQty(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out = null;
		
		try{
			String courseId = req.getParameter("courseId");
			String courseunitId = req.getParameter("courseunitId");
			String questionTypeId = req.getParameter("questionTypeId");
			String difficulty = req.getParameter("difficulty");
			out = resp.getWriter();
			int cnt = questionService.getQuestionQty(courseId,courseunitId,questionTypeId,difficulty);
			ResultModel rm = new ResultModel(0, cnt + "");
			String json = Utils.toJson(rm);
			out.println(json);
		}catch(Exception ex){
			ResultModel rm = new ResultModel(1,"【失败】");
			String json = Utils.toJson(rm);
			out.println(json);
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

	@Override
	protected void list(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		super.list(req, resp);
	}

	@Override
	protected void details(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		super.details(req, resp);
	}

	
	@Override
	protected void delete(HttpServletRequest req, HttpServletResponse resp)  {
		PrintWriter out = null;
		
		try{
			String ids = req.getParameter("ids");
			out = resp.getWriter();
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
	@Override
	protected void edit(HttpServletRequest req, HttpServletResponse resp){
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
			question.setDifficulty(Integer.parseInt(difficulty));
			question.setExplain(explain);
			User currentUser = Utils.getCurrentUser(req);
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
	@Override
	protected void add(HttpServletRequest req, HttpServletResponse resp) {
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
			question.setDifficulty(Integer.parseInt(difficulty));
			question.setExplain(explain);
			User currentUser = Utils.getCurrentUser(req);
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
	@Override
	protected void search(HttpServletRequest req, HttpServletResponse resp) {
		
		PagerModel<Question>  pm = null;
		PrintWriter out = null;
		try {			
			out = resp.getWriter();
			PagerModel2 pm2 = Utils.formToBean(req, PagerModel2.class);
			User user = Utils.getCurrentUser(req);
			pm = questionService.search(user.getId(),pm2.getSort()+" "+pm2.getOrder(), pm2.getPageSize(), pm2.getPageIndex(), pm2.getWhere());
			String json = Utils.toJson(pm);
			out.println(json);
		} catch (Exception e) {			
			e.printStackTrace();
			out.println("{total:0,rows:[]}");
		}
		out.flush();
	}
	@Override
	protected void export(HttpServletRequest req, HttpServletResponse resp) {
		PagerModel<Question>  pm = null;
		PrintWriter out = null;
		try {			
			out = resp.getWriter();
			String where = req.getParameter("where");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");	
			String path = req.getRealPath("admin/");
			String excel = String.format("upload/试题导出列表%s.xls", formatter.format(Calendar.getInstance().getTime()));
			path = path+"/"+excel;			
			path = path.replace("/", "\\");
			File file = new File(path);
			file.getParentFile().mkdirs();
			questionService.export(path,where);
			ResultModel rm = new ResultModel(0,excel);
			String json = Utils.toJson(rm);		
			out.print(json);
		} catch (Exception e) {			
			ResultModel rm = new ResultModel(1,e.getMessage());
			String json = Utils.toJson(rm);		
			out.print(json);
		}
		out.flush();
	}
	@Override
	protected void importfile(HttpServletRequest req, HttpServletResponse resp) {		
		PrintWriter out = null;
		try {			
			out = resp.getWriter();
			String filename = req.getParameter("filename");
			User user = Utils.getCurrentUser(req);
			MyProgressListener listener = new MyProgressListener(req);
			String path = req.getRealPath("admin/")+"/"+filename;
			questionService.importfile(path,user.getId(),listener);
			ResultModel rm = new ResultModel(0,"文件导入完成！");
			String json = Utils.toJson(rm);		
			out.print(json);
		} catch (Exception e) {	
			
			ResultModel rm = new ResultModel(1, e.getMessage());
			String json = Utils.toJson(rm);		
			out.print(json);
		}
		out.flush();
	}	
}
