package co.com.training.web.tests;

import co.com.training.web.config.driver.DriverManager;
import co.com.training.web.pageobject.NavigationPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    private static DriverManager driverManager;
    public NavigationPage navigationPage;

    String url = System.getenv("NAME");

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        driverManager = DriverManager.newDriver(browser);
        navigationPage = new NavigationPage(driverManager.getWebDriver(url));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driverManager.getWebDriver().close();
    }

    public NavigationPage getNavigationPage() {
        return navigationPage;
    }
}
