package pageFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class ManagerHomePage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    WebElement homePageUserName;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee")
    WebElement welcomeText;

    @FindBy(xpath = "/html/body/div[2]/div/ul/li[2]/a")
    WebElement addCustomerPage;

    public ManagerHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageDashboardUserName() {
        return homePageUserName.getText();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public void clickToGoAddCustomerPage(){
        this.addCustomerPage.click();
    }
}
