package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement testLoginPageButton;

    public PracticePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTestLoginPageButton() {
        return driver.findElement(By.linkText("Test Login Page"));
    }


    //----------------------------------------------------

    public void clickOnTestLoginPageButton () {
        this.getTestLoginPageButton().click();

    }

}
