package selenium_native;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    protected ApplicationManager applicationManager;

    @BeforeClass
    @Parameters({"configFile"})
    public void setUp (@Optional String configFile) throws Exception  {
        if (configFile==null) {
            configFile = System.getProperty("configFile");
        }
        if (configFile==null) {
            configFile = System.getenv("configFile");
        }
        if (configFile==null) {
            configFile = "application.properties";
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
