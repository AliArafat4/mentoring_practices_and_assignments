package tests.assignments.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.assignments.pages.CLPages.AddContactPage;
import tests.assignments.pages.CLPages.CLContactListPage;
import tests.assignments.pages.CLPages.CLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactListApplicationTest {

    /*
    Example 1: Contact List Application Test
    Target: https://thinking-tester-contact-list.herokuapp.com/
    Test Scenario:
    - Navigate to the application
    - Create a new user account
    - Login with the created user
    - Add 5 different contacts
    - Assert that all contacts are properly added and displayed
    Page Objects Needed:
    - LoginPage (registration and login elements)
    - ContactListPage (contact management elements)
    - AddContactPage (contact form elements)
    Assertions:
    - Verify successful user registration
    - Verify successful login
    - Verify each contact is added correctly
    - Verify total contact count equals 5
     */

    @Test
    public void contactListApplicationTest() {

        CLLoginPage clLoginPage = new CLLoginPage();
        CLContactListPage clContactListPage = new CLContactListPage();
        AddContactPage addContactPage = new AddContactPage();

        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));

        Faker faker = new Faker();

        clLoginPage.signup(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password());

        Assert.assertTrue(clContactListPage.logout.isDisplayed());

        for (int i = 0; i < 5; i++) {

//            Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
//            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clContactListPage.addContact));
//            button.click();

            try {
                Thread.sleep(1500);
                Assert.assertEquals(clContactListPage.myTableRows.size(), i);
                clContactListPage.addContact.click();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Date birthday = faker.date().birthday();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String formattedBDay = format.format(birthday);
            String email = faker.internet().emailAddress();
            String phone = "8005551234";
            String street1 = faker.address().streetAddress();
            String street2 = faker.address().streetAddress();
            String city = faker.address().city();
            String state = faker.address().state();
            String zip = faker.address().zipCode();
            String countryCode = faker.address().countryCode();

            addContactPage.addContact(firstName, lastName, formattedBDay, email, phone, street1, street2, city, state, zip, countryCode);
            
        }

        Assert.assertEquals(clContactListPage.myTableRows.size(), 5);

        Driver.closeDriver();

    }
}