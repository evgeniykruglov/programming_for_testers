package selenium_web.tests;

import selenium_web.framework.ApplicationManager;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class TestBase {
    protected ApplicationManager applicationManager;
    private int checkCounter;
    private int checkFrequency;

    @BeforeClass
    public void setUp() throws Exception  {
        String configFile = System.getProperty("config", "application.properties");
        Properties p = new Properties();
        p.load(new FileReader(new File(configFile)));
        applicationManager = new ApplicationManager(p);
        checkCounter = 0;
        checkFrequency = Integer.parseInt(p.getProperty("check.frequency", "1"));
    }

    protected boolean timeToCheck() {
        checkCounter++;
        if(checkCounter > checkFrequency) {
            checkCounter = 0;
            return true;
        } else return false;
    }
    @AfterClass
    public void tearDown() throws Exception {
        applicationManager.stop();
    }


    @DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
        List<GroupData> groupData = GroupDataGenerator.generateRandomGroups(5);
        List<Object[]> list = wrapGroupForDataProvider(groupData);
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> groupsFromCSVFile() throws IOException {
        return wrapGroupForDataProvider(GroupDataGenerator.loadGroupsFromCsvFile(new File("groups.csv"))).iterator();
    }

    @DataProvider
    public Iterator<Object[]> groupsFromXMLFile() throws IOException {
        return wrapGroupForDataProvider(GroupDataGenerator.loadGroupsFromXMLFile(new File("groups.xml"))).iterator();
    }

    private List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group: groups) {
            list.add(new Object[] {group});
        }
        return list;
    }
}
