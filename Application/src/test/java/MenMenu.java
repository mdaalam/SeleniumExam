import org.openqa.selenium.By;
import org.testng.annotations.Test;
import PageObject.MenMenuPage;

import java.io.IOException;

public class MenMenu extends FSBase{



    @Test(priority = 1, enabled = true)
    public void testBasketBallLink() throws InterruptedException, IOException {

//        driver.findElement(By.xpath(MenMenuPage.menLink)).click();
//        driver.findElement(By.xpath(MenMenuPage.baseBallLink)).click();

        clickByXpath(MenMenuPage.menLink);
        clickByXpath(MenMenuPage.baseBallLink);
        check("Men Shoes BasketBall",getTitle());


    }


}
