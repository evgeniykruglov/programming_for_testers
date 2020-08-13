package selenium_native.framework;

import java.io.IOException;

public class ProcessHelper extends HelperBase {

    private Process process;
    public ProcessHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void startAppUnderTest() {
        String command = applicationManager.getProperty("app.path");
        try {
             process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void stopAppUnderTest() {
        process.destroy();
    }
}
