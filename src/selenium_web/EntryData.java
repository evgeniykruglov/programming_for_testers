package selenium_web;

public class EntryData {
    private final String firstName;
    private final String lastName;
    private final String address;

    public EntryData(String name, String header, String footer) {
        this.firstName = name;
        this.lastName = header;
        this.address = footer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}