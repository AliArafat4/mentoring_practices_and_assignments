package tests.assignments.pages.BankApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TransactionPage {


    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    public WebElement balance;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement transactionsButton;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    private WebElement depositButton;

    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement withdrawButton;

    @FindBy(xpath = "//input[@type='number']")
    private WebElement amountField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitDepositWithdrawButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    private WebElement depositSuccessMessage;

    @FindBy(xpath = "//span[.='Transaction successful']")
    private WebElement withdrawSuccessMessage;

    @FindBy(xpath = ".//table/tbody/tr[last()]/td[1]")
    private WebElement lastTransactionDone;


    public TransactionPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void depositAmountOperation(String amount) {
        depositButton.click();
        amountField.sendKeys(amount);
        submitDepositWithdrawButton.click();
    }

    public void withdrawAmountOperation(String amount) {
        withdrawButton.click();
        amountField.sendKeys(amount);
        submitDepositWithdrawButton.click();
    }

    public boolean getDepositSuccessMsg() {
        return depositSuccessMessage.isDisplayed();
    }

    public boolean getWithdrawSuccessMsg() {
        return withdrawSuccessMessage.isDisplayed();
    }


}