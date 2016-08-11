package com.csmy.bean;

import java.util.Date;
import java.util.List;


/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String title;
     private Integer courseId;
     private String  courseName;
     private Integer courseunitId;
     private String  nuitName;
     private Integer typeId;
     private String  typeName;
     private Integer deleteFlag;
     private String answer;
     private Integer defficulty;
     private String explanin;
     private Integer teacherId;
     private String  teacherNmae;
     private Date createDate;
     private List<QuestionOption> list;


    // Constructors

    /** default constructor */
    public Question() {
    }

	/** minimal constructor */
    public Question(Integer id, String title, Integer deleteFlag, Date createDate) {
        this.id = id;
        this.title = title;
        this.deleteFlag = deleteFlag;
        this.createDate = createDate;
    }
    
    /** full constructor */
    public Question(Integer id, String title, Integer courseId, Integer courseunitId, Integer typeId, Integer deleteFlag, String answer, Integer defficulty, String explanin, Integer teacherId, Date createDate) {
        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.courseunitId = courseunitId;
        this.typeId = typeId;
        this.deleteFlag = deleteFlag;
        this.answer = answer;
        this.defficulty = defficulty;
        this.explanin = explanin;
        this.teacherId = teacherId;
        this.createDate = createDate;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseunitId() {
        return this.courseunitId;
    }
    
    public void setCourseunitId(Integer courseunitId) {
        this.courseunitId = courseunitId;
    }

    public Integer getTypeId() {
        return this.typeId;
    }
    
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getDefficulty() {
        return this.defficulty;
    }
    
    public void setDefficulty(Integer defficulty) {
        this.defficulty = defficulty;
    }

    public String getExplanin() {
        return this.explanin;
    }
    
    public void setExplanin(String explanin) {
        this.explanin = explanin;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getNuitName() {
		return nuitName;
	}

	public void setNuitName(String nuitName) {
		this.nuitName = nuitName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTeacherNmae() {
		return teacherNmae;
	}

	public void setTeacherNmae(String teacherNmae) {
		this.teacherNmae = teacherNmae;
	}

	public List<QuestionOption> getList() {
		return list;
	}

	public void setList(List<QuestionOption> list) {
		this.list = list;
	}
   


}