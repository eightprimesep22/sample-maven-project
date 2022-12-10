package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/**
 * Created by Jay Vaghani
 */
public class LoginPageTestWithDataProvider extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();


    @Test(dataProvider = "credentials", dataProviderClass = TestData.class)
    public void doLogin(String username, String password, String error){
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(username, password);
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(error, actualMessage, "Login page not displayed");
    }

}
