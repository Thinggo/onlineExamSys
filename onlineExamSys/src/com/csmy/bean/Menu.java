package com.csmy.bean;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu  implements java.io.Serializable {


    // Fields    

     private Integer id;
     @SerializedName("text")
     private String name;
     private String url;
     private Integer pid;
     private Integer seqNo;
     @SerializedName("iconCls")
     private String icon;
     private Integer menustatus;
     private Integer menutype;
     private List<Menu> children;
     
     //业务逻辑需要添加:用于做授权控制
     private boolean checked;

    // Constructors

    /** default constructor */
    public Menu() {
    }

	/** minimal constructor */
    public Menu(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }
    
    /** full constructor */
    public Menu(Integer id, String name, String url, Integer pid, Integer seqNo, String icon, Integer menustatus, Integer menutype) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.seqNo = seqNo;
        this.icon = icon;
        this.menustatus = menustatus;
        this.menutype = menutype;
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

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSeqNo() {
        return this.seqNo;
    }
    
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getIcon() {
        return this.icon;
    }
    
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getMenustatus() {
        return this.menustatus;
    }
    
    public void setMenustatus(Integer menustatus) {
        this.menustatus = menustatus;
    }

    public Integer getMenutype() {
        return this.menutype;
    }
    
    public void setMenutype(Integer menutype) {
        this.menutype = menutype;
    }

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
   








}