package selenium_javaEE.fw;

import org.netbeans.jemmy.operators.*;
import org.testng.annotations.Test;
import selenium_javaEE.tests.Folders;
import selenium_web.framework.HelperBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class FolderHelper extends HelpersBase {

    public FolderHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Folders getFolders() {
        List<String> list = new ArrayList<String>();
        JFrameOperator mainFrame = applicationManager.getApplication();
        JTreeOperator tree = new JTreeOperator(mainFrame);
        Object[] children = tree.getChildren(tree.getRoot());
        for (Object child : children) {
            list.add("" + child);
        }
        return new Folders(list);
    }

    public String createFolder(String folder) {
        applicationManager.getMenuHelper().pushCreateFolder();
        JDialogOperator dialog = new JDialogOperator(applicationManager.getApplication());
        new JTextFieldOperator(dialog).setText(folder);
        new JButtonOperator(dialog, "OK").push();
        return waitMessageDialog("Warning", 300);
    }

}
