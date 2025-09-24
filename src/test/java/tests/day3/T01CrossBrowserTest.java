package tests.day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import utilities.TestBase;

public class T01CrossBrowserTest extends TestBase {
    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
    Do this test with Chrome, Edge and Firefox
    */

    @Test
    public void T01CrossBrowserTest(@Optional("A") String name, @Optional("10") int age, @Optional("it") String option, @Optional("coding") String interest, @Optional("male") String gender) {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("age")).sendKeys(age + "");
        new Select(driver.findElement(By.id("options"))).selectByValue(option);
        driver.findElement(By.xpath("//input[@value='" + interest + "']")).click();
        driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Alert alert = driver.switchTo().alert();

        Assert.assertTrue(alert.getText().contains("Your passcode is:"));
    }
}