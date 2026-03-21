package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductListPage;
import base.BaseTest;

public class GadgetTest extends BaseTest{
	
	@DataProvider(name = "productData")
	  public Object[][] getData()
	  {
		  return new Object[][] 
				  {
	            		{"Bluetooth Headphones", "700", "1400"},
				  };
	  }
	
  @Test(dataProvider = "productData")
  public void test(String productName, String min, String max) throws InterruptedException {
	  
	  
	  HomePage hp = new HomePage(driver);
	  ProductListPage pl = new ProductListPage(driver);
	  
	  hp.searchProduct(productName);
	  pl.applyFilters(min, max);
	  pl.printTopFive();
  }
}
