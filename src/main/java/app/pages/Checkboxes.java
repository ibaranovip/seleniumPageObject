package app.pages;

import app.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkboxes {

    By checkBoxlink1 = By.xpath("//*[@id=\"checkboxes\"]/input[1]");
    By checkBoxlink2 = By.xpath("//*[@id=\"checkboxes\"]/input[2]");
    By pageCheсkBox = By.linkText("Checkboxes");



    public  Checkboxes goPage() {
        DriverManager.getDriver().findElement(pageCheсkBox).click();
        return new Checkboxes( );
    }

    //example method with change parameter method
    public boolean checkboxIsSelected(int option) {
        return  DriverManager.getDriver().findElement(By.xpath("//*[@id=\"checkboxes\"]/input[\" + option + \"]")).isSelected();
    }





    //returns true if element is checked else returns false
    public boolean CheckBox3() {
        boolean value =  DriverManager.getDriver().findElement(checkBoxlink2).isSelected();
    return  value;}
}
