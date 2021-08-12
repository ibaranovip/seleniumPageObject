package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddRemove {

    private By linkRemoveAddPage = By.xpath("//a[@href='/add_remove_elements/']");
    private By buttonAddElem = By.xpath("//button[.='Add Element']");
    private  By buttonDelite = By.xpath("//button[@class='added-manually']");
    @Step
    public AddRemove returnPage(){
        Methods.click(linkRemoveAddPage);
        return new AddRemove();
    }
    @Step
    public boolean isElementPresentAdd1(){
        DriverManager.getDriver().findElement(buttonAddElem).click();
      //return true or .....
    return Methods.isPresent(Methods.findWebElement(buttonDelite));}


}
