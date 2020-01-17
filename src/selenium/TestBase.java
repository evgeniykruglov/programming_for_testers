package selenium;

import framework.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected ApplicationManager applicationManager;

    @BeforeTest
    public void setUp() throws Exception  {
        applicationManager = new ApplicationManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        applicationManager.stop();
    }
}
