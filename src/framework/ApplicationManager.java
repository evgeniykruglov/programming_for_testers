package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    public static final String baseUrl =  "http://address.book/";
    private StringBuffer verificationErrors = new StringBuffer();

    public NavigationHelper navigationHelper;
    public GroupHelper groupHelper;
    public EntryHelper entryHelper;

    public ApplicationManager() {
        System.setProperty("webdriver.gecko.driver","webdriver\\geckodriver64.exe");
        System.setProperty("webdriver.ie.driver","D:\\src\\JPGdownloader\\webdriver\\IEDriverServer.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        navigationHelper = new NavigationHelper(this);
        entryHelper = new EntryHelper(this);
        groupHelper = new GroupHelper(this);
    }

    public void stop() {
        driver.quit();
    }
}
