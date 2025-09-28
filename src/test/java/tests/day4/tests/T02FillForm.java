package tests.day4.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.day4.pages.FillFormPage;
import utilities.Driver;

public class T02FillForm {

    /*
    Go to https://claruswaysda.github.io/ActionsForm.html
    Fill form and submit
    Do all actions and assert
    */

    @Test
    public void testAddRecord() {
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");
        FillFormPage fillFormPage = new FillFormPage();

        String alertText = fillFormPage.fillName("Test")
                .fillAge("25")
                .fillOptions("it")
                .fillInterest()
                .fillGender()
                .formSubmit()
                .verifySuccess();

        Assert.assertTrue(alertText.contains("Your passcode is"));
        Driver.closeDriver();
    }


}