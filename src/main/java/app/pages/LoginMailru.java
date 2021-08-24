package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

import static app.util.Methods.getText;

public class LoginMailru {
    private By fieldName = By.xpath("//input[@name='login']");
    private By buttonSetPassword = By.xpath("//button[@class='button svelte-1eyrl7y']");
    private By fieldPasword = By.xpath("//input[@name='password']");
    private By buttonPasswordEnter = By.xpath("//button[@class='second-button svelte-1eyrl7y']");
    private By itemSelect = By.xpath("//select[@name='domain']");
    private By assertLogin = By.xpath("//div[@class='ph-project ph-project__account svelte-a0l97g']");
    private By button_compose = By.xpath("//a[@class='compose-button compose-button_white compose-button_base compose-button_with-dropdown js-shortcut']");
    private By fieldTo = By.xpath("//input[@class = 'container--H9L5q size_s--3_M-_']");
    private By fieldSubjectLetter = By.cssSelector("div.container--3QXHv > div > input");
    private By fieldTextInput = By.xpath("//div[@role='textbox']/div[1]");
    private  By buttonSendLetter = By.xpath("//span[contains(text(),'Отправить')]");




    public void getUrl(String url){
        DriverManager.getDriver().get(url);
    }

    public  void    login (String userName, String password) {
        DriverManager.getDriver().findElement(fieldName).sendKeys(userName);
        Methods.SelectEtem(itemSelect, "@mail.ru");
        DriverManager.getDriver().findElement(buttonSetPassword).click();
        DriverManager.getDriver().findElement(fieldPasword).sendKeys(password);
        DriverManager.getDriver().findElement(buttonPasswordEnter).click();
    }
    public void compose(String to, String desc, String text){
        Methods.PopupMenu();
        Methods.waitFor(5);
        Methods.waitForClickablility(button_compose,5);
        Methods.clickWebElement(button_compose);
        Methods.click(button_compose);

   

        DriverManager.getDriver().findElement(fieldTo).sendKeys(to);
        DriverManager.getDriver().findElement(fieldSubjectLetter).sendKeys(desc);
        DriverManager.getDriver().findElement(fieldTextInput).sendKeys(text);
        DriverManager.getDriver().findElement(buttonSendLetter).click();
    }
    public String getAssert(){
        return getText(assertLogin);
    }

}
