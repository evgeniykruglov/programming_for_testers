package mantis.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelper {
    public AccountHelper(ApplicationManager manager) {
        super(manager);
    }

    public AccountHelper signUp(User user) {
        openUrl("/signup_page.php");
        type(By.name("username"), user.login);
        type(By.name("password"), user.password);
        click(By.cssSelector("input.button"));
        WebElement errorMessage = findElement(By.cssSelector("table.width50 tbody tr td p"));
        if (errorMessage != null) throw new RuntimeException(errorMessage.getText());
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }

        MailHelper.Msg message = manager.getMailHelper().getNewMail(user.login, user.password);
        String confirmationLink = message.getConfirmationLink();
        openAbsoluteUrl(confirmationLink);

        type(By.name("password"), user.password);
        type(By.name("password_confirm"), user.password);
        return this;
    }

    public String whoIsLogged() {
        try {
            return driver.findElement(By.cssSelector("td.login-info-left span")).getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
