package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class CustomerRegMsg {
    WebDriver driver;
    By regResponseMsg = By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p");
    By customerId = By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]");


    public CustomerRegMsg(WebDriver driver){
        this.driver = driver;
    }

    public String getCustomerId(){
        return driver.findElement(customerId).getText();
    }

    public String getRegResponseMsg(){
        return driver.findElement(regResponseMsg).getText();
    }
}
