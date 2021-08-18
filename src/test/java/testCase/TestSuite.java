package testCase;


import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class TestSuite extends BasePageTest {




    @Test(priority=2,testName="Add element",description="", alwaysRun = true)
    public void testAddElementPage() {
        myApp.addRemove.returnPage();
        assertThat(true).isEqualTo(myApp.addRemove.isElementPresentAdd1());


    }

    @Test(priority=3,testName="check box",description="",alwaysRun = true)
    public void chekBoxes1() {
        myApp.checkboxes.goPage();
        assertThat(true).isEqualTo(myApp.checkboxes.checkboxIsSelected(2));
    }

    @Test (priority=4,testName="Download file",description="",alwaysRun = true)


    public void testDownload() throws Exception {
        myApp.downLoad.goPage();
        myApp.downLoad.clickDownload();
        myApp.downLoad.isFileDownloaded("/home/ivan/Downloads", "some-file.txt");
    }


    @Test  (priority=5,testName="search image Broken",description="",alwaysRun = true)

    public void brokenimage1() throws IOException {
        myApp.imageBroken.goPage();

        assertThat(2).isEqualTo(myApp.imageBroken.serchBrokenImg());
    }


    @Test (priority=6,testName="pop up",description="", alwaysRun = true)
    public void testChekPopUp() {
        myApp.popUp.getUrl("https://minicen.ru/");
        myApp.popUp.PopupMenu();


    }



    @Test (priority=7,testName="imitation move mouse, select options seze",description="", alwaysRun = true)
    public void testChekLink() throws InterruptedException {
        myApp.actionMouseScroll.getUrl("http://prestashop-automation.qatestlab.com.ua/ru");
        myApp.actionMouseScroll.moveMause();
        assertThat("m").isEqualTo(myApp.actionMouseScroll.assertOption());
    }



    @Test(priority=8,testName="loginPage",description="", alwaysRun = true)
    public void testLogin() {


        myApp.loginPage.returnPage().login("tomsmith", "SuperSecretPassword!");
         assertThat( "You logged into a secure area!").isEqualTo(myApp.loginPage.getAssert());


    }

    @Test(priority=9,testName="loginPage",description="", alwaysRun = true)
    public void dataPicker() {
        myApp.datePicker.getUrl("https://www.uralairlines.ru/");
        myApp.datePicker.closeWindowPopUp();
        myApp.datePicker.selectFromTo("Санкт-Петербург","Москва");
        myApp.datePicker.selectDate("29");
        myApp.datePicker.clickDenyTicket();
        myApp.datePicker.clickButtonSearch();





    }

}



