package com.csmy.object;

/**
 * PaperOption entity. @author MyEclipse Persistence Tools
 */

public class PaperOption implements java.io.Serializable {

	// Fields

	private Integer id;
	private QuestionOption questionOption;
	private PaperDetail paperDetail;
	private String label;

	// Constructors

	/** default constructor */
	public PaperOption() {
	}

	/** full constructor */
	public PaperOption(QuestionOption questionOption, PaperDetail paperDetail,
			String label) {
		this.questionOption = questionOption;
		this.paperDetail = paperDetail;
		this.label = label;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionOption getQuestionOption() {
		return this.questionOption;
	}

	public void setQuestionOption(QuestionOption questionOption) {
		this.questionOption = questionOption;
	}

	public PaperDetail getPaperDetail() {
		return this.paperDetail;
	}

	public void setPaperDetail(PaperDetail paperDetail) {
		this.paperDetail = paperDetail;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}