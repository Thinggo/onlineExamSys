package com.csmy.object;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * PaperDetail entity. @author MyEclipse Persistence Tools
 */

public class PaperDetail implements java.io.Serializable {

	// Fields

	private Integer pagerId;
	private Teacher teacher;
	private ExamPlan examPlan;
	private Question question;
	private Student student;
	private Integer displayId;
	private String answer;
	private Double score;
	private Timestamp markingTime;
	private Boolean flag;
	private Set paperOptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public PaperDetail() {
	}

	/** minimal constructor */
	public PaperDetail(ExamPlan examPlan, Question question, Student student,
			Integer displayId) {
		this.examPlan = examPlan;
		this.question = question;
		this.student = student;
		this.displayId = displayId;
	}

	/** full constructor */
	public PaperDetail(Teacher teacher, ExamPlan examPlan, Question question,
			Student student, Integer displayId, String answer, Double score,
			Timestamp markingTime, Boolean flag, Set paperOptions) {
		this.teacher = teacher;
		this.examPlan = examPlan;
		this.question = question;
		this.student = student;
		this.displayId = displayId;
		this.answer = answer;
		this.score = score;
		this.markingTime = markingTime;
		this.flag = flag;
		this.paperOptions = paperOptions;
	}

	// Property accessors

	public Integer getPagerId() {
		return this.pagerId;
	}

	public void setPagerId(Integer pagerId) {
		this.pagerId = pagerId;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public ExamPlan getExamPlan() {
		return this.examPlan;
	}

	public void setExamPlan(ExamPlan examPlan) {
		this.examPlan = examPlan;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getDisplayId() {
		return this.displayId;
	}

	public void setDisplayId(Integer displayId) {
		this.displayId = displayId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Timestamp getMarkingTime() {
		return this.markingTime;
	}

	public void setMarkingTime(Timestamp markingTime) {
		this.markingTime = markingTime;
	}

	public Boolean getFlag() {
		return this.flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Set getPaperOptions() {
		return this.paperOptions;
	}

	public void setPaperOptions(Set paperOptions) {
		this.paperOptions = paperOptions;
	}

}