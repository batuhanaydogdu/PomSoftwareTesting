package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoPOMTest {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void SauceDemoAddCart() {
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");

        // login
       /* LogInPage logInPage = new  LogInPage(driver);
        logInPage.setUserName("standard_user");
        logInPage.setPasswd("secret_sauce");
        logInPage.clickLogInButton();*/
        LogInPage2 logInPage = new  LogInPage2(driver);
        List<WebElement> products = logInPage.setUserName("standard_user")
                .setPasswd("secret_sauce").clickLogInButton().getProductNameLinks();

        // select first product
        //InventoryPage inventoryPage = new InventoryPage(driver);
        //List <WebElement> products = inventoryPage.getProductNameLinks();
        products.get(0).click();

        // add item to the Cart
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
        inventoryItemPage.addtoCartButtonClick();

        // go and check Shopping Cart
        // check if 1 item on the list
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getClass();
        int numberofProducts = shoppingCartPage.getNumberofItems();
        Assert.assertEquals(numberofProducts,1);

        // logout
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();

    }
    public static void main(String args[]){
        SauceDemoPOMTest test = new SauceDemoPOMTest();
        test.SauceDemoAddCart();
    }

}
