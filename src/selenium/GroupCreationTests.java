package selenium;

import framework.NavigationHelper;
import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        applicationManager.navigationHelper.openMainPage();
        applicationManager.navigationHelper.gotoGroupsPage();
        applicationManager.groupHelper.initGroupCreation();
        GroupData groupData = new GroupData("new group", "some logo", "some footer");
        applicationManager.groupHelper.fillGroupForm(groupData);
        applicationManager.groupHelper.submitGroupCreation();
        applicationManager.navigationHelper.gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        applicationManager.navigationHelper.openMainPage();
        applicationManager.navigationHelper.gotoGroupsPage();
        applicationManager.groupHelper.initGroupCreation();
        applicationManager.groupHelper.fillGroupForm(new GroupData("new group", "", ""));
        applicationManager.groupHelper.submitGroupCreation();
        applicationManager.navigationHelper.gotoGroupsPage();
    }

}
