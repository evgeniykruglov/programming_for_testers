package selenium;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;


public class GroupCreationTests extends TestBase{
    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();

        applicationManager.getGroupHelper().initGroupCreation()
                                           .fillGroupForm(groupData)
                                           .submitGroupCreation();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        Assert.assertEquals(originlist.size() + 1, newList.size());
        originlist.add(groupData);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);


    }

}
