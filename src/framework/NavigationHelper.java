package framework;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoAddNewEntryPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void openMainPage() {
        driver.get(ApplicationManager.baseUrl + "/");
    }
}
