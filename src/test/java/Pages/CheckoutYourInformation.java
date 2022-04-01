package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;


public class CheckoutYourInformation {

    protected WebDriver driver;

    @FindBy(name = "firstName" )
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement submitBtn;

    public CheckoutYourInformation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CheckoutOverview proceed() {
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2)) //how often it will be checked for the presence of the element
                .ignoreAll(Collections.singleton(NoSuchElementException.class));

        firstName.clear();
        firstName.sendKeys("Secret");


        lastName.clear();
        lastName.sendKeys("Secret");


        postalCode.clear();
        postalCode.sendKeys("1000");



        submitBtn.click();

        return new CheckoutOverview(driver);
    }


}

