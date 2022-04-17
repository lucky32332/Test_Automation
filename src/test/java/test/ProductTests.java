package test;

import Pages.LoginPage;
import Pages.ProductsPage;
import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductTests extends TestUtil {


    @Test

    public void addItemToTheCart() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("onesie");
        productsPage.nextStep();




        //Hard Assert
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1, "Because we have only one item so far");

        WebElement itemView = driver.findElement(By.xpath("//*[contains(@class,'inventory_item_name')][1]"));
        Assert.assertTrue(itemView.isDisplayed(), "This shall be visible after add product");



    }
}

