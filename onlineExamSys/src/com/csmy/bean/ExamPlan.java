package com.csmy.bean;

import java.util.Date;


/**
 * ExamPlan entity. @author MyEclipse Persistence Tools
 */

public class ExamPlan  implements java.io.Serializable {


    // Fields    

	 private Integer id;
     private String name;
     private String descrption;
     private Integer strategyId;
     private String strategyName;
     private Date beginTime;
     private Integer duration;
     private Byte examPattern;
     private Byte isShowResult;
     private Byte isArrangeRoom;
          
     private Integer teacherId;
     private String teacherName;
     private Date createTime;


    // Constructors

    /** default constructor */
    public ExamPlan() {
    }

	/** minimal constructor */
    public ExamPlan(Integer id, String name, Date beginTime, Integer teacherId, Date createTime) {
        this.id = id;
        this.name = name;
        this.beginTime = beginTime;
        this.teacherId = teacherId;
        this.createTime = createTime;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public Integer getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Byte getExamPattern() {
		return examPattern;
	}

	public void setExamPattern(Byte examPattern) {
		this.examPattern = examPattern;
	}

	public Byte getIsShowResult() {
		return isShowResult;
	}

	public void setIsShowResult(Byte isShowResult) {
		this.isShowResult = isShowResult;
	}

	public Byte getIsArrangeRoom() {
		return isArrangeRoom;
	}

	public void setIsArrangeRoom(Byte isArrangeRoom) {
		this.isArrangeRoom = isArrangeRoom;
	}

}