package pageFactoryPages;

import model.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class AddCustomer {
    WebDriver driver;

    @FindBy(name = "name")
    WebElement customerName;

    @FindBy(name = "rad1")
    List<WebElement> genderList;

    @FindBy(name = "dob")
    WebElement dateOfBirth;

    @FindBy(name = "addr")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    WebElement state;

    @FindBy(name = "pinno")
    WebElement pin;

    @FindBy(name = "telephoneno")
    WebElement mobileNo;

    @FindBy(name = "emailid")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "sub")
    WebElement btnSubmit;

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCustomerName(String customerName) {
        this.customerName.sendKeys(customerName);
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("m"))
            genderList.get(0).click();
        else if(gender.equalsIgnoreCase("f"))
            genderList.get(1).click();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.sendKeys(dateOfBirth);
    }

    public void setAddress(String address) {
        this.address.sendKeys(address);
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setState(String state) {
        this.state.sendKeys(state);
    }

    public void setPin(String pin) {
        this.pin.sendKeys(pin);
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo.sendKeys(mobileNo);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public void addNewCustomer(Customer customer) throws InterruptedException {
        this.setCustomerName(customer.customerName);
        this.setGender(customer.gender);
        this.setDateOfBirth(customer.dateOfBirth);
        this.setAddress(customer.address);
        this.setCity(customer.city);
        this.setState(customer.state);
        this.setPin(customer.pin);
        this.setMobileNo(customer.mobileNo);
        this.setEmail(customer.email);
        this.setPassword(customer.password);
        Thread.sleep(3000);
        this.clickSubmit();
    }
}
