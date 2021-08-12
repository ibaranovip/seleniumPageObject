package app.pageBuilder;

import app.pages.*;

public class MyApp extends MyAppBuilder{


    public LoginPage loginPage;
    public    AddRemove addRemove;
    public Checkboxes checkboxes;
    public DownLoad downLoad;
    public ImageBroken imageBroken;
    public  PopUp popUp;
    public ActionMouseScroll actionMouseScroll;

    public MyApp() {
        loginPage = MyAppBuilder.pageLogin();
        addRemove  = MyAppBuilder.pageAddRemove();
        checkboxes = new Checkboxes();
        downLoad = new DownLoad();
        imageBroken = new ImageBroken();
        actionMouseScroll = new ActionMouseScroll();
        popUp = new PopUp();









    }
}
