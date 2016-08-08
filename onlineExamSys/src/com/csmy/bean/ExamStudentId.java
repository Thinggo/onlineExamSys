package com.csmy.bean;



/**
 * ExamStudentId entity. @author MyEclipse Persistence Tools
 */

public class ExamStudentId  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer studentId;
     private Integer examplanId;


    // Constructors

    /** default constructor */
    public ExamStudentId() {
    }

    
    /** full constructor */
    public ExamStudentId(Integer id, Integer studentId, Integer examplanId) {
        this.id = id;
        this.studentId = studentId;
        this.examplanId = examplanId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExamplanId() {
        return this.examplanId;
    }
    
    public void setExamplanId(Integer examplanId) {
        this.examplanId = examplanId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ExamStudentId) ) return false;
		 ExamStudentId castOther = ( ExamStudentId ) other; 
         
		 return ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getStudentId()==castOther.getStudentId()) || ( this.getStudentId()!=null && castOther.getStudentId()!=null && this.getStudentId().equals(castOther.getStudentId()) ) )
 && ( (this.getExamplanId()==castOther.getExamplanId()) || ( this.getExamplanId()!=null && castOther.getExamplanId()!=null && this.getExamplanId().equals(castOther.getExamplanId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getStudentId() == null ? 0 : this.getStudentId().hashCode() );
         result = 37 * result + ( getExamplanId() == null ? 0 : this.getExamplanId().hashCode() );
         return result;
   }   





}