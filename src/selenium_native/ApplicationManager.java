package selenium_native;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    public String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private Properties properties;
    private static ApplicationManager singleton;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }

    public void setProperties(Properties props) {
        this.properties = props;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public void stop() {
    }

/*    public FolderHelper getFolderHelper() {
        if (folderHelper == null) {
            folderHelper = new FolderHelper(this);
        }
        return folderHelper;
    }
    */
}
