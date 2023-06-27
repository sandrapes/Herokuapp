package Herokuapp.Tests;

import Herokuapp.Base.BaseTest;
import Herokuapp.Pages.HomepagePage;
import Herokuapp.Pages.LoginPage;
import Herokuapp.Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public ProfilePage profilePage;

    @BeforeMethod
    public void pageSetUp() {
        driver.get(homeURL);
        homepagePage = new HomepagePage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

    }

    @Test
    public void test() {
        homepagePage.clickOnFormAuthentication();
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        loginPage.inputUserame(validUsername);
        loginPage.inputPassword(validPassword);
        loginPage.clickOnLogInButton();
        Assert.assertTrue(elementIsPresent(profilePage.success));
        Assert.assertTrue(elementIsPresent(profilePage.logOutButton));
    }

    @Test
    public void test2() {
        homepagePage.clickOnFormAuthentication();
        String validPassword = excelReader.getStringData("Login", 1, 1);
        String loginURL = excelReader.getStringData("URL", 1, 1);

        for (int i = 0; i < excelReader.getLastRow("Login"); i++) {
            loginPage.inputUserame((excelReader.getStringData("Login", i, 2)));
            loginPage.inputPassword(validPassword);
            loginPage.clickOnLogInButton();
            Assert.assertTrue(loginPage.message.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), loginURL);

        }



    }




    @AfterMethod
    public void pageTearDown() {
        driver.manage().deleteAllCookies();
    }


}
