package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GroupModificationTests extends TestBase {
    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group) throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(originlist.size()-1);
        applicationManager.getGroupHelper().tickGroupCheckbox(index);
        applicationManager.getGroupHelper().initGroupEdit()
                                           .fillGroupForm(group)
                                           .submitGroupEdition();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        originlist.remove(index);
        originlist.add(group);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);
    }
}
