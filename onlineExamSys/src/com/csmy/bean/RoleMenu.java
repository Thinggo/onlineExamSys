package com.csmy.bean;



/**
 * RoleMenu entity. @author MyEclipse Persistence Tools
 */

public class RoleMenu  implements java.io.Serializable {


    // Fields    

     private RoleMenuId id;


    // Constructors

    /** default constructor */
    public RoleMenu() {
    }

    
    /** full constructor */
    public RoleMenu(RoleMenuId id) {
        this.id = id;
    }

   
    // Property accessors

    public RoleMenuId getId() {
        return this.id;
    }
    
    public void setId(RoleMenuId id) {
        this.id = id;
    }
   








}