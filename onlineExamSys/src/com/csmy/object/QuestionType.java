package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * QuestionType entity. @author MyEclipse Persistence Tools
 */

public class QuestionType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private Boolean isObjective;
	private String remark;
	private Set examStrategyDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public QuestionType() {
	}

	/** minimal constructor */
	public QuestionType(String typeName, Boolean isObjective) {
		this.typeName = typeName;
		this.isObjective = isObjective;
	}

	/** full constructor */
	public QuestionType(String typeName, Boolean isObjective, String remark,
			Set examStrategyDetails) {
		this.typeName = typeName;
		this.isObjective = isObjective;
		this.remark = remark;
		this.examStrategyDetails = examStrategyDetails;
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

	public Boolean getIsObjective() {
		return this.isObjective;
	}

	public void setIsObjective(Boolean isObjective) {
		this.isObjective = isObjective;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getExamStrategyDetails() {
		return this.examStrategyDetails;
	}

	public void setExamStrategyDetails(Set examStrategyDetails) {
		this.examStrategyDetails = examStrategyDetails;
	}

}