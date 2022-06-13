package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement practiceButton;

    public HomepagePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getPracticeButton() {
        return driver.findElement(By.id("menu-item-20"));
    }

    //--------------------------------------------------------

    public void clickOnPracticeButton () {
        this.getPracticeButton().click();
    }


}
