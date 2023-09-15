package com.Store.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@Column
	private int pid ;
	
	@Column
	private String pname ;
	
	@Column
	private String Category ;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public Product(int pid, String pname, String category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.Category = category;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
