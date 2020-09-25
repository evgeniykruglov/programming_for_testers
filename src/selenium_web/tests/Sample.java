package selenium_web.tests;

import selenium_web.framework.ApplicationManager;
import selenium_web.framework.JdbcHelper;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Sample {
    public static void main(String[] args) throws Exception {
        String configFile = System.getProperty("config", "application.properties");
        Properties p = new Properties();
        p.load(new FileReader(new File(configFile)));
        ApplicationManager applicationManager = new ApplicationManager(p);
        applicationManager.getHibernateHelper().listGroups();
        JdbcHelper jdbc = new JdbcHelper(applicationManager, "jdbc:mysql://localhost/db?user=user&password=password");
        System.out.println(jdbc.listGroups());


    }

}
