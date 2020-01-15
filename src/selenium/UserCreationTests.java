package selenium;

import org.testng.annotations.Test;


public class  UserCreationTests extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        applicationManager.openMainPage();
        applicationManager.gotoAddNewEntryPage();
        //initEntryCreation();
        EntryData entryData = new EntryData("Ivan", "Brovkin", "Moscow");
        applicationManager.fillEntryForm(entryData);
        applicationManager.submitEntryCreation();
        applicationManager.gotoAddNewEntryPage();
    }

}
