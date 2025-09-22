package tests.assignments;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class HardAssertLoginTest extends TestBase {
    /*
    Task 4: Hard Assertions Practice
    Objective: Implement hard assertions for login functionality
    Test Case: Positive Login Test
    1. Navigate to https://claruswaysda.github.io/signIn.html
    2. Enter username: "admin"
    3. Enter password: "123"
    4. Click Submit button
    5. Use hard assertions to verify:
    New page URL is "https://claruswaysda.github.io/signIn.html"
    Page contains text "Employee Table"
    Implementation Requirements:
    Create class HardAssertLoginTest
    Use appropriate WebDriver setup and teardown
    Implement proper element locators
    Use meaningful assertion messages
     */

    @Test
    public void testAssertLogin() {
        driver.get("https://claruswaysda.github.io/signIn.html");
        By usernameField = By.id("username");
        By passwordField = By.id("password");
        By loginButton = By.xpath("//input[@type='submit']");
        driver.findElement(usernameField).sendKeys("admin");
        driver.findElement(passwordField).sendKeys("123");
        driver.findElement(loginButton).click();

        String expectedText = "Employee Table";
        By textId = By.id("employeeHeader");

        Assert.assertEquals(driver.findElement(textId).getText(),expectedText);

    }
}