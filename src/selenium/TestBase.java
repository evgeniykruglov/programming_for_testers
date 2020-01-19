package selenium;

import framework.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

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
}
