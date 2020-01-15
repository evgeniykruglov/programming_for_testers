package selenium;

import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        applicationManager.openMainPage();
        applicationManager.gotoGroupsPage();
        applicationManager.initGroupCreation();
        GroupData groupData = new GroupData("new group", "some logo", "some footer");
        applicationManager.fillGroupForm(groupData);
        applicationManager.submitGroupCreation();
        applicationManager.gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        applicationManager.openMainPage();
        applicationManager.gotoGroupsPage();
        applicationManager.initGroupCreation();
        applicationManager.fillGroupForm(new GroupData("new group", "", ""));
        applicationManager.submitGroupCreation();
        applicationManager.gotoGroupsPage();
    }

}
