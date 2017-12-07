package com.geog.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.geog.Model.City;
import com.geog.Model.Country;
import com.geog.Model.Region;


public class DAO {
	private static DataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/geography";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	//countries
	public ArrayList<Country> loadCountries() throws Exception {
		ArrayList<Country> countries = new ArrayList<Country>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "select * from country";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String code= myRs.getString("co_code");
			String name = myRs.getString("co_name");
			String details = myRs.getString("co_details");

			// create new country object
			Country country = new Country(code,name, details);
			countries.add(country);
		}	
		return countries;
	}

	public Country loadCountry(String co_code) throws Exception {
		List<Country> countries = new ArrayList<Country>();
		Country country = new Country();
	
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from country WHERE co_code = '" + co_code + "';";

		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String countryCode = myRs.getString("co_code");
			String countryName = myRs.getString("co_name");
			String countryDetails = myRs.getString("co_details");

			country = new Country(countryCode, countryName, countryDetails);
			countries.add(country);
		}	
		return country;
	}
	
	//add country
	public void addCountry(Country country) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into country values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, country.getCo_code());
		myStmt.setString(2, country.getCo_name());
		myStmt.setString(3, country.getCo_details());
		myStmt.execute();
		myStmt.close();
		myConn.close();
	}
	
	public void updateCountry(String co_code,String co_name,String co_details) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "update country set co_name = ?,co_details = ? where co_code = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, co_name);
		myStmt.setString(2, co_details);
		myStmt.setString(3,co_code);
		myStmt.execute();
		myStmt.close();
		myConn.close();
		
	
	}
	
	//delete country
	public void deleteCountry(String code) throws Exception {
	    Connection myConn = null;
	    PreparedStatement myStmt = null;
	    
	    myConn = mysqlDS.getConnection();
		String sql = "DELETE FROM country WHERE co_code = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, code);
		myStmt.execute();
		myStmt.close();
		myConn.close();
	    
	}
	
	
	//regions
	public ArrayList<Region> loadRegions() throws Exception {
		ArrayList<Region> regions = new ArrayList<Region>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "select * from region";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String co_code= myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String reg_name = myRs.getString("reg_name");
			String reg_desc = myRs.getString("reg_desc");

			// create new region object
			Region region = new Region(co_code,reg_code,reg_name, reg_desc);
			regions.add(region);
		}	
		return regions;
	}
	
	//add region
	public void addRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into region values (?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, region.getCo_code());
		myStmt.setString(2, region.getReg_code());
		myStmt.setString(3, region.getReg_name());
		myStmt.setString(4, region.getReg_desc());
		myStmt.execute();			
	}
	
	
	//cities
	public ArrayList<City> loadCities() throws Exception {
		ArrayList<City> cities = new ArrayList<City>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "select * from city";
		myStmt = myConn.createStatement();
		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String cty_code= myRs.getString("cty_code");
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String cty_name= myRs.getString("cty_name");
			int population = myRs.getInt("population");
			boolean isCoastal = myRs.getBoolean("isCoastal");
			double areaKM= myRs.getDouble("areaKM");

			// create new city object
			City city = new City(cty_code,co_code,reg_code,cty_name,population,isCoastal,areaKM);
			cities.add(city);
		}	
		return cities;
	}

	//add city
	public void addCity(City city) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into city values (?, ?, ?, ?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, city.getCty_code());
		myStmt.setString(2, city.getCo_code());
		myStmt.setString(3, city.getReg_code());
		myStmt.setString(4, city.getCty_name());
		myStmt.setLong(5, city.getPopulation());
		myStmt.setString(6, city.getisCoastal()?"true":"false");
		myStmt.setLong(7, (long) city.getAreaKM());
		myStmt.execute();			
	}
	
	public void findCity(City city) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql = "";
		
		myConn = mysqlDS.getConnection();
		
		if(city.getSign() == "less_than"){
			
				sql = "select * from city where population < ?";
			
		}
		
		
		
		
		myStmt = myConn.prepareStatement(sql);
		myStmt.execute();			
	}
	
	public City loadCity(String code) throws Exception {
		City city = new City();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from city where cty_code = " + "'" + code + "'";
		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String cty_code = myRs.getString("cty_code");
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String cty_name = myRs.getString("cty_name");
			int population = myRs.getInt("population");
			boolean isCoastal = myRs.getBoolean("isCoastal");
			float areaKM = myRs.getFloat("areaKM");

			// create new product object
			city = new City(cty_code, co_code,reg_code,cty_name,population,isCoastal,areaKM);
		}	
		return city;
	}
}