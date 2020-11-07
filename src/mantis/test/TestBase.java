package mantis.test;

import mantis.fw.ApplicationManager;
import org.testng.annotations.*;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    protected ApplicationManager app;

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
            configFile = "src/mantis/application.properties";
        }
        Properties props = new Properties();
        props.load(new FileReader(configFile));
        log.info("setup start");
        app = ApplicationManager.getInstance();
        app.setProperties(props);
        log.info("setup end");
    }

    @AfterClass
    public void tearDown() throws Exception  {
        app.stop();
    }

}
