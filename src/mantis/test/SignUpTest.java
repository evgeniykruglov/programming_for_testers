package mantis.test;

import mantis.fw.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.*;

public class SignUpTest extends TestBase {
    User user = new User()
            .setLogin("1")
            .setEmail("1")
            .setPassword("1");

    @BeforeClass
    public void initShortcuts() {
    }

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
        assertThat(app.getAccountHelper().whoIsLogged(), equalTo(user.getLogin()));
    }
}
