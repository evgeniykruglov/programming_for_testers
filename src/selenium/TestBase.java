package selenium;

import framework.ApplicationManager;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5 ; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString("name"))
                    .withHeader(generateRandomString("footer"))
                    .withFooter(generateRandomString("header"));
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
}
