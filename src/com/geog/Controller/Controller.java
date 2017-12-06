package com.geog.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import com.geog.DAO.DAO;
import com.geog.Model.City;
import com.geog.Model.Country;
import com.geog.Model.Region;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@SessionScoped
@ManagedBean (name="controller")
public class Controller {
	
	ArrayList<Country> countries;
	ArrayList<Region> regions;
	ArrayList<City> cities;
	private DAO dao;

	public Controller() {
		super();
		countries = new ArrayList<Country>();
		regions = new ArrayList<Region>();
		cities = new ArrayList<City>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller(ArrayList<Country> countries,ArrayList<Region> regions,ArrayList<City> cities) {
		super();
		this.countries = countries;
		this.regions = regions;
		this.cities = cities;
	}

	public ArrayList<City> getCities() {
		return cities;
	}

	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public void setRegions(ArrayList<Region> regions) {
		this.regions = regions;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	
	public void loadCountries() throws Exception {
		countries.clear();
		if (dao != null) {
			try {
				countries = dao.loadCountries();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addCountry(Country country) {
		if (dao != null) {
			try {
				dao.addCountry(country);
				return "country";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Country Code " + country.getCo_code() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Country " + country.getCo_code());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	
	public String deleteCountry(String co_code) throws Exception {
		
			System.out.println("inside controler");
			dao.deleteCountry(co_code);
			return "country";
		
	}
	
	public void loadRegions() throws Exception {
		regions.clear();
		if (dao != null) {
			try {
				regions = dao.loadRegions();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addRegion(Region region) {
		if (dao != null) {
			try {
				dao.addRegion(region);
				return "region";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Country Code " + region.getCo_code() + " does not exist");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Region " + region.getReg_name() + ". Please make sure the country code is valid");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	////CITY
	
	public void loadCity() throws Exception {
		cities.clear();
		if (dao != null) {
			try {
				cities = dao.loadCities();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	


}
