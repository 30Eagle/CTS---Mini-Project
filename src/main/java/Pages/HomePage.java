package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement serachBox = driver.findElement(By.id("search-box-input"));
	@FindBy(id = "search-box-input")
	WebElement serachBox;
	
	@FindBy(css = "div[class='sort-selected']")
	WebElement searchDropDown;
	
	public void searchProduct(String productName)
	{
		serachBox.sendKeys(productName + Keys.ENTER);
		
	}
	

}
