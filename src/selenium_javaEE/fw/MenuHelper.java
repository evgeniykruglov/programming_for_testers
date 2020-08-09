package selenium_javaEE.fw;

import org.netbeans.jemmy.operators.*;

public class MenuHelper extends HelpersBase {

     public MenuHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void pushCreateFolder() {
        JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
        menu.pushMenuNoBlock("File|New folder...");


    }
}
