package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Department department;
	private String code;
	private String name;
	private String remark;
	private Integer courseStatus;
	private Set courseUnits = new HashSet(0);
	private Set examStrategies = new HashSet(0);
	private Set questions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/** full constructor */
	public Course(Teacher teacher, Department department, String code,
			String name, String remark, Integer courseStatus, Set courseUnits,
			Set examStrategies, Set questions) {
		this.teacher = teacher;
		this.department = department;
		this.code = code;
		this.name = name;
		this.remark = remark;
		this.courseStatus = courseStatus;
		this.courseUnits = courseUnits;
		this.examStrategies = examStrategies;
		this.questions = questions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCourseStatus() {
		return this.courseStatus;
	}

	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}

	public Set getCourseUnits() {
		return this.courseUnits;
	}

	public void setCourseUnits(Set courseUnits) {
		this.courseUnits = courseUnits;
	}

	public Set getExamStrategies() {
		return this.examStrategies;
	}

	public void setExamStrategies(Set examStrategies) {
		this.examStrategies = examStrategies;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}