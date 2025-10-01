package tests.assignments.tests;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.day6.CLPages.AddContactPage;
import tests.day6.CLPages.CLContactListPage;
import tests.day6.CLPages.CLLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReportManager;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ContactListApplicationTestWithReporting {

    /*
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
    Reporting Requirements:
    - Use ExtentReports
    - Add .info() logs for each major step
    - Use .pass() for successful assertions
    - Use .fail() for failed assertions with screenshots
    - Add system information (Browser, Environment, Tester)
    - Generate report with timestamp in filename
*/

    @Test
    public void contactListApplicationTest() {
        ExtentReportManager.createTest("Create 5 Contacts Test");

        CLLoginPage clLoginPage = new CLLoginPage();
        CLContactListPage clContactListPage = new CLContactListPage();
        AddContactPage addContactPage = new AddContactPage();

        try {
            Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
            ExtentReportManager.log(Status.PASS, "user navigates to contact list page successfully");
        } catch (Exception e) {
            ExtentReportManager.log(Status.FAIL, "user navigates to contact list page failed");
        }

        Faker faker = new Faker();

        clLoginPage.signup(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), faker.internet().password());
        ExtentReportManager.log(Status.INFO, "user sign up to the application");

        try {
            Assert.assertTrue(clContactListPage.logout.isDisplayed());
            ExtentReportManager.log(Status.PASS, "user created successfully");

        } catch (Exception e) {
            ExtentReportManager.log(Status.FAIL, "user creation failed");
        }

        for (int i = 0; i < 5; i++) {

//            Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
//            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(clContactListPage.addContact));
//            button.click();
            ExtentReportManager.log(Status.INFO, "adding contact number " + (i + 1));

            try {
                Thread.sleep(1500);
                Assert.assertEquals(clContactListPage.myTableRows.size(), i);
                ExtentReportManager.log(Status.PASS, "contact number " + (i + 1) + " added successfully");

                clContactListPage.addContact.click();
            } catch (InterruptedException e) {
                ExtentReportManager.log(Status.FAIL, "contact creation failed");

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


        try {
            Assert.assertEquals(clContactListPage.myTableRows.size(), 5);
            ExtentReportManager.log(Status.PASS, "all record has been added successfully");
        } catch (Exception e) {
            ExtentReportManager.log(Status.FAIL, "only " + clContactListPage.myTableRows.size() + " records has been added");
        }


        ExtentReportManager.flushReport();
        Driver.closeDriver();

    }
}