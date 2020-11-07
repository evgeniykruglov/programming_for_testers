package mantis.fw;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelper {
    public AccountHelper(ApplicationManager manager) {
        super(manager);
    }

    public AccountHelper signUp(User user) {
        openUrl("/signup_page.php");
        //click(By.cssSelector());
        return this;
    }

    public boolean isLogged(User user) {
        return false;
    }
}
