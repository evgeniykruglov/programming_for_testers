package selenium;

import org.testng.annotations.Test;

public class GroupRemovalTest extends TestBase {

    @Test
    public void deleteSomeGroup() {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        applicationManager.getGroupHelper().tickGroupCheckbox(2);
        applicationManager.getGroupHelper().deleteGroup();

        applicationManager.getNavigationHelper().gotoGroupsPage();
    }

}
