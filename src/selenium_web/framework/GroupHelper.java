package selenium_web.framework;

import org.openqa.selenium.By;
import selenium_web.tests.GroupData;

public class GroupHelper extends WebDriverHelperBase {

    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }



    public GroupHelper initGroupCreation() {
        returnToGroupsPage();
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

    public GroupHelper createGroup(GroupData groupData) {
        returnToGroupsPage();
        initGroupCreation();
        fillGroupForm(groupData);
        submitGroupCreation();
        manager.getApplicationModel().addGroup(groupData);
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        tickGroupCheckbox(index);
        deleteGroup();
        manager.getApplicationModel().removeGroup(index);
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        tickGroupCheckbox(index);
        initGroupEdit();
        fillGroupForm(group);
        submitGroupEdition();
        returnToGroupsPage();
        manager.getApplicationModel().removeGroup(index).addGroup(group);
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
        
    }


    private GroupHelper deleteGroup() {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.name("delete"));
        
        return this;
    }
}
