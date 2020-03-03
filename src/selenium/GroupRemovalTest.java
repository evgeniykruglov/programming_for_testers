package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GroupRemovalTest extends TestBase {

    @Test
    public void deleteSomeGroup() {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();


        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(originlist.size()-1);

        applicationManager.getGroupHelper().deleteGroup(index);
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        originlist.remove(index);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);
    }

}
