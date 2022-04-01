package test;

import Pages.CartPage;
import Pages.CheckoutYourInformation;
import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentPage extends TestUtil {
    @Test
    public void PaymentPage () {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
        CartPage cartPage = productsPage.login();
        CheckoutYourInformation checkoutYourInformation = cartPage.Checkout();
       checkoutYourInformation.proceed();

        WebElement view = driver.findElement(By.xpath("//*[text()='DESCRIPTION']"));
        Assert.assertTrue(view.isDisplayed(), "This shall be visible after successfull login");



    }
}
