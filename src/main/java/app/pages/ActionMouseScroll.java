package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionMouseScroll {

    By locator = By.xpath("//*[@data-id-product=\"1\"]");
    By locateClick = By.className("quick-view");
    By select = By.id("group_1");
    By select2 = By.xpath("//*[@id=\"group_1\"]/option[3]");


    public void getUrl(String url){
        DriverManager.getDriver().get(url);
    }


    public void moveMause() throws InterruptedException {
    //scroll and wait webelemet presenceOfElementLocated
        WebElement webElement = DriverManager.getDriver().findElement(locator);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 5);
        WebElement elem_gplay_btn = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem_gplay_btn);

        // simulate mouse movement and Expected Conditions presence Of Element Located
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(webElement).perform();
        DriverManager.getDriver().findElement(locateClick).click();

        WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(), 5);

        WebElement s = wait1.until(ExpectedConditions.presenceOfElementLocated(select));
        s.click();

        DriverManager.getDriver().findElement(select2).click();


    }
    //get text assert
    public    String assertOption(){
       return Methods.getText(select2);
    }
}
