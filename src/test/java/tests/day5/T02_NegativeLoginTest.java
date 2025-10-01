//package tests.day5;
//
//public class T02_NegativeLoginTest {
//
//    @Test
//    void positiveLoginTest() {
//        CLHomePage homePage = new CLHomePage();
//        Driver.getDriver().get(ConfigReader.getProperty("cl_url"));
//        homePage.email.sendKeys(ConfigReader.getProperty("cl_email"));
//        homePage.submit.click();
//        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(homePage.error));
//        assert homePage.error.isDisplayed();
//        Driver.closeDriver();
//    }
//}