package framework;

import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected final WebDriver driver;
    protected ApplicationManager manager;

    private static boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
        this.driver = manager.driver;
    }

}
