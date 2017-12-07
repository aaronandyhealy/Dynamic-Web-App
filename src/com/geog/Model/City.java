package com.geog.Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;




@ManagedBean(name="city")
@SessionScoped
public class City {
	
	private String cty_code;
	private String co_code;
	private String reg_code;
	private String cty_name;
	private int population;
	private boolean isCoastal;
	private double areaKM;
	private String sign;
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public City(){
	}

	public City(String cty_code, String co_code, String reg_code,String cty_name, int population, boolean isCoastal, double areaKM) {
		super();
		this.cty_code = cty_code;
		this.co_code = co_code;
		this.reg_code = reg_code;
		this.cty_name = cty_name;
		this.population = population;
		this.isCoastal = isCoastal;
		this.areaKM = areaKM;
	}

	public String getCty_code() {
		return cty_code;
	}

	public void setCty_code(String cty_code) {
		this.cty_code = cty_code;
	}

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

	public String getCty_name() {
		return cty_name;
	}

	public void setCty_name(String cty_name) {
		this.cty_name = cty_name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean getisCoastal() {
		return isCoastal;
	}

	public void setisCoastal(boolean isCoastal) {
		this.isCoastal = isCoastal;
	}

	public double getAreaKM() {
		return areaKM;
	}

	public void setAreaKM(double areaKM) {
		this.areaKM = areaKM;
	}

	
}