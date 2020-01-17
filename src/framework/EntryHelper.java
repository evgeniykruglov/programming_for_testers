package framework;

import org.openqa.selenium.By;
import selenium.EntryData;

public class EntryHelper extends HelperBase{
    public EntryHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillEntryForm(EntryData entryData) {
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(entryData.getFirstName());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(entryData.getLastName());
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(entryData.getAddress());
    }

    public void submitEntryCreation() {
        driver.findElement(By.name("submit")).click();
    }
}
