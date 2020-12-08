package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver browserDriver) {
        driver = browserDriver;

    }
    public List<WebElement> getProductNameLinks(){
        List<WebElement> productLinks =  driver.findElements(By.className("inventory_item_name"));
        return productLinks;
    }
    public List<WebElement> getProductImageLinks(){
        List<WebElement> productLinks =  driver.findElements(By.className("inventory_item_img"));
        return productLinks;
    }



    public InventoryPage listItems(){

        WebElement sortContainer= driver.findElement(By.className("product_sort_container"));
        sortContainer.click();
        List<WebElement> options=sortContainer.findElements(By.tagName("option"));
        options.get(2).click();


        return this;

    }
    public boolean isListed(){
        List<WebElement> prices=driver.findElements(By.className("inventory_item_price"));
        for(int i=0;i<prices.size()-1;i++){
            double a=Double.parseDouble(prices.get(i).getText().substring(1));
            double b=Double.parseDouble(prices.get(i+1).getText().substring(1));

            if(a>b) return false;

        }
        return true;
    }

}
