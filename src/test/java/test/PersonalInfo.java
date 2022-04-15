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


public class PersonalInfo extends TestUtil {
    @Test
    public void PersonalInfo () {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
        CartPage cartPage = productsPage.nextStep();
        CheckoutYourInformation checkoutYourInformation = cartPage.Checkout();
       checkoutYourInformation.proceed();

        WebElement view = driver.findElement(By.xpath("//*[text()='DESCRIPTION']"));
        Assert.assertTrue(view.isDisplayed(), "This shall be visible after successfull login");



    }
}
