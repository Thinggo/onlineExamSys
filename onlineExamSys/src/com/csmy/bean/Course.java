package com.csmy.bean;



import java.util.HashSet;
import java.util.Set;


/**
 * course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer teacherid ;
     public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	private String  teacherName ;
     private Integer departmentid ;
     private String  deptName;

     private String code;
     private String name;
     private String remark;
     private Integer courseStatus;
     

    // Constructors

    /** default constructor */
    public Course() {
    }

	/** minimal constructor */
    public Course(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    
    /** full constructor */
    public Course(Integer id, int teacherid , int departmentid , String code, String name, String remark, Integer courseStatus, Set courseUnits, Set questions, Set examStrategies) {
        this.id = id;
        this.teacherid = teacherid;
        this.departmentid = departmentid;
        this.code = code;
        this.name = name;
        this.remark = remark;
        this.courseStatus = courseStatus;
        
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherid() {
        return this.teacherid;
    }
    
    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getDepartmentid() {
        return this.departmentid;
    }
    
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
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
}