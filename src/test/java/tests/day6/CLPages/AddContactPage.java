package tests.day6.CLPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddContactPage {

    @FindBy(id = "cancel")
    public WebElement cancel;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "birthdate")
    private WebElement birthDate;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "phone")
    private WebElement phone;
    @FindBy(id = "street1")
    private WebElement street1;
    @FindBy(id = "street2")
    private WebElement street2;
    @FindBy(id = "city")
    private WebElement city;
    @FindBy(id = "stateProvince")
    private WebElement stateProvince;
    @FindBy(id = "postalCode")
    private WebElement postalCode;
    @FindBy(id = "country")
    private WebElement country;
    @FindBy(id = "submit")
    private WebElement submit;


    public AddContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void addContact(
            String firstName,
            String lastName,
            String birthDate,
            String email,
            String phone,
            String street1,
            String street2,
            String city,
            String stateProvince,
            String postalCode,
            String country
    ) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.birthDate.sendKeys(birthDate);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.street1.sendKeys(street1);
        this.street2.sendKeys(street2);
        this.city.sendKeys(city);
        this.stateProvince.sendKeys(stateProvince);
        this.postalCode.sendKeys(postalCode);
        this.country.sendKeys(country);
        submit.click();

    }
}