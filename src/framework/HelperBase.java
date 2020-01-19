package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected final WebDriver driver;
    protected ApplicationManager manager;

    private static boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
    }

    protected void type(By locator, String name) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(name);
    }

    protected void click(By aNew) {
        driver.findElement(aNew).click();
    }

    public void deleteGroupById(int i) {
        click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.name("delete"));
    }
}
