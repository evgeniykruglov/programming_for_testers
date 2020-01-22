package framework;

import org.openqa.selenium.By;
import selenium.GroupData;

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

    public void tickGroupCheckbox(int i) {
        click(By.xpath("//input[@name='selected[]'][" + i + "]"));
    }

    public void submitGroupEdition() {
        click(By.xpath("//input[contains(@value,'Update')]"));
    }
}
