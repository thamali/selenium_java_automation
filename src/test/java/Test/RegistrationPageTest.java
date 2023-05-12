package Test;

import BaseTest.TestBase;
import PageObjects.RegistrationConfirmationPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.logging.Logger;

public class RegistrationPageTest extends TestBase {
    Logger log=Logger.getLogger(String.valueOf(RegistrationPageTest.class));

    RegistrationPage registrationPage;
    RegistrationConfirmationPage registrationConfirmationPage;

    public RegistrationPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        log.info(".......Launching chrome browser........");
        registrationPage=new RegistrationPage();
    }

    @Test(priority = 1)
    public void RegistrationPageTitleTest(){
        log.info("Starting to get the Registration Page Title is:");
        String regPageTitle= registrationPage.validateRegistrationPageTitle();
        log.info("The Registration Page Title is:" + regPageTitle);
      //  System.out.println("The Registration Page Title is :" + regPageTitle  );
        Assert.assertEquals(regPageTitle,"Request a demo | Provet Cloud");
    }

    //Verify User registration
    @Test(priority = 2)
    public void UserRegistrationTest(){
        log.info("****Click on Accept Coockie Alert****");
        registrationPage.AcceptCoockie();
        log.info("****Starting User Registration****");
        registrationConfirmationPage = registrationPage.SubmitRegistrationDetail(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("clinicname")
                , prop.getProperty("email"), prop.getProperty("phone"),prop.getProperty("jobtitle"),prop.getProperty("countryName"));
         log.info("****User Successfully Registered****");

    }

    //generate allure report after test execution
    @AfterMethod
    public void assessTestStatus(ITestResult result) {
        log.info("****Starting to capture alllure report screenshots****");
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Step screenshot: ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else if (result.getStatus() == ITestResult.SKIP) {
            Allure.addAttachment("Step screenshot: ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
        }
        log.info("****Generated Allure Reports****");
    }
    @AfterSuite
   public void tearDown(){
        driver.quit();
        log.info("****Browser is closed****");
   }




}
