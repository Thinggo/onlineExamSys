package com.csmy.bean;

import java.util.Date;


/**
 * PaperDetail entity. @author MyEclipse Persistence Tools
 */

public class PaperDetail  implements java.io.Serializable {


    // Fields    

     private Integer pagerId;
     private Integer studentId;
     private Integer planId;
     private Integer questionId;
     private Integer displayId;
     private String answer;
     private Double score;
     private Integer teacherId;
     private Date markingTime;
     private Byte flag;


    // Constructors

    /** default constructor */
    public PaperDetail() {
    }

	/** minimal constructor */
    public PaperDetail(Integer pagerId, Integer studentId, Integer planId, Integer questionId, Integer displayId) {
        this.pagerId = pagerId;
        this.studentId = studentId;
        this.planId = planId;
        this.questionId = questionId;
        this.displayId = displayId;
    }
    
    /** full constructor */
    public PaperDetail(Integer pagerId, Integer studentId, Integer planId, Integer questionId, Integer displayId, String answer, Double score, Integer teacherId, Date markingTime, Byte flag) {
        this.pagerId = pagerId;
        this.studentId = studentId;
        this.planId = planId;
        this.questionId = questionId;
        this.displayId = displayId;
        this.answer = answer;
        this.score = score;
        this.teacherId = teacherId;
        this.markingTime = markingTime;
        this.flag = flag;
    }

   
    // Property accessors

    public Integer getPagerId() {
        return this.pagerId;
    }
    
    public void setPagerId(Integer pagerId) {
        this.pagerId = pagerId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPlanId() {
        return this.planId;
    }
    
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getDisplayId() {
        return this.displayId;
    }
    
    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getMarkingTime() {
        return this.markingTime;
    }
    
    public void setMarkingTime(Date markingTime) {
        this.markingTime = markingTime;
    }

    public Byte getFlag() {
        return this.flag;
    }
    
    public void setFlag(Byte flag) {
        this.flag = flag;
    }
   








}