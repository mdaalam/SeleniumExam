import PageObject.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProductTest extends FSBase {

    public static String testDataFilePath = "/Users/malam2/Desktop/WEB2/Application/src/test/Data/test_data.xlsx";

    @Test
    public void searchProduct() throws Exception {

        String product = readFromExcel(testDataFilePath, "Product", "A2");
        clickByXPathAndSendKeys(HomePage.searchField, product);
        clickByXpath(HomePage.searchIcon);
        Thread.sleep(5000);

        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());




    }


    // Write 5 other test cases here ...

}
