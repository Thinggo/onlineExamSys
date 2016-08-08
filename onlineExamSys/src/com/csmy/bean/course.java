package com.csmy.bean;



import java.util.HashSet;
import java.util.Set;


/**
 * course entity. @author MyEclipse Persistence Tools
 */

public class course  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private int teacherid ;
     private int departmentid ;
     private String code;
     private String name;
     private String remark;
     private Integer courseStatus;
     private Set courseUnits = new HashSet(0);
     private Set questions = new HashSet(0);
     private Set examStrategies = new HashSet(0);


    // Constructors

    /** default constructor */
    public course() {
    }

	/** minimal constructor */
    public course(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    
    /** full constructor */
    public course(Integer id, int teacherid , int departmentid , String code, String name, String remark, Integer courseStatus, Set courseUnits, Set questions, Set examStrategies) {
        this.id = id;
        this.teacherid = teacherid;
        this.departmentid = departmentid;
        this.code = code;
        this.name = name;
        this.remark = remark;
        this.courseStatus = courseStatus;
        this.courseUnits = courseUnits;
        this.questions = questions;
        this.examStrategies = examStrategies;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public int getTeacher() {
        return this.teacherid;
    }
    
    public void setTeacher(int teacher) {
        this.teacherid = teacher;
    }

    public int getDepartment() {
        return this.departmentid;
    }
    
    public void setDepartment(int department) {
        this.departmentid = department;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCourseStatus() {
        return this.courseStatus;
    }
    
    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Set getCourseUnits() {
        return this.courseUnits;
    }
    
    public void setCourseUnits(Set courseUnits) {
        this.courseUnits = courseUnits;
    }

    public Set getQuestions() {
        return this.questions;
    }
    
    public void setQuestions(Set questions) {
        this.questions = questions;
    }

    public Set getExamStrategies() {
        return this.examStrategies;
    }
    
    public void setExamStrategies(Set examStrategies) {
        this.examStrategies = examStrategies;
    }
   








}