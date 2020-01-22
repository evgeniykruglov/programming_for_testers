package selenium;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
    @Test
    public void modifySomeGroup() throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        applicationManager.getGroupHelper().tickGroupCheckbox(1);
        applicationManager.getGroupHelper().initGroupEdit();
        GroupData groupData = new GroupData();
        groupData.setName("edited name1");
        applicationManager.getGroupHelper().fillGroupForm(groupData);
        applicationManager.getGroupHelper().submitGroupEdition();


        applicationManager.getNavigationHelper().gotoGroupsPage();
    }
}
