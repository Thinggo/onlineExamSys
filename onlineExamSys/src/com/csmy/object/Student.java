package com.csmy.object;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer id;
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
	private String stustatus;
	private Timestamp regTime;
	private Timestamp loginTime;
	private String loginIp;
	private Set paperDetails = new HashSet(0);
	private Set examStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Department department, String no, String password,
			String name) {
		this.department = department;
		this.no = no;
		this.password = password;
		this.name = name;
	}

	/** full constructor */
	public Student(Department department, String no, String password,
			String name, String sex, String phone, String email,
			String identityCard, String photoUrl, String remark,
			String stustatus, Timestamp regTime, Timestamp loginTime,
			String loginIp, Set paperDetails, Set examStudents) {
		this.department = department;
		this.no = no;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.identityCard = identityCard;
		this.photoUrl = photoUrl;
		this.remark = remark;
		this.stustatus = stustatus;
		this.regTime = regTime;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.paperDetails = paperDetails;
		this.examStudents = examStudents;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getStustatus() {
		return this.stustatus;
	}

	public void setStustatus(String stustatus) {
		this.stustatus = stustatus;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Set getPaperDetails() {
		return this.paperDetails;
	}

	public void setPaperDetails(Set paperDetails) {
		this.paperDetails = paperDetails;
	}

	public Set getExamStudents() {
		return this.examStudents;
	}

	public void setExamStudents(Set examStudents) {
		this.examStudents = examStudents;
	}

}