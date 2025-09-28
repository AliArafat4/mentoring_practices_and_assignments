package tests.assignments.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import utilities.Driver;

public class AddToTablePage {


    By nameField = By.id("nameInput");
    By ageField = By.id("ageInput");
    By countrySelect = By.id("countrySelect");
    By addRecordButton = By.xpath("//button[@onclick='addRecord()']");

    public AddToTablePage fillName(String name) {
        Driver.getDriver().findElement(nameField).sendKeys(name);
        return this;
    }

    public AddToTablePage fillAge(String age) {
        Driver.getDriver().findElement(ageField).sendKeys(age);
        return this;
    }

    public AddToTablePage fillCountrySelect(String countryName) {
        new Select(Driver.getDriver().findElement(countrySelect)).selectByVisibleText(countryName);
        return this;
    }

    public AddToTablePage submit() {
        Driver.getDriver().findElement(addRecordButton).click();
        return this;
    }

}