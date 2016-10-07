package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class CustomerRegMsg {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[1]/td/p")
    WebElement regResponseMsg;


    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    WebElement customerId;


    public CustomerRegMsg(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCustomerId(){
        return customerId.getText();
    }

    public String getRegResponseMsg(){
        return regResponseMsg.getText();
    }
}
