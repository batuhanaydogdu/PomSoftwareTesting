package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage2 extends BasePage{

    private By userNameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");

    public LogInPage2 (WebDriver browserDriver){
        super(browserDriver);
    }
    public LogInPage2 setUserName (String userName){
        WebElement userNameTextBox = driver.findElement(userNameLocator);
        userNameTextBox.sendKeys(userName);
        return this;
    }
    public LogInPage2 setPasswd (String passwrd){
        WebElement passwordTextBox = driver.findElement(passwordLocator);
        passwordTextBox.sendKeys(passwrd);
        return this;
    }
    public InventoryPage clickLogInButton (){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        return new InventoryPage(driver);
    }
}
