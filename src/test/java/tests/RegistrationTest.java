package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void registrationTestPositive() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User().withEmail("ilia" + i + "@gmail.com").withPassword("Ilia12345$");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void registrationTestWrongEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        User user = new User().withEmail("ilia" + i + "gmail.com").withPassword("Ilia12345$");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorMessageWrongFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
