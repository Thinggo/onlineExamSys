package com.csmy.bean;

import java.util.Date;

/**
 * ExamStudent entity. @author MyEclipse Persistence Tools
 */

public class ExamStudent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer studentId;
	private String studentName;
	private Integer examplanId;
	private String examplanName;
	private Integer examRoomId;
	private String examRoomName;
	private Integer seatNo;
	private Date loginTime;
	private String loginIp;
	private Integer overTime;
	private Integer examstatus;
	private Date submitTime;

	// Constructors

	/** default constructor */
	public ExamStudent() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getExamplanId() {
		return examplanId;
	}

	public void setExamplanId(Integer examplanId) {
		this.examplanId = examplanId;
	}

	public Integer getExamRoomId() {
		return examRoomId;
	}

	public void setExamRoomId(Integer examRoomId) {
		this.examRoomId = examRoomId;
	}

	public Integer getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getOverTime() {
		return overTime;
	}

	public void setOverTime(Integer overTime) {
		this.overTime = overTime;
	}

	public Integer getExamstatus() {
		return examstatus;
	}

	public void setExamstatus(Integer examstatus) {
		this.examstatus = examstatus;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getExamplanName() {
		return examplanName;
	}

	public void setExamplanName(String examplanName) {
		this.examplanName = examplanName;
	}

	public String getExamRoomName() {
		return examRoomName;
	}

	public void setExamRoomName(String examRoomName) {
		this.examRoomName = examRoomName;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
}