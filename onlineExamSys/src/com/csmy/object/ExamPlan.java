package com.csmy.object;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ExamPlan entity. @author MyEclipse Persistence Tools
 */

public class ExamPlan implements java.io.Serializable {

	// Fields

	private Integer id;
	private ExamStrategy examStrategy;
	private Teacher teacher;
	private String name;
	private String descrption;
	private Timestamp beginTime;
	private Timestamp createTime;
	private Set paperDetails = new HashSet(0);
	private Set markingPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamPlan() {
	}

	/** minimal constructor */
	public ExamPlan(Teacher teacher, String name, Timestamp beginTime,
			Timestamp createTime) {
		this.teacher = teacher;
		this.name = name;
		this.beginTime = beginTime;
		this.createTime = createTime;
	}

	/** full constructor */
	public ExamPlan(ExamStrategy examStrategy, Teacher teacher, String name,
			String descrption, Timestamp beginTime, Timestamp createTime,
			Set paperDetails, Set markingPapers) {
		this.examStrategy = examStrategy;
		this.teacher = teacher;
		this.name = name;
		this.descrption = descrption;
		this.beginTime = beginTime;
		this.createTime = createTime;
		this.paperDetails = paperDetails;
		this.markingPapers = markingPapers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ExamStrategy getExamStrategy() {
		return this.examStrategy;
	}

	public void setExamStrategy(ExamStrategy examStrategy) {
		this.examStrategy = examStrategy;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrption() {
		return this.descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Set getPaperDetails() {
		return this.paperDetails;
	}

	public void setPaperDetails(Set paperDetails) {
		this.paperDetails = paperDetails;
	}

	public Set getMarkingPapers() {
		return this.markingPapers;
	}

	public void setMarkingPapers(Set markingPapers) {
		this.markingPapers = markingPapers;
	}

}