package selenium;

import framework.ApplicationManager;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static selenium.GroupDataGenerator.*;

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

    @DataProvider
    public Iterator<Object[]> groupsFromCSVFile() throws IOException {
        return wrapGroupForDataProvider(loadGroupsFromCsvFile(new File("groups.csv"))).iterator();
    }

    @DataProvider
    public Iterator<Object[]> groupsFromXMLFile() throws IOException {
        return wrapGroupForDataProvider(loadGroupsFromXMLFile(new File("groups.xml"))).iterator();
    }

    private List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group: groups) {
            list.add(new Object[] {group});
        }
        return list;
    }
}
