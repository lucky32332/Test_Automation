package test;


import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductsFromCart extends TestUtil {
    @Test
    public void BuyProductsFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
       CartPage cartPage = productsPage.nextStep();
       cartPage.Checkout();


        Assert.assertEquals(productsPage.getItemsInTheCart(), 1, "Because we have only one item so far");

        WebElement visual = driver.findElement(By.id("checkout_info_container"));

        Assert.assertTrue(visual.isDisplayed(), "This shall be visible after successfull proceed page");


    }
}
