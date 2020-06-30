package selenium_web.tests;

import selenium_web.framework.GroupHelper;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import utils.SortedListOf;

import java.util.Random;

public class GroupModificationTests extends TestBase {
    @Test(dataProvider = "randomValidGroupGenerator")
    public void modifySomeGroup(GroupData group) throws Exception {
        //applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();
        GroupHelper groupHelper =applicationManager.getGroupHelper();
        SortedListOf<GroupData> originlist = groupHelper.getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(originlist.size()-1);

        groupHelper.modifyGroup(index, group);


        SortedListOf<GroupData>  newList = groupHelper.getGroups();

        assertThat(newList, equalTo(originlist.without(index).withAdded(group)));
//        originlist.remove(index);
//        originlist.add(group);
//        //Collections.sort(originlist);
//        assertEquals(newList, originlist);
    }
}
