package pages.Factory;

import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.mobileweb.mWebHomePage;

public class MWebPageFactory extends PageFactory{
    @Override
    public HomePage getHomePage(WebDriver driver) {
        return new mWebHomePage(driver);
    }
}
