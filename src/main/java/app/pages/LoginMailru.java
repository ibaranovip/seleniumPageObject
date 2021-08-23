package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import org.openqa.selenium.By;

import static app.util.Methods.getText;

public class LoginMailru {
    By fieldName = By.xpath("//input[@name='login']");
    By buttonSetPassword = By.xpath("//button[@class='button svelte-1eyrl7y']");
    By fieldPasword = By.xpath("//input[@name='password']");
    By buttonPasswordEnter = By.xpath("//button[@class='second-button svelte-1eyrl7y']");
    By itemSelect = By.xpath("//select[@name='domain']");
    By assertLogin = By.xpath("//div[@class='ph-project ph-project__account svelte-a0l97g']");


    public void getUrl(String url){
        DriverManager.getDriver().get(url);
    }

    public  void    login (String userName, String password) {
        DriverManager.getDriver().findElement(fieldName).sendKeys(userName);
        Methods.SelectEtem(itemSelect, "@inbox.ru");
        DriverManager.getDriver().findElement(buttonSetPassword).click();
        DriverManager.getDriver().findElement(fieldPasword).sendKeys(password);
        DriverManager.getDriver().findElement(buttonPasswordEnter).click();
    }
    public String getAssert(){
        return getText(assertLogin);
    }

}
