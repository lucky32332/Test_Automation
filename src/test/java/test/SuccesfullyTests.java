package test;


import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvHelper;

import java.io.IOException;

public class SuccesfullyTests extends TestUtil {

    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/users.csv");
    }

    @Test(dataProvider = "csvUserList")
    public void SuccessfulLogin(String userName, String password) {


        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        WebElement userAllPagesButton = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(userAllPagesButton.isDisplayed(), "This shall be visible after successfull login");

    }
}


