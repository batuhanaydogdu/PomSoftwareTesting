package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SauceDemoPOMAdvancedTest {
    WebDriver driver;
    WebDriverWait wait;
   // private String user = "standard_user";
    //private String passwd= "secret_sauce";

    @Test(dataProviderClass = DataDrivenSignIn.class,dataProvider = "SignIn_Provider")
    public void SauceDemoAddCartAdvanced(String user, String passwd) throws Exception {
        System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/index.html");

        // login
        LogInPage3 logInPage = new LogInPage3(driver);
        logInPage.logIn(user,passwd);


        //list low to high  price
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.listItems();
        boolean forAssertion=inventoryPage.isListed();  //check for listed or not
        Assert.assertEquals(forAssertion,true);   //check ?1:0




        // select first product

        List<WebElement> products = inventoryPage.getProductNameLinks();
        products.get(0).click();

        // add item to the Cart
        InventoryItemPage inventoryItemPage = new InventoryItemPage(driver);
        inventoryItemPage.addtoCartButtonClick();

        //go back and add first item
        List<WebElement> productsAfterAdding=inventoryItemPage.goBackInventoryPage().getProductImageLinks();
        productsAfterAdding.get(0).click();
        inventoryItemPage.addtoCartButtonClick();

        // go and check Shopping Cart
        // check if 2 item on the list
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.getClass();
        int numberofProducts = shoppingCartPage.getNumberofItems();
        Assert.assertEquals(numberofProducts,2);

        //checkout
        CartPage cartPage=new CartPage(driver);
        cartPage.checkout();

        //continue checkout
        CheckOutStepOnePage cosop=new CheckOutStepOnePage(driver);
        cosop.continueTo("neler","oluyo","postalcodede");


        CheckOutStepTwoPage costp=new CheckOutStepTwoPage(driver);
        costp.clickFinish();


        // logout
        MenuPage menuPage = new MenuPage(driver);
        menuPage.logOut();

    }
    public static void main(String args[]) throws Exception {
      //  SauceDemoPOMAdvancedTest test = new SauceDemoPOMAdvancedTest();
       // test.SauceDemoAddCartAdvanced();
    }

}


