package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    public static final String baseUrl =  "http://address.book/";
    private StringBuffer verificationErrors = new StringBuffer();

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private EntryHelper entryHelper;

    public ApplicationManager() {
        System.setProperty("webdriver.gecko.driver","webdriver\\geckodriver64.exe");
        System.setProperty("webdriver.ie.driver","D:\\src\\JPGdownloader\\webdriver\\IEDriverServer.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        if (navigationHelper == null) {
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }


    public GroupHelper getGroupHelper() {
        if (groupHelper == null) {
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }

    public EntryHelper getEntryHelper() {
        if(entryHelper == null) {
            entryHelper = new EntryHelper(this);
        }
        return entryHelper;
    }
}
