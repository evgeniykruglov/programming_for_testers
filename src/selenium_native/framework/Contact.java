package selenium_native.framework;

public class Contact {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setFirstName(String string) {
        this.firstName = string;
        return this;
    }

    public Contact setLastName(String string) {
        lastName = string;
        return this;
    }
}
