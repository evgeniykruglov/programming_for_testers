package selenium_web.framework;

import org.openqa.selenium.By;
import selenium_web.tests.EntryData;

public class EntryHelper extends HelperBase{
    public EntryHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillEntryForm(EntryData entryData) {
        type(By.name("firstname"), entryData.getFirstName());
        type(By.name("lastname"), entryData.getLastName());
        type(By.name("address"), entryData.getAddress());
    }

    public void submitEntryCreation() {
        click(By.name("submit"));
    }

    public void deleteGroupById(int i) {
        //click(By.xpath("//*[@id=\"content\"]/form[2]/input[1]"));
        click(By.xpath("//input[@name='selected[]'][" + i + "]"));
        click(By.name("delete"));
    }
}
