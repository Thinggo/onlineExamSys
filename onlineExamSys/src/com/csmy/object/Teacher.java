package com.csmy.object;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.*;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userrole userrole;
	private Department department;
	private String no;
	private String password;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String identityCard;
	private String photoUrl;
	private String remark;
	private String teacherstatus;
	private Date regTime;
	private Date loginTime;
	private String loginIp;
	private Set courses = new HashSet(0);
	private Set paperDetails = new HashSet(0);
	private Set questions = new HashSet(0);
	private Set markingPapers = new HashSet(0);
	private Set examStrategies = new HashSet(0);
	private Set examPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Department department, String no, String password,
			String name) {
		this.department = department;
		this.no = no;
		this.password = password;
		this.name = name;
	}

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentityCard() {
		return this.identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTeacherstatus() {
		return this.teacherstatus;
	}

	public void setTeacherstatus(String teacherstatus) {
		this.teacherstatus = teacherstatus;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	public Set getPaperDetails() {
		return this.paperDetails;
	}

	public void setPaperDetails(Set paperDetails) {
		this.paperDetails = paperDetails;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

	public Set getMarkingPapers() {
		return this.markingPapers;
	}

	public void setMarkingPapers(Set markingPapers) {
		this.markingPapers = markingPapers;
	}

	public Set getExamStrategies() {
		return this.examStrategies;
	}

	public void setExamStrategies(Set examStrategies) {
		this.examStrategies = examStrategies;
	}

	public Set getExamPlans() {
		return this.examPlans;
	}

	public void setExamPlans(Set examPlans) {
		this.examPlans = examPlans;
	}

}