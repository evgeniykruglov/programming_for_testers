package selenium_web.tests;

import org.junit.Before;
import org.testng.annotations.*;
import utils.SortedListOf;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GroupCreationTests extends TestBase {
    @Before


    @Test(dataProvider = "groupsFromCSVFile")
    public void testGroupCreationWithValidDataCSV(GroupData groupData) throws Exception {
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> originlist = new SortedListOf<GroupData>(applicationManager.getHibernateHelper().listGroups());
        applicationManager.getGroupHelper().createGroup(groupData);
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> newList = new SortedListOf<GroupData>(applicationManager.getHibernateHelper().listGroups());

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
        SortedListOf<GroupData> originlist = applicationManager.getModel().getGroups();
        applicationManager.getGroupHelper().createGroup(groupData);
        applicationManager.getNavigationHelper().gotoGroupsPage();
        SortedListOf<GroupData> newList = applicationManager.getModel().getGroups();

        assertThat(newList, equalTo(originlist.withAdded(groupData)));
    }

    @Test(dataProvider = "groupsFromXMLFile")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        SortedListOf<GroupData> oldList = applicationManager.getModel().getGroups();
        applicationManager.getGroupHelper().createGroup(group);
        SortedListOf<GroupData> newList = applicationManager.getModel().getGroups();
        assertThat(newList, equalTo(oldList));

        if (timeToCheck()) {
            if (applicationManager.getProperty("check.db").equals("true")) {
                assertThat(applicationManager.getModel().getGroups(), equalTo(
                        applicationManager.getHibernateHelper().listGroups()));
            }

            if (applicationManager.getProperty("check.ui").equals("true")) {
                assertThat(applicationManager.getModel().getGroups(), equalTo(
                        applicationManager.getGroupHelper().getUIGroups()));
            }
        }
    }

}
