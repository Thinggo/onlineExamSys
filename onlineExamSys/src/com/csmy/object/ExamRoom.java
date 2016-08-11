package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * ExamRoom entity. @author MyEclipse Persistence Tools
 */

public class ExamRoom implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer no;
	private String roomAddr;
	private String roomIp;
	private Set examStudents = new HashSet(0);
	private Set markingPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamRoom() {
	}

	/** minimal constructor */
	public ExamRoom(Integer no) {
		this.no = no;
	}

	/** full constructor */
	public ExamRoom(Integer no, String roomAddr, String roomIp,
			Set examStudents, Set markingPapers) {
		this.no = no;
		this.roomAddr = roomAddr;
		this.roomIp = roomIp;
		this.examStudents = examStudents;
		this.markingPapers = markingPapers;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNo() {
		return this.no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getRoomAddr() {
		return this.roomAddr;
	}

	public void setRoomAddr(String roomAddr) {
		this.roomAddr = roomAddr;
	}

	public String getRoomIp() {
		return this.roomIp;
	}

	public void setRoomIp(String roomIp) {
		this.roomIp = roomIp;
	}

	public Set getExamStudents() {
		return this.examStudents;
	}

	public void setExamStudents(Set examStudents) {
		this.examStudents = examStudents;
	}

	public Set getMarkingPapers() {
		return this.markingPapers;
	}

	public void setMarkingPapers(Set markingPapers) {
		this.markingPapers = markingPapers;
	}

}