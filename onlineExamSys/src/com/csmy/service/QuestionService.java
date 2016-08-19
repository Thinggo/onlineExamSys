package com.csmy.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.csmy.bean.Course;
import com.csmy.bean.CourseUnit;
import com.csmy.bean.Question;
import com.csmy.bean.QuestionType;
import com.csmy.dao.CourseDao;
import com.csmy.dao.CourseUnitDao;
import com.csmy.dao.QuestionDao;
import com.csmy.dao.QuestionTypeDao;
import com.csmy.utils.ExcelUtil;
import com.csmy.utils.LogUtil;
import com.csmy.utils.MyProgressListener;
import com.csmy.utils.ProgressStatus;
import com.csmy.vo.PagerModel;
import com.csmy.vo.QuestionModel;

public class QuestionService {
	QuestionDao questionDao = new QuestionDao();

	public List<QuestionType> questionTypeList() throws Exception {

		return new QuestionTypeDao().questionTypeList();

	}

	public PagerModel<Question> search(Integer uid, String order, int pageSize, int pageIndex, String where)
			throws Exception {

		return questionDao.list(uid, order, pageSize, pageIndex, where);
	}

	public void insert(Question question) throws Exception {
		questionDao.insert(question);
	}

	public void update(Question question) throws Exception {
		questionDao.update(question);
	}

	public void delete(int id) throws Exception {
		questionDao.delete(id + "");
	}

	public void delete(String ids) throws Exception {
		questionDao.delete(ids);
	}

	public int getQuestionQty(String courseId, String courseunitId, String questionTypeId, String difficulty)
			throws Exception {
		String where = "1=1";
		if (courseId != null && courseId.length() > 0) {
			where += " AND courseId=" + courseId;
		}
		if (courseunitId != null && courseunitId.length() > 0) {
			where += " AND courseunitId=" + courseunitId;
		}
		if (questionTypeId != null && questionTypeId.length() > 0) {
			where += " AND typeId=" + questionTypeId;
		}

		if (difficulty != null && difficulty.length() > 0) {
			where += " AND difficulty=" + difficulty;
		}
		int cnt = 0;
		List<Question> list = questionDao.select(where);
		if (list != null)
			cnt = list.size();
		return cnt;
	}

	public void export(String excel, String where) throws Exception {
		String[] COLUMNS_CN = { "试题类型", "课程名称", "课程单元", "试题难度", "试题内容", "标准答案", "试题解析" };
		String[] COLUMNS_EN = { "questionType", "courseName", "unitName", "difficulty", "questionTitle", "answer",
				"explain" };
		List<Question> list = questionDao.select(where);
		int maxLen = 0;
		for (Question q : list) {
			if (q.getList() == null || q.getList().isEmpty())
				continue;
			if (q.getList().size() > maxLen)
				maxLen = q.getList().size();
		}
		String[] titles_en = new String[7 + maxLen];
		String[] titles_cn = new String[7 + maxLen];
		for (int i = 0; i < COLUMNS_CN.length; i++) {
			titles_en[i] = COLUMNS_EN[i];
			titles_cn[i] = COLUMNS_CN[i];
		}
		char ch = 'A';
		for (int i = 0; i < maxLen; i++) {
			titles_en[i + 7] = "option" + (char) (ch + i);
			titles_cn[i + 7] = "选项" + (char) (ch + i);
		}
		ExcelUtil.Questions2Book(excel, list, "试题", titles_en, titles_cn);
	}

	public void importfile(String filename, int uid, MyProgressListener listener) throws Exception {

		File file = new File(filename);

		List<QuestionModel> list = ExcelUtil.readExcel(file, 0, 2, QuestionModel.class);
		if (listener != null) {
			listener.update(list.size(), list.size() * 3, 1);
		}
		List<Question> qlist = new ArrayList<Question>();
		Map<String, Integer> types = new HashMap<String, Integer>();
		Map<String, Integer> courses = new HashMap<String, Integer>();
		Map<String, Integer> units = new HashMap<String, Integer>();

		List<QuestionType> tlist = (new QuestionTypeDao()).questionTypeList();
		for (QuestionType t : tlist) {
			types.put(t.getTypeName(), t.getTypeId());
		}
		CourseUnitDao courseUnitDao = new CourseUnitDao();
		List<Course> clist = (new CourseDao()).select("1=1");
		for (Course c : clist) {
			courses.put(c.getName(), c.getId());
		}
		int i = 1;
		for (QuestionModel m : list) {

			if (listener != null) {
				listener.update(list.size() + i++, list.size() * 3, 1);
			}

			Question q = m.toQuestion();
			q.setTeacherId(uid);
			if (types.containsKey(m.getQuestionType())) {
				q.setTypeId(types.get(m.getQuestionType()));
			} else {
				throw new Exception(m.getCourseName() + " 题型无效！");
			}
			if (courses.containsKey(m.getCourseName())) {
				q.setCourseId(courses.get(m.getCourseName()));
			} else {
				throw new Exception(m.getCourseName() + " 课程无效！");
			}

			if (m.getUnitName() != null && m.getUnitName().length() > 0) {
				if (units.containsKey(m.getCourseName() + m.getUnitName())) {
					q.setCourseunitId(units.get(m.getCourseName() + m.getUnitName()));
				} else {
					List<CourseUnit> us = courseUnitDao
							.select("courseId=" + q.getCourseId() + " AND name='" + m.getUnitName() + "' ");
					if (us.isEmpty())
						throw new Exception(m.getCourseName() + "_"+m.getUnitName() + " 课程单元无效！");
					else {
						units.put(m.getCourseName() + m.getUnitName(), us.get(0).getId());
						q.setCourseunitId(us.get(0).getId());
					}
				}
			}
			qlist.add(q);

		}
		(new QuestionDao()).insert(qlist);
		if (listener != null) {
			listener.update(list.size() * 3, list.size() * 3, 1);
		}
	}

}
