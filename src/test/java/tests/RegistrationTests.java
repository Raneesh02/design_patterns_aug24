package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.RegistrationPageFluent;

public class RegistrationTests extends BaseTest {

    @Test
    public void testDobError(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        registrationPage.enterFirstName("Itachi");
        registrationPage.enterLastName("Uchiha");
        registrationPage.submitForm();
        Assert.assertTrue(registrationPage.isDobErrorDisplayed(),"Dob error is not displayed");
    }

    @Test
    public void testDobErrorFluent(){
        RegistrationPageFluent registrationPageFluent = new RegistrationPageFluent(DriverManager.getDriver());
        registrationPageFluent.navigateByUrl().enterFirstName("Itachi").enterLastName("Uchiha").submitForm();
        Assert.assertTrue(registrationPageFluent.isDobErrorDisplayed(),"Dob error is not displayed");
    }

    @Test
    public void testCountryDropdown(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        Assert.assertEquals(registrationPage.getSelectedCountry(),"Your country *");
        registrationPage.selectCountry("India");
        Assert.assertEquals(registrationPage.getSelectedCountry(),"India");
    }

    @Test
    public void testPhoneValidations(){
        RegistrationPage registrationPage = new RegistrationPage(DriverManager.getDriver());
        registrationPage.navigateByUrl();
        registrationPage.enterPhone("hello123");
        registrationPage.submitForm();
        Assert.assertEquals(registrationPage.getPhoneError(),"Only numbers are allowed.");
        registrationPage.enterPhone("7489549876");
        Assert.assertFalse(registrationPage.isPhoneErrorPresent(),"Phone error should be resolved");
    }
}
