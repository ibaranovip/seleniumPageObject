package app.util;

import app.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static app.browser.DriverManager.getDriver;

public class Methods {
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
}
