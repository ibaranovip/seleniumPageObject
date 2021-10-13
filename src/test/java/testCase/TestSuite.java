package testCase;


import app.util.Methods;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class TestSuite extends BasePageTest {

    @Test(priority = 2, testName = "LoginMail", description = "mail.ru", alwaysRun = true)
    public void loginMail() {
        myApp.loginMailru.getUrl("https://mail.ru/");
        myApp.loginMailru.login("bar_van", "------jN"); //here your email/password
        myApp.loginMailru.compose("bar_van@mail.ru", "test", "Hello world");

        //   assertThat("here your email").isEqualTo(myApp.loginMailru.getAssert());


    }

    @Test(priority = 3, testName = "Date picker", description = "Ввод места отправдения и назначения, даты полета", alwaysRun = true)
    public void dataPicker() {
        myApp.datePicker.getUrl("https://www.uralairlines.ru/");
        myApp.datePicker.closeWindowPopUp();
        myApp.datePicker.selectFromTo("Санкт-Петербург", "Москва");
        myApp.datePicker.selectDate("29");
        myApp.datePicker.clickDenyTicket();
        myApp.datePicker.clickButtonSearch();

    }


    @Test(priority = 4, testName = "Add element", description = "Интерактивное добавление элемента", alwaysRun = true)
    public void testAddElementPage() {
        myApp.addRemove.returnPage();
        assertThat(true).isEqualTo(myApp.addRemove.isElementPresentAdd1());


    }

    @Test(priority = 5, testName = "check box", description = "Проверка чекбокса", alwaysRun = true)
    public void chekBoxes1() {
        myApp.checkboxes.goPage();
        assertThat(true).isEqualTo(myApp.checkboxes.checkboxIsSelected(2));
    }

    @Test(priority = 6, testName = "Download file", description = "", alwaysRun = true)


    public void testDownload() throws Exception {
        myApp.downLoad.goPage();
        myApp.downLoad.clickDownload();
        myApp.downLoad.isFileDownloaded("/home/ivan/Downloads", "some-file.txt");
    }


    @Test(priority = 7, testName = "search image Broken", description = "Поиск битых ссылок", alwaysRun = true)

    public void brokenimage1() throws IOException {
        myApp.imageBroken.goPage();

        assertThat(2).isEqualTo(myApp.imageBroken.serchBrokenImg());
    }


    @Test(priority = 8, testName = "pop up", description = "Обработка оповещений и всплывающих окон", alwaysRun = true)
    public void testChekPopUp() {
        myApp.popUp.getUrl("https://minicen.ru/");
        myApp.popUp.PopupMenu();


    }


    @Test(priority = 9, testName = "", description = " Быстрый просмотр товара, выбор размера ", alwaysRun = true)
    public void testChekLink() throws InterruptedException {
        myApp.actionMouseScroll.getUrl("http://prestashop-automation.qatestlab.com.ua/ru");
        myApp.actionMouseScroll.moveMause();
        assertThat("l").isEqualTo(myApp.actionMouseScroll.assertOption());
    }


    @Test(priority = 10, testName = "loginPage", description = "Авторизация", alwaysRun = true)
    public void testLogin() {


        myApp.loginPage.returnPage().login("tomsmith", "SuperSecretPassword!");
        assertThat("You logged into a secure area!").isEqualTo(myApp.loginPage.getAssert());


    }

    @Test(testName = "zaprosto")
    public void test() {
        myApp.dkp.getWindowHandle();
        myApp.dkp.setUser("", "");


        myApp.dkp.setShop();
        myApp.dkp.createNewCredit();
        myApp.dkp.selectManufacture();
        myApp.dkp.selectNameProduct();

        myApp.dkp.generateUser();
        myApp.dkp.setNumberAgreement();
        myApp.dkp.clickContinie();
        myApp.dkp.assertVisible();


        myApp.dkp.openNewTabJS();
        myApp.dkp.getWindowHandle();
        myApp.dkp.getUrl("https://test-admin.za-prosto.ru/");

        myApp.dkp.accountLogout2();

        myApp.dkp.accountLogout();

        myApp.dkp.getUrl("https://test-admin.za-prosto.ru/");
//        myApp.dkp.accountLogout2();
//
        myApp.dkp.setOpmenege("", "");
        myApp.dkp.selectUser();
        myApp.dkp.inputGuid();
        myApp.dkp.clickAgreeOpM();
        myApp.dkp.getWindowHandle();
        myApp.dkp.getWindowHandle();
        myApp.dkp.clickPopUpAgreeOpM();
        myApp.dkp.getWindowHandle();

    }

    @Test(testName = "zaprosto")
    public void test2() {
        myApp.dkp.getUrl("https://test-admin.za-prosto.ru/");
//        myApp.dkp.accountLogout2();
//
        myApp.dkp.setOpmenege("", "");
        myApp.dkp.selectUser();
        myApp.dkp.inputGuidTest();
       myApp.dkp.clickAgreeOpM();

        //assertThat("").isEqualTo(myApp.dkp.clickAgreeOpM());
        myApp.dkp.getWindowHandle();
        myApp.dkp.getWindowHandle();
        myApp.dkp.clickPopUpAgreeOpM();


    }
    @Test(testName = "zaprosto")
    public void test3()   {
        myApp.dkp.getSmsWindow();
        myApp.dkp.getWindowHandle();
        myApp.dkp.getWindowHandle();

        myApp.dkp.getSms();
        System.out.println(myApp.dkp.getSmsNumber());
    }
}



