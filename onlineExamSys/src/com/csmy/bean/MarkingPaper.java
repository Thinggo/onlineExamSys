package com.csmy.bean;


/**
 * MarkingPaper entity. @author MyEclipse Persistence Tools
 */

public class MarkingPaper  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer teacherId;
     private Integer roomId;
     private Integer planId;


    // Constructors

    /** default constructor */
    public MarkingPaper() {
    }

	/** minimal constructor */
    public MarkingPaper(Integer id, Integer teacherId) {
        this.id = id;
        this.teacherId = teacherId;
    }
    
    /** full constructor */
    public MarkingPaper(Integer id, Integer teacherId, Integer roomId, Integer planId) {
        this.id = id;
        this.teacherId = teacherId;
        this.roomId = roomId;
        this.planId = planId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPlanId() {
        return this.planId;
    }
    
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
   








}