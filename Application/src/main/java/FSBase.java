import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class FSBase extends Base {

    String testdata_file_path = "/Users/malam2/Desktop/WEB2/Application/src/test/Test_Data/testdata.xlsx";

    String signInLinkXpath = "//*[@id=\"app\"]/div/header/nav[1]/div/button";
    String userNameFieldXPath = ".c-form-field.c-form-field--email>label>input";
    String passwordFieldXpath = ".c-form-field.c-form-field--password>label>input";
    String signInButtonXpath = ".c-btn.c-btn--primary";

    public String userName = "footlockertesting@gmail.com";
    public String password = "Test@1234";


    public void fsLogin() throws InterruptedException, IOException {
        clickByXPathAndSendKeys("//*[@id=\"twotabsearchtextbox\"]", "iphone");
        Thread.sleep(5000);

        String userNameTestData = readFromExcel(testdata_file_path, "HomePage", "A1");
        clickByXpath(signInLinkXpath);
        clickByCssSelectorAndSendKeys(userNameFieldXPath, userNameTestData);
        clickByCssSelectorAndSendKeys(passwordFieldXpath, password);
        clickByCssSelector(signInButtonXpath);
    }

    public void myTestCase2() throws InterruptedException {
        clickByXpath(signInLinkXpath);
        Thread.sleep(4000);
        driver.findElement(By.xpath("")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("")).sendKeys("alam.write@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("")).sendKeys("Locker12");
        Thread.sleep(3000);
        driver.findElement(By.xpath("")).click();
        Thread.sleep(3000);

    }

    public void myTestCase3() throws InterruptedException, IOException {
        clickByXPathAndSendKeys("//*[@id=\"twotabsearchtextbox\"]", "iphone");
        Thread.sleep(5000);

        String userNameTestData = readFromExcel(testdata_file_path, "HomePage", "A1");
        clickByXpath(signInLinkXpath);
        clickByCssSelectorAndSendKeys(userNameFieldXPath, userNameTestData);
        clickByCssSelectorAndSendKeys(passwordFieldXpath, password);
        clickByCssSelector(signInButtonXpath);
    }

    public void myTestCase4() throws InterruptedException, IOException {
        clickByXPathAndSendKeys("//*[@id=\"twotabsearchtextbox\"]", "iphone");
        Thread.sleep(5000);

        String userNameTestData = readFromExcel(testdata_file_path, "HomePage", "A1");
        clickByXpath(signInLinkXpath);
        clickByCssSelectorAndSendKeys(userNameFieldXPath, userNameTestData);
        clickByCssSelectorAndSendKeys(passwordFieldXpath, password);
        clickByCssSelector(signInButtonXpath);
    }

    public void myTestCase5() throws InterruptedException, IOException {
        clickByXPathAndSendKeys("//*[@id=\"twotabsearchtextbox\"]", "iphone");
        Thread.sleep(5000);

        String userNameTestData = readFromExcel(testdata_file_path, "HomePage", "A1");
        clickByXpath(signInLinkXpath);
        clickByCssSelectorAndSendKeys(userNameFieldXPath, userNameTestData);
        clickByCssSelectorAndSendKeys(passwordFieldXpath, password);
        clickByCssSelector(signInButtonXpath);
    }

    public void takeScreenshot() {
        // sreenshort code
        // sreenshort code lkahflajhflkjahs
        // sreenshort code
    }

//
//        driver.findElement(By.xpath(signInLinkXpath)).click();
//        Thread.sleep(4000);
//        driver.findElement(By.cssSelector(userNameFieldXPath)).sendKeys(userName);
//        Thread.sleep(4000);
//        driver.findElement(By.cssSelector(passwordFieldXpath)).sendKeys(password);
//        Thread.sleep(4000);
//        driver.findElement(By.cssSelector(signInButtonXpath)).click();
//        Thread.sleep(5000);










}