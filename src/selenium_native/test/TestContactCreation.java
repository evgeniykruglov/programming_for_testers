package selenium_native.test;

import org.testng.annotations.Test;
import selenium_native.framework.Contact;

public class TestContactCreation extends TestBase {

    @Test
    public void testContactCreateWithValidData(){
        Contact contact = new Contact().setFirstName("Tester").setLastName("ItProger");
        applicationManager.getContactHelper().createContact(contact);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
