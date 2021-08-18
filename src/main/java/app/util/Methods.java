package app.util;

import app.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static app.browser.DriverManager.getDriver;

public class Methods {
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void selectDate(String date, By locator, By tagName ){  //Here any date you can give
        WebElement eval=DriverManager.getDriver().findElement(locator);
        List<WebElement> alldates = eval.findElements(By.tagName("td"));
        for(WebElement cell:alldates){
            String day=cell.getText();
            if (day.equals(date)) {
                cell.click();
                break;
            }
        }
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWebElement(By element){
       WebElement webElement = DriverManager.getDriver().findElement(element);
       webElement.click();
    }
    public static void clickJavaScript(By element){
        WebElement webElement = DriverManager.getDriver().findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",webElement);
    }
    public static void clickJavaScriptWebElem(WebElement webElement){
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",webElement);
    }
    public static void clickPerfomance(By locator){


    }
    public static WebElement waitForClickablility(By element, int timeout) {
        WebElement webElement = DriverManager.getDriver().findElement(element);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static Object executarJavascript(String cmd, Object... params) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        return js.executeScript(cmd, params);
    }
    public static WebElement findWebElement(By element){
       return DriverManager.getDriver().findElement(element);
    }

    //scrollIntoView
    public static WebElement scrollIntoView(WebElement element) {
        return (WebElement) ((JavascriptExecutor) DriverManager.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", element);}





    public static boolean presenceOfElement(WebElement element, int timeout) {
        Boolean result = getValueFromWebElement(element).isEmpty();

        return  result;

    }


    public static void click(By element){
        DriverManager.getDriver().findElement(element).click();
    }
    public static String getText(By element){
       return DriverManager.getDriver().findElement(element).getText();
    }

    public static void sendElement(By element, String send){
        DriverManager.getDriver().findElement(element).sendKeys(send);
    }




        public static Boolean isPresent(WebElement element) {

            switch (getLocatorFromWebElement(element)) {
                case "id":
                    return DriverManager.getDriver().findElements(By.id(getValueFromWebElement(element))).size() > 0;
                case "className":
                    return DriverManager.getDriver().findElements(By.className(getValueFromWebElement(element))).size() > 0;
                case "tagName":
                    return DriverManager.getDriver().findElements(By.tagName(getValueFromWebElement(element))).size() > 0;
                case "xpath":
                    return DriverManager.getDriver().findElements(By.xpath(getValueFromWebElement(element))).size() > 0;
                case "cssSelector":
                    return DriverManager.getDriver().findElements(By.cssSelector(getValueFromWebElement(element))).size() > 0;
                case "linkText":
                    return DriverManager.getDriver().findElements(By.linkText(getValueFromWebElement(element))).size() > 0;
                case "name":
                    return DriverManager.getDriver().findElements(By.name(getValueFromWebElement(element))).size() > 0;
                case "partialLinkText":
                    return DriverManager.getDriver().findElements(By.partialLinkText(getValueFromWebElement(element))).size() > 0;
                default:
                    throw new IllegalStateException("locator : " + getLocatorFromWebElement(element) + " not found!!!");
            }

        }

        public static String getLocatorFromWebElement(WebElement element) {
            String[] content = element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "").trim().split(": ");
            return content[0];
        }

        public static String getValueFromWebElement(WebElement element) {
            String[] content = element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "").trim().split(": ");
            return content[1];
        }

    public static void  PopupMenu () {
        String parentWindowHandler = DriverManager.getDriver().getWindowHandle(); // Store parent window
        String newWindow = null;
        Set<String> handles = DriverManager.getDriver().getWindowHandles();
        Iterator<String> iter = handles.iterator();

        while (iter.hasNext()) {    //switch next windows

            newWindow = iter.next();
            if (!parentWindowHandler.equals(newWindow)) {
                DriverManager.getDriver().switchTo().window(newWindow);} }
        DriverManager.getDriver().switchTo().window(parentWindowHandler);
    }
}
