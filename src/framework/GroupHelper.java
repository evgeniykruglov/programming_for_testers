package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
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

    public GroupHelper deleteGroup() {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.name("delete"));
        return this;
    }

    public GroupHelper deleteGroup(int i) {
        tickGroupCheckbox(i);
        deleteGroup();
        return this;
    }

    public void tickGroupCheckbox(int i) {
        click(By.xpath("//input[@name='selected[]'][" + (i+1) + "]"));
    }

    public void submitGroupEdition() {
        click(By.xpath("//input[contains(@value,'Update')]"));
    }

    public List<GroupData> getGroups() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
        for (WebElement checkbox : checkboxes) {
            String title = checkbox.getAttribute("title");
            GroupData group = new GroupData()
                    .withName(title.substring("Select (".length(), title.length() - ")".length() ));
            groups.add(group);
        }
        return groups;
    }
}
