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

public class WrongTests extends TestUtil {

    @DataProvider(name = "csv.wrong.users")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/csv.wrong.users");
    }
    @Test(dataProvider = "csv.wrong.users" )
    public void WrongTests(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(userName, password);

        WebElement errorLoginLabel = driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']"));

        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }




}






