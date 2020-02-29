package framework;

public enum Constants {
    WEBDRIVER("o"),
    OPERA_DRIVER_PATH("webdriver//operadriver"), // Use command "chmod +x operadriver" before first start
    FIREFOX_DRIVER_PATH("webdriver\\geckodriver64.exe"),
    IE_DRIVER_PATH("webdriver\\IEDriverServer.exe");

    private String text;

    Constants(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
