package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
    protected WebDriver driver;

    @FindBy(css = "[id=checkout]")
    private WebElement btnCart;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public CheckoutYourInformation Checkout() {


        btnCart.click();

        return new CheckoutYourInformation(driver);
    }


}


