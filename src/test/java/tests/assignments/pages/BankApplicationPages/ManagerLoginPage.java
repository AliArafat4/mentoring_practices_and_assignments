package tests.assignments.pages.BankApplicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManagerLoginPage {

    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-lg'][.='Bank Manager Login']")
    private WebElement managerLoginButton;

    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-lg'][.='Customer Login']")
    private WebElement customerLoginButton;

    public ManagerLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickHomePageButton() {
        homeButton.click();
    }

    public void clickManagerLoginButton() {
        managerLoginButton.click();
    }

    public void clickCustomerLoginButton() {
        customerLoginButton.click();
    }
}