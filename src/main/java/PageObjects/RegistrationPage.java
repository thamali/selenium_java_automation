package PageObjects;

import BaseTest.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends TestBase {


    //Page Factory Object Reporsitory

    @FindBy(xpath="//input[@name='firstname']")
   private WebElement txtfirstname;
    @FindBy(xpath = "//input[@name='lastname']")
   private WebElement txtlastname;
    @FindBy(xpath="//input[@name='company']")
    private WebElement txtclinicname;
    @FindBy(xpath ="//input[@name='email']")
    private WebElement txtemail;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement txtphone;
    @FindBy(xpath ="//input[@name='jobtitle']")
    private WebElement txtjobtitle;
    @FindBy(xpath = "//input[@type='checkbox' and @class='hs-input' and @name='LEGAL_CONSENT.subscription_type_6801572']")
    private WebElement checkboxaccept;
    @FindBy(xpath = "//input[@type='submit' and @value='Submit']" )
    private WebElement btnsubmit;
    @FindBy(xpath = "//a[contains(text( ),'Acceptera')]")
    private WebElement Alertcoockie;
    @FindBy(xpath = "//*[@name='country__dropdown_']")
    private WebElement country;

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
     public RegistrationConfirmationPage SubmitRegistrationDetail(String fname, String lname, String clinicname, String email, String phone, String jobtitle, String countryName){

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
        return new RegistrationConfirmationPage();

     }

}
