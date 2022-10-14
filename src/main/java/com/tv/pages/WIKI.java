package com.tv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tv.baseclass.BaseClass;

import comm.tv.common.SeleniumMethods;

public class WIKI {
	public SeleniumMethods selMethod ;
	
	@FindBy(id="searchInput")
	WebElement searchInput;
	@FindBy(id="searchButton")
	WebElement searchButton;
	@FindBy(xpath = "//*[@class='infobox vevent']//th[text()='Country']//..//td")
	WebElement country;
	@FindBy(xpath = "//*[@class='infobox vevent']//th//div[text()='Release date']//..//..//td//li")
	WebElement releaseDate;
	
	public WIKI(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selMethod = new SeleniumMethods(driver);
	}

	public void searchMovie(String movie) {
		selMethod.sendKeys(searchInput, movie);
		selMethod.click(searchButton);
		
	}

	public String getMovieReleaseDate() {
		return selMethod.getText(releaseDate);
	}

	public String getMovieCountry() {
		return selMethod.getText(country);
	}
	
	
	
}

