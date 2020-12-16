package mantis.test;

import mantis.fw.User;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SignUpTest extends TestBase{
    @Test
    public void sigUpTest() {
        User user = new User()
                .setLogin("")
                .setEmail("")
                .setPassword("");
        app.getAccountHelper().signUp(user);
        assertTrue (app.getAccountHelper().isLogged(user));
    }
}
