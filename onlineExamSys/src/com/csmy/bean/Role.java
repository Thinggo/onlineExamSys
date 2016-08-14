package com.csmy.bean;



/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String remark;


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Role(Integer id, String rolename, String remark) {
        this.id = id;
        this.name = rolename;
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
        this.name =name;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}