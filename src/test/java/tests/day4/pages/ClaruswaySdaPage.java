package tests.day4.pages;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.day4.pages.AddRecordWebTablePage;
import utilities.Driver;


public class ClaruswaySdaPage {
    By addRecordWebTableBy = By.xpath("//a[.='Add Record Web Table']");

    public AddRecordWebTablePage clickWebTable() {
        Driver.getDriver().findElement(addRecordWebTableBy).click();
        return new AddRecordWebTablePage();
    }
}