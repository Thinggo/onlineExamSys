package com.csmy.bean;



/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String code;
     private String name;
     private String pid;
     private String type;
     private Byte isClosed;
     private String remark;


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(Integer id, String code, String name, String type, Byte isClosed) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.isClosed = isClosed;
    }
    
    /** full constructor */
    public Department(Integer id, String code, String name, String pid, String type, Byte isClosed, String remark) {
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

    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
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
   








}