package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class CheckOutStepOnePage {
    WebDriver driver;
    private By firstNameLocator = By.id("first-name");
    private By lastNameLocator = By.id("last-name");
    private By postalCodeLocator = By.id("postal-code");

    public CheckOutStepOnePage(WebDriver driver){

        this.driver=driver;
    }

    private CheckOutStepOnePage setFirstName (String firstName){
        WebElement firstNameTextBox = driver.findElement(firstNameLocator);
        firstNameTextBox.sendKeys(firstName);
        return this;
    }
    private CheckOutStepOnePage setLastName (String lastName){
        WebElement lastNameTextBox = driver.findElement(lastNameLocator);
        lastNameTextBox.sendKeys(lastName);
        return this;
    }
    private CheckOutStepOnePage setPostalCode(String postalCode){
        WebElement postalCodeTextBox=driver.findElement(postalCodeLocator);
        postalCodeTextBox.sendKeys(postalCode);
        return this;

    }

    public void continueTo(String firstName,String lastName, String postalCode){
        WebElement contunieButton=driver.findElement(By.xpath("//*[contains(@class,'btn_primary cart_button')]"));
        setFirstName(firstName);
        setLastName(lastName);
        setPostalCode(postalCode);
        contunieButton.click();


    }

}
