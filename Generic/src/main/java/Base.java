import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;




import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;




public class Base {


    public String name = null;


    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());


    @AfterMethod
    public void cleanUp() throws InterruptedException {

        // Take the screenshot


        log.info("driver is quiting");
        driver.quit();
    }


    @Parameters({"useSauceLab", "userName", "key", "appUrl", "os", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab, String userName, String key, String appUrl, String os, String browserName, String browserVersion) throws IOException {
        if (useSauceLab == true) {
            getSauceLabDriver(userName, key, os, browserName, browserVersion);
//            getSauceLabDriver();
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to(appUrl);
        driver.manage().window().maximize();
        log.info("browser loaded with App");
    }


    public void getSauceLabDriver(){}

    //get local driver
    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            //driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "/Users/malam2/Desktop/WEB2/Generic/src/resource/driver/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "/Users/malam2/Desktop/WEB2/Generic/src/resource/driver/chromedriver");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            //driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "");
            //driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }

    //get cloud driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,
                                       String browserVersion )throws IOException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }

    public void check(String actualValue, String expectedValue) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(actualValue, expectedValue);
    }


    public void clickByXpath(String xPath) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(xPath)).click();
        Thread.sleep(5000);
    }

    public void clickByCssSelector(String css)  throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(css)).click();
    }

    public void takeScreenShot() {
        //
        //
        //

    }

    public void clickByCssSelectorAndSendKeys(String css, String key)  throws InterruptedException {
        Thread.sleep(3000);
        // clear the field
        driver.findElement(By.cssSelector(css)).sendKeys(key);
    }

    public void clickByXPathAndSendKeys(String xp, String key)  throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(xp)).sendKeys(key);
    }

    public void waitSometime(int time) throws Exception{
        Thread.sleep(time);
    }


    public static String readFromExcel(String fileRef, String sheetRef, String cellRef) throws IOException {
        FileInputStream fis = new FileInputStream(fileRef);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetRef);
        DataFormatter formatter = new DataFormatter();
        CellReference cellReference = new CellReference(cellRef);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        String value = "";
        if (cell != null) {
            value = formatter.formatCellValue(cell);//cell.getStringCellValue();
        }
        return value;
    }

    public String getTitle() throws InterruptedException {
        Thread.sleep(5000);
        return driver.getTitle();

    }

    public void takeTheScreenshot(String testCaseName) throws Exception {
        System.out.println(name);

        System.out.println("------------------------------");
        Thread.sleep(3000);
        String screenShotLocation = "/Users/malam2/Desktop/WEB2/Application/src/test/testResult/Screenshot/";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = dateFormat.format(date); //2016/11/16 12:08:43
        System.out.println("---------------------"+currentTime);

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenShotLocation + testCaseName + "_" +currentTime + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

}