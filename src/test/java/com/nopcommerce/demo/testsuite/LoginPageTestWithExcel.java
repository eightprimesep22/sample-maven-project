package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.excelutility.ExcelUtility;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
public class LoginPageTestWithExcel extends BaseTest {

    public static final String FILE_PATH = System.getProperty("user.dir")+"/src/test/java/resources/testdata/ExcelData.xlsx";
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void setExcel(){
        // Tell the code about the location of Excel file
        try {
            ExcelUtility.setExcelFile(FILE_PATH, "LoginTests");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData(){
        return ExcelUtility.getTestData("Invalid_Login");
    }


    @Test(dataProvider = "dataFromExcel")
    public void doLogin(String username, String password){
        homePage.clickOnLoginLink();
        loginPage.loginToApplication(username, password);
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(actualMessage, "Login page not displayed");
    }

}
