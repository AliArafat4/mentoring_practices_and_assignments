package tests.assignments.pages.BankApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CustomerLoginPage {

    @FindBy(id = "userSelect")
    private WebElement userSelect;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;


    public CustomerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void SelectAccount(String fullName) {
        Select select = new Select(userSelect);
        select.selectByVisibleText(fullName);
        loginButton.click();
    }
}