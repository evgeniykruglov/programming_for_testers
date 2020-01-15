package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import selenium.EntryData;
import selenium.GroupData;
import selenium.TestBase;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    public static WebDriver driver;
    public static final String baseUrl =  "http://address.book/";
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager() {
        System.setProperty("webdriver.gecko.driver","webdriver\\geckodriver64.exe");
        System.setProperty("webdriver.ie.driver","D:\\src\\JPGdownloader\\webdriver\\IEDriverServer.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void gotoGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void gotoAddNewEntryPage() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void openMainPage() {
        driver.get(baseUrl + "/");
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void fillEntryForm(EntryData entryData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys("Ivan");
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys("Brovkin");
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys("Moscow");
    }

    public void submitEntryCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
