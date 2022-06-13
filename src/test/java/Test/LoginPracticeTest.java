package Test;

import Base.BaseTest;
import Pages.HomepagePage;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPracticeTest extends BaseTest {



    @BeforeMethod
    public void pageSetUp () {
        driver.manage().window().maximize();
        driver.navigate().to(homePageURL);

    }

    @Test (priority = 10)
    public void sucessfulLogin () {
        String validUsername = excelReader.getStringData("Login",1,0);
        String validPassword = excelReader.getStringData("Login",1,1);
        String invalidUsername = "invalid username";
        String invalidPassword = "invalid password";

        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.insertUsername(validUsername);
        testLoginPage.insertPassword(validPassword);
        testLoginPage.clickOnSubmitButton();
        visibilityWait(logoutPage.getLogoutButton());
        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());
        Assert.assertTrue(logoutPage.getMessage().isDisplayed());
    }

    @Test (priority = 20)
    public void invalidUsername () {
        String validUsername = excelReader.getStringData("Login",1,0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        String invalidUsername = "invalid username";
        String invalidPassword = "invalid password";

        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.insertUsername(invalidUsername);
        testLoginPage.insertPassword(validPassword);
        testLoginPage.clickOnSubmitButton();
        visibilityWait(testLoginPage.getErrorNotification());
        Assert.assertTrue(testLoginPage.getErrorNotification().isDisplayed());

        boolean check = false;
        try  {
            check = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();

        } catch (Exception e) {
        }
        Assert.assertFalse(check);

    }

    @Test (priority = 30)
    public void invalidPassword () {
        String validUsername = excelReader.getStringData("Login",1,1);
        String validPassword = "Password123";
        String invalidUsername = "invalid username";
        String invalidPassword = "invalid password";

        homepagePage.clickOnPracticeButton();
        practicePage.clickOnTestLoginPageButton();
        testLoginPage.insertUsername(validUsername);
        testLoginPage.insertPassword(invalidPassword);
        testLoginPage.clickOnSubmitButton();
        visibilityWait(testLoginPage.getErrorNotification());
        Assert.assertTrue(testLoginPage.getErrorNotification().isDisplayed());

        boolean check = false;
        try {
            check = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(check);
    }

}
