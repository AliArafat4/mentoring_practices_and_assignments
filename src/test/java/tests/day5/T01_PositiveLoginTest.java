//package tests.day5;
//
//import org.testng.annotations.Test;
//
//public class T01_PositiveLoginTest {
//
//
//    @Test
//    void positiveLoginTest() {
//
//           /*
//        Task 1: Parallel Test Configuration
//        Objective: Create a parallel test suite that runs login tests on multiple browsers simultaneously.
//        Requirements:
//        - Create a TestNG XML file with parallel execution at the method level
//        - Set thread count to 3
//        - Include at least 2 test classes: PositiveLoginTest and NegativeLoginTest
//        - Configure timeout for each test method to 30 seconds
//        Expected Output: All tests should run in parallel, reducing total execution time.
//     */
//        CLHomePage homePage = new CLHomePage();
//        CLContactListPage contactListPage = new CLContactListPage();
//        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
//        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
//        homePage.password.sendKeys(ConfigReader.getProperty("cl_password"));
//        homePage.submit.click();
//        assert contactListPage.logout.isDisplayed();
//        Driver.closeDriver();
//
//    }
//}