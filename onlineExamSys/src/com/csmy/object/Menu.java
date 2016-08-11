package com.csmy.object;

import java.util.HashSet;
import java.util.Set;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String url;
	private String pid;
	private Integer seqNo;
	private String icon;
	private Integer menustatus;
	private Integer menutype;
	private Set rolemenus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}

	/** full constructor */
	public Menu(String name, String url, String pid, Integer seqNo,
			String icon, Integer menustatus, Integer menutype, Set rolemenus) {
		this.name = name;
		this.url = url;
		this.pid = pid;
		this.seqNo = seqNo;
		this.icon = icon;
		this.menustatus = menustatus;
		this.menutype = menutype;
		this.rolemenus = rolemenus;
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

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
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

	public Set getRolemenus() {
		return this.rolemenus;
	}

	public void setRolemenus(Set rolemenus) {
		this.rolemenus = rolemenus;
	}

}