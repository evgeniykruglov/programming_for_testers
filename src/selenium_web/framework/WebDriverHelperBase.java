package selenium_web.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelperBase extends HelperBase {

    protected final WebDriver driver;
    private final WebDriverWait wait;

    private static boolean acceptNextAlert = true;

    public WebDriverHelperBase(ApplicationManager manager) throws Error {
        super(manager);
        this.driver = manager.getDriver();
        wait = new WebDriverWait(driver, 10);
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

}
