package testCase;

import app.browser.DriverManager;
import app.browser.TargetFactory;


import app.pageBuilder.MyApp;
import app.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static app.browser.ConfigurationManager.configuration;

@Listeners({TestListeners.class})
public   class BasePageTest {
    protected MyApp myApp;


    @BeforeSuite
    public void beforeSuite() {

        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration().url());
           myApp = new MyApp();


    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
       // DriverManager.quit();

    }
}


