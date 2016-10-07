package pages;

import model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class AddCustomer {
    WebDriver driver;

    By customerName = By.name("name");
    By gender = By.name("rad1");
    By dateOfBirth = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By mobileNo = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");
    By btnSubmit = By.name("sub");

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public void setCustomerName(String customerName) {
        driver.findElement(this.customerName).sendKeys(customerName);
    }

    public void setGender(String gender) {
        List<WebElement> genderList = driver.findElements(this.gender);
        if(gender.equalsIgnoreCase("m"))
            genderList.get(0).click();
        else if(gender.equalsIgnoreCase("f"))
            genderList.get(1).click();
    }

    public void setDateOfBirth(String dateOfBirth) {
        driver.findElement(this.dateOfBirth).sendKeys(dateOfBirth);
    }

    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }

    public void setCity(String city) {
        driver.findElement(this.city).sendKeys(city);
    }

    public void setState(String state) {
        driver.findElement(this.state).sendKeys(state);
    }

    public void setPin(String pin) {
        driver.findElement(this.pin).sendKeys(pin);
    }

    public void setMobileNo(String mobileNo) {
        driver.findElement(this.mobileNo).sendKeys(mobileNo);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(btnSubmit).click();
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
