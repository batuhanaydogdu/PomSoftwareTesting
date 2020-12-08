package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage {
    WebDriver driver;

    public InventoryItemPage(WebDriver browserDriver) {
        driver = browserDriver;

    }
    public void addtoCartButtonClick (){
        WebElement addtToCartButton =  driver.findElement(By.xpath("//*[contains(@class,'btn_primary btn_inventory')]"));
        addtToCartButton.click();
    }

    public InventoryPage goBackInventoryPage(){
        WebElement gobackButton=driver.findElement(By.className("inventory_details_back_button"));
        gobackButton.click();
        return new InventoryPage(driver);

    }

}
