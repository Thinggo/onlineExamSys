package com.csmy.bean;

import java.util.Date;


/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String no;
     private String password;
     private String name;
     private Integer deptId;
     private String sex;
     private String phone;
     private String email;
     private String identityCard;
     private Integer roleId;
     private String photoUrl;
     private String remark;
     private String teacherstatus;
     private Date regTime;
     private Date loginTime;
     private String loginIp;


    // Constructors

    /** default constructor */
    public Teacher() {
    }

	/** minimal constructor */
    public Teacher(Integer id, String no, String password, String name, Integer deptId) {
        this.id = id;
        this.no = no;
        this.password = password;
        this.name = name;
        this.deptId = deptId;
    }
    
    /** full constructor */
    public Teacher(Integer id, String no, String password, String name, Integer deptId, String sex, String phone, String email, String identityCard, Integer roleId, String photoUrl, String remark, String teacherstatus, Date regTime, Date loginTime, String loginIp) {
        this.id = id;
        this.no = no;
        this.password = password;
        this.name = name;
        this.deptId = deptId;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.identityCard = identityCard;
        this.roleId = roleId;
        this.photoUrl = photoUrl;
        this.remark = remark;
        this.teacherstatus = teacherstatus;
        this.regTime = regTime;
        this.loginTime = loginTime;
        this.loginIp = loginIp;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return this.no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return this.identityCard;
    }
    
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }
    
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTeacherstatus() {
        return this.teacherstatus;
    }
    
    public void setTeacherstatus(String teacherstatus) {
        this.teacherstatus = teacherstatus;
    }

    public Date getRegTime() {
        return this.regTime;
    }
    
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLoginTime() {
        return this.loginTime;
    }
    
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return this.loginIp;
    }
    
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
   








}