package selenium_native.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium_native.framework.Contact;

public class TestContactCreation extends TestBase {

    @Test
    public void testContactCreateWithValidData(){
        Contact contact = new Contact().setFirstName("Tester").setLastName("ItProger");
        applicationManager.getContactHelper().createContact(contact);
        Contact createdContact = applicationManager.getContactHelper().getFirstContact();
        Assert.assertEquals(contact, createdContact);

    }
}
