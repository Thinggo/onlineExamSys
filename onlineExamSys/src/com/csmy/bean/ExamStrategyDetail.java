package com.csmy.bean;



/**
 * ExamStrategyDetail entity. @author MyEclipse Persistence Tools
 */

public class ExamStrategyDetail  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer strategyId;
     private String strategyName;
     private Integer questionType;
     private String questionTypeName;
     private Integer unitId;     
     private String unitName;
     
     private Integer difficulty; 
     
     private Integer quantity;
     private Integer score;


    // Constructors

    /** default constructor */
    public ExamStrategyDetail() {
    }

	/** minimal constructor */
    public ExamStrategyDetail(Integer id, Integer questionType, Integer unitId, Integer quantity, Integer score) {
        this.id = id;
        this.questionType = questionType;
        this.unitId = unitId;
        this.quantity = quantity;
        this.score = score;
    }
    
    /** full constructor */
    public ExamStrategyDetail(Integer id, Integer strategyId, Integer questionType, Integer unitId, Integer quantity, Integer score) {
        this.id = id;
        this.strategyId = strategyId;
        this.questionType = questionType;
        this.unitId = unitId;
        this.quantity = quantity;
        this.score = score;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrategyId() {
        return this.strategyId;
    }
    
    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }
    
    public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public Integer getQuestionType() {
        return this.questionType;
    }
    
    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTypeName() {
		return questionTypeName;
	}

	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}

	public Integer getUnitId() {
        return this.unitId;
    }
    
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
    
    public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getScore() {
        return this.score;
    }
    
    public void setScore(Integer score) {
        this.score = score;
    }

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
   
}