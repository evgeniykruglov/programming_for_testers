package selenium;

import framework.NavigationHelper;
import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        applicationManager.getGroupHelper().initGroupCreation();
        GroupData groupData = new GroupData("new group", "some logo", "some footer");
        applicationManager.getGroupHelper().fillGroupForm(groupData);
        applicationManager.getGroupHelper().submitGroupCreation();
        applicationManager.getNavigationHelper().gotoGroupsPage();
    }

    @Test
    public void testEmptyGroupCreation() throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        applicationManager.getGroupHelper().initGroupCreation();
        applicationManager.getGroupHelper().fillGroupForm(new GroupData("new group", "", ""));
        applicationManager.getGroupHelper().submitGroupCreation();
        applicationManager.getNavigationHelper().gotoGroupsPage();
    }

}
