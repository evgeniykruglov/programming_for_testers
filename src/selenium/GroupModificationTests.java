package selenium;

import framework.GroupHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GroupModificationTests extends TestBase {
    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group) throws Exception {
        //applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        GroupHelper groupHelper =applicationManager.getGroupHelper();
        List<GroupData> originlist = groupHelper.getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(originlist.size()-1);

        groupHelper.modifyGroup(index, group);


        List<GroupData> newList = groupHelper.getGroups();
        originlist.remove(index);
        originlist.add(group);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);
    }
}
