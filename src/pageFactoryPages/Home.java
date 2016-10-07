package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Home {
    WebDriver webDriver;

    @FindBy(className = "barone")
    WebElement pageTitle;

    @FindBy(name = "emailid")
    WebElement emailId;

    @FindBy(name = "btnLogin")
    WebElement btnSubmit;


    public Home(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void setEmail(String email){
        emailId.sendKeys(email);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }
}
