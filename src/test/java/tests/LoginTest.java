package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }
    @Test
    public void loginPositiveTest() {}

//        //open login/Reg form
//        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
//        loginBtn.click();
//        //fill login/Reg form
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("noa@gmail.com");
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[2]"));
//
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys("Nnoa12345$");
//
//        //click Login button
//        wd.findElement(By.xpath("//button[1]")).click();
//
//        //Assert if button Logout is
//        //pause(5000);
//
//        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0);
//    }

    @Test
    public void loginTest2() {
        User user = new User().withEmail("korona1504@gmail.com").withPassword("KoronA10$");
//        String email = "korona1504@gmail.com";
//        String password = "KoronA10$";

        app.getUser().openLoginRegistrationForm();
        //app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitLogin();
        app.getUser().pause(5000);

        Assert.assertTrue(app.getUser().isLogged());
        //Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }


}
