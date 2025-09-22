package tests.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class DependencyTest {
    /*
    Task 3: Dependency Testing
    Objective: Create interdependent test methods using dependsOnMethods
    Requirements:
    Create a class called DependencyTest
    Create a @BeforeClass method to set up WebDriver
    Create the following dependent test chain:
    openYahoo() - Navigate to Yahoo
    openBing() - Navigate to Bing (depends on Yahoo test)
    openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
    Add intentional failure in Yahoo test and observe behavior
    Create @AfterClass method to close driver
     */

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void openYahoo(){
        driver.get("https://www.yahoo.com");
        Assert.fail();
    }

    @Test(dependsOnMethods = "openYahoo")
    public void openBing(){
        driver.get("https://www.bing.com");
    }

    @Test(dependsOnMethods = "openBing")
    void openDuckDuckGo(){
        driver.get("https://www.duckduck.com");
    }


    @AfterClass
    void  tearDown()
    {
        driver.quit();
    }
}