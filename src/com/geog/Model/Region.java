package com.geog.Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;




@ManagedBean(name="region")
@SessionScoped
public class Region {

	private String co_code;
	private String reg_code;
	private String reg_name;
	private String reg_desc;
	
	//Constructors
	public Region(){
	}

	public Region(String co_code, String reg_code, String reg_name,String reg_desc) {
		super();
		this.co_code = co_code;
		this.reg_code = reg_code;
		this.reg_name = reg_name;
		this.reg_desc = reg_desc;
	}

	//Getters and Setters
	public String getCo_code() {
		return co_code;
	}

	public void setCo_code(String co_code) {
		this.co_code = co_code;
	}

	public String getReg_code() {
		return reg_code;
	}

	public void setReg_code(String reg_code) {
		this.reg_code = reg_code;
	}

	public String getReg_name() {
		return reg_name;
	}

	public void setReg_name(String reg_name) {
		this.reg_name = reg_name;
	}

	public String getReg_desc() {
		return reg_desc;
	}

	public void setReg_desc(String reg_desc) {
		this.reg_desc = reg_desc;
	}

	
}