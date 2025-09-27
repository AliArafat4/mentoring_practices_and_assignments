package tests.assignments.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.assignments.pages.BankApplicationPages.*;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;


public class BankingApplicationTest {
    /*
    Example 2: Banking Application Test
    Target: https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
    Test Scenario:
    - Open 5 new customer accounts
    - Deposit 100 USD to each account
    - Withdraw 100 USD from any one account
    - Delete all created accounts
    - Verify account operations
    Page Objects Needed:
    - ManagerLoginPage (manager interface elements)
    - CustomerManagementPage (add/delete customer elements)
    - AccountManagementPage (account creation elements)
    - CustomerLoginPage (customer interface elements)
    - TransactionPage (deposit/withdraw elements)
    Assertions:
    - Verify account creation success
    - Verify deposit transactions
    - Verify withdrawal transactions
    - Verify account balance updates
    - Verify account deletion
     */

    @Test
    public void bankTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));

        //Create a manager login page object
        ManagerLoginPage managerLoginPage = new ManagerLoginPage();

        //login to manager page
        managerLoginPage.clickManagerLoginButton();

        //Create a customer management page object
        CustomerManagementPage customerManagementPage = new CustomerManagementPage();

        //press add customer button to be used to add customer's information
        customerManagementPage.clickAddCustomerButton();

        //Create an account management page object to get user information fields
        AccountManagementPage accountManagementPage = new AccountManagementPage();

        Faker faker = new Faker();

        //this list stores faker customer names to be used to log in to customer account
        ArrayList<String> accountsNamesList = new ArrayList<String>();

        //adding 5 customers accounts and verify them
        for (int i = 0; i < 5; i++) {

            //create fake data
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String zip = faker.address().zipCode();

            //add name to list
            accountsNamesList.add(firstName + " " + lastName);

            //add customer account
            customerManagementPage.addCustomer(firstName, lastName, zip);

            waitForAlertAndClick();

            customerManagementPage.clickOpenAccountButton();

            //create account for transaction
            accountManagementPage.openAccount(firstName + " " + lastName);

            waitForAlertAndClick();

            customerManagementPage.clickAddCustomerButton();
        }


        //create a customer login page object
        CustomerLoginPage customerLoginPage = new CustomerLoginPage();

        //create a transaction page object
        TransactionPage transactionPage = new TransactionPage();

        //loop to deposit amount
        for (String accountName : accountsNamesList) {

            //go back to home page
            managerLoginPage.clickHomePageButton();

            //go to customer login page
            managerLoginPage.clickCustomerLoginButton();

            //go to account
            customerLoginPage.SelectAccount(accountName);

            int balance = Integer.parseInt(transactionPage.balance.getText());

            //deposit 100 to account
            transactionPage.depositAmountOperation("100");

            //verify
            Assert.assertEquals(Integer.parseInt(transactionPage.balance.getText()), balance += 100);
            Assert.assertTrue(transactionPage.getDepositSuccessMsg());
        }

        //go back to home page
        managerLoginPage.clickHomePageButton();

        //go to customer login page
        managerLoginPage.clickCustomerLoginButton();

        //login to first account
        customerLoginPage.SelectAccount(accountsNamesList.getFirst());

        int balance = Integer.parseInt(transactionPage.balance.getText());

        //withdraw 100
        transactionPage.withdrawAmountOperation("100");

        //verify withdraw
        Assert.assertEquals(Integer.parseInt(transactionPage.balance.getText()), balance -= 100);
        Assert.assertTrue(transactionPage.getWithdrawSuccessMsg());

        //go back to home page
        managerLoginPage.clickHomePageButton();

        //login to manager page
        managerLoginPage.clickManagerLoginButton();

        //go to customer management tab to delete users
        customerManagementPage.clickCustomerManagementButton();

        //delete all created accounts
        for (String accounts : accountsNamesList) {
            customerManagementPage.deleteUser(accounts.split(" ")[0], accounts.split(" ")[1]);
        }

        //go to open account tab to check accounts from select
        customerManagementPage.clickOpenAccountButton();

        //verify deletion
        for (String accounts : accountsNamesList) {
            Assert.assertFalse(accountManagementPage.checkAccountExists(accounts));
        }


        //close driver
        Driver.closeDriver();
    }

    public void waitForAlertAndClick() {
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains("successfully"));
        alert.accept();
        Driver.getDriver().switchTo().defaultContent();
    }
}