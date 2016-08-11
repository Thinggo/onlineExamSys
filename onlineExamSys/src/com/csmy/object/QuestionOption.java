package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * QuestionOption entity. @author MyEclipse Persistence Tools
 */

public class QuestionOption implements java.io.Serializable {

	// Fields

	private Integer id;
	private Question question;
	private String name;
	private Integer seqNo;
	private Boolean isRight;
	private Set paperOptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public QuestionOption() {
	}

	/** minimal constructor */
	public QuestionOption(String name, Integer seqNo, Boolean isRight) {
		this.name = name;
		this.seqNo = seqNo;
		this.isRight = isRight;
	}

	/** full constructor */
	public QuestionOption(Question question, String name, Integer seqNo,
			Boolean isRight, Set paperOptions) {
		this.question = question;
		this.name = name;
		this.seqNo = seqNo;
		this.isRight = isRight;
		this.paperOptions = paperOptions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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

	public Boolean getIsRight() {
		return this.isRight;
	}

	public void setIsRight(Boolean isRight) {
		this.isRight = isRight;
	}

	public Set getPaperOptions() {
		return this.paperOptions;
	}

	public void setPaperOptions(Set paperOptions) {
		this.paperOptions = paperOptions;
	}

}