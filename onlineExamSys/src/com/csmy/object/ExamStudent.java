package com.csmy.object;

import java.sql.Timestamp;

/**
 * ExamStudent entity. @author MyEclipse Persistence Tools
 */

public class ExamStudent implements java.io.Serializable {

	// Fields

	private ExamStudentId id;
	private ExamRoom examRoom;
	private Integer seatNo;
	private Timestamp loginTime;
	private Integer overTime;
	private Integer examstatus;
	private Timestamp submitTime;

	// Constructors

	/** default constructor */
	public ExamStudent() {
	}

	/** minimal constructor */
	public ExamStudent(ExamStudentId id) {
		this.id = id;
	}

	/** full constructor */
	public ExamStudent(ExamStudentId id, ExamRoom examRoom, Integer seatNo,
			Timestamp loginTime, Integer overTime, Integer examstatus,
			Timestamp submitTime) {
		this.id = id;
		this.examRoom = examRoom;
		this.seatNo = seatNo;
		this.loginTime = loginTime;
		this.overTime = overTime;
		this.examstatus = examstatus;
		this.submitTime = submitTime;
	}

	// Property accessors

	public ExamStudentId getId() {
		return this.id;
	}

	public void setId(ExamStudentId id) {
		this.id = id;
	}

	public ExamRoom getExamRoom() {
		return this.examRoom;
	}

	public void setExamRoom(ExamRoom examRoom) {
		this.examRoom = examRoom;
	}

	public Integer getSeatNo() {
		return this.seatNo;
	}

	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Integer overTime) {
		this.overTime = overTime;
	}

	public Integer getExamstatus() {
		return this.examstatus;
	}

	public void setExamstatus(Integer examstatus) {
		this.examstatus = examstatus;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

}