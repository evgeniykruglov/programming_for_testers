package framework;

import org.openqa.selenium.By;
import selenium.EntryData;

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
}
