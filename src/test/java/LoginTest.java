import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver wd;

    @BeforeMethod
    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void loginPositiveTest(){

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

        //click  Login button
        wd.findElement(By.xpath("//button[1]")).click();
        //Assert if button Logout is

        Assert.assertTrue(wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0);

    }

    @AfterMethod
    public void tearDown(){
        //wd.quit();
    }
}
