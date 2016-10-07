package test;

import helper.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class TestWithNoPOM {
    @Test(priority = 0)
    public void userRegistrationAndAddCustomer() {
        try {

            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://demo.guru99.com");

            Thread.sleep(5000);
            driver.findElement(By.name("emailid")).sendKeys("md.afzal.hossain@outlook.com");
            Thread.sleep(5000);
            driver.findElement(By.name("btnLogin")).click();

            Thread.sleep(5000);
            String userId = driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
            String password = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[2]")).getText();

            Assert.assertNotNull(password);

            driver.get("http://demo.guru99.com/v4/");
            Thread.sleep(5000);
            driver.findElement(By.name("uid")).sendKeys(userId);
            driver.findElement(By.name("password")).sendKeys(password);
            Thread.sleep(5000);
            driver.findElement(By.name("btnLogin")).click();

            String dashBBoardUsername = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();
            Assert.assertTrue(dashBBoardUsername.contains(userId));

            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a")).click();

            Thread.sleep(5000);
            driver.findElement(By.name("name")).sendKeys("Afzal");
            driver.findElements(By.name("rad1")).get(0).click();
            driver.findElement(By.name("dob")).sendKeys("2016-08-02");
            driver.findElement(By.name("addr")).sendKeys("Gulshan");
            driver.findElement(By.name("city")).sendKeys("Dhaka");
            driver.findElement(By.name("state")).sendKeys("Dhaka");
            driver.findElement(By.name("pinno")).sendKeys("123456");
            driver.findElement(By.name("telephoneno")).sendKeys("1234567");
            driver.findElement(By.name("emailid")).sendKeys(Util.generateEmail());
            driver.findElement(By.name("password")).sendKeys("1234");

            Thread.sleep(5000);
            driver.findElement(By.name("sub")).click();

            String customerAddResponseMsg = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[1]/td/p")).getText();
            Assert.assertTrue(customerAddResponseMsg.contains("Successfully"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
