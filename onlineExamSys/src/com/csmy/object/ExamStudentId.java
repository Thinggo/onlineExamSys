package com.csmy.object;

/**
 * ExamStudentId entity. @author MyEclipse Persistence Tools
 */

public class ExamStudentId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Student student;
	private ExamStrategy examStrategy;

	// Constructors

	/** default constructor */
	public ExamStudentId() {
	}

	/** full constructor */
	public ExamStudentId(Integer id, Student student, ExamStrategy examStrategy) {
		this.id = id;
		this.student = student;
		this.examStrategy = examStrategy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExamStrategy getExamStrategy() {
		return this.examStrategy;
	}

	public void setExamStrategy(ExamStrategy examStrategy) {
		this.examStrategy = examStrategy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExamStudentId))
			return false;
		ExamStudentId castOther = (ExamStudentId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getStudent() == castOther.getStudent()) || (this
						.getStudent() != null && castOther.getStudent() != null && this
						.getStudent().equals(castOther.getStudent())))
				&& ((this.getExamStrategy() == castOther.getExamStrategy()) || (this
						.getExamStrategy() != null
						&& castOther.getExamStrategy() != null && this
						.getExamStrategy().equals(castOther.getExamStrategy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getStudent() == null ? 0 : this.getStudent().hashCode());
		result = 37
				* result
				+ (getExamStrategy() == null ? 0 : this.getExamStrategy()
						.hashCode());
		return result;
	}

}