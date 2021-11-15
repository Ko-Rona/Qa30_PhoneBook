package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (!app.getUser().isLogged()) {
            app.getUser().login();
        }
    }

    @Test(invocationCount = 5)
    public void addNewContactTest() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Harry")
                .lastName("Foll")
                .phone("1234567" + index)
                .email("harry" + index + "@gmail.com")
                .address("Haifa")
                .description("friend").build();
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().submitContactForm();

        Assert.assertTrue(app.contact().isContactAdded());

    }
}
