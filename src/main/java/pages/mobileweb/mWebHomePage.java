package pages.mobileweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.web.WebHomepage;

public class mWebHomePage extends WebHomepage implements HomePage {

    By hamburgerCss=By.cssSelector("button[aria-controls='navbarSupportedContent']");

    public mWebHomePage(WebDriver driver) {
        super(driver);
    }

    public void toggleHamburger(){
        waitAndClick(hamburgerCss);
    }

    public void openCategories(){
        toggleHamburger();
        super.openCategories();
    }


}
