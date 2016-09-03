package com.csmy.bean;



/**
 * ExamRoom entity. @author MyEclipse Persistence Tools
 */

public class ExamRoom  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer no;
     private String roomAddr;
     private String roomIp;
     private int capacity;


    // Constructors

    /** default constructor */
    public ExamRoom() {
    }

	/** minimal constructor */
    public ExamRoom(Integer id, Integer no) {
        this.id = id;
        this.no = no;
    }
    
    /** full constructor */
    public ExamRoom(Integer id, Integer no, String roomAddr, String roomIp) {
        this.id = id;
        this.no = no;
        this.roomAddr = roomAddr;
        this.roomIp = roomIp;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return this.no;
    }
    
    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRoomAddr() {
        return this.roomAddr;
    }
    
    public void setRoomAddr(String roomAddr) {
        this.roomAddr = roomAddr;
    }

    public String getRoomIp() {
        return this.roomIp;
    }
    
    public void setRoomIp(String roomIp) {
        this.roomIp = roomIp;
    }

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
   








}