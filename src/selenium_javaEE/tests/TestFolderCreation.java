package selenium_javaEE.tests;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class TestFolderCreation extends TestBase {

    @Test
    public void testFolderCreation() throws Exception {
        String folder = "newFolder";
        Folders oldFolders = applicationManager.getFolderHelper().getFolders();
        applicationManager.getFolderHelper().createFolder(folder);
        Folders newFolders = applicationManager.getFolderHelper().getFolders();
        //assertThat (newFolders, equalTo(oldFolders.withAdded(folder)));
    }

    @Test
    public void testVariousFolderCreation() {
        String folder1 = "newFolder1";
        String folder2 = "newFolder2";
        Folders oldFolders = applicationManager.getFolderHelper().getFolders();
        assertThat(applicationManager.getFolderHelper().createFolder(folder1), is(nullValue()));
        Folders newFolders = applicationManager.getFolderHelper().getFolders();
        //assertThat (newFolders, equalTo(oldFolders.withAdded(folder1)));
        assertThat(applicationManager.getFolderHelper().createFolder(folder2), is(nullValue()));
        Folders newFolders2 = applicationManager.getFolderHelper().getFolders();
        //assertThat (newFolders2, equalTo(oldFolders.withAdded(folder2)));
    }

    @Test
    public void testSameFolderCreation() {
        String folder = "newFolder3";
        Folders oldFolders = applicationManager.getFolderHelper().getFolders();
        assertThat(applicationManager.getFolderHelper().createFolder(folder), is(nullValue()));
        Folders newFolders = applicationManager.getFolderHelper().getFolders();
        assertThat(applicationManager.getFolderHelper().createFolder(folder),
                equalTo("Duplicated folder name. A new folder hasn't been added."));
        Folders newFolders2 = applicationManager.getFolderHelper().getFolders();
        //assertThat (newFolders2, equalTo(oldFolders));
    }
}
