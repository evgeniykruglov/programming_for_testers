package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @Test
    public void modifySomeGroup() throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();

        applicationManager.getGroupHelper().tickGroupCheckbox(0);
        applicationManager.getGroupHelper().initGroupEdit();
        GroupData group = new GroupData();
        group.setName("edited name1");
        applicationManager.getGroupHelper().fillGroupForm(group);
        applicationManager.getGroupHelper().submitGroupEdition();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        originlist.remove(0);
        originlist.add(group);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);
    }
}
