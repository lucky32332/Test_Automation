package test;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestProblemUser extends TestUtil {


    @Test
    public void TestProblemUser() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("problem_user", "secret_sauce");
        productsPage.addItemToTheCart("bike-light");


        Assert.assertEquals(productsPage.getItemsInTheCart(), 1, "Because we have only one item so far");

        productsPage.removeItemFromTheCart("bike-light");

        //Soft Assert
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(productsPage.getItemsInTheCart(), 0, "Because we have only one item so far");
        System.out.println("I will be executed");

        //for example at the end of the test
        softAssert.assertAll(); // now all asserts





    }
}


