package pages.Factory;

import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.web.WebHomepage;

public class WebPageFactory extends PageFactory{
    @Override
    public HomePage getHomePage(WebDriver driver) {
        return new WebHomepage(driver);
    }
}
