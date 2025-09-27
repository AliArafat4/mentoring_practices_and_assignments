package tests.assignments.pages.BankApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class AccountManagementPage {

    @FindBy(id = "userSelect")
    private WebElement customerSelectField;

    @FindBy(id = "currency")
    private WebElement currencySelectField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public AccountManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void openAccount(String name) {
        Select userSelect = new Select(customerSelectField);
        userSelect.selectByVisibleText(name);

        Select currencySelect = new Select(currencySelectField);
        currencySelect.selectByIndex(1); // Dollars
        submitButton.click();

    }

    public boolean checkAccountExists(String name) {
        Select userSelect = new Select(customerSelectField);
        for (WebElement user : userSelect.getOptions()) {
            return user.getText().contains(name);
        }

        return false;
    }
}