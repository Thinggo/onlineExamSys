package com.csmy.bean;

import java.util.Date;


/**
 * ExamStrategy entity. @author MyEclipse Persistence Tools
 */

public class ExamStrategy  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer courseId;
     private String courseName;
     private Integer totalScore;
     private Integer passScore;
     private Byte strategystatus;
     private Date createtime;
   
     private Byte examPattern;
     private Byte isShowResult;
     private Byte isArrangeRoom;
     private Integer teacherId;
     private String teacherName;
     private Integer duration;



    // Constructors

    /** default constructor */
    public ExamStrategy() {
    }

	
    
   

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseId() {
        return this.courseId;
    }
    
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    
    public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getTotalScore() {
        return this.totalScore;
    }
    
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getPassScore() {
        return this.passScore;
    }
    
    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public Byte getStrategystatus() {
        return this.strategystatus;
    }
    
    public void setStrategystatus(Byte strategystatus) {
        this.strategystatus = strategystatus;
    }

    public Date getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    

    public Byte getExamPattern() {
        return this.examPattern;
    }
    
    public void setExamPattern(Byte examPattern) {
        this.examPattern = examPattern;
    }

    public Byte getIsShowResult() {
        return this.isShowResult;
    }
    
    public void setIsShowResult(Byte isShowResult) {
        this.isShowResult = isShowResult;
    }

    public Byte getIsArrangeRoom() {
        return this.isArrangeRoom;
    }
    
    public void setIsArrangeRoom(Byte isArrangeRoom) {
        this.isArrangeRoom = isArrangeRoom;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
    
    public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getDuration() {
        return this.duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

	@Override
	public String toString() {
		return "ExamStrategy [id=" + id + ", name=" + name + ", courseId="
				+ courseId + ", CourseName=" + courseName + ", totalScore="
				+ totalScore + ", passScore=" + passScore + ", strategystatus="
				+ strategystatus + ", createtime=" + createtime
				+ ", isDiffOrunit="  + ", examPattern="
				+ examPattern + ", isShowResult=" + isShowResult
				+ ", isArrangeRoom=" + isArrangeRoom + ", teacherId="
				+ teacherId + ", TeacherName=" + teacherName + ", duration="
				+ duration + "]";
	}
    
}