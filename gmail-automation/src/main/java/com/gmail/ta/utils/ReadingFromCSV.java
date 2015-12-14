package com.gmail.ta.utils;

import au.com.bytecode.opencsv.CSVReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class ReadingFromCSV {
	
	private String email;
	private String password;
	
	private String secondEmail;
	private String secondPassword;
	
	public String getSecondEmail() {
		return secondEmail;
	}
	public String getSecondPassword() {
		return secondPassword;
	}
	public void setSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
	}
	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	private static final Logger LOGGER = Logger.getLogger(ReadingFromCSV.class);
	private static String CSV_Path = "src/main/resources/Users.csv";
	private WebDriver driver;
	
	public void readFromCSV() throws IOException {

    CSVReader reader = new CSVReader(new FileReader(CSV_Path));
	String [] csvCell;	
		 while ((csvCell = reader.readNext()) != null) {   
		 setEmail(csvCell[0]);
		 setPassword(csvCell[1]);
		 setSecondEmail(csvCell[2]);
		 setSecondPassword(csvCell[3]);
		 LOGGER.info("Reading data from CSV file");
		 
	 }

			
	}
	
	
}