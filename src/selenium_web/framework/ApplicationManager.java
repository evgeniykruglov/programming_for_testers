package selenium_web.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private WebDriver driver;
    public String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private EntryHelper entryHelper;
    private Properties properties;
    private HibernateHelper hibernateHelper;
    private ApplicationModel applicationModel;

    public ApplicationManager(Properties props) throws Exception {

        properties = props;
        applicationModel = new ApplicationModel();
        applicationModel.setGroups(getHibernateHelper().listGroups());
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

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
        if (entryHelper == null) {
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

    public ApplicationModel getModel() {
        return applicationModel;
    }

    public WebDriver getDriver() {
        if (driver == null) {

            switch (properties.getProperty("browser").charAt(0)) {
                case 'o':
                    System.setProperty("webdriver.opera.driver", Constants.OPERA_DRIVER_PATH.getText());
                    driver = new OperaDriver();
                    break;
                case 'f':
                    System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_PATH.getText());
                    driver = new FirefoxDriver();
                    break;
                case 'i':
                    System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH.getText());
                    driver = new InternetExplorerDriver();
                    break;
                case 'c':
                    System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH.getText());
                    driver = new ChromeDriver();
                    break;
                default:
                    throw new Error("Type of webdriver is not specified. Please set value for constant Constants.WEBDRIVER");
            }
            baseUrl = properties.getProperty("baseUrl");
            driver.get(baseUrl + "/");
        }

        return driver;
    }

    public HibernateHelper getHibernateHelper() {
        if (hibernateHelper == null) {
            hibernateHelper = new HibernateHelper(this);
        }
        return hibernateHelper;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
