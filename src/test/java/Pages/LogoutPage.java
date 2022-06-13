package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement logoutButton;

    WebElement message;

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
    }

    public WebElement getMessage() {
        return driver.findElement(By.className("post-title"));
    }

    //--------------------

    public void clickOnLogoutButton () {
        this.getLogoutButton().click();
    }
}
