package selenium_web.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationHelper extends WebDriverHelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void gotoGroupsPage() {
        if (!onGroupPage()){
            click(By.linkText("groups"));
        }
    }

    public void gotoAddNewEntryPage() {
        click(By.linkText("add new"));
    }

    public void openMainPage() {
        if(!onMainPage()) {
            click(By.linkText("home"));
        }
    }

    private boolean onMainPage() {
        return (driver.findElements(By.id("maintable")).size()>0);
    }

    private boolean onGroupPage() {
        String currentUrl = driver.getCurrentUrl();
        List<WebElement> listOfElements = driver.findElements(By.name("new"));
        return (currentUrl.contains("/group.php") && listOfElements.size() > 0);
    }
}
