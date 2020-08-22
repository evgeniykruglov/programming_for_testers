package selenium_web.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium_web.tests.GroupData;
import utils.SortedListOf;

import java.util.List;

public class GroupHelper extends WebDriverHelperBase {
    private SortedListOf<GroupData> cachedGroups;

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public SortedListOf<GroupData> getGroups() {
        //manager.getNavigationHelper().openMainPage();

        if(cachedGroups == null) {
            rebuildCache();
        }
        return cachedGroups;
    }

    private void rebuildCache() {
        this.cachedGroups = new SortedListOf<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            GroupData group = new GroupData()
                    .withName(title.substring("Select (".length(), title.length() - ")".length() ));
            this.cachedGroups.add(group);
        }
    }

    public GroupHelper initGroupCreation() {
        returnToGroupsPage();
        click(By.name("new"));
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        this.cachedGroups = null;
        return this;
    }

    public GroupHelper fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
        return this;
    }

    public GroupHelper initGroupEdit() {
        click(By.xpath("//input[contains(@value,'Edit group')]"));
        return this;
    }

    public GroupHelper createGroup(GroupData groupData) {
        returnToGroupsPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        return this;
    }

    public GroupHelper deleteGroup(int i) {
        tickGroupCheckbox(i);
        deleteGroup();
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        tickGroupCheckbox(index);
        initGroupEdit();
        fillGroupForm(group);
        submitGroupEdition();
        returnToGroupsPage();
        return this;
    }

    private void returnToGroupsPage() {
        manager.getNavigationHelper().gotoGroupsPage();
    }

    public void tickGroupCheckbox(int i) {
        click(By.xpath("//input[@name='selected[]'][" + (i+1) + "]"));
    }

    public void submitGroupEdition() {
        click(By.xpath("//input[contains(@value,'Update')]"));
        this.cachedGroups = null;
    }


    private GroupHelper deleteGroup() {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.name("delete"));
        this.cachedGroups = null;
        return this;
    }
}
