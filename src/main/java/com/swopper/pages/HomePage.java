package com.swopper.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	
	//By locators
	
	
	
	
	
	

	//constructor
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Get the title of the page
	public String getHomePageTitle() {
		return driver.getTitle();
	}

}
