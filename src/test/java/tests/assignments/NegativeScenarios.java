package tests.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class NegativeScenarios extends TestBase {
    /*
    Go to https://claruswaysda.github.io/signIn.html
    Do negative test with all scenarios
    */


    @DataProvider
    public Object[][] negativeTestsProvider() {
        return new Object[][]{
                {"", ""},
                {"admin", ""},
                {"", "123"},
                {"admin", "321"},
                {"name", "123"},
                {"name", "321"}

        };
    }

    @Test(dataProvider = "negativeTestsProvider")
    public void negativeTests(String username, String password) {
        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}