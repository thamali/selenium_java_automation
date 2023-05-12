package Test;

import BaseTest.TestBase;
import PageObjects.RegistrationConfirmationPage;

public class RegistrationConfirmationPageTest extends TestBase {
   // RegistrationPage registrationPage;
    RegistrationConfirmationPage registrationConfirmationPage;
    public RegistrationConfirmationPageTest(){

    }

    /*@BeforeMethod
    public void setUp(){
        initialization();
       registrationPage =new RegistrationPage();
      //  registrationPage.AcceptCoockie();
       homePage= registrationPage.SubmitRegistrationDetail(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("clinicname")
               , prop.getProperty("email"), prop.getProperty("phone"),prop.getProperty("jobtitle"),prop.getProperty("countryName"));

    }

    @Test(priority = 1)
    public void HomePageTitleTest(){
        String homepagetitle= homePage.validateHomePageTitle();
        Assert.assertEquals(homepagetitle,"Provet Cloud thank you for contacting us.");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
*/

}
