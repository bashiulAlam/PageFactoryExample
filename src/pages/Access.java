package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Access {
    WebDriver webDriver;
    By title = By.className("barone");
    By userId = By.xpath("/html/body/table/tbody/tr[4]/td[2]");
    By password = By.xpath("/html/body/table/tbody/tr[5]/td[2]");
    By validityText = By.xpath("/html/body/table/tbody/tr[6]/td/h3");

    public Access(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getPageTitle(){
        return webDriver.findElement(title).getText();
    }

    public String getUserId(){
        return webDriver.findElement(userId).getText();
    }

    public String getPassword(){
        return webDriver.findElement(password).getText();
    }

    public String getValidityPeriodText(){
        return webDriver.findElement(validityText).getText();
    }
}
