package selenium;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;


public class GroupCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 20 ; i++) {
            GroupData group = new GroupData();
            group.setName(generateRandomString("name"));
            group.setFooter(generateRandomString("footer"));
            group.setHeader(generateRandomString("header"));
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    public String generateRandomString(String title) {
        Random rnd = new Random();
        if (rnd.nextInt(10) == 0) {
            return "";
        } else {
            return title + rnd.nextInt();
        }
    }


    @Test(dataProvider = "randomValidGroupGenerator")
    public void testGroupCreationWithValidData(GroupData groupData) throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> originlist = applicationManager.getGroupHelper().getGroups();

        applicationManager.getGroupHelper().initGroupCreation();

        applicationManager.getGroupHelper().fillGroupForm(groupData);
        applicationManager.getGroupHelper().submitGroupCreation();
        applicationManager.getNavigationHelper().gotoGroupsPage();

        List<GroupData> newList = applicationManager.getGroupHelper().getGroups();
        Assert.assertEquals(originlist.size() + 1, newList.size());
        originlist.add(groupData);
        Collections.sort(originlist);
        Assert.assertEquals(newList, originlist);


    }

}
