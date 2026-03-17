package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponenets.AbstractComponent;

public class ProductListPage extends AbstractComponent {
	
	WebDriver driver;
	public ProductListPage(WebDriver driver) 
	{
		super(driver);
		this .driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='sort-selected']")
	private WebElement sortDropdown;
	
	@FindBy(css = "li[data-sorttype='rlvncy']")
    private WebElement relevanceOption;

    @FindBy(css = "li[data-sorttype='plrty']")
    private WebElement popularityOption;

    @FindBy(css = "input[name='fromVal']")
    private WebElement minRangeInput;

    @FindBy(css = "input[name='toVal']")
    private WebElement maxRangeInput;

    @FindBy(css = "div[class='price-go-arrow btn btn-line btn-theme-secondary']") 
    private WebElement priceGoButton;

//    @FindBy(className = "product-tuple-listing")
//    List<WebElement> products;

   

    public void applyFilters(String min, String max) throws InterruptedException 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
//        sort.click();
        
        waitForElementToAppearAndClick(sortDropdown);
        
//        wait.until(ExpectedConditions.elementToBeClickable(relevanceOption)).click();
        waitForElementToAppearAndClick(relevanceOption);
        
//        sort.click();
        waitForElementToAppearAndClick(sortDropdown);
        
//        wait.until(ExpectedConditions.elementToBeClickable(popularityOption)).click();
        waitForElementToAppearAndClick(popularityOption);

        wait.until(ExpectedConditions.elementToBeClickable(minRangeInput));

        minRangeInput.clear();
        minRangeInput.sendKeys(min);
        
        maxRangeInput.clear();
        maxRangeInput.sendKeys(max);

        wait.until(ExpectedConditions.elementToBeClickable(priceGoButton)).click();
        
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-title")));   
        Thread.sleep(3000);
        
    }
    
    
    public void printTopFive() {
    		System.out.println("--- Top 5 Bluetooth Headphones ---");
        
        List<WebElement> freshProducts = driver.findElements(By.className("product-tuple-listing"));

        int count = Math.min(freshProducts.size(), 5);
        
        for (int i = 0; i < count; i++) 
        {
            try 
            {
                WebElement product = driver.findElements(By.className("product-tuple-listing")).get(i);
                
                String title = product.findElement(By.className("product-title")).getText();
                String price = product.findElement(By.className("product-price")).getText();
                
                System.out.println((i + 1) + ". " + title + " | Price: " + price);
                
            } 
            catch (Exception e) 
            {
                System.out.println("Error fetching product " + (i + 1) + ". Skipping...");
            }
        }
        System.out.println("-----------------------------------");
    }
    
}