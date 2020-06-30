package selenium_javaEE.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import selenium_javaEE.fw.ApplicationManager;
//import selenium_web.tests.GroupData;
//import selenium_web.tests.GroupDataGenerator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    protected ApplicationManager applicationManager;

    @BeforeClass
    @Parameters({"configFile"})
    public void setUp (String configFile) throws Exception  {
        if (configFile==null) {
            configFile = System.getProperty("configFile");
        }
        if (configFile==null) {
            configFile = System.getenv("configFile");
        }
        if (configFile==null) {
            configFile = "selenium_javaEE.application.properties";
        }
        Properties props = new Properties();
        props.load(new FileReader(configFile));
        log.info("setup start");
        applicationManager = ApplicationManager.getInstance();
        applicationManager.setProperties(props);
        log.info("setup end");
}

    @AfterClass
    public void tearDown() throws Exception  {
        applicationManager.stop();
    }

}
