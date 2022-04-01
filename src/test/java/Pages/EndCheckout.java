package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EndCheckout{

    protected WebDriver driver;


    @FindBy(id = "back-to-products")
   public WebElement backBtn;


    public EndCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage Checkout() {


        backBtn.click();

        return new ProductsPage(driver);
    }
    }




