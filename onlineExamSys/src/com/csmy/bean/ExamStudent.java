package com.csmy.bean;

import java.util.Date;


/**
 * ExamStudent entity. @author MyEclipse Persistence Tools
 */

public class ExamStudent  implements java.io.Serializable {


    // Fields    

     private ExamStudentId id;
     private Integer examRoomId;
     private Integer seatNo;
     private Date loginTime;
     private Integer overTime;
     private Integer examstatus;
     private Date submitTime;


    // Constructors

    /** default constructor */
    public ExamStudent() {
    }

	/** minimal constructor */
    public ExamStudent(ExamStudentId id) {
        this.id = id;
    }
    
    /** full constructor */
    public ExamStudent(ExamStudentId id, Integer examRoomId, Integer seatNo, Date loginTime, Integer overTime, Integer examstatus, Date submitTime) {
        this.id = id;
        this.examRoomId = examRoomId;
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

    public Integer getExamRoomId() {
        return this.examRoomId;
    }
    
    public void setExamRoomId(Integer examRoomId) {
        this.examRoomId = examRoomId;
    }

    public Integer getSeatNo() {
        return this.seatNo;
    }
    
    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }
    
    public void setLoginTime(Date loginTime) {
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

    public Date getSubmitTime() {
        return this.submitTime;
    }
    
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
   








}