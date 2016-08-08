package com.csmy.bean;



/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public class UserRole  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String rolename;
     private String remark;


    // Constructors

    /** default constructor */
    public UserRole() {
    }

	/** minimal constructor */
    public UserRole(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public UserRole(Integer id, String rolename, String remark) {
        this.id = id;
        this.rolename = rolename;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}