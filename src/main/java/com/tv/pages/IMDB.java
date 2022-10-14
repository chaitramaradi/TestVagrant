package com.tv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tv.baseclass.BaseClass;

import comm.tv.common.SeleniumMethods;

public class IMDB {

	public SeleniumMethods selMethod ;
	
	
	@FindBy(id="suggestion-search")
	WebElement search;
	@FindBy(id="suggestion-search-button")
	WebElement searchButton;
	@FindBy(xpath = "//li[@data-testid='title-details-releasedate']//li[@role='presentation']//a")
	WebElement releaseDate;
	@FindBy(xpath = "//li[@data-testid='title-details-origin']//li[@role='presentation']//a")
	WebElement country;
	String movieLink = "//a[contains(text() , 'MovieName')]";
	
	
	public IMDB(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selMethod = new SeleniumMethods(driver);
	}
	
	public void searchMovie(String movie) {
		selMethod.sendKeys(search, movie);
		selMethod.click(searchButton);
	}
	
	public void selectMovie(String movie) {
		selMethod.click(By.xpath(movieLink.replace("MovieName", movie)));
	}
	public String getMovieReleaseDate() {
		return selMethod.getText(releaseDate);
	}
	public String getMovieCountry() {
		return selMethod.getText(country);
	}
}
