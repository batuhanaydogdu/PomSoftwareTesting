package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage{

    private By userNameLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");

    public LogInPage (WebDriver browserDriver){
        super(browserDriver);
    }
    public void setUserName (String userName){
        WebElement userNameTextBox = driver.findElement(userNameLocator);
        userNameTextBox.sendKeys(userName);
    }
    public void setPasswd (String passwrd){
        WebElement passwordTextBox = driver.findElement(passwordLocator);
        passwordTextBox.sendKeys(passwrd);
    }
    public void clickLogInButton (){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
}
