package selenium_native.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import selenium_native.framework.ApplicationManager;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    protected ApplicationManager applicationManager ;

    @BeforeClass
    public void setUp () throws Exception  {
        Properties props = new Properties();
        props.load(new FileReader("src/selenium_native/application.properties"));
        log.info("setup start");
        applicationManager = ApplicationManager.getInstance(props);
        /*applicationManager.setProperties(props);*/
        log.info("setup end");
}

    @AfterClass
    public void tearDown() throws Exception  {
        applicationManager.getInstance(null).stop();
    }

}
