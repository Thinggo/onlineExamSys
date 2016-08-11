package com.csmy.object;

/**
 * ExamStrategyDetail entity. @author MyEclipse Persistence Tools
 */

public class ExamStrategyDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private QuestionType questionType;
	private ExamStrategy examStrategy;
	private Integer unitId;
	private Integer quantity;
	private Integer score;

	// Constructors

	/** default constructor */
	public ExamStrategyDetail() {
	}

	/** minimal constructor */
	public ExamStrategyDetail(QuestionType questionType, Integer unitId,
			Integer quantity, Integer score) {
		this.questionType = questionType;
		this.unitId = unitId;
		this.quantity = quantity;
		this.score = score;
	}

	/** full constructor */
	public ExamStrategyDetail(QuestionType questionType,
			ExamStrategy examStrategy, Integer unitId, Integer quantity,
			Integer score) {
		this.questionType = questionType;
		this.examStrategy = examStrategy;
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

	public QuestionType getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public ExamStrategy getExamStrategy() {
		return this.examStrategy;
	}

	public void setExamStrategy(ExamStrategy examStrategy) {
		this.examStrategy = examStrategy;
	}

	public Integer getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
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

}