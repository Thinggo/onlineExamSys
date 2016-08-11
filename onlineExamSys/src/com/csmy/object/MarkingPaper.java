package com.csmy.object;

/**
 * MarkingPaper entity. @author MyEclipse Persistence Tools
 */

public class MarkingPaper implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private ExamRoom examRoom;
	private ExamPlan examPlan;

	// Constructors

	/** default constructor */
	public MarkingPaper() {
	}

	/** minimal constructor */
	public MarkingPaper(Teacher teacher) {
		this.teacher = teacher;
	}

	/** full constructor */
	public MarkingPaper(Teacher teacher, ExamRoom examRoom, ExamPlan examPlan) {
		this.teacher = teacher;
		this.examRoom = examRoom;
		this.examPlan = examPlan;
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

	public ExamRoom getExamRoom() {
		return this.examRoom;
	}

	public void setExamRoom(ExamRoom examRoom) {
		this.examRoom = examRoom;
	}

	public ExamPlan getExamPlan() {
		return this.examPlan;
	}

	public void setExamPlan(ExamPlan examPlan) {
		this.examPlan = examPlan;
	}

}