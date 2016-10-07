package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class ManagerHomePage {
    WebDriver driver;
    By homePageUserName = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td");

    By welcomeText = By
            .xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/marquee");

    By addCustomerPage = By.xpath("/html/body/div[2]/div/ul/li[2]/a");

    public ManagerHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageDashboardUserName() {
        return driver.findElement(homePageUserName).getText();
    }

    public String getWelcomeText() {
        return driver.findElement(welcomeText).getText();
    }

    public void clickToGoAddCustomerPage(){
        driver.findElement(this.addCustomerPage).click();
    }
}
