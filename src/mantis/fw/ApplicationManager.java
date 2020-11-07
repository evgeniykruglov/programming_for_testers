package mantis.fw;

import java.util.Properties;

public class ApplicationManager {
    private static ApplicationManager singleton;
    private WebDriverHelper webDriverHelper;
    private HibernateHelper hibernateHelper;

    private Properties props;
    private AccountHelper accountHelper;

    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }


    public void stop() {
        if (webDriverHelper != null) {
            webDriverHelper.stop();
        }
    }

    public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
    }

    public HibernateHelper getHibernateHelper() {
        if (hibernateHelper == null) {
            hibernateHelper = new HibernateHelper(this);
        }
        return hibernateHelper;
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public void setProperties(Properties props) {
        this.props = props;
    }

    public AccountHelper getAccountHelper() {
        if (accountHelper == null) {
            accountHelper = new AccountHelper(this);
        }
        return accountHelper;
    }
}
