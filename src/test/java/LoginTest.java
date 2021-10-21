import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;



public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest() {

        //open login/Reg form
        WebElement loginBtn = wd.findElement(By.xpath("//*[text()='LOGIN']"));
        loginBtn.click();
        //fill login/Reg form
        WebElement emailInput=wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("noa@gmail.com");

        WebElement passwordInput=wd.findElement(By.xpath("//input[2]"));

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Nnoa12345$");

        //click Login button
        wd.findElement(By.xpath("//button[1]")).click();

        //Assert if button Logout is
        //pause(5000);

        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0);
    }

    @Test
    public void loginTest2(){
        String email = "noa@gmail.com";
        String password = "Nnoa12345$";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email,password);
        submitLogin();
        pause(5000);

        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Sign Out']")));
    }
}
