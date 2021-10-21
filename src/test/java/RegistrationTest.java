import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logout();
        }
    }

    @Test
    public void registrationTestPositive() throws InterruptedException {

        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "ilia" + i + "@gmail.com";
        String password = "Ilia12345$";
        System.out.println("Email: " + email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();

        pause(3000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

    @Test
    public void registrationTestWrongEmail(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email = "ilia"+i+"gmail.com";
        String password = "Ilia12345#";
        System.out.println("Email: " +email);

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        Assert.assertFalse(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }

}
