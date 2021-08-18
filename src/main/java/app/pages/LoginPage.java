package app.pages;

import app.browser.DriverManager;
import static app.util.Methods.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage  {


    private By link = By.linkText("Form Authentication");
    private By fieldLogin = By.id("username");
    private By fieldPassw = By.id("password");
    private By buttonLogin = By.className("radius");
    private By assertLogin = By.id("flash");


    public LoginPage returnPage(){
        DriverManager.getDriver().findElement(link).click();
        return new LoginPage();
    }

    public  void    login (String userName, String Password) {
        DriverManager.getDriver().findElement(fieldLogin).sendKeys(userName);
        DriverManager.getDriver().findElement(fieldPassw).sendKeys(Password);
       DriverManager.getDriver().findElement(buttonLogin).click();
          }
    public String getAssert(){
       return getText(assertLogin);
    }





}




