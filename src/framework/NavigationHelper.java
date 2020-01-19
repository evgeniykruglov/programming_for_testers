package framework;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }

    public void gotoAddNewEntryPage() {
        click(By.linkText("add new"));
    }

    public void openMainPage() {
        driver.get(ApplicationManager.baseUrl + "/");
    }
}
