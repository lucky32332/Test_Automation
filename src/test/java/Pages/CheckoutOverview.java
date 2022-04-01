package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;




public class CheckoutOverview {
    protected WebDriver driver;

    @FindBy(css = "[id=finish]")
    private WebElement submitBtn;



    public CheckoutOverview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public EndCheckout Finish() {

        //fluent wait
        FluentWait fluentWait = new FluentWait(driver);

        fluentWait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();


        return new EndCheckout(driver);
    }
}
