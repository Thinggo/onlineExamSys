package com.csmy.bean;



/**
 * QuestionType entity. @author MyEclipse Persistence Tools
 */

public class QuestionType  implements java.io.Serializable {


    // Fields    

     private Integer typeId;
     private String typeName;
     private Byte isObjective;
     private String remark;


    // Constructors

    /** default constructor */
    public QuestionType() {
    }

	/** minimal constructor */
    public QuestionType(Integer typeId, String typeName, Byte isObjective) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.isObjective = isObjective;
    }
    
    /** full constructor */
    public QuestionType(Integer typeId, String typeName, Byte isObjective, String remark) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.isObjective = isObjective;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return this.typeName;
    }
    
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Byte getIsObjective() {
        return this.isObjective;
    }
    
    public void setIsObjective(Byte isObjective) {
        this.isObjective = isObjective;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}