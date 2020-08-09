package selenium_javaEE.fw;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

import javax.swing.*;

public class HelpersBase {
    protected final ApplicationManager applicationManager;
    protected final JFrameOperator mainFrame;

    public HelpersBase(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.mainFrame = applicationManager.getApplication();
    }

    protected String waitMessageDialog(String title, int timeout) {
        long startTime = System.currentTimeMillis();
        long currentTime = startTime;
        while (currentTime < startTime + timeout) {
            JDialog dialog = JDialogOperator.findJDialog(
                    applicationManager.getApplication().getOwner(),
                    title,
                    false,
                    false);
            if(dialog !=  null) {
                JDialogOperator jDialogOp = new JDialogOperator(dialog);
                String message = new JLabelOperator(jDialogOp).getText();
                jDialogOp.requestClose();
                return message;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime = System.currentTimeMillis();
        }
        return null;
    }
}
