package selenium;

import org.junit.Before;
import org.testng.annotations.*;
import utils.SortedListOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GroupCreationTests extends TestBase{
    @Before


    @Test(dataProvider = "groupsFromCSVFile")
    public void testGroupCreationWithValidDataCSV(GroupData groupData) throws Exception {
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        applicationManager.getGroupHelper().createGroup(groupData);
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> newList = applicationManager.getGroupHelper().getGroups();

        assertThat(newList, equalTo(originlist.withAdded(groupData)));
//
//        Assert.assertEquals(originlist.size() + 1, newList.size());
//
//        originlist.add(groupData);
//        Collections.sort(originlist);
//        assertEquals(newList, originlist);


    }

    @Test(dataProvider = "groupsFromXMLFile")
    public void testGroupCreationWithValidDataXML(GroupData groupData) throws Exception {
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        applicationManager.getGroupHelper().createGroup(groupData);
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> newList = applicationManager.getGroupHelper().getGroups();

        assertThat(newList, equalTo(originlist.withAdded(groupData)));
    }

}
