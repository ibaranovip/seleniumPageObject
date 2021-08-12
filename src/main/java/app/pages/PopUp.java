package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class PopUp {

       public void getUrl(String url){
           DriverManager.getDriver().get(url);
       }

        public void  PopupMenu () {
            String parentWindowHandler = DriverManager.getDriver().getWindowHandle(); // Store parent window
            String newWindow = null;
            Set<String> handles = DriverManager.getDriver().getWindowHandles();
            Iterator<String> iter = handles.iterator();

            while (iter.hasNext()) {    //switch next windows

                newWindow = iter.next();
                if (!parentWindowHandler.equals(newWindow)) {
                    DriverManager.getDriver().switchTo().window(newWindow);
                }
            }

            WebElement js = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"fsFormInfo\"]/div/div/div[2]/div/p[3]/a"));

            //method from class Methods execute Javascript

            Methods.executarJavascript("arguments[0].click();",js);

            WebElement js1 = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"fsFormSelectCity\"]/div/div/div[2]/div[3]/a[35]"));

            //find and wait weblemen To Be Clickable, scroll and click
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 2);
            wait.until(ExpectedConditions.elementToBeClickable(js1));
            ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",js1);
            js1.click();
            //
            WebElement js2 = DriverManager.getDriver().findElement(By.xpath("//*[@id=\"fsFormSelectTradePoint\"]/div[1]/div/div[2]/div[4]/a[19]"));
            WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(),2);
            wait.until(ExpectedConditions.elementToBeClickable(js2));
            ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();",js2);
            js2.click();


            DriverManager.getDriver().switchTo().window(parentWindowHandler);

        }

    }
