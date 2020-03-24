package selenium;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import utils.SortedListOf;
import java.util.Random;

public class GroupRemovalTest extends TestBase {

    @Test
    public void deleteSomeGroup() {
        //applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoGroupsPage();


        SortedListOf<GroupData> originlist = applicationManager.getGroupHelper().getGroups();
        Random rnd = new Random();
        int index = rnd.nextInt(originlist.size()-1);

        applicationManager.getGroupHelper().deleteGroup(index);
        applicationManager.getNavigationHelper().gotoGroupsPage();

        SortedListOf<GroupData>  newList = applicationManager.getGroupHelper().getGroups();
        assertThat(newList, equalTo(originlist.without(index)));
        //originlist.remove(index);
        //Collections.sort(originlist);
        //assertEquals(newList, originlist);
    }

}
