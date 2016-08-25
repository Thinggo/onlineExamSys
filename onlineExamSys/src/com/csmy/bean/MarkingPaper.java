package com.csmy.bean;

import java.util.List;

/**
 * MarkingPaper entity. @author MyEclipse Persistence Tools
 */

public class MarkingPaper  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private List<Integer> teacherId;
    
     private Integer questionTypeid;
     private Integer planId;
     private Integer count;


    // Constructors

    /** default constructor */
    public MarkingPaper() {
    }   

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }   
   

    public Integer getPlanId() {
        return this.planId;
    }
    
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

	public Integer getQuestionTypeid() {
		return questionTypeid;
	}

	public void setQuestionTypeid(Integer questionTypeid) {
		this.questionTypeid = questionTypeid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}


	public List<Integer> getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(List<Integer> teacherId) {
		this.teacherId = teacherId;
	}


	
}