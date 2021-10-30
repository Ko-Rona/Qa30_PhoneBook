package tests;

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
        String email = "ilia" + i + "@gmail.com";

        String password = "Ilia12345$";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        app.getUser().pause(5000);
        // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[text()='Sign Out']")));
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void registrationTestWrongEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        String email = "ilia" + i + "gmail.com";
        String password = "Ilia12345#";
        System.out.println("Email: " + email);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitRegistration();

        Assert.assertTrue(app.getUser().isErrorMessageWrongFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
