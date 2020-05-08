package selenium;

import framework.ApplicationManager;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static selenium.GroupDataGenerator.generateRandomGroups;

public class TestBase {
    protected ApplicationManager applicationManager;

    @BeforeClass
    public void setUp() throws Exception  {
        applicationManager = new ApplicationManager();
    }

    @AfterClass
    public void tearDown() throws Exception {
        applicationManager.stop();
    }


    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<GroupData> groupData = generateRandomGroups(5);
        List<Object[]> list = wrapGroupForDataProvider(groupData);
        return list.iterator();
    }

    private List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group: groups) {
            list.add(new Object[] {group});
        }
        return list;
    }
}
