package app.util;

import app.browser.DriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.xml.datatype.DatatypeConstants;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static app.browser.DriverManager.getDriver;
import static org.apache.commons.lang3.StringUtils.split;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Methods {

    public static void NewTab(){

    }
    public static String createGuid(By guideNumber) {
        Map<String, String> guideMap = new HashMap<>();

        String guide1 = Methods.getText(guideNumber);
        String split[] = StringUtils.split(guide1, "Номер заявки \\");
        String part1 = split[0];


        guideMap.put("guide1",  part1);
        String giudeNum = guideMap.get("guide1");



        return giudeNum;
    }
    public static void inputGuid(By locator, String guid){

        WebElement element= DriverManager.getDriver().findElement(locator);
        Methods.executarJavascript("arguments[0].click();", element);

        // enter city departure and get all city
        element.sendKeys(guid);}

    public static WebDriver newDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("START_MAXIMIZED");
        options.addArguments("incognito");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(cap);

        return driver;}


    public static void openNewTabJS(){
       //"url": url, focused: true,  'incognito': true
       // ((JavascriptExecutor)DriverManager.getDriver()).executeScript("window.open('https://test-admin.za-prosto.ru', '_blank');");"_self"
        ((JavascriptExecutor)DriverManager.getDriver()).executeScript("window.open(arguments[0])");
    }

    public static void newTab( ){


        Actions action = new Actions(DriverManager.getDriver());

        action.keyDown(Keys.CONTROL).sendKeys("n").build().perform();//it is work!!!

    }

    public static void newTab1( ){
        Actions action = new TouchActions(DriverManager.getDriver());
        action.keyDown(Keys.CONTROL).sendKeys("n").build().perform();//it is work!!!

    }








    /*
    * type keys
    * element_enter.sendKeys(Keys.RETURN)*/
  /*  String myText = "first line\nsecond line";
    myText = myText.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
myElement.sendKeys(myText);*/
    /*
    https://www.selenium.dev/documentation/webdriver/keyboard/
    * search webelement
    * perform click javaScript
    * send keys*/
    public static void doubleClick(By locator){

        Actions act = new Actions(DriverManager.getDriver());

//Double click on element
        WebElement ele = DriverManager.getDriver().findElement(locator);
        act.doubleClick(ele).perform();
    }

    public static void sendElemJsclick(By locator, String text) {

        WebElement eval = DriverManager.getDriver().findElement(locator);
        Methods.executarJavascript("arguments[0].click();", eval);
        // enter Keys.HOME - return in начало строки
        eval.sendKeys(Keys.HOME + text);

    }

   public static void sendKeysShift(By locator, String text) {


                Actions action = new Actions(DriverManager.getDriver());

            // Store google search box WebElement
            WebElement search = DriverManager.getDriver().findElement(locator);

            // Enters text "qwerty" with keyDown SHIFT key and after keyUp SHIFT key (QWERTYqwerty)
            action.keyDown(Keys.SHIFT).sendKeys(search,text).perform();
        }
    public static void sendKeysShiftNull(By locator) {


        Actions action = new Actions(DriverManager.getDriver());

        // Store google search box WebElement
        WebElement search = DriverManager.getDriver().findElement(locator);


        // Enters text "qwerty" with keyDown SHIFT key and after keyUp SHIFT key (QWERTYqwerty)
       search.sendKeys(Keys.TAB);
    }





    public static void sendElementWebElement(By locator, String text){
        WebElement searchElement = DriverManager.getDriver().findElement(locator);
        //standard sendkeys
        searchElement.sendKeys(text);
        searchElement.clear();
    }


   public static void sendElementActions(By locator, String text){
        WebElement elementAction = DriverManager.getDriver().findElement(locator);
       Actions action = new Actions(DriverManager.getDriver());
       action.moveToElement(elementAction).click().sendKeys(text).build().perform();
   }


    //use javascript, number is entered
    public static void sendElementJs(By locator, String value){

        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].value = \" + value + \";", locator);
    }


    public static void selectEtem(By locator, String option){
        WebElement webElement = DriverManager.getDriver().findElement(locator);
        Select select = new Select(webElement);
        select.selectByVisibleText(option); //selectBy - VisibleText!!!!!
    }


    public static WebElement waitpresenceOfElementLocated(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForClickablilitylocator(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithJSelementscroll(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(6));
        WebElement elem_gplay_btn = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem_gplay_btn);
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", elem_gplay_btn);
    }
