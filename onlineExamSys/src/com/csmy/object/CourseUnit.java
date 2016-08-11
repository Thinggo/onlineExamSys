package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * CourseUnit entity. @author MyEclipse Persistence Tools
 */

public class CourseUnit implements java.io.Serializable {

	// Fields

	private Integer id;
	private Course course;
	private String name;
	private Integer pid;
	private Integer seqNo;
	private String remark;
	private Set questions = new HashSet(0);

	// Constructors

	/** default constructor */
	public CourseUnit() {
	}

	/** minimal constructor */
	public CourseUnit(String name) {
		this.name = name;
	}

	/** full constructor */
	public CourseUnit(Course course, String name, Integer pid, Integer seqNo,
			String remark, Set questions) {
		this.course = course;
		this.name = name;
		this.pid = pid;
		this.seqNo = seqNo;
		this.remark = remark;
		this.questions = questions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}