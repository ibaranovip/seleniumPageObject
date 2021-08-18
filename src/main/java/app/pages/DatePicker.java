package app.pages;

import app.browser.DriverManager;
import app.util.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;



public class DatePicker {
    private By windowsPopup = By.xpath("//button[@class='uk-modal-close-outside uan-modal__close uk-icon']");
    private By inputFrom = By.xpath("//*[@id=\"field38\"]");
    private By inputTo = By.xpath("//*[@id=\"cityInputTo\"]");
    private By setFrom = By.xpath("//div[@class=\"city-select-dropdown__place\"]");
    private By setTo = By.xpath("//div[@class=\"city-select-dropdown__place\"]");
    private By denySecondTicket = By.xpath("//*[@id=\"form-switcher\"]/li[1]/div/div/div/div/div[1]/div[4]/div[2]/div/div[2]/div[2]/button");
    private By buttonSearch = By.xpath("//a[@class=\"uk-button uk-button-primary ts-v2__button ticket-search__btn margin-top--11px height--50px padding-top--7px\"]");

    private By clickCalendar = By.xpath("//*[@id=\"firstDatePicker\"]");
    public By getCalendar = By.cssSelector("div.daterangepicker.dropdown-menu.ltr.show-ranges.show-calendar.displayleft > div.calendars > div.drp-calendar.left");


    public void getUrl(String url){
        DriverManager.getDriver().get(url);
    }


    public void closeWindowPopUp(){
        Methods.PopupMenu();
        Methods.waitForClickablility(windowsPopup,5);
        Methods.clickJavaScript(windowsPopup);
    }





    public void selectFromTo(String from, String to){  //Here any date you can give

        WebElement eval= DriverManager.getDriver().findElement(inputFrom);
        Methods.executarJavascript("arguments[0].click();", eval);


        eval.sendKeys(from);


        List<WebElement> allcity = eval.findElements(setFrom);
        for(WebElement cell:allcity){
            String city=cell.getText();
            if (city.equals(from)) {
                cell.click();
                break;
            }
        }


    ////////
   //Here any date you can give

        WebElement city =DriverManager.getDriver().findElement(inputTo);

        Methods.waitForClickablility(inputTo, 5);
        Methods.clickJavaScript(inputTo);
        city.sendKeys(to);

        List<WebElement> allCityTo = city.findElements(setTo);
        for(WebElement cell:allCityTo){
            String cityTo=cell.getText();
            if (cityTo.equals(to)) {
                cell.click();
                break;
            }
        }
    }

    public   void selectDate(String date ){  //Here any date you can give
        Methods.clickJavaScript(clickCalendar);
        WebElement eval=DriverManager.getDriver().findElement(getCalendar);
        List<WebElement> alldates = eval.findElements(By.tagName("td"));
        for(WebElement cell:alldates){
            String day=cell.getText();
            if (day.equals(date)) {
                cell.click();
                break;
            }
        }
    }
    public void clickDenyTicket(){
        Methods.clickWebElement(denySecondTicket);
    }
    public void clickButtonSearch(){
        Methods.clickWebElement(buttonSearch);
    }
}
