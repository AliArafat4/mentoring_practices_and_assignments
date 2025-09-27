package tests.assignments.pages.BankApplicationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class CustomerManagementPage {

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCdField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement customerManagementButton;

    @FindBy(xpath = "//table")
    private WebElement allTableRows;


    public CustomerManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickAddCustomerButton() {
        addCustomerButton.click();
    }

    public void clickOpenAccountButton() {
        openAccountButton.click();
    }

    public void clickCustomerManagementButton() {
        customerManagementButton.click();
    }

    public void addCustomer(String firstName, String lastName, String postCd) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCdField.sendKeys(postCd);
        submitButton.click();
    }

    public void deleteUser(String fName, String lName) {

        allTableRows.findElement(By.xpath("//tr[td[1][text()='" + fName + "'] and td[2][text()='" + lName + "']]/td[5]/button[1]")).click();
    }


}