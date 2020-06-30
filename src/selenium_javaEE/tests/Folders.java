package selenium_javaEE.tests;

import java.util.ArrayList;
import java.util.List;

public class Folders {
    private List<String> storedFolders = null;

    public Folders(List<String> folders) {
        this.storedFolders = new ArrayList<>(folders);
    }

    public Folders withAdded(String folder) {
        Folders newList = new Folders(storedFolders);
        newList.storedFolders.add(folder);
        return newList;
    }

}
