package com.csmy.bean;



/**
 * CourseUnit entity. @author MyEclipse Persistence Tools
 */

public class CourseUnit  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer pid;
     private Integer courseId;
     private Integer seqNo;
     private String remark;


    // Constructors

    /** default constructor */
    public CourseUnit() {
    }

	/** minimal constructor */
    public CourseUnit(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /** full constructor */
    public CourseUnit(Integer id, String name, Integer pid, Integer courseId, Integer seqNo, String remark) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.courseId = courseId;
        this.seqNo = seqNo;
        this.remark = remark;
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

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }
    
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}