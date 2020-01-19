package selenium;

import framework.ApplicationManager;
import framework.EntryHelper;
import framework.NavigationHelper;
import org.testng.annotations.Test;


public class  UserCreationTests extends TestBase{

    @Test
    public void testEntryCreation() throws Exception {
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getNavigationHelper().gotoAddNewEntryPage();
        //initEntryCreation();
        EntryData entryData = new EntryData("Ivan", "Brovkin", "Moscow");
        applicationManager.getEntryHelper().fillEntryForm(entryData);
        applicationManager.getEntryHelper().submitEntryCreation();
        applicationManager.getNavigationHelper().gotoAddNewEntryPage();
    }

}
