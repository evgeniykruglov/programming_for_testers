package selenium_javaEE.fw;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import addressbook.AddressBookFrame;

public class ApplicationManager {
    protected WebDriver driver;
    public String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private Properties properties;
    private static ApplicationManager singleton;
    private FolderHelper folderHelper;
    private JFrameOperator mainframe;
    private MenuHelper menuHelper;

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
        //getApplication().requestClose();
        if (driver != null) driver.quit();
    }

    public FolderHelper getFolderHelper() {
        if (folderHelper == null) {
            folderHelper = new FolderHelper(this);
        }
        return folderHelper;
    }

    public MenuHelper getMenuHelper() {
        if (menuHelper == null) {
            menuHelper = new MenuHelper(this);
        }
        return menuHelper;
    }

    public JFrameOperator getApplication()  {
        if(mainframe == null) {
            try {
                new ClassReference("addressbook.AddressBookFrame").startApplication();
                mainframe = new JFrameOperator("jAddressBook");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mainframe;
    }
}
