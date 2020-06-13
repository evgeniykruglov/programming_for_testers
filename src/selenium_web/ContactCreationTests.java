package selenium_web;

import selenium_web.framework.ContactHelper;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
    @Test
    public void createContact() {
        ContactData contact = new ContactData();
        contact.firstName = "FirstNAME";
        applicationManager.getNavigationHelper().openMainPage();
        applicationManager.getContactHelper().initContactCreation();
        applicationManager.getContactHelper().fillContactForm(contact, ContactHelper.CREATION);

        applicationManager.getContactHelper().submitContactCreation();
        applicationManager.getNavigationHelper().openMainPage();
    }
}
