package test;

import helper.Util;
import model.Customer;
import model.Manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactoryPages.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Afzal on 11-Aug-16.
 */
public class TestWithPageFactory {

    WebDriver driver;
    Manager manager;
    Home home;
    Access access;
    Login login;
    ManagerHomePage managerHomePage;
    AddCustomer addCustomer;
    CustomerRegMsg customerRegMsg;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com");
        manager = new Manager();
        manager.customerList = new ArrayList<Customer>();
    }

    @BeforeMethod
    public void setUpMethod() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void userRegistration() {
        try {

            home = new Home(driver);
            Thread.sleep(5000);
            manager.email = "md.afzal.hossain@outlook.com";
            home.setEmail(manager.email);
            Thread.sleep(5000);
            home.clickSubmit();

            access = new Access(driver);
            String pageTitle = access.getPageTitle();

            manager.userId = access.getUserId();
            manager.password = access.getPassword();
            manager.expiryTime = access.getValidityPeriodText();

            System.out.println("pageTitle : " + pageTitle + ",  userId : " + manager.userId
                    + ", password : " + manager.password + ", expiryText : " + manager.expiryTime);

            Assert.assertNotNull(manager.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void userLogIn() {
        try {
            driver.get("http://demo.guru99.com/v4/");
            login = new Login(driver);
            Thread.sleep(5000);
            login.loginToGuruBank(manager.userId, manager.password);

            managerHomePage = new ManagerHomePage(driver);

            String welcomeText = managerHomePage.getWelcomeText();
            System.out.println("welcomeText : " + welcomeText);

            String dashBBoardUsername = managerHomePage.getHomePageDashboardUserName();

            Assert.assertTrue(dashBBoardUsername.contains(manager.userId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void addCustomer() {
        try {
            Thread.sleep(5000);
            managerHomePage.clickToGoAddCustomerPage();
            addCustomer = new AddCustomer(driver);

            manager.customerList.add(new Customer());
            manager.customerList.get(0).customerName = "Afzal";
            manager.customerList.get(0).gender = "m";
            manager.customerList.get(0).dateOfBirth = "2016-08-02";
            manager.customerList.get(0).address = "Gulshan";
            manager.customerList.get(0).city = "Dhaka";
            manager.customerList.get(0).state = "Dhaka";
            manager.customerList.get(0).pin = "123456";
            manager.customerList.get(0).mobileNo = "1234567";
            manager.customerList.get(0).email = Util.generateEmail();
            manager.customerList.get(0).password = "123";

            Thread.sleep(5000);
            addCustomer.addNewCustomer(manager.customerList.get(0));

            customerRegMsg = new CustomerRegMsg(driver);
            String customerId = customerRegMsg.getCustomerId();
            String customerAddResponseMsg = customerRegMsg.getRegResponseMsg();

            Assert.assertTrue(customerAddResponseMsg.contains("Successfully"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
