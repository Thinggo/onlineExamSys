package com.csmy.bean;

import java.util.*;


/**
 * PaperDetail entity.
 *  @author chun
 */

public class PaperDetail  implements java.io.Serializable {


    // Fields    

     private Integer paperId;
     private Integer studentId;
     private String  studentName;
     private Integer planId;
     private String  planName;
     private Integer questionId;
     private String  questionTitle;
     private Integer   questionType;
     private Integer displayId;
     private String answer;  //学生答案
     private String rightAnswer; //正确答案
     private Integer refscore ;
     private Double score;
     private Integer teacherId;
     private String teacherName;
     private Date markingTime;
     private Byte flag;
     private List<PaperOption> list;

    // Constructors

    /** default constructor */
    public PaperDetail() {
    }

	/** minimal constructor */
    public PaperDetail(Integer paperId, Integer studentId, Integer planId, Integer questionId, Integer displayId) {
        this.paperId = paperId;
        this.studentId = studentId;
        this.planId = planId;
        this.questionId = questionId;
        this.displayId = displayId;
    }
    
    /** full constructor */
    public PaperDetail(Integer paperId, Integer studentId, Integer planId, Integer questionId, Integer displayId, String answer, Double score, Integer teacherId, Date markingTime, Byte flag) {
        this.paperId = paperId;
        this.studentId = studentId;
        this.planId = planId;
        this.questionId = questionId;
        this.displayId = displayId;
        this.answer = answer;
        this.score = score;
        this.teacherId = teacherId;
        this.markingTime = markingTime;
        this.flag = flag;
    }

   
    // Property accessors

    public Integer getPaperId() {
        return this.paperId;
    }
    
    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPlanId() {
        return this.planId;
    }
    
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getDisplayId() {
        return this.displayId;
    }
    
    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getScore() {
        return this.score;
    }
    
    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getMarkingTime() {
        return this.markingTime;
    }
    
    public void setMarkingTime(Date markingTime) {
        this.markingTime = markingTime;
    }

    public Byte getFlag() {
        return this.flag;
    }
    
    public void setFlag(Byte flag) {
        this.flag = flag;
    }

	public Integer getRefscore() {
		return refscore;
	}

	public void setRefscore(Integer refscore) {
		this.refscore = refscore;
	}

	public List<PaperOption> getList() {
		return list;
	}

	public void setList(List<PaperOption> list) {
		this.list = list;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	

}