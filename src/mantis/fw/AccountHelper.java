package mantis.fw;

import org.openqa.selenium.By;

public class AccountHelper extends WebDriverHelper {
    public AccountHelper(ApplicationManager manager) {
        super(manager);
    }

    public AccountHelper signUp(User user) {
        openUrl("/signup_page.php");
        type(By.name("username"), user.login);
        type(By.name("password"), user.password);
        click(By.cssSelector("input.button"));

        MailHelper.Msg message = manager.getMailHelper().getNewMail(user.login, user.password);
        String confirmationLink = message.getConfirmationLink();
        openAbsoluteUrl(confirmationLink);

        type(By.name("password"), user.password);
        type(By.name("password_confirm"), user.password);
        return this;
    }

    public boolean isLogged(User user) {
        return false;
    }
}