/*
* метод выбирет модель телефона*/
     public static void waitForelementToBeClickable(By locator, int timeout) {
         try {WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    WebElement element = DriverManager.getDriver().findElement(locator);
        element.sendKeys(Keys.CONTROL);//highlight text - highlight text  выделить нименовние чтобы н нем сфокусировть
        element.click();
    } catch (TimeoutException e) {
             System.err.println("waitForelementToBeClickable isn't present!!");}}

    public static  String getAlert(By locator)  {
          String ak = null;



        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(18)); // seconds
             ak = wait.until(ExpectedConditions.visibilityOfElementLocated (locator)).getText();


        }catch (UnhandledAlertException e){


        }


   return getText(locator); }

    public static void getUrl(String url){
        DriverManager.getDriver().get(url);
    }


    public static String isAlertPresent(By locator, int timeout){
        try {
            Alert a = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(alertIsPresent());


        }
        catch (TimeoutException e) {
            System.err.println("Alert isn't present!!");
                        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = getDriver().switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }


        }
            return getText(locator);

    }

    public static  String isDialogPresent(int timeout) throws TimeoutException {
        String ar = null;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));


            Alert alert = wait.until(alertIsPresent());
            ar = alert.getText();

        } catch (NoAlertPresentException ex) {
            System.out.println("Alert is NOT Displayed");



        }

           return ar;}



    public static Object waitForVisibilityLocator(By locator, int timeout) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
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




    public static void clickWebElement(By element){
       WebElement webElement = DriverManager.getDriver().findElement(element);
       webElement.click();
    }
    public static void clickJavaScript(By element){
        WebElement webElement = DriverManager.getDriver().findElement(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",webElement);
    }
    public static void clickJavaScriptLocator (By locator){
        Methods.executarJavascript("arguments[0].click();", locator);
    }
    public static void clickPerfomance(By locator){


    }
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebElement webElement = DriverManager.getDriver().findElement(locator);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    /////////

    ///


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

    public static void sendElement(By locator, String send){
        WebElement webElement =DriverManager.getDriver().findElement(locator);
        webElement.sendKeys(send);

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

     /*
     * Window Handle
     * */

    public static String switchTab(){
        String parentHandle = "";
        String currentHandle ="";
        Set<String> win  = DriverManager.getDriver().getWindowHandles();

        Iterator<String> it =  win.iterator();
        if(win.size() > 1){
            while(it.hasNext()){
                String handle = it.next();
                if (!handle.equalsIgnoreCase(parentHandle)){
                    DriverManager.getDriver().switchTo().window(handle);
                    currentHandle = handle;
                }
            }
        }
        else{
            System.out.println("Unable to switch");
        }
        return currentHandle;
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

    public static void IteratorIterator(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://mail.google.com/");
        String firstWindowHandle = driver.getWindowHandle();
        System.out.println("First Window Handle is: "+firstWindowHandle);
        // Opening an adjacent blank tab
        ((JavascriptExecutor)driver).executeScript("window.open('','_blank');");
        new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandles = driver.getWindowHandles();
        // Using iterator
        Iterator<String> itr = allWindowHandles.iterator();
        while(itr.hasNext()) {
            String nextWindow = itr.next();
            if(!firstWindowHandle.equalsIgnoreCase(nextWindow)) {
                driver.switchTo().window(nextWindow);
                System.out.println("New Tab Window Handle is: "+nextWindow);
                //https://question-it.com/questions/1735562/kak-otkryt-ssylku-v-novoj-vkladke-hrom-s-pomoschju-selenium-webdriver
            }
        }
    }
    /*
    * DOWNLOAD
    * */
    public static void isFileDownloaded(String fileDownloadpath, String fileName) throws Exception {

        Path path = FileSystems.getDefault().getPath(fileDownloadpath);

        if (Files.exists(path) && Files.isDirectory(path)) {
            int maxDeptch = 1;
            try (Stream<Path> streamDirv = Files.find(path, maxDeptch, (p, a) -> String.valueOf(p).endsWith(fileName))) {
                Long counter = streamDirv
                        .map(String::valueOf)
                        .peek(System.out::println)
                        .count();
                System.out.println("Found:  " + counter);
                try {
                    File file = new File(fileDownloadpath, fileName);
                    file.delete(); //удаление  файла перед последующим запуском test
                    System.out.println(fileName+" delited");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("not delited");
                }


                // действия, если папка существует
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("such derectory not exist");
        }
    }
}




