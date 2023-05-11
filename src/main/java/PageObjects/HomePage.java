package PageObjects;

import BaseTest.TestBase;

public class HomePage extends TestBase {

    public HomePage(){
    }

    //validate Home Page title
    public String validateHomePageTitle(){
        return driver.getTitle();
    }
}
