package selenium_native.framework;


import java.util.Properties;

public class ApplicationManager {
    private Properties properties;
    private static ApplicationManager singleton;
    private ContactHelper contactHelper;
    private ProcessHelper processHelper ;

    public static ApplicationManager getInstance(Properties props) {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(props);
            singleton.start();

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

    public void start() {
        getProcessHelper().startAppUnderTest();
    }

    public void stop() {
        getProcessHelper().stopAppUnderTest();
    }

    public void createContact() {

    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public ProcessHelper getProcessHelper() {
        if (processHelper == null) {
            processHelper = new ProcessHelper(this);
        }
        return processHelper;
    }

}
