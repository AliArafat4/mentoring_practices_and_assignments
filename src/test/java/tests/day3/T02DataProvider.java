package tests.day3;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ExcelUtilities;
import utilities.TestBase;

public class T02DataProvider extends TestBase {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider
    Do it with all 3 ways
    */
    @DataProvider
    public Object[][] informationDataProvider() {

        return new Object[][]{
                {"A", 10, 4},
                {"B", 15, 5},
                {"C", 20, 3},
        };
    }

    @DataProvider
    public Object[][] informationDataProviderFaker() {
        Faker faker = new Faker();

        return new Object[][]{
                {faker.name().firstName(), faker.number().numberBetween(10, 50), faker.number().numberBetween(0, 5)},
                {faker.name().firstName(), faker.number().numberBetween(10, 50), faker.number().numberBetween(0, 5)},
                {faker.name().firstName(), faker.number().numberBetween(10, 50), faker.number().numberBetween(0, 5)},
        };
    }

    @DataProvider
    public Object[][] informationDataProviderExcel() {
        ExcelUtilities eu = new ExcelUtilities("info.xlsx", "Sheet1");
        return eu.getExcelDataAsArray();
    }

    @Test(dataProvider = "informationDataProvider")
    public void T02DataProvider(String name, int age, int countryIndex) {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(countryIndex);
        driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
    }

    @Test(dataProvider = "informationDataProviderFaker")
    public void T02DataProviderFaker(String name, int age, int countryIndex) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(countryIndex);
        driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
    }

    @Test(dataProvider = "informationDataProviderExcel")
    public void T02DataProviderExcel(String name, double age, double countryIndex) {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys(age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByIndex((int) countryIndex);
        driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
    }
}