package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        if (!app.getUser().isLogged()) {
            app.getUser().login();
        }
        int contactCountBeforeRemoval = app.contact().getContactCount();
        if (contactCountBeforeRemoval == 0) {
            app.contact().addContacts();
        }
    }

    @Test
    public void removeContact() {
        int contactCountBeforeRemoval = app.contact().getContactCount();
        app.contact().clickOnFirstContact();
        app.contact().removeContact();
        app.getUser().pause(3000);
        int contactCountAfterRemoval = app.contact().getContactCount();

        Assert.assertEquals(contactCountAfterRemoval, contactCountBeforeRemoval - 1);
    }

//    @Test  *In progress...*
//    public void removeContactByNumber() {
//        Contact cont = Contact.builder().phone("2222222222").build();
//
//        app.contact().clickOnContactByNumber(cont);
//        app.getUser().pause(8000);
//        app.contact().removeContact();
//    }

    @Test
    public void removeAllContacts() {
        int contactCountBeforeRemoval = app.contact().getContactCount();
        for (int i = 0; i < contactCountBeforeRemoval; i++) {
            app.contact().clickOnFirstContact();
            app.contact().removeContact();
            app.getUser().pause(3000);
        }
        app.getUser().pause(2000);
        int contactCountAfterRemoval = app.contact().getContactCount();

        Assert.assertEquals(0, contactCountAfterRemoval);
        Assert.assertTrue(app.contact().isMessageNoContactsHere());
    }
}
