package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import utilities.Driver;

public class T03_SmokeTestSuiteImplementation {
    /*
    Task 2: Data Provider Parallel Execution
    Objective: Implement a data-driven test that runs search functionality with multiple search terms in
    parallel.
    Requirements:
    - Create a data provider with at least 5 different search terms
    - Enable parallel execution for the data provider
    - Create a test method that accepts search terms and validates results
    - Configure XML file with data-provider-thread-count of 2
    Expected Output: Each search term should be tested simultaneously in separate thread
     */

    @DataProvider(parallel = true)
    public Object[][] searchDataProvider() {
        return new Object[][]{
                {"phone"},
                {"laptop"},
                {"wii"},
                {"psp"},
                {"pc"},
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void searchSmokeTest(@Optional("Term") String searchTerm) throws InterruptedException {

        Driver.getDriver().get("https://Google.com");
        By searchField = By.xpath("//textarea[@id='APjFqb']");
        Driver.getDriver().findElement(searchField).sendKeys(searchTerm, Keys.ENTER);

//        By tools = By.xpath("//span[normalize-space()='Tools']");
//        By results = By.id("result-stats");
//
//        Driver.getDriver().findElement(tools).click();
//        System.out.println(Driver.getDriver().findElement(results).getText());

        Driver.closeDriver();

    }
}