package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    
    @BeforeClass
    public void setup() throws IOException {
    	
    		Properties prop = new Properties();
    		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\config.properties");
    		prop.load(fis);
    		String browserName = prop.getProperty("browser");
    		System.out.println(browserName);
    		if(browserName.equals("chrome"))
    		{
    			WebDriverManager.chromedriver().setup();
    			driver = new ChromeDriver(); 
    		}
    		else if(browserName.equals("edge"))
    		{
    			WebDriverManager.edgedriver().setup();
    			driver = new EdgeDriver();
    		}
    		String url = prop.getProperty("url");
    		System.out.println(url);
    		driver.get(url);

    		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}