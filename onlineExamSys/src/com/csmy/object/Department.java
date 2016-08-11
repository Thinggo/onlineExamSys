package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String pid;
	private String type;
	private Boolean isClosed;
	private String remark;
	private Set teachers = new HashSet(0);
	private Set courses = new HashSet(0);
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String code, String name, String type, Boolean isClosed) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.isClosed = isClosed;
	}

	/** full constructor */
	public Department(String code, String name, String pid, String type,
			Boolean isClosed, String remark, Set teachers, Set courses,
			Set students) {
		this.code = code;
		this.name = name;
		this.pid = pid;
		this.type = type;
		this.isClosed = isClosed;
		this.remark = remark;
		this.teachers = teachers;
		this.courses = courses;
		this.students = students;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsClosed() {
		return this.isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set teachers) {
		this.teachers = teachers;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}