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

    public void deleteGroupById(int i) {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.xpath("//input[@name='selected[]'][" + i + "]"));
        click(By.name("delete"));
    }
}
