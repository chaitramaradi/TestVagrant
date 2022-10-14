package comm.tv.common;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumMethods {
	
	WebDriver driver;
	public SeleniumMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public void sendKeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public void click(WebElement element) {
		elementToBeClickable(element);
		element.click();
	}
	
	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void visibilityOf(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(By xpath) {
		WebElement element = driver.findElement(xpath);
		elementToBeClickable(element);
		element.click();
	}

	public String getText(WebElement element) {
		visibilityOf(element);
		return element.getText();
		
	}
	
	public void quit() {
		driver.quit();
	}
}
