package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class Login {
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(className = "barone")
    WebElement pageTitle;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserId(String userId) {
        this.userId.sendKeys(userId);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String getLoginTitle() {
        return pageTitle.getText();
    }

    public void loginToGuruBank(String userId, String pasword) throws InterruptedException {
        this.setUserId(userId);
        this.setPassword(pasword);
        Thread.sleep(3000);
        this.clickLogin();
    }
}

