package selenium;

import framework.EntryHelper;
import framework.NavigationHelper;
import org.testng.annotations.Test;


public class  UserCreationTests extends TestBase{

    @Test
    public void testEntryCreation() throws Exception {
        applicationManager.navigationHelper.openMainPage();
        applicationManager.navigationHelper.gotoAddNewEntryPage();
        //initEntryCreation();
        EntryData entryData = new EntryData("Ivan", "Brovkin", "Moscow");
        applicationManager.entryHelper.fillEntryForm(entryData);
        applicationManager.entryHelper.submitEntryCreation();
        applicationManager.navigationHelper.gotoAddNewEntryPage();
    }

}
