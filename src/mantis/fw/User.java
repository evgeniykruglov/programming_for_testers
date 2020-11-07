package mantis.fw;

public class User {
    String login = "";
    String password = "";
    String email = "";
    public User setLogin(String s) {
        login = s;
        return this;
    }

    public User setEmail(String s) {
        email = s; return this;
    }

    public User setPassword(String s) {
        password = s; return this;
    }
}
