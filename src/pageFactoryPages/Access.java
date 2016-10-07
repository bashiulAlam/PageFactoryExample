package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Access {
    WebDriver webDriver;

    @FindBy(className="barone")
    WebElement title;

    @FindBy(xpath="/html/body/table/tbody/tr[4]/td[2]")
    WebElement userId;

    @FindBy(xpath="/html/body/table/tbody/tr[5]/td[2]")
    WebElement password;

    @FindBy(xpath="/html/body/table/tbody/tr[6]/td/h3")
    WebElement validityText;

    public Access(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getPageTitle(){
        return title.getText();
    }

    public String getUserId(){
        return userId.getText();
    }

    public String getPassword(){
        return password.getText();
    }

    public String getValidityPeriodText(){
        return validityText.getText();
    }
}

