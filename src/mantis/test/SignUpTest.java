package mantis.test;

import mantis.fw.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SignUpTest extends TestBase {
    User user = new User()
            .setLogin("")
            .setEmail("")
            .setPassword("");

    @BeforeClass
    public void createMailUser() {
        if (! app.getJamesHelper().doesUserExist(user.getLogin())) {
            app.getJamesHelper().createUser(user.getLogin(), user.getPassword());
        }
    }

    @AfterClass
    public void deleteMailUser() {
        if ( app.getJamesHelper().doesUserExist(user.getLogin())) {
            app.getJamesHelper().deleteUser(user.getLogin());
        }
    }


    @Test
    public void sigUpTest() {

        app.getAccountHelper().signUp(user);
        assertTrue(app.getAccountHelper().isLogged(user));
    }
}
