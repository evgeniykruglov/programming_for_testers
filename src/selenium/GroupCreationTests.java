package selenium;

        import org.junit.Before;
        import org.testng.Assert;
        import org.testng.annotations.*;

        import java.util.*;


public class GroupCreationTests extends TestBase{
    @Before


    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
        //applicationManager.getNavigationHelper().openMainPage();
        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        applicationManager.getGroupHelper().createGroup(groupData);
        applicationManager.getNavigationHelper().gotoGroupsPage();


        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        Assert.assertEquals(originlist.size() + 1, newList.size());
        originlist.add(groupData);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);


    }

}
