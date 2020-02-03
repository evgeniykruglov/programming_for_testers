package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class GroupRemovalTest extends TestBase {

    @Test
    public void deleteSomeGroup() {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();


        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();

        //applicationManager.getGroupHelper().tickGroupCheckbox(2);
        applicationManager.getGroupHelper().deleteGroup(0);
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        originlist.remove(0);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);
    }

}
