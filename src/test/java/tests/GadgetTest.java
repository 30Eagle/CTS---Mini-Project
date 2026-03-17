package tests;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductListPage;
import base.BaseTest;

public class GadgetTest extends BaseTest{
  @Test
  public void test() throws InterruptedException {
	  
	  
	  HomePage hp = new HomePage(driver);
	  ProductListPage pl = new ProductListPage(driver);
	  
	  hp.searchProduct("Bluetooth Headphones");
	  pl.applyFilters("700","1400");
	  pl.printTopFive();
  }
}
