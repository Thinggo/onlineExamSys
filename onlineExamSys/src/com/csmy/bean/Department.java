package com.csmy.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String code;
     @SerializedName("text")
     private String name;
     private Integer pid;
     private Integer type;
     private Byte isClosed;
     private String remark;
     private List<Department> children;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Integer id, String code, String name, Integer type, Byte isClosed) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.isClosed = isClosed;
    }
    
    /** full constructor */
    public Department(Integer id, String code, String name, Integer pid, Integer type, Byte isClosed, String remark) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.pid = pid;
        this.type = type;
        this.isClosed = isClosed;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getIsClosed() {
        return this.isClosed;
    }
    
    public void setIsClosed(Byte isClosed) {
        this.isClosed = isClosed;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

	public List<Department> getChildren() {
		return children;
	}

	public void setChildren(List<Department> children) {
		this.children = children;
	}
   








}