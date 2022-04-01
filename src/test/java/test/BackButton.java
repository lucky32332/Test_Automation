package test;

import Pages.*;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BackButton extends TestUtil {
    @Test
    public void BackButton() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
        CartPage cartPage = productsPage.login();
        CheckoutYourInformation checkoutYourInformation = cartPage.Checkout();
        CheckoutOverview checkoutOverview = checkoutYourInformation.proceed();
        EndCheckout endCheckout = checkoutOverview.Finish();
        endCheckout.Checkout();

        WebElement visual = driver.findElement(By.className("shopping_cart_link") );

        Assert.assertTrue(visual.isDisplayed(), "This shall be visible after successfull proceed page");


    }
}
