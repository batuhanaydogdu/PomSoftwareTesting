package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    public void checkout(){
        WebElement checkoutButton=driver.findElement(By.xpath("//*[contains(@class,'btn_action checkout_button')]"));
        checkoutButton.click();
    }

}
