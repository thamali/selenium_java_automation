package PageObjects;

import BaseTest.TestBase;
import Util.TestUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RegistrationPage extends TestBase {

    //Page Factory Object Reporsitory

    @FindBy(xpath="//input[@name='firstname']")
    WebElement txtfirstname;
    @FindBy(xpath = "//input[@name='lastname']")
    WebElement txtlastname;
    @FindBy(xpath="//input[@name='company']")
    WebElement txtclinicname;
    @FindBy(xpath ="//input[@name='email']")
    WebElement txtemail;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement txtphone;
    @FindBy(xpath ="//input[@name='jobtitle']")
    WebElement txtjobtitle;
    @FindBy(xpath = "//input[@type='checkbox' and @class='hs-input' and @name='LEGAL_CONSENT.subscription_type_6801572']")
    WebElement checkboxaccept;
    @FindBy(xpath = "//input[@type='submit' and @value='Submit']" )
    WebElement btnsubmit;
    @FindBy(xpath = "//a[contains(text( ),'Acceptera')]")
    WebElement Alertcoockie;
    @FindBy(xpath = "//*[@name='country__dropdown_']")
    WebElement country;

    //Initializing the page objects
    public RegistrationPage(){
        PageFactory.initElements(TestBase.driver,this);
    }

    //Actions:Verify Registration Page Title
     public String validateRegistrationPageTitle(){
      return driver.getTitle();
     }

   //Accept Coockies
    public void AcceptCoockie(){
        Alertcoockie.click();
    }


     //Input Data to the Text Fields in Registration Form and Submit
     public HomePage SubmitRegistrationDetail(String fname,String lname,String clinicname,String email,String phone,String jobtitle, String countryName){

        txtfirstname.sendKeys(fname);
        txtlastname.sendKeys(lname);
        txtclinicname.sendKeys(clinicname);
        txtemail.sendKeys(email);
        txtphone.sendKeys(phone);
        txtjobtitle.sendKeys(jobtitle);
         Select select = new Select(country);
         select.selectByValue(countryName);
        checkboxaccept.click();
        btnsubmit.click();

        //Navigate to the HomePage
        return new HomePage();

     }

}
