package selenium_native.framework;


public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createContact(Contact contact) {
        initContactCreation();
        fillContactForm(contact);
        confirmContactCreation();

    }

    private void confirmContactCreation() {
        applicationManager.getAutoItHelper()
                .click("Save")
                .winWaitAndActivate("AddressBook Portable", "", 5000);
    }

    private void fillContactForm(Contact contact) {
        applicationManager.getAutoItHelper()
                .send("TDBEdit12", contact.getFirstName())
                .send("TDBEdit11", contact.getLastName());
    }

    private void initContactCreation() {
        applicationManager.getAutoItHelper()
                .winWaitAndActivate("AddressBook Portable", "", 5000)
                .click("Add")
                .winWaitAndActivate("Add Contact", "", 5000);
    }

    public Contact getFirstContact() {
            applicationManager.getAutoItHelper()
                    .winWaitAndActivate("Addressbook Portable", "", 5000)
                    .click("TListView1")
                    .send("{DOWN}{SPACE}")
                    .click("Edit")
                    .winWaitAndActivate("Update Contact", "" ,5000);
            Contact contact = new Contact()
                    .setFirstName(applicationManager.getAutoItHelper().getText("TDBEdit12"))
                    .setLastName(applicationManager.getAutoItHelper().getText("TDBEdit11"));
            applicationManager.getAutoItHelper().click("Cancel")
                    .winWaitAndActivate("Addressbook Portable", "", 5000);

            return contact;
    }
}
