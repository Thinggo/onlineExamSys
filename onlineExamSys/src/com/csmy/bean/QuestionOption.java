package com.csmy.bean;



/**
 * QuestionOption entity. @author MyEclipse Persistence Tools
 */

public class QuestionOption  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer seqNo;
     private Integer questionId;
     private Byte isRight;


    // Constructors

    /** default constructor */
    public QuestionOption() {
    	isRight = (byte)0;
    }

	/** minimal constructor */
    public QuestionOption(Integer id, String name, Integer seqNo, Byte isRight) {
        this.id = id;
        this.name = name;
        this.seqNo = seqNo;
        this.isRight = isRight;
    }
    
    /** full constructor */
    public QuestionOption(Integer id, String name, Integer seqNo, Integer questionId, Byte isRight) {
        this.id = id;
        this.name = name;
        this.seqNo = seqNo;
        this.questionId = questionId;
        this.isRight = isRight;
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

    public Integer getSeqNo() {
        return this.seqNo;
    }
    
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Byte getIsRight() {
        return this.isRight;
    }
    
    public void setIsRight(Byte isRight) {
        this.isRight = isRight;
    }
   








}