package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Home {
    WebDriver webDriver;
    By pageTitle = By.className("barone");
    By emailId = By.name("emailid");
    By btnSubmit = By.name("btnLogin");

    public Home(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getPageTitle(){
        return webDriver.findElement(pageTitle).getText();
    }

    public void setEmail(String email){
        webDriver.findElement(emailId).sendKeys(email);
    }

    public void clickSubmit(){
        webDriver.findElement(btnSubmit).click();
    }
}
