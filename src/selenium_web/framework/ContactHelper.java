package selenium_web.framework;

import org.openqa.selenium.By;
import selenium_web.tests.ContactData;

public class ContactHelper extends HelperBase {
    public static boolean CREATION = true;
    public static boolean MODIFICATION = true;

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean formType) {
        type(By.name("firstname"), contactData.firstName);
        if (formType == CREATION) {

        } else if (formType == MODIFICATION) {
            if (driver.findElements(By.name("new_group")).size() != 0) {
                throw new Error("Group selector exists in contact modification form");
            }
        }
    }

    public void submitContactCreation() {
        click(By.xpath("//input[contains(@value,'Enter')]"));
    }
}
