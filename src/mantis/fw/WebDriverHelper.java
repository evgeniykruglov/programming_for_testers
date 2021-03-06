package mantis.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

    protected static WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    public final ApplicationManager manager;

    private static boolean acceptNextAlert = true;

    public WebDriverHelper(ApplicationManager manager) {
        this.manager = manager;
        switch (manager.getProperty("browser").charAt(0)) {
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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    protected void type(By locator, String name) {
        if (name != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(name);
        }
    }

    protected void click(By aNew) {
        driver.findElement(aNew).click();
    }

    public void stop() {
        driver.quit();
    }

    public void openUrl(String url) {
        openAbsoluteUrl(manager.getProperty("baseUrl") + url);
    }

    public void openAbsoluteUrl(String url) {
        driver.get(url);
    }

    public WebElement findElement(By linkText) {
        try {
            return driver.findElement(linkText);
        } catch (Exception e) {
            return null;
        }
    }
}
