package com.csmy.bean;


/**
 * PaperOption entity. @author MyEclipse Persistence Tools
 */

public class PaperOption  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer paperDetailId;
     private Integer optionId; //试题选项ID
     private String  questionOptionName;
     private Byte isright;
     private String label;


    // Constructors

    /** default constructor */
    public PaperOption() {
    }

    
    /** full constructor */
    public PaperOption(Integer id, Integer paperDetailId, Integer optionId, String label) {
        this.id = id;
        this.paperDetailId = paperDetailId;
        this.optionId = optionId;
        this.label = label;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperDetailId() {
        return this.paperDetailId;
    }
    
    public void setPaperDetailId(Integer paperDetailId) {
        this.paperDetailId = paperDetailId;
    }

    public Integer getOptionId() {
        return this.optionId;
    }
    
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }


	public Byte getIsright() {
		return isright;
	}


	public void setIsright(Byte isright) {
		this.isright = isright;
	}


	public String getQuestionOptionName() {
		return questionOptionName;
	}


	public void setQuestionOptionName(String questionOptionName) {
		this.questionOptionName = questionOptionName;
	}
   








}