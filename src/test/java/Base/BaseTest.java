package Base;

import Pages.HomepagePage;
import Pages.LogoutPage;
import Pages.PracticePage;
import Pages.TestLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomepagePage homepagePage;
    public TestLoginPage testLoginPage;
    public PracticePage practicePage;
    public LogoutPage logoutPage;
    public ExcelReader excelReader;
    public String homePageURL;


    @BeforeClass
    public void setUp () throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepagePage = new HomepagePage(driver, wdwait);
        testLoginPage = new TestLoginPage(driver, wdwait);
        practicePage = new PracticePage(driver, wdwait);
        logoutPage = new LogoutPage(driver, wdwait);
        excelReader = new ExcelReader("C:\\Users\\aleksandar.vuksanovi\\OneDrive - Smart kolektiv\\Documents\\Aleksandar\\Aleksandar\\IT Bootcamp\\Kurs\\Selenium\\Test Data.xlsx");
        homePageURL = excelReader.getStringData("URLs", 1, 0);
    }

    public void visibilityWait (WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickabilityWait (WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollIntoView (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @AfterClass
    public void tearDown () {
        //driver.close();
        //driver.quit();

    }

}
