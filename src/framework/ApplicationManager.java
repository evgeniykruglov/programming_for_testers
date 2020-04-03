package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    protected WebDriver driver;
    public static final String baseUrl =  "http://address.book/";
    private StringBuffer verificationErrors = new StringBuffer();
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private EntryHelper entryHelper;

    public ApplicationManager() throws Exception {
        switch (Constants.WEBDRIVER.getText().charAt(0)) {
            case 'o':
                System.setProperty("webdriver.opera.driver",Constants.OPERA_DRIVER_PATH.getText());
                driver = new OperaDriver();
                break;
            case 'f':
                System.setProperty("webdriver.gecko.driver",Constants.FIREFOX_DRIVER_PATH.getText());
                driver = new FirefoxDriver();
                break;
            case 'i':
                System.setProperty("webdriver.ie.driver",Constants.IE_DRIVER_PATH.getText());
                driver = new InternetExplorerDriver();
                break;
            case 'c':
                System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH.getText());
                driver = new ChromeDriver();
                break;
            default:
                throw new Exception("Type of webdriver is not specified. Please set value for constant Constants.WEBDRIVER");
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(ApplicationManager.baseUrl + "/");
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

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }
}
