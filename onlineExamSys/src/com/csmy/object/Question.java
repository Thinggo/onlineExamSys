package com.csmy.object;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.csmy.object.*;
/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private Integer id;
	private CourseUnit courseUnit;
	private Teacher teacher;
	private Course course;
	private String title;
	private QuestionType type;
	private Integer deleteFlag;
	private String answer;
	private Integer defficulty;
	private String explanin;
	private Date createDate;
	private List<QuestionOption> list ;
	private Set paperDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(String title, Integer deleteFlag, Date createDate) {
		this.title = title;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
	}

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CourseUnit getCourseUnit() {
		return this.courseUnit;
	}

	public void setCourseUnit(CourseUnit courseUnit) {
		this.courseUnit = courseUnit;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public Integer getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getDefficulty() {
		return this.defficulty;
	}

	public void setDefficulty(Integer defficulty) {
		this.defficulty = defficulty;
	}

	public String getExplanin() {
		return this.explanin;
	}

	public void setExplanin(String explanin) {
		this.explanin = explanin;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	

	public List<QuestionOption> getList() {
		return list;
	}

	public void setList(List<QuestionOption> list) {
		this.list = list;
	}

	public Set getPaperDetails() {
		return this.paperDetails;
	}

	public void setPaperDetails(Set paperDetails) {
		this.paperDetails = paperDetails;
	}

}