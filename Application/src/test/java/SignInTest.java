import PageObject.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SignInTest extends FSBase {

    public static String testDataFilePath = "/Users/malam2/Desktop/WEB2/Application/src/test/Data/test_data.xlsx";


    @Test (priority = 1, enabled = true)
    public void DCT_FS_1234() throws Exception {

        // Test Data
        String userName = readFromExcel(testDataFilePath, "SignInData", "A2");
        String password = readFromExcel(testDataFilePath, "SignInData", "B2");

        clickByXpath(HomePage.signInLink);
        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());

        clickByCssSelectorAndSendKeys(HomePage.emailField, userName);
        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());

        clickByCssSelectorAndSendKeys(HomePage.passwordField, password);
        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());

        clickByCssSelector(HomePage.loginButton);
//        new Object(){}.getClass().getEnclosingMethod().getName();

        takeTheScreenshot(new Object(){}.getClass().getEnclosingMethod().getName());



    }



//    @Test (priority = 0, enabled = false)
//    public void testNewLogin2() throws InterruptedException, IOException {
//
//        // Test Data
//        String userName = readFromExcel(testDataFilePath, "SignInData", "A3");
//        String password = readFromExcel(testDataFilePath, "SignInData", "B3");
//
//        clickByXpath(HomePage.signInLink);
//        clickByCssSelectorAndSendKeys(HomePage.emailField, userName);
//        clickByCssSelectorAndSendKeys(HomePage.passwordField, password);
//        clickByCssSelector(HomePage.loginButton);
//
//    }
//
//    @Test (priority = 0, enabled = false)
//    public void DCT_FS_1234() throws InterruptedException, IOException {
//
//        // Test Data
//        String userName = readFromExcel(testDataFilePath, "SignInData", "A4");
//        String password = readFromExcel(testDataFilePath, "SignInData", "B4");
//
//        clickByXpath(HomePage.signInLink);
//        clickByCssSelectorAndSendKeys(HomePage.emailField, userName);
//        clickByCssSelectorAndSendKeys(HomePage.passwordField, password);
//        clickByCssSelector(HomePage.loginButton);
//
//    }
//
//    @Test (priority = 0, enabled = false)
//    public void testNewLogin4() throws InterruptedException, IOException {
//
//        // Test Data
//        String userName = readFromExcel(testDataFilePath, "SignInData", "A5");
//        String password = readFromExcel(testDataFilePath, "SignInData", "B5");
//
//        clickByXpath(HomePage.signInLink);
//        clickByCssSelectorAndSendKeys(HomePage.emailField, userName);
//        clickByCssSelectorAndSendKeys(HomePage.passwordField, password);
//        clickByCssSelector(HomePage.loginButton);
//
//    }
//
//    @Test (priority = 0, enabled = false)
//    public void testNewLogin5() throws InterruptedException, IOException {
//
//        // Test Data
//        String userName = readFromExcel(testDataFilePath, "SignInData", "A6");
//        String password = readFromExcel(testDataFilePath, "SignInData", "B6");
//
//        clickByXpath(HomePage.signInLink);
//        clickByCssSelectorAndSendKeys(HomePage.emailField, userName);
//        clickByCssSelectorAndSendKeys(HomePage.passwordField, password);
//        clickByCssSelector(HomePage.loginButton);
//
//    }
//
//
//
//
//
//
//
//
//
////    @Test
////    public void testFSSignIn() throws Exception {
////        //fsLogin();
////        String userNameTestData = readFromExcel(testdata_file_path, "HomePage", "A1");
////        //clickByXpath(HomePage.signInLinkXpath);
////        //clickByCssSelectorAndSendKeys(userNameFieldXPath, userNameTestData);
////        //clickByCssSelectorAndSendKeys(passwordFieldXpath, password);
////        //clickByCssSelector(signInButtonXpath);
////        //Assert.assertEquals(driver.getTitle(), "Message Inbox | Secure Message Center");
////
////    }
//
////    @Test
////    public void myTestCase2() {
////
////        // test step 1
////        // test step 2
////        // test step 3
////        // test step 4
////
////    }
////
////    @Test
////    public void myTestCase4() {
////
////        // test step 1
////        // test step 2
////        // test step 3
////        // test step 4
////    }


}