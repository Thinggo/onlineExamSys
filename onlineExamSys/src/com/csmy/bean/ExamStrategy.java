package com.csmy.bean;

import java.util.Date;


/**
 * ExamStrategy entity. @author MyEclipse Persistence Tools
 */

public class ExamStrategy  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer courseId;
     private Integer totalScore;
     private Integer passScore;
     private Byte strategystatus;
     private Date createtime;
     private Byte isDiffOrunit;
     private Byte examPattern;
     private Byte isShowResult;
     private Byte isArrangeRoom;
     private Integer teacherId;
     private Integer duration;


    // Constructors

    /** default constructor */
    public ExamStrategy() {
    }

	/** minimal constructor */
    public ExamStrategy(Integer id, String name, Integer totalScore, Integer passScore, Date createtime, Byte isDiffOrunit, Byte isShowResult, Byte isArrangeRoom, Integer teacherId, Integer duration) {
        this.id = id;
        this.name = name;
        this.totalScore = totalScore;
        this.passScore = passScore;
        this.createtime = createtime;
        this.isDiffOrunit = isDiffOrunit;
        this.isShowResult = isShowResult;
        this.isArrangeRoom = isArrangeRoom;
        this.teacherId = teacherId;
        this.duration = duration;
    }
    
    /** full constructor */
    public ExamStrategy(Integer id, String name, Integer courseId, Integer totalScore, Integer passScore, Byte strategystatus, Date createtime, Byte isDiffOrunit, Byte examPattern, Byte isShowResult, Byte isArrangeRoom, Integer teacherId, Integer duration) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.totalScore = totalScore;
        this.passScore = passScore;
        this.strategystatus = strategystatus;
        this.createtime = createtime;
        this.isDiffOrunit = isDiffOrunit;
        this.examPattern = examPattern;
        this.isShowResult = isShowResult;
        this.isArrangeRoom = isArrangeRoom;
        this.teacherId = teacherId;
        this.duration = duration;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Byte getStrategystatus() {
        return this.strategystatus;
    }
    
    public void setStrategystatus(Byte strategystatus) {
        this.strategystatus = strategystatus;
    }

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Byte getIsDiffOrunit() {
        return this.isDiffOrunit;
    }
    
    public void setIsDiffOrunit(Byte isDiffOrunit) {
        this.isDiffOrunit = isDiffOrunit;
    }

    public Byte getExamPattern() {
        return this.examPattern;
    }
    
    public void setExamPattern(Byte examPattern) {
        this.examPattern = examPattern;
    }

    public Byte getIsShowResult() {
        return this.isShowResult;
    }
    
    public void setIsShowResult(Byte isShowResult) {
        this.isShowResult = isShowResult;
    }

    public Byte getIsArrangeRoom() {
        return this.isArrangeRoom;
    }
    
    public void setIsArrangeRoom(Byte isArrangeRoom) {
        this.isArrangeRoom = isArrangeRoom;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDuration() {
        return this.duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
   








}