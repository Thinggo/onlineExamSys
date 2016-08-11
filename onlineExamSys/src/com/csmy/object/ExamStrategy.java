package com.csmy.object;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ExamStrategy entity. @author MyEclipse Persistence Tools
 */

public class ExamStrategy implements java.io.Serializable {

	// Fields

	private Integer id;
	private Teacher teacher;
	private Course course;
	private String name;
	private Integer totalScore;
	private Integer passScore;
	private Boolean strategystatus;
	private Timestamp createtime;
	private Boolean isDiffOrunit;
	private Boolean examPattern;
	private Boolean isShowResult;
	private Boolean isArrangeRoom;
	private Integer duration;
	private Set examStudents = new HashSet(0);
	private Set examPlans = new HashSet(0);
	private Set examStrategyDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExamStrategy() {
	}

	/** minimal constructor */
	public ExamStrategy(Teacher teacher, String name, Integer totalScore,
			Integer passScore, Timestamp createtime, Boolean isDiffOrunit,
			Boolean isShowResult, Boolean isArrangeRoom, Integer duration) {
		this.teacher = teacher;
		this.name = name;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.createtime = createtime;
		this.isDiffOrunit = isDiffOrunit;
		this.isShowResult = isShowResult;
		this.isArrangeRoom = isArrangeRoom;
		this.duration = duration;
	}

	/** full constructor */
	public ExamStrategy(Teacher teacher, Course course, String name,
			Integer totalScore, Integer passScore, Boolean strategystatus,
			Timestamp createtime, Boolean isDiffOrunit, Boolean examPattern,
			Boolean isShowResult, Boolean isArrangeRoom, Integer duration,
			Set examStudents, Set examPlans, Set examStrategyDetails) {
		this.teacher = teacher;
		this.course = course;
		this.name = name;
		this.totalScore = totalScore;
		this.passScore = passScore;
		this.strategystatus = strategystatus;
		this.createtime = createtime;
		this.isDiffOrunit = isDiffOrunit;
		this.examPattern = examPattern;
		this.isShowResult = isShowResult;
		this.isArrangeRoom = isArrangeRoom;
		this.duration = duration;
		this.examStudents = examStudents;
		this.examPlans = examPlans;
		this.examStrategyDetails = examStrategyDetails;
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

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getPassScore() {
		return this.passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	public Boolean getStrategystatus() {
		return this.strategystatus;
	}

	public void setStrategystatus(Boolean strategystatus) {
		this.strategystatus = strategystatus;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Boolean getIsDiffOrunit() {
		return this.isDiffOrunit;
	}

	public void setIsDiffOrunit(Boolean isDiffOrunit) {
		this.isDiffOrunit = isDiffOrunit;
	}

	public Boolean getExamPattern() {
		return this.examPattern;
	}

	public void setExamPattern(Boolean examPattern) {
		this.examPattern = examPattern;
	}

	public Boolean getIsShowResult() {
		return this.isShowResult;
	}

	public void setIsShowResult(Boolean isShowResult) {
		this.isShowResult = isShowResult;
	}

	public Boolean getIsArrangeRoom() {
		return this.isArrangeRoom;
	}

	public void setIsArrangeRoom(Boolean isArrangeRoom) {
		this.isArrangeRoom = isArrangeRoom;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Set getExamStudents() {
		return this.examStudents;
	}

	public void setExamStudents(Set examStudents) {
		this.examStudents = examStudents;
	}

	public Set getExamPlans() {
		return this.examPlans;
	}

	public void setExamPlans(Set examPlans) {
		this.examPlans = examPlans;
	}

	public Set getExamStrategyDetails() {
		return this.examStrategyDetails;
	}

	public void setExamStrategyDetails(Set examStrategyDetails) {
		this.examStrategyDetails = examStrategyDetails;
	}

}