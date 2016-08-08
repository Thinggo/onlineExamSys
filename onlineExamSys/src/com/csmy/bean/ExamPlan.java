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
     private Date beginTime;
     private Integer teacherId;
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
    
    /** full constructor */
    public ExamPlan(Integer id, String name, String descrption, Integer strategyId, Date beginTime, Integer teacherId, Date createTime) {
        this.id = id;
        this.name = name;
        this.descrption = descrption;
        this.strategyId = strategyId;
        this.beginTime = beginTime;
        this.teacherId = teacherId;
        this.createTime = createTime;
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

    public String getDescrption() {
        return this.descrption;
    }
    
    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public Integer getStrategyId() {
        return this.strategyId;
    }
    
    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public Date getBeginTime() {
        return this.beginTime;
    }
    
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
   








}