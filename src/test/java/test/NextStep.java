package test;

import Pages.*;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class NextStep extends TestUtil {
    @Test
    public void NextStep() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
        CartPage cartPage = productsPage.nextStep();
        CheckoutYourInformation checkoutYourInformation = cartPage.Checkout();
        CheckoutOverview checkoutOverview = checkoutYourInformation.proceed();
        checkoutOverview.Finish();

        WebElement view = driver.findElement(By.xpath("//*[@id='checkout_complete_container']"));

        Assert.assertTrue(view.isDisplayed(), "This shall be visible after successfull proceed page");

    }
}
