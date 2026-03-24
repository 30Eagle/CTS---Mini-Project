package tests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pages.HomePage;
import Pages.ProductListPage;
import base.BaseTest;

public class GadgetTest extends BaseTest {

    @DataProvider(name = "productData")
    public Object[][] getData() throws IOException
    {
        
        ObjectMapper mapper = new ObjectMapper();
        
        
        List<Map<String, String>> data = mapper.readValue(
            new File(System.getProperty("user.dir") + "/src/test/resources/productData.json"), 
            new TypeReference<List<Map<String, String>>>() {}
        );

        
        Object[][] testData = new Object[data.size()][3];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i).get("productName");
            testData[i][1] = data.get(i).get("min");
            testData[i][2] = data.get(i).get("max");
        }

        return testData;
    }

    @Test(dataProvider = "productData")
    public void searchPage(String productName, String min, String max) throws InterruptedException {
    	
        HomePage hp = new HomePage(driver);
        hp.searchProduct(productName);
    }
    @Test(dataProvider = "productData", dependsOnMethods = {"searchPage"})
    public void filterStep(String productName, String min, String max) throws InterruptedException
    {
        ProductListPage pl = new ProductListPage(driver);

        
        pl.applyFilters(min, max);
        pl.printTopFive();
    }
    
}