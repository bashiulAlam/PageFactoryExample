package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Login {
    WebDriver driver;
    By userId = By.name("uid");
    By password = By.name("password");
    By pageTitle =By.className("barone");
    By btnLogin = By.name("btnLogin");

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void setUserId(String userId){
        driver.findElement(this.userId).sendKeys(userId);;
    }

    public void setPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }

    public String getLoginTitle(){
        return	driver.findElement(pageTitle).getText();
    }

    public void loginToGuruBank(String userId, String pasword) throws InterruptedException {
        this.setUserId(userId);
        this.setPassword(pasword);
        Thread.sleep(3000);
        this.clickLogin();
    }
}
