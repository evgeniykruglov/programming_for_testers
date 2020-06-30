package selenium_javaEE.tests;

import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TestFolderCreation extends TestBase {

    @Test
    public void testFolderCreation() {
        String folder = "newFolder";
        Folders oldFolders = applicationManager.getFolderHelper().getFolders();
        applicationManager.getFolderHelper().createFolder(folder);
        Folders newFolders = applicationManager.getFolderHelper().getFolders();
        assertThat (newFolders, equalTo(oldFolders.withAdded(folder)));
    }
}
