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

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupEdit() {
        click(By.xpath("//input[contains(@value,'Edit group')]"));
    }

    public void deleteGroup() {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.name("delete"));
    }

    public void deleteGroup(int i) {
        tickGroupCheckbox(i);
        deleteGroup();
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
            GroupData group = new GroupData();
            String title = checkbox.getAttribute("title");
            group.setName(title.substring("Select (".length(), title.length() - ")".length() ));
            groups.add(group);
        }
        return groups;
    }
}
