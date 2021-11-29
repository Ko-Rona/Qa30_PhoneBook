package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[.='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());

    }

    public void submitContactForm() {
        click(By.xpath("//button[.='Save']"));
    }

    public boolean isContactAdded() {
        return isElementPresent(By.xpath("(//div[@class='contact-item_card__2SOIM'])"));
    }

    public void clickOnFirstContact() {
        click(By.xpath("(//div[@class='contact-item_card__2SOIM'])[1]"));
    }

    public void removeContact() {
        click(By.xpath("//button[text()='Remove']"));

    }

    public int getContactCount() {
        return wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
    }

    public boolean isMessageNoContactsHere() {
        Boolean isMessage = new WebDriverWait(wd, 5)
                .until(ExpectedConditions
                        .textToBePresentInElement
                                (wd.findElement(By.cssSelector("div[class='contact-page_message__2qafk'] h1")), "No Contacts here!"));
        return isMessage;
    }

    public void clickOnContactByNumber(Contact cont) {
        List<WebElement> elements = wd.findElements(By.xpath("//div[@class='contact-item_card__2SOIM']"));

        for (WebElement we : elements) {
            if (we.getText().contains(cont.getPhone())) {
                we.click();
                break;
            }
        }
    }

    public void addContacts() {

        for (int i = 0; i < 4; i++) {
            int index = (int) (System.currentTimeMillis() / 1000) % 3600;
            Contact contact = Contact.builder()
                    .name("Harry")
                    .lastName("Foll")
                    .phone("1234567" + index)
                    .email("harry" + index + "@gmail.com")
                    .address("Haifa")
                    .description("friend").build();
            openContactForm();
            fillContactForm(contact);
            submitContactForm();
            pause(3000);
        }
    }

    public boolean isContactPresent(String phone) {
        List<WebElement> contactEmails = wd.findElements(By.cssSelector("h3"));
        for (WebElement w : contactEmails) {
            String text = w.getText();
            if (text.contains(phone)) return true;
        }
        return false;
    }

}

