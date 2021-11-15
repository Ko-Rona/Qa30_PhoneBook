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

        logger.info("Test Registration Positive starts with email--->"+user.getEmail());
        logger.info("Test Registration Positive starts with password--->"+user.getPassword());

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void registrationTestPositive2(){

        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String email = "nik"+i+"@gmail.com";
        String password ="Nik12345$";
        System.out.println("Email: " +email);


        logger.info("Test Registration Positive2 starts with email--->"+email);
        logger.info("Test Registration Positive2 starts with password--->"+password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email,password);
        app.getUser().submitRegistration();

        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
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
