package Util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent 
{

	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponent(WebDriver driver) 
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForElementToAppearAndClick(WebElement ele)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click(); 
	}
	
	
	

}
