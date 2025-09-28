package tests.assignments.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.assignments.pages.AddToTablePage;
import utilities.ConfigReader;
import utilities.Driver;

public class DataProviderAddToTableTest {

    /*
    Go to https://claruswaysda.github.io/addRecordWebTable.html
    Add records to the table using DataProvider
     */

    @DataProvider
    public Object[][] dataProviderAddToTable() {
        return new Object[][]{
                {"test1", "25", "USA"},
                {"test2", "30", "UK"},
                {"test3", "35", "Germany"},
                {"test4", "40", "Australia"}

        };
    }

    @Test(dataProvider = "dataProviderAddToTable")
    void addToTableTest(String name, String age, String country) {
        Driver.getDriver().get(ConfigReader.getProperty("table_url"));

        AddToTablePage addToTablePage = new AddToTablePage();

        addToTablePage.fillName(name)
                .fillAge(age)
                .fillCountrySelect(country)
                .submit();

        Driver.closeDriver();
    }

}