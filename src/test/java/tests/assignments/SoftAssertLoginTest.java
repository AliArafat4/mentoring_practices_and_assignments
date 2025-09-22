package tests.assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class SoftAssertLoginTest extends TestBase {
    /*
    Task 5: Soft Assertions Practice
    Objective: Implement soft assertions for negative test scenarios
    Test Case: Negative Login Test
    1. Navigate to https://claruswaysda.github.io/signIn.html
    2. Enter username: "wronguser"
    3. Enter password: "wrongpass"
    4. Click Submit button
    5. Use soft assertions to verify:
    JavaScript alert is displayed
    Alert message text is "Incorrect username or password"
    Implementation Requirements:
    Create class SoftAssertLoginTest
    Handle JavaScript alert using WebDriver's Alert interface
    Use SoftAssert object for assertions
    Include proper assertAll() call
    Add meaningful assertion message
     */

    @Test
    public void testSoftAssertLogin() {
        driver.get("https://claruswaysda.github.io/signIn.html");
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By loginButton = By.xpath("//input[@type='submit']");
        driver.findElement(usernameField).sendKeys("wronguser");
        driver.findElement(passwordField).sendKeys("wrongpass");
        driver.findElement(loginButton).click();

        String expectedText = "Incorrect username or password";
        Alert alert = driver.switchTo().alert();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alert.getText(),expectedText);
        softAssert.assertAll();
    }
}